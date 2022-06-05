package com.ird.faa.importExcel.impressionCarteExcel.excelControllerCartes;

import java.util.List;

import com.ird.faa.bean.ImpressionCarte;
import com.ird.faa.importExcel.impressionCarteExcel.excelMessageCartes.ResponseMessageCartes;
import com.ird.faa.importExcel.impressionCarteExcel.excelServiceCartes.ExcelServiceCartes;
import com.ird.faa.importExcel.impressionCarteExcel.excelhelperCartes.ExcelHelperCartes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@Controller
@RequestMapping("/api/excel")
public class ExcelControllerCartes {
    @Autowired
    ExcelServiceCartes fileService;
    @PostMapping("/upload")
    public ResponseEntity<ResponseMessageCartes> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        if (ExcelHelperCartes.hasExcelFormat(file)) {
            try {
                fileService.save(file);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessageCartes(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessageCartes(message));
            }
        }
        message = "Please upload an excel file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessageCartes(message));
    }
    @GetMapping("/tutorials")
    public ResponseEntity<List<ImpressionCarte>> getAllImpressionCartes() {
        try {
            List<ImpressionCarte> tutorials = fileService.getAllImpressionCartes();
            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
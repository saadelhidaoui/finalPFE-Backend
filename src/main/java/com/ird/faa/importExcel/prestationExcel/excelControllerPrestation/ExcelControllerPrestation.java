package com.ird.faa.importExcel.prestationExcel.excelControllerPrestation;

import java.util.List;

import com.ird.faa.bean.Adherent;
import com.ird.faa.bean.Prestation;
import com.ird.faa.importExcel.adherentExcel.excelHelperAdherent.ExcelHelperAdherent;
import com.ird.faa.importExcel.adherentExcel.excelMessageAdherent.ResponseMessageAdherent;
import com.ird.faa.importExcel.adherentExcel.excelServiceAdherent.ExcelServiceAdherent;
import com.ird.faa.importExcel.prestationExcel.excelHelperPrestation.ExcelHelperPrestation;
import com.ird.faa.importExcel.prestationExcel.excelServicePrestation.ExcelServicePrestation;
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
public class ExcelControllerPrestation {
    @Autowired
    ExcelServicePrestation fileService;
    @PostMapping("/uploadPrestation")
    public ResponseEntity<ResponseMessageAdherent> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        if (ExcelHelperPrestation.hasExcelFormat(file)) {
            try {
                fileService.save(file);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessageAdherent(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessageAdherent(message));
            }
        }
        message = "Please upload an excel file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessageAdherent(message));
    }
    @GetMapping("/Prestations")
    public ResponseEntity<List<Prestation>> getAllTutorials() {
        try {
            List<Prestation> tutorials = fileService.getAllPrestation();
            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
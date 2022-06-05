package com.ird.faa.importExcel.impressionCarteExcel.excelServiceCartes;

import java.io.IOException;
import java.util.List;

import com.ird.faa.bean.ImpressionCarte;
import com.ird.faa.dao.ImpressionCarteDao;
import com.ird.faa.importExcel.impressionCarteExcel.excelhelperCartes.ExcelHelperCartes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class ExcelServiceCartes {
    @Autowired
    ImpressionCarteDao repository;
    public void save(MultipartFile file) {
        try {
            List<ImpressionCarte> tutorials = ExcelHelperCartes.excelToImpressionCartes(file.getInputStream());
            repository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }
    public List<ImpressionCarte> getAllImpressionCartes() {
        return repository.findAll();
    }
}
package com.ird.faa.importExcel.prestationExcel.excelServicePrestation;

import com.ird.faa.bean.Prestation;
import com.ird.faa.dao.PrestationDao;
import com.ird.faa.importExcel.prestationExcel.excelHelperPrestation.ExcelHelperPrestation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ExcelServicePrestation {
    @Autowired
    PrestationDao repository;
    @Autowired
    private ExcelHelperPrestation excelHelperPrestation;

    public void save(MultipartFile file) {
        try {
            List<Prestation> tutorials = excelHelperPrestation.excelToPrestation(file.getInputStream());
            repository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }
    public List<Prestation> getAllPrestation() {
        return repository.findAll();
    }
}
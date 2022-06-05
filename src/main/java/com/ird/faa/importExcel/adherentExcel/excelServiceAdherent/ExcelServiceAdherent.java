package com.ird.faa.importExcel.adherentExcel.excelServiceAdherent;

import com.ird.faa.bean.Adherent;
import com.ird.faa.dao.AdherentDao;
import com.ird.faa.importExcel.adherentExcel.excelHelperAdherent.ExcelHelperAdherent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ExcelServiceAdherent {
    @Autowired
    AdherentDao repository;
    @Autowired
    private ExcelHelperAdherent excelHelperAdherent;

    public void save(MultipartFile file) {
        try {
            List<Adherent> tutorials = excelHelperAdherent.excelToAdherent(file.getInputStream());
            repository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }
    public List<Adherent> getAllAdherent() {
        return repository.findAll();
    }
}
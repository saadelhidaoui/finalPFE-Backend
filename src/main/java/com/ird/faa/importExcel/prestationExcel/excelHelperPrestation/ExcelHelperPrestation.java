package com.ird.faa.importExcel.prestationExcel.excelHelperPrestation;


import com.ird.faa.bean.*;
import com.ird.faa.security.service.facade.RoleService;
import com.ird.faa.service.admin.facade.*;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
@Configuration
public class ExcelHelperPrestation {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = {"reference", "numArrivee", "typePrestation", "chargeCas", "adherent", "notes", "niveauImportance", "etatPrestation"};
    static String SHEET = "Prestations";
    @Autowired
    private  TypePrestationAdminService typePrestationAdminService;
    @Autowired
    private  AdherentAdminService adherentAdminService;
    @Autowired
    private  FonctionAdminService fonctionAdminService;
    @Autowired
    private  NiveauImportanceAdminService niveauImportanceAdminService;
    @Autowired
    private  EtatPrestationAdminService etatPrestationAdminService;


    public static boolean hasExcelFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public  List<Prestation> excelToPrestation(InputStream is) {
        try {
            Workbook workbook = WorkbookFactory.create(is);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            List<Prestation> prestations = new ArrayList<Prestation>();
            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow = currentRow.iterator();
                Prestation carte = new Prestation();
                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    switch (cellIdx) {
                        case 0:
                            DataFormatter formatter = new DataFormatter();
                            String s0 = formatter.formatCellValue(currentCell);
                            carte.setReference(s0);
                            break;
                        case 1:
                            DataFormatter formatter1 = new DataFormatter();
                            String s1 = formatter1.formatCellValue(currentCell);
                            carte.setNumArrivee(s1);
                            break;
                        case 2:
                            DataFormatter formatter3 = new DataFormatter();
                            String s3 = formatter3.formatCellValue(currentCell);
                            TypePrestation typePrestation = typePrestationAdminService.findByLibelle(s3);
                            carte.setTypePrestation(typePrestation);
                            break;
                        case 3:
                            DataFormatter formatter7 = new DataFormatter();
                            String s7 = formatter7.formatCellValue(currentCell);
                            carte.setChargeCas(s7);
                            break;
                        case 4:
                            DataFormatter formatter8 = new DataFormatter();
                            String s8 = formatter8.formatCellValue(currentCell);
                            Adherent adherent = adherentAdminService.findByCin(s8);
                            carte.setAdherent(adherent);
                            break;
                        case 5:DataFormatter formatter9 = new DataFormatter();
                            String s9= formatter9.formatCellValue(currentCell);
                            carte.setNotes(s9);
                            break;
                        case 6:
                            DataFormatter formatter10 = new DataFormatter();
                            String s10 = formatter10.formatCellValue(currentCell);
                            NiveauImportance niveauImportance = niveauImportanceAdminService.findByLibelle(s10);
                            carte.setNiveauImportance(niveauImportance);
                            break;
                        case 7:
                            DataFormatter formatter11 = new DataFormatter();
                            String s11 = formatter11.formatCellValue(currentCell);
                            EtatPrestation etatPrestation = etatPrestationAdminService.findByLibelle(s11);
                            carte.setEtatPrestation(etatPrestation);
                            break;
                        default:
                            break;
                    }
                    cellIdx++;
                }
                prestations.add(carte);
            }
            workbook.close();
            return prestations;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}
package com.ird.faa.excelhelper;

import com.ird.faa.bean.ImpressionCarte;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class ExcelHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = {"Id", "aff", "qualite", "nom", "prenom", "nomprenomar", "nomAr", "prenomAr", "cinn", "pprr", "ppr", "naissance", "dtNaissance", "photo", "cinnConjoint", "cinConjoint", "adherent", "nomAdherent", "prenomAdherent", "cinnAdherent", "cinAdherent", "pprrAdherent", "versocarte", "aff1", "aff2", "nval"};
    static String SHEET = "ImpressionCartes";

    public static boolean hasExcelFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public static List<ImpressionCarte> excelToImpressionCartes(InputStream is) {
        try {
            Workbook workbook = WorkbookFactory.create(is);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            List<ImpressionCarte> cartes = new ArrayList<ImpressionCarte>();
            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow = currentRow.iterator();
                ImpressionCarte carte = new ImpressionCarte();
                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    switch (cellIdx) {
                        case 0:
                            carte.setId((long) currentCell.getNumericCellValue());
                            break;
                        case 1:
                            DataFormatter formatter1 = new DataFormatter();
                            String s1 = formatter1.formatCellValue(currentCell);
                            carte.setAff(s1);
                            break;
                        case 2:
                            DataFormatter formatter2 = new DataFormatter();
                            String s2 = formatter2.formatCellValue(currentCell);
                            carte.setQualite(s2);
                            break;
                        case 3:
                            DataFormatter formatter3 = new DataFormatter();
                            String s3 = formatter3.formatCellValue(currentCell);
                            carte.setNom(s3);
                            break;
                        case 4:
                            DataFormatter formatter4 = new DataFormatter();
                            String s4 = formatter4.formatCellValue(currentCell);
                            carte.setPrenom(s4);
                            break;
                        case 5:
//                            DataFormatter formatter5 = new DataFormatter();
//                            String s5 = formatter5.formatCellValue(currentCell);
                            carte.setNomprenomar(currentCell.getStringCellValue());
                            break;
                        case 6:
//                            DataFormatter formatter6 = new DataFormatter();
//                            String s6 = formatter6.formatCellValue(currentCell);
                            carte.setNomAr(currentCell.getStringCellValue());
                            break;
                        case 7:
//                            DataFormatter formatter7 = new DataFormatter();
//                            String s7 = formatter7.formatCellValue(currentCell);
                            carte.setPrenomAr(currentCell.getStringCellValue());
                            break;
                        case 8:
                            DataFormatter formatter8 = new DataFormatter();
                            String s8 = formatter8.formatCellValue(currentCell);
                            carte.setCinn(s8);
                            break;
                        case 9:DataFormatter formatter9 = new DataFormatter();
                            String s9= formatter9.formatCellValue(currentCell);
                            carte.setCin(s9);
                            break;
                        case 10:
                            DataFormatter formatter10 = new DataFormatter();
                            String s10 = formatter10.formatCellValue(currentCell);
                            carte.setPprr(s10);
                            break;
                        case 11:
                            DataFormatter formatter11 = new DataFormatter();
                            String s11 = formatter11.formatCellValue(currentCell);
                            carte.setPpr(s11);
                            break;
                        case 12:
                            DataFormatter formatter12 = new DataFormatter();
                            String s12 = formatter12.formatCellValue(currentCell);
                            carte.setNaissance(s12);
                            break;
                        case 13:
                            DataFormatter formatter13 = new DataFormatter();
                            String s13 = formatter13.formatCellValue(currentCell);
                            carte.setDtNaissance(s13);
                            break;
                        case 14:
                            DataFormatter formatter14 = new DataFormatter();
                            String s14 = formatter14.formatCellValue(currentCell);
                            carte.setPhoto(s14);
                            break;
                        case 15:
                            DataFormatter formatter15 = new DataFormatter();
                            String s15 = formatter15.formatCellValue(currentCell);
                            carte.setCinnConjoint(s15);
                            break;
                        case 16:
                            DataFormatter formatter16 = new DataFormatter();
                            String s16 = formatter16.formatCellValue(currentCell);
                            carte.setCinConjoint(s16);
                            break;
                        case 17:
                            DataFormatter formatter17 = new DataFormatter();
                            String s17 = formatter17.formatCellValue(currentCell);
                            carte.setAdherent(s17);
                            break;
                        case 18:
                            DataFormatter formatter18 = new DataFormatter();
                            String s18 = formatter18.formatCellValue(currentCell);
                            carte.setNomAdherent(s18);
                            break;
                        case 19:
                            DataFormatter formatter19 = new DataFormatter();
                            String s19 = formatter19.formatCellValue(currentCell);
                            carte.setPrenomAdherent(s19);
                            break;
                        case 20:
                            DataFormatter formatter20 = new DataFormatter();
                            String s20 = formatter20.formatCellValue(currentCell);
                            carte.setCinnAdherent(s20);
                            break;
                        case 21:
                            DataFormatter formatter205 = new DataFormatter();
                            String s205 = formatter205.formatCellValue(currentCell);
                            carte.setCinAdherent(s205);
                            break;
                        case 22:
                            DataFormatter formatter21 = new DataFormatter();
                            String s21 = formatter21.formatCellValue(currentCell);
                            carte.setPprrAdherent(s21);
                            break;
                        case 23:
                            DataFormatter formatter22 = new DataFormatter();
                            String s22 = formatter22.formatCellValue(currentCell);
                            carte.setPprAdherent(s22);
                            break;
                        case 24:
                            DataFormatter formatter23 = new DataFormatter();
                            String s23 = formatter23.formatCellValue(currentCell);
                            carte.setVersocarte(s23);
                            break;
                        case 25:
                            DataFormatter formatter24 = new DataFormatter();
                            String s24 = formatter24.formatCellValue(currentCell);
                            carte.setAff1(s24);
                            break;
                        case 26:
                            DataFormatter formatter25 = new DataFormatter();
                            String s25 = formatter25.formatCellValue(currentCell);
                            carte.setAff2(s25);
                            break;
                        case 27:
                            DataFormatter formatter26 = new DataFormatter();
                            String s26 = formatter26.formatCellValue(currentCell);
                            carte.setNval(s26);
                            break;



                        default:
                            break;
                    }
                    cellIdx++;
                }
                cartes.add(carte);
            }
            workbook.close();
            return cartes;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}
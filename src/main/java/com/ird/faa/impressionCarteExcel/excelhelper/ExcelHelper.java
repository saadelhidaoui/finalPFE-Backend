package com.ird.faa.impressionCarteExcel.excelhelper;

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
                            if(s1==null)
                                carte.setAff("");
                            else
                                carte.setAff(s1);
                            break;
                        case 2:
                            DataFormatter formatter2 = new DataFormatter();
                            String s2 = formatter2.formatCellValue(currentCell);
                            if (s2==null)
                                carte.setQualite("");
                            else
                                carte.setQualite(s2);
                            break;
                        case 3:
                            DataFormatter formatter3 = new DataFormatter();
                            String s3 = formatter3.formatCellValue(currentCell);
                            if (s3==null)
                                carte.setNom("");
                            else
                                carte.setNom(s3);
                            break;
                        case 4:
                            DataFormatter formatter4 = new DataFormatter();
                            String s4 = formatter4.formatCellValue(currentCell);
                            if(s4==null)
                                carte.setPrenom("");
                            else
                                carte.setPrenom(s4);
                            break;
                        case 5:
                            DataFormatter formatter5 = new DataFormatter();
                            String s5 = formatter5.formatCellValue(currentCell);
                            if (s5==null)
                                carte.setNomprenomar("");
                            else
                                carte.setNomprenomar(s5);
                            break;
                        case 6:
                            DataFormatter formatter6 = new DataFormatter();
                            String s6 = formatter6.formatCellValue(currentCell);
                            if(s6==null)
                                carte.setNomAr("");
                            else
                                carte.setNomAr(s6);
                            break;
                        case 7:
                            DataFormatter formatter7 = new DataFormatter();
                            String s7 = formatter7.formatCellValue(currentCell);
                            if(s7==null)
                                carte.setPrenomAr("");
                            else
                                carte.setPrenomAr(s7);
                            break;
                        case 8:
                            DataFormatter formatter8 = new DataFormatter();
                            String s8 = formatter8.formatCellValue(currentCell);
                            if (s8==null)
                                carte.setCinn("");
                            else
                                carte.setCinn(s8);
                            break;
                        case 9:DataFormatter formatter9 = new DataFormatter();
                            String s9= formatter9.formatCellValue(currentCell);
                            if(s9==null)
                                carte.setCin("");
                            else
                                carte.setCin(s9);
                            break;
                        case 10:
                            DataFormatter formatter10 = new DataFormatter();
                            String s10 = formatter10.formatCellValue(currentCell);
                            if(s10==null)
                                carte.setPprr("");
                            else
                                carte.setPprr(s10);
                            break;
                        case 11:
                            DataFormatter formatter11 = new DataFormatter();
                            String s11 = formatter11.formatCellValue(currentCell);
                            if(s11==null)
                                carte.setPpr("");
                            else
                                carte.setPpr(s11);
                            break;
                        case 12:
                            DataFormatter formatter12 = new DataFormatter();
                            String s12 = formatter12.formatCellValue(currentCell);
                            if (s12==null)
                                carte.setNaissance("");
                            else
                                carte.setNaissance(s12);
                            break;
                        case 13:
                            DataFormatter formatter13 = new DataFormatter();
                            String s13 = formatter13.formatCellValue(currentCell);
                            if (s13==null)
                                carte.setDtNaissance("");
                            else
                                carte.setDtNaissance(s13);
                            break;
                        case 14:
                            DataFormatter formatter14 = new DataFormatter();
                            String s14 = formatter14.formatCellValue(currentCell);
                            if (s14==null)
                                carte.setPhoto("");
                            else
                                carte.setPhoto(s14);
                            break;
                        case 15:
                            DataFormatter formatter15 = new DataFormatter();
                            String s15 = formatter15.formatCellValue(currentCell);
                            if (s15==null)
                                carte.setCinnConjoint("");
                            else
                                carte.setCinnConjoint(s15);
                            break;
                        case 16:
                            DataFormatter formatter16 = new DataFormatter();
                            String s16 = formatter16.formatCellValue(currentCell);
                            if (s16==null)
                                carte.setCinConjoint("");
                            else
                                carte.setCinConjoint(s16);
                            break;
                        case 17:
                            DataFormatter formatter17 = new DataFormatter();
                            String s17 = formatter17.formatCellValue(currentCell);
                            if (s17==null)
                                carte.setAdherent("");
                            else
                                carte.setAdherent(s17);
                            break;
                        case 18:
                            DataFormatter formatter18 = new DataFormatter();
                            String s18 = formatter18.formatCellValue(currentCell);
                            if (s18==null)
                                carte.setNomAdherent("");
                            else
                                carte.setNomAdherent(s18);
                            break;
                        case 19:
                            DataFormatter formatter19 = new DataFormatter();
                            String s19 = formatter19.formatCellValue(currentCell);
                            if (s19==null)
                                carte.setPrenomAdherent("");
                            else
                                carte.setPrenomAdherent(s19);
                            break;
                        case 20:
                            DataFormatter formatter20 = new DataFormatter();
                            String s20 = formatter20.formatCellValue(currentCell);
                            if (s20==null)
                                carte.setCinnAdherent("");
                            else
                                carte.setCinnAdherent(s20);
                            break;
                        case 21:
                            DataFormatter formatter205 = new DataFormatter();
                            String s205 = formatter205.formatCellValue(currentCell);
                            if (s205==null)
                                carte.setCinAdherent("");
                            else
                                carte.setCinAdherent(s205);
                            break;
                        case 22:
                            DataFormatter formatter21 = new DataFormatter();
                            String s21 = formatter21.formatCellValue(currentCell);
                            if (s21==null)
                                carte.setPprrAdherent("");
                            else
                                carte.setPprrAdherent(s21);
                            break;
                        case 23:
                            DataFormatter formatter22 = new DataFormatter();
                            String s22 = formatter22.formatCellValue(currentCell);
                            if (s22==null)
                                carte.setPprAdherent("");
                            else
                                carte.setPprAdherent(s22);
                            break;
                        case 24:
                            DataFormatter formatter23 = new DataFormatter();
                            String s23 = formatter23.formatCellValue(currentCell);
                            if (s23==null)
                                carte.setVersocarte("");
                            else
                                carte.setVersocarte(s23);
                            break;
                        case 25:
                            DataFormatter formatter24 = new DataFormatter();
                            String s24 = formatter24.formatCellValue(currentCell);
                            if (s24==null)
                                carte.setAff1("");
                            else
                                carte.setAff1(s24);
                            break;
                        case 26:
                            DataFormatter formatter25 = new DataFormatter();
                            String s25 = formatter25.formatCellValue(currentCell);
                            if (s25==null)
                                carte.setAff2("");
                            else
                                carte.setAff2(s25);
                            break;
                        case 27:
                            DataFormatter formatter26 = new DataFormatter();
                            String s26 = formatter26.formatCellValue(currentCell);
                            if (s26==null)
                                carte.setNval("");
                            else
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
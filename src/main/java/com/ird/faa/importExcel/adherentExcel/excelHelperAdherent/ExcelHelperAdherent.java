package com.ird.faa.importExcel.adherentExcel.excelHelperAdherent;


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
public class ExcelHelperAdherent {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = {"numAdhesion", "cin", "nom", "prenom", "origine", "ville", "telephone", "qualite", "adresse", "ppr", "dtNaissance", "etatCarte", "dtArrivee", "dtReception", "statut", "fonction"};
    static String SHEET = "Adherents";
    @Autowired
    private  QualiteAdminService qualiteAdminService;
    @Autowired
    private  EtatCarteAdminService etatCarteAdminSerice;
    @Autowired
    private  FonctionAdminService fonctionAdminService;
    @Autowired
    private  StatutAdminService statutAdminService;
    @Autowired
    private  VilleAdminService villeAdminService;


    public static boolean hasExcelFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public  List<Adherent> excelToAdherent(InputStream is) {
        try {
            Workbook workbook = WorkbookFactory.create(is);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();
            List<Adherent> adherents = new ArrayList<Adherent>();
            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsInRow = currentRow.iterator();
                Adherent carte = new Adherent();
                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    switch (cellIdx) {

                        case 0:
                            DataFormatter formatter0 = new DataFormatter();
                            String s0 = formatter0.formatCellValue(currentCell);
                            carte.setNumAdhesion(s0);
                            break;
                        case 1:
                            DataFormatter formatter1 = new DataFormatter();
                            String s1 = formatter1.formatCellValue(currentCell);
                            carte.setCin(s1);
                            break;
                        case 2:
                            DataFormatter formatter2 = new DataFormatter();
                            String s2 = formatter2.formatCellValue(currentCell);
                            carte.setNom(s2);
                            break;
                        case 3:
                            DataFormatter formatter3 = new DataFormatter();
                            String s3 = formatter3.formatCellValue(currentCell);
                            carte.setPrenom(s3);
                            break;
                        case 4:
                            DataFormatter formatter4 = new DataFormatter();
                            String s4 = formatter4.formatCellValue(currentCell);
                            carte.setOrigine(s4);
                            break;
                        case 5:
                            DataFormatter formatter5 = new DataFormatter();
                            String s5 = formatter5.formatCellValue(currentCell);
                            Ville ville = villeAdminService.findByLibelle(s5);
                            carte.setVille(ville);
                            break;
                        case 6:
                            DataFormatter formatter6 = new DataFormatter();
                            String s6 = formatter6.formatCellValue(currentCell);
                            carte.setTelephone(s6);
                            break;
                        case 7:
                            DataFormatter formatter7 = new DataFormatter();
                            String s7 = formatter7.formatCellValue(currentCell);
                            Qualite qualite = qualiteAdminService.findByLibelle(s7);
                            carte.setQualite(qualite);
                            break;
                        case 8:
                            DataFormatter formatter8 = new DataFormatter();
                            String s8 = formatter8.formatCellValue(currentCell);
                            carte.setAdresse(s8);
                            break;
                        case 9:DataFormatter formatter9 = new DataFormatter();
                            String s9= formatter9.formatCellValue(currentCell);
                            carte.setPpr(s9);
                            break;
                        case 10:
                            DataFormatter formatter10 = new DataFormatter();
                            String s10 = formatter10.formatCellValue(currentCell);
                            carte.setDtNaissance(s10);
                            break;
                        case 11:
                            DataFormatter formatter11 = new DataFormatter();
                            String s11 = formatter11.formatCellValue(currentCell);
                            EtatCarte etatCarte = etatCarteAdminSerice.findByLibelle(s11);
                            carte.setEtatCarte(etatCarte);
                            break;
                        case 12:
                            DataFormatter formatter12 = new DataFormatter();
                            String s12 = formatter12.formatCellValue(currentCell);
                            carte.setDtArrivee(s12);
                            break;
                        case 13:
                            DataFormatter formatter13 = new DataFormatter();
                            String s13 = formatter13.formatCellValue(currentCell);
                            carte.setDtReception(s13);
                            break;
                        case 14:
                            DataFormatter formatter14 = new DataFormatter();
                            String s14 = formatter14.formatCellValue(currentCell);
                            Statut statut = statutAdminService.findByLibelle(s14);
                            carte.setStatut(statut);
                            break;
                        case 15:
                            DataFormatter formatter15 = new DataFormatter();
                            String s15 = formatter15.formatCellValue(currentCell);
                            Fonction fonction = fonctionAdminService.findByLibelle(s15);
                            carte.setFonction(fonction);
                            break;
                        default:
                            break;
                    }
                    cellIdx++;
                }
                adherents.add(carte);
            }
            workbook.close();
            return adherents;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}
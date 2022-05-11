package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Reclamation;
import com.ird.faa.ws.rest.provided.vo.ReclamationVo;

@Component
public class ReclamationConverter extends AbstractConverter<Reclamation,ReclamationVo>{

        @Autowired
        private AdherentConverter adherentConverter ;
        @Autowired
        private PieceJointeReclamationConverter pieceJointeReclamationConverter ;
        @Autowired
        private EtatReclamationConverter etatReclamationConverter ;
        private Boolean adherent;
        private Boolean etatReclamation;
        private Boolean pieceJointeReclamations;

public  ReclamationConverter(){
init(true);
}

@Override
public Reclamation toItem(ReclamationVo vo) {
if (vo == null) {
return null;
} else {
Reclamation item = new Reclamation();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getDescription()))
        item.setDescription(vo.getDescription());
        if(StringUtil.isNotEmpty(vo.getDateReclamation()))
        item.setDateReclamation(DateUtil.parse(vo.getDateReclamation()));
            if(vo.getArchive() != null)
            item.setArchive(vo.getArchive());
        if(StringUtil.isNotEmpty(vo.getDateArchivage()))
        item.setDateArchivage(DateUtil.parse(vo.getDateArchivage()));
        if(StringUtil.isNotEmpty(vo.getDateCreation()))
        item.setDateCreation(DateUtil.parse(vo.getDateCreation()));
            if(vo.getAdmin() != null)
            item.setAdmin(vo.getAdmin());
            if(vo.getVisible() != null)
            item.setVisible(vo.getVisible());
        if(StringUtil.isNotEmpty(vo.getUsername()))
        item.setUsername(vo.getUsername());
    if(vo.getAdherentVo()!=null && this.adherent)
        item.setAdherent(adherentConverter.toItem(vo.getAdherentVo())) ;
    if(vo.getEtatReclamationVo()!=null && this.etatReclamation)
        item.setEtatReclamation(etatReclamationConverter.toItem(vo.getEtatReclamationVo())) ;

    if(ListUtil.isNotEmpty(vo.getPieceJointeReclamationsVo()) && this.pieceJointeReclamations)
        item.setPieceJointeReclamations(pieceJointeReclamationConverter.toItem(vo.getPieceJointeReclamationsVo()));

return item;
}
}

@Override
public ReclamationVo toVo(Reclamation item) {
if (item == null) {
return null;
} else {
ReclamationVo vo = new ReclamationVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(StringUtil.isNotEmpty(item.getDescription()))
        vo.setDescription(item.getDescription());

        if(item.getDateReclamation()!=null)
        vo.setDateReclamation(DateUtil.formateDate(item.getDateReclamation()));

        if(item.getArchive()!=null)
        vo.setArchive(item.getArchive());
        if(item.getDateArchivage()!=null)
        vo.setDateArchivage(DateUtil.formateDate(item.getDateArchivage()));
        if(item.getDateCreation()!=null)
        vo.setDateCreation(DateUtil.formateDate(item.getDateCreation()));
        if(item.getAdmin()!=null)
        vo.setAdmin(item.getAdmin());
        if(item.getVisible()!=null)
        vo.setVisible(item.getVisible());
        if(StringUtil.isNotEmpty(item.getUsername()))
        vo.setUsername(item.getUsername());

    if(item.getAdherent()!=null && this.adherent) {
        vo.setAdherentVo(adherentConverter.toVo(item.getAdherent())) ;
    }
    if(item.getEtatReclamation()!=null && this.etatReclamation) {
        vo.setEtatReclamationVo(etatReclamationConverter.toVo(item.getEtatReclamation())) ;
    }
        if(ListUtil.isNotEmpty(item.getPieceJointeReclamations()) && this.pieceJointeReclamations){
        pieceJointeReclamationConverter.init(true);
        pieceJointeReclamationConverter.setReclamation(false);
        vo.setPieceJointeReclamationsVo(pieceJointeReclamationConverter.toVo(item.getPieceJointeReclamations()));
        pieceJointeReclamationConverter.setReclamation(true);
        }

return vo;
}
}

public void init(Boolean value) {
    adherent = value;
    etatReclamation = value;
        pieceJointeReclamations = value;
}


        public AdherentConverter getAdherentConverter(){
        return this.adherentConverter;
        }
        public void setAdherentConverter(AdherentConverter adherentConverter ){
        this.adherentConverter = adherentConverter;
        }
        public PieceJointeReclamationConverter getPieceJointeReclamationConverter(){
        return this.pieceJointeReclamationConverter;
        }
        public void setPieceJointeReclamationConverter(PieceJointeReclamationConverter pieceJointeReclamationConverter ){
        this.pieceJointeReclamationConverter = pieceJointeReclamationConverter;
        }
        public EtatReclamationConverter getEtatReclamationConverter(){
        return this.etatReclamationConverter;
        }
        public void setEtatReclamationConverter(EtatReclamationConverter etatReclamationConverter ){
        this.etatReclamationConverter = etatReclamationConverter;
        }

    public boolean  isAdherent(){
    return this.adherent;
    }
    public void  setAdherent(boolean adherent){
    this.adherent = adherent;
    }
    public boolean  isEtatReclamation(){
    return this.etatReclamation;
    }
    public void  setEtatReclamation(boolean etatReclamation){
    this.etatReclamation = etatReclamation;
    }















        public Boolean  isPieceJointeReclamations(){
        return this.pieceJointeReclamations ;
        }
        public void  setPieceJointeReclamations(Boolean pieceJointeReclamations ){
        this.pieceJointeReclamations  = pieceJointeReclamations ;
        }














}

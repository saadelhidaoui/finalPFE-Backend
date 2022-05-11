package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Projet;
import com.ird.faa.ws.rest.provided.vo.ProjetVo;

@Component
public class ProjetConverter extends AbstractConverter<Projet,ProjetVo>{

        @Autowired
        private PieceJointeProjetConverter pieceJointeProjetConverter ;
        @Autowired
        private EtatProjetConverter etatProjetConverter ;
        private Boolean etatProjet;
        private Boolean pieceJointeProjets;

public  ProjetConverter(){
init(true);
}

@Override
public Projet toItem(ProjetVo vo) {
if (vo == null) {
return null;
} else {
Projet item = new Projet();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getDescription()))
        item.setDescription(vo.getDescription());
        if(StringUtil.isNotEmpty(vo.getDateDebut()))
        item.setDateDebut(DateUtil.parse(vo.getDateDebut()));
        if(StringUtil.isNotEmpty(vo.getPv()))
        item.setPv(vo.getPv());
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
    if(vo.getEtatProjetVo()!=null && this.etatProjet)
        item.setEtatProjet(etatProjetConverter.toItem(vo.getEtatProjetVo())) ;

    if(ListUtil.isNotEmpty(vo.getPieceJointeProjetsVo()) && this.pieceJointeProjets)
        item.setPieceJointeProjets(pieceJointeProjetConverter.toItem(vo.getPieceJointeProjetsVo()));

return item;
}
}

@Override
public ProjetVo toVo(Projet item) {
if (item == null) {
return null;
} else {
ProjetVo vo = new ProjetVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(StringUtil.isNotEmpty(item.getDescription()))
        vo.setDescription(item.getDescription());

        if(item.getDateDebut()!=null)
        vo.setDateDebut(DateUtil.formateDate(item.getDateDebut()));
        if(StringUtil.isNotEmpty(item.getPv()))
        vo.setPv(item.getPv());

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

    if(item.getEtatProjet()!=null && this.etatProjet) {
        vo.setEtatProjetVo(etatProjetConverter.toVo(item.getEtatProjet())) ;
    }
        if(ListUtil.isNotEmpty(item.getPieceJointeProjets()) && this.pieceJointeProjets){
        pieceJointeProjetConverter.init(true);
        pieceJointeProjetConverter.setProjet(false);
        vo.setPieceJointeProjetsVo(pieceJointeProjetConverter.toVo(item.getPieceJointeProjets()));
        pieceJointeProjetConverter.setProjet(true);
        }

return vo;
}
}

public void init(Boolean value) {
    etatProjet = value;
        pieceJointeProjets = value;
}


        public PieceJointeProjetConverter getPieceJointeProjetConverter(){
        return this.pieceJointeProjetConverter;
        }
        public void setPieceJointeProjetConverter(PieceJointeProjetConverter pieceJointeProjetConverter ){
        this.pieceJointeProjetConverter = pieceJointeProjetConverter;
        }
        public EtatProjetConverter getEtatProjetConverter(){
        return this.etatProjetConverter;
        }
        public void setEtatProjetConverter(EtatProjetConverter etatProjetConverter ){
        this.etatProjetConverter = etatProjetConverter;
        }

    public boolean  isEtatProjet(){
    return this.etatProjet;
    }
    public void  setEtatProjet(boolean etatProjet){
    this.etatProjet = etatProjet;
    }













        public Boolean  isPieceJointeProjets(){
        return this.pieceJointeProjets ;
        }
        public void  setPieceJointeProjets(Boolean pieceJointeProjets ){
        this.pieceJointeProjets  = pieceJointeProjets ;
        }














}

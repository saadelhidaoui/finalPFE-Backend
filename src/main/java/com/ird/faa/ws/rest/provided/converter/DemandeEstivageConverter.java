package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.DemandeEstivage;
import com.ird.faa.ws.rest.provided.vo.DemandeEstivageVo;

@Component
public class DemandeEstivageConverter extends AbstractConverter<DemandeEstivage,DemandeEstivageVo>{

        @Autowired
        private AdherentConverter adherentConverter ;
        @Autowired
        private EtatDemandeEstivageConverter etatDemandeEstivageConverter ;
        @Autowired
        private PieceJointeEstivageConverter pieceJointeEstivageConverter ;
        @Autowired
        private DemandeEstivageCentreConverter demandeEstivageCentreConverter ;
        @Autowired
        private EstivageCentreEstivageConverter estivageCentreEstivageConverter ;
    private Boolean demandeEstivageCentre;
    private Boolean adherent;
    private Boolean etatDemandeEstivage;
    private Boolean estivageCentreEstivage;
        private Boolean pieceJointeEstivages;

public  DemandeEstivageConverter(){
init(true);
}

@Override
public DemandeEstivage toItem(DemandeEstivageVo vo) {
if (vo == null) {
return null;
} else {
DemandeEstivage item = new DemandeEstivage();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getDateDebutEstivage()))
        item.setDateDebutEstivage(DateUtil.parse(vo.getDateDebutEstivage()));
        if(StringUtil.isNotEmpty(vo.getDateFinEstivage()))
        item.setDateFinEstivage(DateUtil.parse(vo.getDateFinEstivage()));
        if(StringUtil.isNotEmpty(vo.getDateTraitement()))
        item.setDateTraitement(DateUtil.parse(vo.getDateTraitement()));
    if(vo.getDemandeEstivageCentreVo()!=null && this.demandeEstivageCentre)
        item.setDemandeEstivageCentre(demandeEstivageCentreConverter.toItem(vo.getDemandeEstivageCentreVo())) ;
    if(vo.getAdherentVo()!=null && this.adherent)
        item.setAdherent(adherentConverter.toItem(vo.getAdherentVo())) ;
    if(vo.getEtatDemandeEstivageVo()!=null && this.etatDemandeEstivage)
        item.setEtatDemandeEstivage(etatDemandeEstivageConverter.toItem(vo.getEtatDemandeEstivageVo())) ;
    if(vo.getEstivageCentreEstivageVo()!=null && this.estivageCentreEstivage)
        item.setEstivageCentreEstivage(estivageCentreEstivageConverter.toItem(vo.getEstivageCentreEstivageVo())) ;

    if(ListUtil.isNotEmpty(vo.getPieceJointeEstivagesVo()) && this.pieceJointeEstivages)
        item.setPieceJointeEstivages(pieceJointeEstivageConverter.toItem(vo.getPieceJointeEstivagesVo()));

return item;
}
}

@Override
public DemandeEstivageVo toVo(DemandeEstivage item) {
if (item == null) {
return null;
} else {
DemandeEstivageVo vo = new DemandeEstivageVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(item.getDateDebutEstivage()!=null)
        vo.setDateDebutEstivage(DateUtil.formateDate(item.getDateDebutEstivage()));
        if(item.getDateFinEstivage()!=null)
        vo.setDateFinEstivage(DateUtil.formateDate(item.getDateFinEstivage()));
        if(item.getDateTraitement()!=null)
        vo.setDateTraitement(DateUtil.formateDate(item.getDateTraitement()));

    if(item.getDemandeEstivageCentre()!=null && this.demandeEstivageCentre) {
                demandeEstivageCentreConverter.setDemandeEstivage(false);
        vo.setDemandeEstivageCentreVo(demandeEstivageCentreConverter.toVo(item.getDemandeEstivageCentre())) ;
                demandeEstivageCentreConverter.setDemandeEstivage(true);
    }
    if(item.getAdherent()!=null && this.adherent) {
        vo.setAdherentVo(adherentConverter.toVo(item.getAdherent())) ;
    }
    if(item.getEtatDemandeEstivage()!=null && this.etatDemandeEstivage) {
        vo.setEtatDemandeEstivageVo(etatDemandeEstivageConverter.toVo(item.getEtatDemandeEstivage())) ;
    }
    if(item.getEstivageCentreEstivage()!=null && this.estivageCentreEstivage) {
        vo.setEstivageCentreEstivageVo(estivageCentreEstivageConverter.toVo(item.getEstivageCentreEstivage())) ;
    }
        if(ListUtil.isNotEmpty(item.getPieceJointeEstivages()) && this.pieceJointeEstivages){
        pieceJointeEstivageConverter.init(true);
        vo.setPieceJointeEstivagesVo(pieceJointeEstivageConverter.toVo(item.getPieceJointeEstivages()));
        }

return vo;
}
}

public void init(Boolean value) {
    demandeEstivageCentre = value;
    adherent = value;
    etatDemandeEstivage = value;
    estivageCentreEstivage = value;
        pieceJointeEstivages = value;
}


        public AdherentConverter getAdherentConverter(){
        return this.adherentConverter;
        }
        public void setAdherentConverter(AdherentConverter adherentConverter ){
        this.adherentConverter = adherentConverter;
        }
        public EtatDemandeEstivageConverter getEtatDemandeEstivageConverter(){
        return this.etatDemandeEstivageConverter;
        }
        public void setEtatDemandeEstivageConverter(EtatDemandeEstivageConverter etatDemandeEstivageConverter ){
        this.etatDemandeEstivageConverter = etatDemandeEstivageConverter;
        }
        public PieceJointeEstivageConverter getPieceJointeEstivageConverter(){
        return this.pieceJointeEstivageConverter;
        }
        public void setPieceJointeEstivageConverter(PieceJointeEstivageConverter pieceJointeEstivageConverter ){
        this.pieceJointeEstivageConverter = pieceJointeEstivageConverter;
        }
        public DemandeEstivageCentreConverter getDemandeEstivageCentreConverter(){
        return this.demandeEstivageCentreConverter;
        }
        public void setDemandeEstivageCentreConverter(DemandeEstivageCentreConverter demandeEstivageCentreConverter ){
        this.demandeEstivageCentreConverter = demandeEstivageCentreConverter;
        }
        public EstivageCentreEstivageConverter getEstivageCentreEstivageConverter(){
        return this.estivageCentreEstivageConverter;
        }
        public void setEstivageCentreEstivageConverter(EstivageCentreEstivageConverter estivageCentreEstivageConverter ){
        this.estivageCentreEstivageConverter = estivageCentreEstivageConverter;
        }

    public boolean  isDemandeEstivageCentre(){
    return this.demandeEstivageCentre;
    }
    public void  setDemandeEstivageCentre(boolean demandeEstivageCentre){
    this.demandeEstivageCentre = demandeEstivageCentre;
    }
    public boolean  isAdherent(){
    return this.adherent;
    }
    public void  setAdherent(boolean adherent){
    this.adherent = adherent;
    }
    public boolean  isEtatDemandeEstivage(){
    return this.etatDemandeEstivage;
    }
    public void  setEtatDemandeEstivage(boolean etatDemandeEstivage){
    this.etatDemandeEstivage = etatDemandeEstivage;
    }
    public boolean  isEstivageCentreEstivage(){
    return this.estivageCentreEstivage;
    }
    public void  setEstivageCentreEstivage(boolean estivageCentreEstivage){
    this.estivageCentreEstivage = estivageCentreEstivage;
    }



















        public Boolean  isPieceJointeEstivages(){
        return this.pieceJointeEstivages ;
        }
        public void  setPieceJointeEstivages(Boolean pieceJointeEstivages ){
        this.pieceJointeEstivages  = pieceJointeEstivages ;
        }


}

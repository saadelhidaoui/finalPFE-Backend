package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Prestation;
import com.ird.faa.ws.rest.provided.vo.PrestationVo;

@Component
public class PrestationConverter extends AbstractConverter<Prestation,PrestationVo>{

        @Autowired
        private AdherentConverter adherentConverter ;
        @Autowired
        private EtatPrestationConverter etatPrestationConverter ;
        @Autowired
        private PieceJointePrestationConverter pieceJointePrestationConverter ;
        @Autowired
        private NiveauImportanceConverter niveauImportanceConverter ;
        @Autowired
        private TypePrestationConverter typePrestationConverter ;
    private Boolean etatPrestation;
    private Boolean niveauImportance;
    private Boolean typePrestation;
    private Boolean adherent;
        private Boolean pieceJointePrestations;

public  PrestationConverter(){
init(true);
}

@Override
public Prestation toItem(PrestationVo vo) {
if (vo == null) {
return null;
} else {
Prestation item = new Prestation();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getNumArrivee()))
        item.setNumArrivee(vo.getNumArrivee());
            if(vo.getEnvoye() != null)
            item.setEnvoye(vo.getEnvoye());
        if(StringUtil.isNotEmpty(vo.getDateEnvoi()))
        item.setDateEnvoi(DateUtil.parse(vo.getDateEnvoi()));
        if(StringUtil.isNotEmpty(vo.getDateTraitement()))
        item.setDateTraitement(DateUtil.parse(vo.getDateTraitement()));
        if(StringUtil.isNotEmpty(vo.getChargeCas()))
        item.setChargeCas(vo.getChargeCas());
            if(vo.getResultat() != null)
            item.setResultat(vo.getResultat());
        if(StringUtil.isNotEmpty(vo.getNotes()))
        item.setNotes(vo.getNotes());
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
    if(vo.getEtatPrestationVo()!=null && this.etatPrestation)
        item.setEtatPrestation(etatPrestationConverter.toItem(vo.getEtatPrestationVo())) ;
    if(vo.getNiveauImportanceVo()!=null && this.niveauImportance)
        item.setNiveauImportance(niveauImportanceConverter.toItem(vo.getNiveauImportanceVo())) ;
    if(vo.getTypePrestationVo()!=null && this.typePrestation)
        item.setTypePrestation(typePrestationConverter.toItem(vo.getTypePrestationVo())) ;
    if(vo.getAdherentVo()!=null && this.adherent)
        item.setAdherent(adherentConverter.toItem(vo.getAdherentVo())) ;

    if(ListUtil.isNotEmpty(vo.getPieceJointePrestationsVo()) && this.pieceJointePrestations)
        item.setPieceJointePrestations(pieceJointePrestationConverter.toItem(vo.getPieceJointePrestationsVo()));

return item;
}
}

@Override
public PrestationVo toVo(Prestation item) {
if (item == null) {
return null;
} else {
PrestationVo vo = new PrestationVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(StringUtil.isNotEmpty(item.getNumArrivee()))
        vo.setNumArrivee(item.getNumArrivee());

        if(item.getEnvoye()!=null)
        vo.setEnvoye(item.getEnvoye());
        if(item.getDateEnvoi()!=null)
        vo.setDateEnvoi(DateUtil.formateDate(item.getDateEnvoi()));
        if(item.getDateTraitement()!=null)
        vo.setDateTraitement(DateUtil.formateDate(item.getDateTraitement()));
        if(StringUtil.isNotEmpty(item.getChargeCas()))
        vo.setChargeCas(item.getChargeCas());

        if(item.getResultat()!=null)
        vo.setResultat(item.getResultat());
        if(StringUtil.isNotEmpty(item.getNotes()))
        vo.setNotes(item.getNotes());

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

    if(item.getEtatPrestation()!=null && this.etatPrestation) {
        vo.setEtatPrestationVo(etatPrestationConverter.toVo(item.getEtatPrestation())) ;
    }
    if(item.getNiveauImportance()!=null && this.niveauImportance) {
        vo.setNiveauImportanceVo(niveauImportanceConverter.toVo(item.getNiveauImportance())) ;
    }
    if(item.getTypePrestation()!=null && this.typePrestation) {
        vo.setTypePrestationVo(typePrestationConverter.toVo(item.getTypePrestation())) ;
    }
    if(item.getAdherent()!=null && this.adherent) {
        vo.setAdherentVo(adherentConverter.toVo(item.getAdherent())) ;
    }
        if(ListUtil.isNotEmpty(item.getPieceJointePrestations()) && this.pieceJointePrestations){
        pieceJointePrestationConverter.init(true);
        pieceJointePrestationConverter.setPrestation(false);
        vo.setPieceJointePrestationsVo(pieceJointePrestationConverter.toVo(item.getPieceJointePrestations()));
        pieceJointePrestationConverter.setPrestation(true);
        }

return vo;
}
}

public void init(Boolean value) {
    etatPrestation = value;
    niveauImportance = value;
    typePrestation = value;
    adherent = value;
        pieceJointePrestations = value;
}


        public AdherentConverter getAdherentConverter(){
        return this.adherentConverter;
        }
        public void setAdherentConverter(AdherentConverter adherentConverter ){
        this.adherentConverter = adherentConverter;
        }
        public EtatPrestationConverter getEtatPrestationConverter(){
        return this.etatPrestationConverter;
        }
        public void setEtatPrestationConverter(EtatPrestationConverter etatPrestationConverter ){
        this.etatPrestationConverter = etatPrestationConverter;
        }
        public PieceJointePrestationConverter getPieceJointePrestationConverter(){
        return this.pieceJointePrestationConverter;
        }
        public void setPieceJointePrestationConverter(PieceJointePrestationConverter pieceJointePrestationConverter ){
        this.pieceJointePrestationConverter = pieceJointePrestationConverter;
        }
        public NiveauImportanceConverter getNiveauImportanceConverter(){
        return this.niveauImportanceConverter;
        }
        public void setNiveauImportanceConverter(NiveauImportanceConverter niveauImportanceConverter ){
        this.niveauImportanceConverter = niveauImportanceConverter;
        }
        public TypePrestationConverter getTypePrestationConverter(){
        return this.typePrestationConverter;
        }
        public void setTypePrestationConverter(TypePrestationConverter typePrestationConverter ){
        this.typePrestationConverter = typePrestationConverter;
        }

    public boolean  isEtatPrestation(){
    return this.etatPrestation;
    }
    public void  setEtatPrestation(boolean etatPrestation){
    this.etatPrestation = etatPrestation;
    }
    public boolean  isNiveauImportance(){
    return this.niveauImportance;
    }
    public void  setNiveauImportance(boolean niveauImportance){
    this.niveauImportance = niveauImportance;
    }
    public boolean  isTypePrestation(){
    return this.typePrestation;
    }
    public void  setTypePrestation(boolean typePrestation){
    this.typePrestation = typePrestation;
    }
    public boolean  isAdherent(){
    return this.adherent;
    }
    public void  setAdherent(boolean adherent){
    this.adherent = adherent;
    }



























        public Boolean  isPieceJointePrestations(){
        return this.pieceJointePrestations ;
        }
        public void  setPieceJointePrestations(Boolean pieceJointePrestations ){
        this.pieceJointePrestations  = pieceJointePrestations ;
        }














}

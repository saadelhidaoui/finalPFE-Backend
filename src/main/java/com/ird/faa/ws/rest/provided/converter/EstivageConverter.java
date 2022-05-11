package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Estivage;
import com.ird.faa.ws.rest.provided.vo.EstivageVo;

@Component
public class EstivageConverter extends AbstractConverter<Estivage,EstivageVo>{

        @Autowired
        private CentreEstivageConverter centreEstivageConverter ;
        @Autowired
        private NiveauImportanceConverter niveauImportanceConverter ;
    private Boolean centreEstivage;
    private Boolean niveauImportance;

public  EstivageConverter(){
init(true);
}

@Override
public Estivage toItem(EstivageVo vo) {
if (vo == null) {
return null;
} else {
Estivage item = new Estivage();
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
        if(StringUtil.isNotEmpty(vo.getNotes()))
        item.setNotes(vo.getNotes());
        if(StringUtil.isNotEmpty(vo.getChargeCas()))
        item.setChargeCas(vo.getChargeCas());
            if(vo.getResultat() != null)
            item.setResultat(vo.getResultat());
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
    if(vo.getCentreEstivageVo()!=null && this.centreEstivage)
        item.setCentreEstivage(centreEstivageConverter.toItem(vo.getCentreEstivageVo())) ;
    if(vo.getNiveauImportanceVo()!=null && this.niveauImportance)
        item.setNiveauImportance(niveauImportanceConverter.toItem(vo.getNiveauImportanceVo())) ;


return item;
}
}

@Override
public EstivageVo toVo(Estivage item) {
if (item == null) {
return null;
} else {
EstivageVo vo = new EstivageVo();
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
        if(StringUtil.isNotEmpty(item.getNotes()))
        vo.setNotes(item.getNotes());

        if(StringUtil.isNotEmpty(item.getChargeCas()))
        vo.setChargeCas(item.getChargeCas());

        if(item.getResultat()!=null)
        vo.setResultat(item.getResultat());
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

    if(item.getCentreEstivage()!=null && this.centreEstivage) {
        vo.setCentreEstivageVo(centreEstivageConverter.toVo(item.getCentreEstivage())) ;
    }
    if(item.getNiveauImportance()!=null && this.niveauImportance) {
        vo.setNiveauImportanceVo(niveauImportanceConverter.toVo(item.getNiveauImportance())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    centreEstivage = value;
    niveauImportance = value;
}


        public CentreEstivageConverter getCentreEstivageConverter(){
        return this.centreEstivageConverter;
        }
        public void setCentreEstivageConverter(CentreEstivageConverter centreEstivageConverter ){
        this.centreEstivageConverter = centreEstivageConverter;
        }
        public NiveauImportanceConverter getNiveauImportanceConverter(){
        return this.niveauImportanceConverter;
        }
        public void setNiveauImportanceConverter(NiveauImportanceConverter niveauImportanceConverter ){
        this.niveauImportanceConverter = niveauImportanceConverter;
        }

    public boolean  isCentreEstivage(){
    return this.centreEstivage;
    }
    public void  setCentreEstivage(boolean centreEstivage){
    this.centreEstivage = centreEstivage;
    }
    public boolean  isNiveauImportance(){
    return this.niveauImportance;
    }
    public void  setNiveauImportance(boolean niveauImportance){
    this.niveauImportance = niveauImportance;
    }
































}

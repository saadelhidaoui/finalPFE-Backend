package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Enfant;
import com.ird.faa.ws.rest.provided.vo.EnfantVo;

@Component
public class EnfantConverter extends AbstractConverter<Enfant,EnfantVo>{

        @Autowired
        private AdherentConverter adherentConverter ;
        @Autowired
        private QualiteConverter qualiteConverter ;
    private Boolean qualite;
    private Boolean adherent;

public  EnfantConverter(){
init(true);
}

@Override
public Enfant toItem(EnfantVo vo) {
if (vo == null) {
return null;
} else {
Enfant item = new Enfant();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getNom()))
        item.setNom(vo.getNom());
        if(StringUtil.isNotEmpty(vo.getPrenom()))
        item.setPrenom(vo.getPrenom());
        if(StringUtil.isNotEmpty(vo.getAge()))
        item.setAge(NumberUtil.toLong(vo.getAge()));
        if(StringUtil.isNotEmpty(vo.getDateNaissance()))
        item.setDateNaissance(DateUtil.parse(vo.getDateNaissance()));
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
    if(vo.getQualiteVo()!=null && this.qualite)
        item.setQualite(qualiteConverter.toItem(vo.getQualiteVo())) ;
    if(vo.getAdherentVo()!=null && this.adherent)
        item.setAdherent(adherentConverter.toItem(vo.getAdherentVo())) ;


return item;
}
}

@Override
public EnfantVo toVo(Enfant item) {
if (item == null) {
return null;
} else {
EnfantVo vo = new EnfantVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(StringUtil.isNotEmpty(item.getNom()))
        vo.setNom(item.getNom());

        if(StringUtil.isNotEmpty(item.getPrenom()))
        vo.setPrenom(item.getPrenom());

        if(item.getAge()!=null)
        vo.setAge(NumberUtil.toString(item.getAge()));

        if(item.getDateNaissance()!=null)
        vo.setDateNaissance(DateUtil.formateDate(item.getDateNaissance()));
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

    if(item.getQualite()!=null && this.qualite) {
        vo.setQualiteVo(qualiteConverter.toVo(item.getQualite())) ;
    }
    if(item.getAdherent()!=null && this.adherent) {
        vo.setAdherentVo(adherentConverter.toVo(item.getAdherent())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    qualite = value;
    adherent = value;
}


        public AdherentConverter getAdherentConverter(){
        return this.adherentConverter;
        }
        public void setAdherentConverter(AdherentConverter adherentConverter ){
        this.adherentConverter = adherentConverter;
        }
        public QualiteConverter getQualiteConverter(){
        return this.qualiteConverter;
        }
        public void setQualiteConverter(QualiteConverter qualiteConverter ){
        this.qualiteConverter = qualiteConverter;
        }

    public boolean  isQualite(){
    return this.qualite;
    }
    public void  setQualite(boolean qualite){
    this.qualite = qualite;
    }
    public boolean  isAdherent(){
    return this.adherent;
    }
    public void  setAdherent(boolean adherent){
    this.adherent = adherent;
    }




























}

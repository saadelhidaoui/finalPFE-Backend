package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Conjoint;
import com.ird.faa.ws.rest.provided.vo.ConjointVo;

@Component
public class ConjointConverter extends AbstractConverter<Conjoint,ConjointVo>{

        @Autowired
        private AdherentConverter adherentConverter ;
        @Autowired
        private QualiteConverter qualiteConverter ;
    private Boolean qualite;
    private Boolean adherent;

public  ConjointConverter(){
init(true);
}

@Override
public Conjoint toItem(ConjointVo vo) {
if (vo == null) {
return null;
} else {
Conjoint item = new Conjoint();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getCin()))
        item.setCin(vo.getCin());
        if(StringUtil.isNotEmpty(vo.getNom()))
        item.setNom(vo.getNom());
        if(StringUtil.isNotEmpty(vo.getPrenom()))
        item.setPrenom(vo.getPrenom());
        if(StringUtil.isNotEmpty(vo.getOrigin()))
        item.setOrigin(vo.getOrigin());
        if(StringUtil.isNotEmpty(vo.getEmail()))
        item.setEmail(vo.getEmail());
        if(StringUtil.isNotEmpty(vo.getTelephone()))
        item.setTelephone(vo.getTelephone());
    if(vo.getQualiteVo()!=null && this.qualite)
        item.setQualite(qualiteConverter.toItem(vo.getQualiteVo())) ;
    if(vo.getAdherentVo()!=null && this.adherent)
        item.setAdherent(adherentConverter.toItem(vo.getAdherentVo())) ;


return item;
}
}

@Override
public ConjointVo toVo(Conjoint item) {
if (item == null) {
return null;
} else {
ConjointVo vo = new ConjointVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getCin()))
        vo.setCin(item.getCin());

        if(StringUtil.isNotEmpty(item.getNom()))
        vo.setNom(item.getNom());

        if(StringUtil.isNotEmpty(item.getPrenom()))
        vo.setPrenom(item.getPrenom());

        if(StringUtil.isNotEmpty(item.getOrigin()))
        vo.setOrigin(item.getOrigin());

        if(StringUtil.isNotEmpty(item.getEmail()))
        vo.setEmail(item.getEmail());

        if(StringUtil.isNotEmpty(item.getTelephone()))
        vo.setTelephone(item.getTelephone());

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

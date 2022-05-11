package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Tache;
import com.ird.faa.ws.rest.provided.vo.TacheVo;

@Component
public class TacheConverter extends AbstractConverter<Tache,TacheVo>{

        @Autowired
        private EtatTacheConverter etatTacheConverter ;
        @Autowired
        private ModerateurConverter moderateurConverter ;
    private Boolean etatTache;
    private Boolean moderateur;

public  TacheConverter(){
init(true);
}

@Override
public Tache toItem(TacheVo vo) {
if (vo == null) {
return null;
} else {
Tache item = new Tache();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getDateTache()))
        item.setDateTache(DateUtil.parse(vo.getDateTache()));
        if(StringUtil.isNotEmpty(vo.getDescription()))
        item.setDescription(vo.getDescription());
    if(vo.getEtatTacheVo()!=null && this.etatTache)
        item.setEtatTache(etatTacheConverter.toItem(vo.getEtatTacheVo())) ;
    if(vo.getModerateurVo()!=null && this.moderateur)
        item.setModerateur(moderateurConverter.toItem(vo.getModerateurVo())) ;


return item;
}
}

@Override
public TacheVo toVo(Tache item) {
if (item == null) {
return null;
} else {
TacheVo vo = new TacheVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(item.getDateTache()!=null)
        vo.setDateTache(DateUtil.formateDate(item.getDateTache()));
        if(StringUtil.isNotEmpty(item.getDescription()))
        vo.setDescription(item.getDescription());

    if(item.getEtatTache()!=null && this.etatTache) {
        vo.setEtatTacheVo(etatTacheConverter.toVo(item.getEtatTache())) ;
    }
    if(item.getModerateur()!=null && this.moderateur) {
        vo.setModerateurVo(moderateurConverter.toVo(item.getModerateur())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    etatTache = value;
    moderateur = value;
}


        public EtatTacheConverter getEtatTacheConverter(){
        return this.etatTacheConverter;
        }
        public void setEtatTacheConverter(EtatTacheConverter etatTacheConverter ){
        this.etatTacheConverter = etatTacheConverter;
        }
        public ModerateurConverter getModerateurConverter(){
        return this.moderateurConverter;
        }
        public void setModerateurConverter(ModerateurConverter moderateurConverter ){
        this.moderateurConverter = moderateurConverter;
        }

    public boolean  isEtatTache(){
    return this.etatTache;
    }
    public void  setEtatTache(boolean etatTache){
    this.etatTache = etatTache;
    }
    public boolean  isModerateur(){
    return this.moderateur;
    }
    public void  setModerateur(boolean moderateur){
    this.moderateur = moderateur;
    }












}

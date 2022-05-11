package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.GestionReclamation;
import com.ird.faa.ws.rest.provided.vo.GestionReclamationVo;

@Component
public class GestionReclamationConverter extends AbstractConverter<GestionReclamation,GestionReclamationVo>{

        @Autowired
        private ReclamationConverter reclamationConverter ;
        @Autowired
        private ModerateurConverter moderateurConverter ;
    private Boolean moderateur;
    private Boolean reclamation;

public  GestionReclamationConverter(){
init(true);
}

@Override
public GestionReclamation toItem(GestionReclamationVo vo) {
if (vo == null) {
return null;
} else {
GestionReclamation item = new GestionReclamation();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getDateTraitement()))
        item.setDateTraitement(DateUtil.parse(vo.getDateTraitement()));
    if(vo.getModerateurVo()!=null && this.moderateur)
        item.setModerateur(moderateurConverter.toItem(vo.getModerateurVo())) ;
    if(vo.getReclamationVo()!=null && this.reclamation)
        item.setReclamation(reclamationConverter.toItem(vo.getReclamationVo())) ;


return item;
}
}

@Override
public GestionReclamationVo toVo(GestionReclamation item) {
if (item == null) {
return null;
} else {
GestionReclamationVo vo = new GestionReclamationVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(item.getDateTraitement()!=null)
        vo.setDateTraitement(DateUtil.formateDate(item.getDateTraitement()));
    if(item.getModerateur()!=null && this.moderateur) {
        vo.setModerateurVo(moderateurConverter.toVo(item.getModerateur())) ;
    }
    if(item.getReclamation()!=null && this.reclamation) {
        vo.setReclamationVo(reclamationConverter.toVo(item.getReclamation())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    moderateur = value;
    reclamation = value;
}


        public ReclamationConverter getReclamationConverter(){
        return this.reclamationConverter;
        }
        public void setReclamationConverter(ReclamationConverter reclamationConverter ){
        this.reclamationConverter = reclamationConverter;
        }
        public ModerateurConverter getModerateurConverter(){
        return this.moderateurConverter;
        }
        public void setModerateurConverter(ModerateurConverter moderateurConverter ){
        this.moderateurConverter = moderateurConverter;
        }

    public boolean  isModerateur(){
    return this.moderateur;
    }
    public void  setModerateur(boolean moderateur){
    this.moderateur = moderateur;
    }
    public boolean  isReclamation(){
    return this.reclamation;
    }
    public void  setReclamation(boolean reclamation){
    this.reclamation = reclamation;
    }










}

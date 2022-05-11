package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Chercheur;
import com.ird.faa.ws.rest.provided.vo.ChercheurVo;

@Component
public class ChercheurConverter extends AbstractConverter<Chercheur,ChercheurVo>{

        @Autowired
        private ProfilConverter profilConverter ;
        @Autowired
        private SituationModerateurConverter situationModerateurConverter ;
    private Boolean situationModerateur;
    private Boolean profil;

public  ChercheurConverter(){
init(true);
}

@Override
public Chercheur toItem(ChercheurVo vo) {
if (vo == null) {
return null;
} else {
Chercheur item = new Chercheur();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getNumeroMatricule()))
        item.setNumeroMatricule(vo.getNumeroMatricule());
        if(StringUtil.isNotEmpty(vo.getEmailPrincipale()))
        item.setEmailPrincipale(vo.getEmailPrincipale());
            item.setCredentialsNonExpired(vo.getCredentialsNonExpired());
            item.setEnabled(vo.getEnabled());
            item.setAccountNonExpired(vo.getAccountNonExpired());
            item.setAccountNonLocked(vo.getAccountNonLocked());
            item.setPasswordChanged(vo.getPasswordChanged());
        if(StringUtil.isNotEmpty(vo.getCreatedAt()))
        item.setCreatedAt(DateUtil.parse(vo.getCreatedAt()));
        if(StringUtil.isNotEmpty(vo.getUpdatedAt()))
        item.setUpdatedAt(DateUtil.parse(vo.getUpdatedAt()));
        if(StringUtil.isNotEmpty(vo.getUsername()))
        item.setUsername(vo.getUsername());
        if(StringUtil.isNotEmpty(vo.getPassword()))
        item.setPassword(vo.getPassword());
        if(StringUtil.isNotEmpty(vo.getPrenom()))
        item.setPrenom(vo.getPrenom());
        if(StringUtil.isNotEmpty(vo.getNom()))
        item.setNom(vo.getNom());
        if(StringUtil.isNotEmpty(vo.getRole()))
        item.setRole(vo.getRole());
    if(vo.getSituationModerateurVo()!=null && this.situationModerateur)
        item.setSituationModerateur(situationModerateurConverter.toItem(vo.getSituationModerateurVo())) ;
    if(vo.getProfilVo()!=null && this.profil)
        item.setProfil(profilConverter.toItem(vo.getProfilVo())) ;


return item;
}
}

@Override
public ChercheurVo toVo(Chercheur item) {
if (item == null) {
return null;
} else {
ChercheurVo vo = new ChercheurVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getNumeroMatricule()))
        vo.setNumeroMatricule(item.getNumeroMatricule());

        if(StringUtil.isNotEmpty(item.getEmailPrincipale()))
        vo.setEmailPrincipale(item.getEmailPrincipale());

        vo.setCredentialsNonExpired(item.getCredentialsNonExpired());
        vo.setEnabled(item.getEnabled());
        vo.setAccountNonExpired(item.getAccountNonExpired());
        vo.setAccountNonLocked(item.getAccountNonLocked());
        vo.setPasswordChanged(item.getPasswordChanged());
        if(item.getCreatedAt()!=null)
        vo.setCreatedAt(DateUtil.formateDate(item.getCreatedAt()));
        if(item.getUpdatedAt()!=null)
        vo.setUpdatedAt(DateUtil.formateDate(item.getUpdatedAt()));
        if(StringUtil.isNotEmpty(item.getUsername()))
        vo.setUsername(item.getUsername());

        if(StringUtil.isNotEmpty(item.getPassword()))
        vo.setPassword(item.getPassword());

        if(StringUtil.isNotEmpty(item.getPrenom()))
        vo.setPrenom(item.getPrenom());

        if(StringUtil.isNotEmpty(item.getNom()))
        vo.setNom(item.getNom());

        if(StringUtil.isNotEmpty(item.getRole()))
        vo.setRole(item.getRole());

    if(item.getSituationModerateur()!=null && this.situationModerateur) {
        vo.setSituationModerateurVo(situationModerateurConverter.toVo(item.getSituationModerateur())) ;
    }
    if(item.getProfil()!=null && this.profil) {
        vo.setProfilVo(profilConverter.toVo(item.getProfil())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    situationModerateur = value;
    profil = value;
}


        public ProfilConverter getProfilConverter(){
        return this.profilConverter;
        }
        public void setProfilConverter(ProfilConverter profilConverter ){
        this.profilConverter = profilConverter;
        }
        public SituationModerateurConverter getSituationModerateurConverter(){
        return this.situationModerateurConverter;
        }
        public void setSituationModerateurConverter(SituationModerateurConverter situationModerateurConverter ){
        this.situationModerateurConverter = situationModerateurConverter;
        }

    public boolean  isSituationModerateur(){
    return this.situationModerateur;
    }
    public void  setSituationModerateur(boolean situationModerateur){
    this.situationModerateur = situationModerateur;
    }
    public boolean  isProfil(){
    return this.profil;
    }
    public void  setProfil(boolean profil){
    this.profil = profil;
    }


































}

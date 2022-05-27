package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Moderateur;
import com.ird.faa.ws.rest.provided.vo.ModerateurVo;

@Component
public class ModerateurConverter extends AbstractConverter<Moderateur,ModerateurVo>{

        @Autowired
        private ProfilConverter profilConverter ;
        @Autowired
        private SituationModerateurConverter situationModerateurConverter ;
        @Autowired
        private MissionConverter missionConverter ;
        @Autowired
        private TacheConverter tacheConverter ;
    private Boolean situationModerateur;
    private Boolean profil;
        private Boolean missions;
        private Boolean taches;

public  ModerateurConverter(){
init(true);
}

@Override
public Moderateur toItem(ModerateurVo vo) {
if (vo == null) {
return null;
} else {
Moderateur item = new Moderateur();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getNumeroMatricule()))
        item.setNumeroMatricule(vo.getNumeroMatricule());
        if(StringUtil.isNotEmpty(vo.getEmailPrincipale()))
        item.setEmailPrincipale(vo.getEmailPrincipale());

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

    if(ListUtil.isNotEmpty(vo.getMissionsVo()) && this.missions)
        item.setMissions(missionConverter.toItem(vo.getMissionsVo()));
    if(ListUtil.isNotEmpty(vo.getTachesVo()) && this.taches)
        item.setTaches(tacheConverter.toItem(vo.getTachesVo()));

return item;
}
}

@Override
public ModerateurVo toVo(Moderateur item) {
if (item == null) {
return null;
} else {
ModerateurVo vo = new ModerateurVo();
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
        if(ListUtil.isNotEmpty(item.getMissions()) && this.missions){
        missionConverter.init(true);
        missionConverter.setModerateur(false);
        vo.setMissionsVo(missionConverter.toVo(item.getMissions()));
        missionConverter.setModerateur(true);
        }
        if(ListUtil.isNotEmpty(item.getTaches()) && this.taches){
        tacheConverter.init(true);
        tacheConverter.setModerateur(false);
        vo.setTachesVo(tacheConverter.toVo(item.getTaches()));
        tacheConverter.setModerateur(true);
        }

return vo;
}
}

public void init(Boolean value) {
    situationModerateur = value;
    profil = value;
        missions = value;
        taches = value;
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
        public MissionConverter getMissionConverter(){
        return this.missionConverter;
        }
        public void setMissionConverter(MissionConverter missionConverter ){
        this.missionConverter = missionConverter;
        }
        public TacheConverter getTacheConverter(){
        return this.tacheConverter;
        }
        public void setTacheConverter(TacheConverter tacheConverter ){
        this.tacheConverter = tacheConverter;
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



































        public Boolean  isMissions(){
        return this.missions ;
        }
        public void  setMissions(Boolean missions ){
        this.missions  = missions ;
        }



        public Boolean  isTaches(){
        return this.taches ;
        }
        public void  setTaches(Boolean taches ){
        this.taches  = taches ;
        }


}

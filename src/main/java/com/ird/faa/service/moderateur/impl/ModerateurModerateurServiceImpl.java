package com.ird.faa.service.moderateur.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Moderateur;
        import com.ird.faa.bean.SituationModerateur;
        import com.ird.faa.bean.Profil;
        import com.ird.faa.bean.Mission;
        import com.ird.faa.bean.Tache;
import com.ird.faa.dao.ModerateurDao;
import com.ird.faa.service.moderateur.facade.ModerateurModerateurService;
        import com.ird.faa.service.moderateur.facade.ProfilModerateurService;
        import com.ird.faa.service.moderateur.facade.SituationModerateurModerateurService;
        import com.ird.faa.service.moderateur.facade.MissionModerateurService;
        import com.ird.faa.service.moderateur.facade.TacheModerateurService;

import com.ird.faa.ws.rest.provided.vo.ModerateurVo;
import com.ird.faa.service.util.*;
        import com.ird.faa.bean.Mission;
        import com.ird.faa.service.moderateur.facade.MissionModerateurService;
        import com.ird.faa.bean.Tache;
        import com.ird.faa.service.moderateur.facade.TacheModerateurService;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class ModerateurModerateurServiceImpl extends AbstractServiceImpl<Moderateur> implements ModerateurModerateurService {

@Autowired
private ModerateurDao moderateurDao;

        @Autowired
        private ProfilModerateurService profilService ;
        @Autowired
        private SituationModerateurModerateurService situationModerateurService ;
        @Autowired
        private MissionModerateurService missionService ;
        @Autowired
        private TacheModerateurService tacheService ;


@Autowired
private EntityManager entityManager;

    @Override
    public Moderateur findByUsername(String username){
    return moderateurDao.findByUsername(username);
    }

@Override
public List<Moderateur> findAll(){
        return moderateurDao.findAll();
}

        @Override
        public List<Moderateur> findBySituationModerateurReference(String reference){
        return moderateurDao.findBySituationModerateurReference(reference);
        }

        @Override
        @Transactional
        public int deleteBySituationModerateurReference(String reference){
        return moderateurDao.deleteBySituationModerateurReference(reference);
        }

        @Override
        public List<Moderateur> findBySituationModerateurId(Long id){
        return moderateurDao.findBySituationModerateurId(id);
        }

        @Override
        @Transactional
        public int deleteBySituationModerateurId(Long id){
        return moderateurDao.deleteBySituationModerateurId(id);
        }


        @Override
        public List<Moderateur> findByProfilReference(String reference){
        return moderateurDao.findByProfilReference(reference);
        }

        @Override
        @Transactional
        public int deleteByProfilReference(String reference){
        return moderateurDao.deleteByProfilReference(reference);
        }

        @Override
        public List<Moderateur> findByProfilId(Long id){
        return moderateurDao.findByProfilId(id);
        }

        @Override
        @Transactional
        public int deleteByProfilId(Long id){
        return moderateurDao.deleteByProfilId(id);
        }

    @Override
    public Moderateur findByNumeroMatricule(String numeroMatricule){
    if( numeroMatricule==null) return null;
    return moderateurDao.findByNumeroMatricule(numeroMatricule);
    }

    @Override
    @Transactional
    public int deleteByNumeroMatricule(String  numeroMatricule) {
    return moderateurDao.deleteByNumeroMatricule(numeroMatricule);
    }
    @Override
    public Moderateur findByIdOrNumeroMatricule(Moderateur moderateur){
    Moderateur resultat=null;
    if(moderateur != null){
    if(StringUtil.isNotEmpty(moderateur.getId())){
    resultat= moderateurDao.getOne(moderateur.getId());
    }else if(StringUtil.isNotEmpty(moderateur.getNumeroMatricule())) {
    resultat= moderateurDao.findByNumeroMatricule(moderateur.getNumeroMatricule());
    }else if(StringUtil.isNotEmpty(moderateur.getUsername())) {
    resultat = moderateurDao.findByUsername(moderateur.getUsername());
    }
    }
    return resultat;
    }

@Override
public Moderateur findById(Long id){
if(id==null) return null;
return moderateurDao.getOne(id);
}

@Override
public Moderateur findByIdWithAssociatedList(Long id){
    Moderateur moderateur  = findById(id);
    findAssociatedLists(moderateur);
    return moderateur;
}
    private void findAssociatedLists(Moderateur moderateur){
    if(moderateur!=null && moderateur.getId() != null) {
            List<Mission> missions = missionService.findByModerateurId(moderateur.getId());
            moderateur.setMissions(missions);
            List<Tache> taches = tacheService.findByModerateurId(moderateur.getId());
            moderateur.setTaches(taches);
    }
    }
    private void deleteAssociatedLists(Long id){
    if(id != null ) {
            missionService.deleteByModerateurId(id);
            tacheService.deleteByModerateurId(id);
    }
    }

    private void updateAssociatedLists(Moderateur moderateur){
    if(moderateur !=null && moderateur.getId() != null){
            List
            <List<Mission>> resultMissions= missionService.getToBeSavedAndToBeDeleted(missionService.findByModerateurId(moderateur.getId()),moderateur.getMissions());
            missionService.delete(resultMissions.get(1));
            associateMission(moderateur,resultMissions.get(0));
            missionService.update(resultMissions.get(0));

            List
            <List<Tache>> resultTaches= tacheService.getToBeSavedAndToBeDeleted(tacheService.findByModerateurId(moderateur.getId()),moderateur.getTaches());
            tacheService.delete(resultTaches.get(1));
            associateTache(moderateur,resultTaches.get(0));
            tacheService.update(resultTaches.get(0));

    }
    }

@Transactional
public int deleteById(Long id){
int res=0;
if(moderateurDao.findById(id).isPresent())  {
    deleteAssociatedLists(id);
moderateurDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Moderateur update(Moderateur moderateur){
Moderateur foundedModerateur = findById(moderateur.getId());
if(foundedModerateur==null) return null;
else{
    updateAssociatedLists(moderateur);
return  moderateurDao.save(moderateur);
}
}
    private void prepareSave(Moderateur moderateur){
                moderateur.setCredentialsNonExpired(false);
                moderateur.setEnabled(false);
                moderateur.setAccountNonExpired(false);
                moderateur.setAccountNonLocked(false);
                moderateur.setPasswordChanged(false);



    }

@Override
public Moderateur save (Moderateur moderateur){
    prepareSave(moderateur);

    Moderateur result =null;
    Moderateur foundedModerateur = findByNumeroMatricule(moderateur.getNumeroMatricule());
    if(foundedModerateur == null){


    findSituationModerateur(moderateur);
    findProfil(moderateur);

    Moderateur savedModerateur = moderateurDao.save(moderateur);

        saveMissions(savedModerateur,moderateur.getMissions());
        saveTaches(savedModerateur,moderateur.getTaches());
    result = savedModerateur;
    }

    return result;
}

@Override
public List<Moderateur> save(List<Moderateur> moderateurs){
List<Moderateur> list = new ArrayList<>();
for(Moderateur moderateur: moderateurs){
list.add(save(moderateur));
}
return list;
}

        private List<Mission> prepareMissions(Moderateur moderateur,List<Mission> missions){
        for(Mission mission:missions ){
        mission.setModerateur(moderateur);
        }
        return missions;
        }
        private List<Tache> prepareTaches(Moderateur moderateur,List<Tache> taches){
        for(Tache tache:taches ){
        tache.setModerateur(moderateur);
        }
        return taches;
        }


@Override
@Transactional
public int delete(Moderateur moderateur){
    if(moderateur.getNumeroMatricule()==null) return -1;

    Moderateur foundedModerateur = findByNumeroMatricule(moderateur.getNumeroMatricule());
    if(foundedModerateur==null) return -1;
moderateurDao.delete(foundedModerateur);
return 1;
}


public List<Moderateur> findByCriteria(ModerateurVo moderateurVo){

String query = "SELECT o FROM Moderateur o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",moderateurVo.getId());
            query += SearchUtil.addConstraint( "o", "numeroMatricule","LIKE",moderateurVo.getNumeroMatricule());
            query += SearchUtil.addConstraint( "o", "emailPrincipale","LIKE",moderateurVo.getEmailPrincipale());
            query += SearchUtil.addConstraint( "o", "credentialsNonExpired","=",moderateurVo.getCredentialsNonExpired());
            query += SearchUtil.addConstraint( "o", "enabled","=",moderateurVo.getEnabled());
            query += SearchUtil.addConstraint( "o", "accountNonExpired","=",moderateurVo.getAccountNonExpired());
            query += SearchUtil.addConstraint( "o", "accountNonLocked","=",moderateurVo.getAccountNonLocked());
            query += SearchUtil.addConstraint( "o", "passwordChanged","=",moderateurVo.getPasswordChanged());
        query += SearchUtil.addConstraintDate( "o", "createdAt","=",moderateurVo.getCreatedAt());
        query += SearchUtil.addConstraintDate( "o", "updatedAt","=",moderateurVo.getUpdatedAt());
            query += SearchUtil.addConstraint( "o", "username","LIKE",moderateurVo.getUsername());
            query += SearchUtil.addConstraint( "o", "password","LIKE",moderateurVo.getPassword());
            query += SearchUtil.addConstraint( "o", "prenom","LIKE",moderateurVo.getPrenom());
            query += SearchUtil.addConstraint( "o", "nom","LIKE",moderateurVo.getNom());
            query += SearchUtil.addConstraint( "o", "role","LIKE",moderateurVo.getRole());
            query += SearchUtil.addConstraintMinMaxDate("o","createdAt",moderateurVo.getCreatedAtMin(),moderateurVo.getCreatedAtMax());
            query += SearchUtil.addConstraintMinMaxDate("o","updatedAt",moderateurVo.getUpdatedAtMin(),moderateurVo.getUpdatedAtMax());
    if(moderateurVo.getSituationModerateurVo()!=null){
        query += SearchUtil.addConstraint( "o", "situationModerateur.id","=",moderateurVo.getSituationModerateurVo().getId());
            query += SearchUtil.addConstraint( "o", "situationModerateur.reference","LIKE",moderateurVo.getSituationModerateurVo().getReference());
    }

    if(moderateurVo.getProfilVo()!=null){
        query += SearchUtil.addConstraint( "o", "profil.id","=",moderateurVo.getProfilVo().getId());
            query += SearchUtil.addConstraint( "o", "profil.reference","LIKE",moderateurVo.getProfilVo().getReference());
    }

return entityManager.createQuery(query).getResultList();
}
        private  void saveMissions(Moderateur moderateur,List<Mission> missions){

        if (ListUtil.isNotEmpty(moderateur.getMissions())) {
        List<Mission> savedMissions = new ArrayList<>();
        missions.forEach(element -> {
        element.setModerateur(moderateur);
         missionService.save(element);
        });
        moderateur.setMissions(savedMissions);
        }
        }
        private  void saveTaches(Moderateur moderateur,List<Tache> taches){

        if (ListUtil.isNotEmpty(moderateur.getTaches())) {
        List<Tache> savedTaches = new ArrayList<>();
        taches.forEach(element -> {
        element.setModerateur(moderateur);
         tacheService.save(element);
        });
        moderateur.setTaches(savedTaches);
        }
        }

    private void findSituationModerateur(Moderateur moderateur){
        SituationModerateur loadedSituationModerateur =situationModerateurService.findByIdOrReference(moderateur.getSituationModerateur());

    if(loadedSituationModerateur==null ) {
    return;
    }
    moderateur.setSituationModerateur(loadedSituationModerateur);
    }
    private void findProfil(Moderateur moderateur){
        Profil loadedProfil =profilService.findByIdOrReference(moderateur.getProfil());

    if(loadedProfil==null ) {
    return;
    }
    moderateur.setProfil(loadedProfil);
    }

@Override
@Transactional
public void delete(List<Moderateur> moderateurs){
if(ListUtil.isNotEmpty(moderateurs)){
moderateurs.forEach(e->moderateurDao.delete(e));
}
}
@Override
public void update(List<Moderateur> moderateurs){
if(ListUtil.isNotEmpty(moderateurs)){
moderateurs.forEach(e->moderateurDao.save(e));
}
}

        private void associateMission(Moderateur moderateur, List<Mission> mission) {
        if (ListUtil.isNotEmpty(mission)) {
        mission.forEach(e -> e.setModerateur(moderateur));
        }
        }
        private void associateTache(Moderateur moderateur, List<Tache> tache) {
        if (ListUtil.isNotEmpty(tache)) {
        tache.forEach(e -> e.setModerateur(moderateur));
        }
        }




    }

package com.ird.faa.service.adherent.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Mission;
        import com.ird.faa.bean.Ville;
        import com.ird.faa.bean.Moderateur;
        import com.ird.faa.bean.PieceJointeMission;
import com.ird.faa.dao.MissionDao;
import com.ird.faa.service.adherent.facade.MissionAdherentService;
        import com.ird.faa.service.adherent.facade.VilleAdherentService;
        import com.ird.faa.service.adherent.facade.ModerateurAdherentService;
        import com.ird.faa.service.adherent.facade.PieceJointeMissionAdherentService;

import com.ird.faa.ws.rest.provided.vo.MissionVo;
import com.ird.faa.service.util.*;
        import com.ird.faa.bean.PieceJointeMission;
        import com.ird.faa.service.adherent.facade.PieceJointeMissionAdherentService;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class MissionAdherentServiceImpl extends AbstractServiceImpl<Mission> implements MissionAdherentService {

@Autowired
private MissionDao missionDao;

    @Autowired
    private ArchivableService<Mission> archivableService;
        @Autowired
        private VilleAdherentService villeService ;
        @Autowired
        private ModerateurAdherentService moderateurService ;
        @Autowired
        private PieceJointeMissionAdherentService pieceJointeMissionService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Mission> findAll(){
        return missionDao.findAll();
}
        public List<Mission> findByVilleId(Long id){
        return missionDao.findByVilleId(id);
        }

        @Transactional
        public int deleteByVilleId(Long id){
        return missionDao.deleteByVilleId(id);
        }


        @Override
        public List<Mission> findByModerateurNumeroMatricule(String numeroMatricule){
        return missionDao.findByModerateurNumeroMatricule(numeroMatricule);
        }

        @Override
        @Transactional
        public int deleteByModerateurNumeroMatricule(String numeroMatricule){
        return missionDao.deleteByModerateurNumeroMatricule(numeroMatricule);
        }

        @Override
        public List<Mission> findByModerateurId(Long id){
        return missionDao.findByModerateurId(id);
        }

        @Override
        @Transactional
        public int deleteByModerateurId(Long id){
        return missionDao.deleteByModerateurId(id);
        }

    @Override
    public Mission findByReference(String reference){
    if( reference==null) return null;
    return missionDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return missionDao.deleteByReference(reference);
    }
    @Override
    public Mission findByIdOrReference(Mission mission){
    Mission resultat=null;
    if(mission != null){
    if(StringUtil.isNotEmpty(mission.getId())){
    resultat= missionDao.getOne(mission.getId());
    }else if(StringUtil.isNotEmpty(mission.getReference())) {
    resultat= missionDao.findByReference(mission.getReference());
    }
    }
    return resultat;
    }

@Override
public Mission findById(Long id){
if(id==null) return null;
return missionDao.getOne(id);
}

@Override
public Mission findByIdWithAssociatedList(Long id){
    Mission mission  = findById(id);
    findAssociatedLists(mission);
    return mission;
}
    @Override
    public Mission archiver(Mission mission) {
    if (mission.getArchive() == null) {
    mission.setArchive(false);
    }
    mission.setArchive(true);
    mission.setDateArchivage(new Date());
    missionDao.save(mission);
    return mission;

    }

    @Override
    public Mission desarchiver(Mission mission) {
    if (mission.getArchive() == null) {
    mission.setArchive(false);
    }
    mission.setArchive(false);
    mission.setDateArchivage(null);
    missionDao.save(mission);
    return mission;
    }

    private void findAssociatedLists(Mission mission){
    if(mission!=null && mission.getId() != null) {
            List<PieceJointeMission> pieceJointeMissions = pieceJointeMissionService.findByMissionId(mission.getId());
            mission.setPieceJointeMissions(pieceJointeMissions);
    }
    }
    private void deleteAssociatedLists(Long id){
    if(id != null ) {
            pieceJointeMissionService.deleteByMissionId(id);
    }
    }

    private void updateAssociatedLists(Mission mission){
    if(mission !=null && mission.getId() != null){
            List
            <List<PieceJointeMission>> resultPieceJointeMissions= pieceJointeMissionService.getToBeSavedAndToBeDeleted(pieceJointeMissionService.findByMissionId(mission.getId()),mission.getPieceJointeMissions());
            pieceJointeMissionService.delete(resultPieceJointeMissions.get(1));
            associatePieceJointeMission(mission,resultPieceJointeMissions.get(0));
            pieceJointeMissionService.update(resultPieceJointeMissions.get(0));

    }
    }

@Transactional
public int deleteById(Long id){
int res=0;
if(missionDao.findById(id).isPresent())  {
    deleteAssociatedLists(id);
missionDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Mission update(Mission mission){
Mission foundedMission = findById(mission.getId());
if(foundedMission==null) return null;
else{
    archivableService.prepare(mission);
    updateAssociatedLists(mission);
return  missionDao.save(mission);
}
}
    private void prepareSave(Mission mission){
        mission.setDateCreation(new Date());
                    if(mission.getArchive() == null)
                mission.setArchive(false);
                    if(mission.getAdmin() == null)
                mission.setAdmin(false);
                    if(mission.getVisible() == null)
                mission.setVisible(false);



    }

@Override
public Mission save (Mission mission){
    prepareSave(mission);

    Mission result =null;
    Mission foundedMission = findByReference(mission.getReference());
    if(foundedMission == null){


    findVille(mission);
    findModerateur(mission);

    Mission savedMission = missionDao.save(mission);

        savePieceJointeMissions(savedMission,mission.getPieceJointeMissions());
    result = savedMission;
    }

    return result;
}

@Override
public List<Mission> save(List<Mission> missions){
List<Mission> list = new ArrayList<>();
for(Mission mission: missions){
list.add(save(mission));
}
return list;
}

        private List<PieceJointeMission> preparePieceJointeMissions(Mission mission,List<PieceJointeMission> pieceJointeMissions){
        for(PieceJointeMission pieceJointeMission:pieceJointeMissions ){
        pieceJointeMission.setMission(mission);
        }
        return pieceJointeMissions;
        }


@Override
@Transactional
public int delete(Mission mission){
    if(mission.getReference()==null) return -1;

    Mission foundedMission = findByReference(mission.getReference());
    if(foundedMission==null) return -1;
missionDao.delete(foundedMission);
return 1;
}


public List<Mission> findByCriteria(MissionVo missionVo){

String query = "SELECT o FROM Mission o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",missionVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",missionVo.getReference());
        query += SearchUtil.addConstraintDate( "o", "dateDebut","=",missionVo.getDateDebut());
        query += SearchUtil.addConstraintDate( "o", "dateFin","=",missionVo.getDateFin());
            query += SearchUtil.addConstraint( "o", "moyenDeTransport","LIKE",missionVo.getMoyenDeTransport());
            query += SearchUtil.addConstraint( "o", "distance","=",missionVo.getDistance());
            query += SearchUtil.addConstraint( "o", "pv","LIKE",missionVo.getPv());
            query += SearchUtil.addConstraint( "o", "archive","=",missionVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",missionVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",missionVo.getDateCreation());
            query += SearchUtil.addConstraint( "o", "admin","=",missionVo.getAdmin());
            query += SearchUtil.addConstraint( "o", "visible","=",missionVo.getVisible());
            query += SearchUtil.addConstraint( "o", "username","LIKE",missionVo.getUsername());
            query += SearchUtil.addConstraintMinMaxDate("o","dateDebut",missionVo.getDateDebutMin(),missionVo.getDateDebutMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateFin",missionVo.getDateFinMin(),missionVo.getDateFinMax());
            query += SearchUtil.addConstraintMinMax("o","distance",missionVo.getDistanceMin(),missionVo.getDistanceMax());
            query += SearchUtil.addConstraintMinMax("o","pieceJointeMissions",missionVo.getPieceJointeMissionsMin(),missionVo.getPieceJointeMissionsMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",missionVo.getDateArchivageMin(),missionVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",missionVo.getDateCreationMin(),missionVo.getDateCreationMax());
    if(missionVo.getVilleDestinationVo()!=null){
        query += SearchUtil.addConstraint( "o", "villeDestination.id","=",missionVo.getVilleDestinationVo().getId());
    }

    if(missionVo.getModerateurVo()!=null){
        query += SearchUtil.addConstraint( "o", "moderateur.id","=",missionVo.getModerateurVo().getId());
            query += SearchUtil.addConstraint( "o", "moderateur.numeroMatricule","LIKE",missionVo.getModerateurVo().getNumeroMatricule());
    }

return entityManager.createQuery(query).getResultList();
}
        private  void savePieceJointeMissions(Mission mission,List<PieceJointeMission> pieceJointeMissions){

        if (ListUtil.isNotEmpty(mission.getPieceJointeMissions())) {
        List<PieceJointeMission> savedPieceJointeMissions = new ArrayList<>();
        pieceJointeMissions.forEach(element -> {
        element.setMission(mission);
         pieceJointeMissionService.save(element);
        });
        mission.setPieceJointeMissions(savedPieceJointeMissions);
        }
        }

    private void findVille(Mission mission){
        Ville loadedVille = null;
        if(mission.getVilleDestination() != null && mission.getVilleDestination().getId() !=null)
        loadedVille =villeService.findById(mission.getVilleDestination().getId());

    if(loadedVille==null ) {
    return;
    }
    mission.setVilleDestination(loadedVille);
    }
    private void findModerateur(Mission mission){
        Moderateur loadedModerateur =moderateurService.findByIdOrNumeroMatricule(mission.getModerateur());

    if(loadedModerateur==null ) {
    return;
    }
    mission.setModerateur(loadedModerateur);
    }

@Override
@Transactional
public void delete(List<Mission> missions){
if(ListUtil.isNotEmpty(missions)){
missions.forEach(e->missionDao.delete(e));
}
}
@Override
public void update(List<Mission> missions){
if(ListUtil.isNotEmpty(missions)){
missions.forEach(e->missionDao.save(e));
}
}

        private void associatePieceJointeMission(Mission mission, List<PieceJointeMission> pieceJointeMission) {
        if (ListUtil.isNotEmpty(pieceJointeMission)) {
        pieceJointeMission.forEach(e -> e.setMission(mission));
        }
        }




    }

package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Reclamation;
        import com.ird.faa.bean.Adherent;
        import com.ird.faa.bean.EtatReclamation;
        import com.ird.faa.bean.PieceJointeReclamation;
import com.ird.faa.dao.ReclamationDao;
import com.ird.faa.service.admin.facade.ReclamationAdminService;
        import com.ird.faa.service.admin.facade.AdherentAdminService;
        import com.ird.faa.service.admin.facade.PieceJointeReclamationAdminService;
        import com.ird.faa.service.admin.facade.EtatReclamationAdminService;

import com.ird.faa.ws.rest.provided.vo.ReclamationVo;
import com.ird.faa.service.util.*;
        import com.ird.faa.bean.PieceJointeReclamation;
        import com.ird.faa.service.admin.facade.PieceJointeReclamationAdminService;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class ReclamationAdminServiceImpl extends AbstractServiceImpl<Reclamation> implements ReclamationAdminService {

@Autowired
private ReclamationDao reclamationDao;

    @Autowired
    private ArchivableService<Reclamation> archivableService;
        @Autowired
        private AdherentAdminService adherentService ;
        @Autowired
        private PieceJointeReclamationAdminService pieceJointeReclamationService ;
        @Autowired
        private EtatReclamationAdminService etatReclamationService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Reclamation> findAll(){
        String query = "SELECT o FROM Reclamation o where 1=1 ";
        query+= " ORDER BY o.dateReclamation";
        return entityManager.createQuery(query).getResultList();
}

        @Override
        public List<Reclamation> findByAdherentNumeroMatricule(String numeroMatricule){
        return reclamationDao.findByAdherentNumeroMatricule(numeroMatricule);
        }

        @Override
        @Transactional
        public int deleteByAdherentNumeroMatricule(String numeroMatricule){
        return reclamationDao.deleteByAdherentNumeroMatricule(numeroMatricule);
        }

        @Override
        public List<Reclamation> findByAdherentId(Long id){
        return reclamationDao.findByAdherentId(id);
        }

        @Override
        @Transactional
        public int deleteByAdherentId(Long id){
        return reclamationDao.deleteByAdherentId(id);
        }


        @Override
        public List<Reclamation> findByEtatReclamationReference(String reference){
        return reclamationDao.findByEtatReclamationReference(reference);
        }

        @Override
        @Transactional
        public int deleteByEtatReclamationReference(String reference){
        return reclamationDao.deleteByEtatReclamationReference(reference);
        }

        @Override
        public List<Reclamation> findByEtatReclamationId(Long id){
        return reclamationDao.findByEtatReclamationId(id);
        }

        @Override
        @Transactional
        public int deleteByEtatReclamationId(Long id){
        return reclamationDao.deleteByEtatReclamationId(id);
        }

    @Override
    public Reclamation findByReference(String reference){
    if( reference==null) return null;
    return reclamationDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return reclamationDao.deleteByReference(reference);
    }
    @Override
    public Reclamation findByIdOrReference(Reclamation reclamation){
    Reclamation resultat=null;
    if(reclamation != null){
    if(StringUtil.isNotEmpty(reclamation.getId())){
    resultat= reclamationDao.getOne(reclamation.getId());
    }else if(StringUtil.isNotEmpty(reclamation.getReference())) {
    resultat= reclamationDao.findByReference(reclamation.getReference());
    }
    }
    return resultat;
    }

@Override
public Reclamation findById(Long id){
if(id==null) return null;
return reclamationDao.getOne(id);
}

@Override
public Reclamation findByIdWithAssociatedList(Long id){
    Reclamation reclamation  = findById(id);
    findAssociatedLists(reclamation);
    return reclamation;
}
    @Override
    public Reclamation archiver(Reclamation reclamation) {
    if (reclamation.getArchive() == null) {
    reclamation.setArchive(false);
    }
    reclamation.setArchive(true);
    reclamation.setDateArchivage(new Date());
    reclamationDao.save(reclamation);
    return reclamation;

    }

    @Override
    public Reclamation desarchiver(Reclamation reclamation) {
    if (reclamation.getArchive() == null) {
    reclamation.setArchive(false);
    }
    reclamation.setArchive(false);
    reclamation.setDateArchivage(null);
    reclamationDao.save(reclamation);
    return reclamation;
    }

    private void findAssociatedLists(Reclamation reclamation){
    if(reclamation!=null && reclamation.getId() != null) {
            List<PieceJointeReclamation> pieceJointeReclamations = pieceJointeReclamationService.findByReclamationId(reclamation.getId());
            reclamation.setPieceJointeReclamations(pieceJointeReclamations);
    }
    }
    private void deleteAssociatedLists(Long id){
    if(id != null ) {
            pieceJointeReclamationService.deleteByReclamationId(id);
    }
    }

    private void updateAssociatedLists(Reclamation reclamation){
    if(reclamation !=null && reclamation.getId() != null){
            List
            <List<PieceJointeReclamation>> resultPieceJointeReclamations= pieceJointeReclamationService.getToBeSavedAndToBeDeleted(pieceJointeReclamationService.findByReclamationId(reclamation.getId()),reclamation.getPieceJointeReclamations());
            pieceJointeReclamationService.delete(resultPieceJointeReclamations.get(1));
            associatePieceJointeReclamation(reclamation,resultPieceJointeReclamations.get(0));
            pieceJointeReclamationService.update(resultPieceJointeReclamations.get(0));

    }
    }

@Transactional
public int deleteById(Long id){
int res=0;
if(reclamationDao.findById(id).isPresent())  {
    deleteAssociatedLists(id);
reclamationDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Reclamation update(Reclamation reclamation){
Reclamation foundedReclamation = findById(reclamation.getId());
if(foundedReclamation==null) return null;
else{
    archivableService.prepare(reclamation);
    updateAssociatedLists(reclamation);
return  reclamationDao.save(reclamation);
}
}
    private void prepareSave(Reclamation reclamation){
        reclamation.setDateCreation(new Date());
                    if(reclamation.getArchive() == null)
                reclamation.setArchive(false);
                    if(reclamation.getAdmin() == null)
                reclamation.setAdmin(false);
                    if(reclamation.getVisible() == null)
                reclamation.setVisible(false);



    }

@Override
public Reclamation save (Reclamation reclamation){
    prepareSave(reclamation);

    Reclamation result =null;
    Reclamation foundedReclamation = findByReference(reclamation.getReference());
    if(foundedReclamation == null){


    findAdherent(reclamation);
    findEtatReclamation(reclamation);

    Reclamation savedReclamation = reclamationDao.save(reclamation);

        savePieceJointeReclamations(savedReclamation,reclamation.getPieceJointeReclamations());
    result = savedReclamation;
    }

    return result;
}

@Override
public List<Reclamation> save(List<Reclamation> reclamations){
List<Reclamation> list = new ArrayList<>();
for(Reclamation reclamation: reclamations){
list.add(save(reclamation));
}
return list;
}

        private List<PieceJointeReclamation> preparePieceJointeReclamations(Reclamation reclamation,List<PieceJointeReclamation> pieceJointeReclamations){
        for(PieceJointeReclamation pieceJointeReclamation:pieceJointeReclamations ){
        pieceJointeReclamation.setReclamation(reclamation);
        }
        return pieceJointeReclamations;
        }


@Override
@Transactional
public int delete(Reclamation reclamation){
    if(reclamation.getReference()==null) return -1;

    Reclamation foundedReclamation = findByReference(reclamation.getReference());
    if(foundedReclamation==null) return -1;
reclamationDao.delete(foundedReclamation);
return 1;
}


public List<Reclamation> findByCriteria(ReclamationVo reclamationVo){

String query = "SELECT o FROM Reclamation o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",reclamationVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",reclamationVo.getReference());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",reclamationVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "description","LIKE",reclamationVo.getDescription());
        query += SearchUtil.addConstraintDate( "o", "dateReclamation","=",reclamationVo.getDateReclamation());
            query += SearchUtil.addConstraint( "o", "archive","=",reclamationVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",reclamationVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",reclamationVo.getDateCreation());
            query += SearchUtil.addConstraint( "o", "admin","=",reclamationVo.getAdmin());
            query += SearchUtil.addConstraint( "o", "visible","=",reclamationVo.getVisible());
            query += SearchUtil.addConstraint( "o", "username","LIKE",reclamationVo.getUsername());
            query += SearchUtil.addConstraintMinMaxDate("o","dateReclamation",reclamationVo.getDateReclamationMin(),reclamationVo.getDateReclamationMax());
            query += SearchUtil.addConstraintMinMax("o","pieceJointeReclamations",reclamationVo.getPieceJointeReclamationsMin(),reclamationVo.getPieceJointeReclamationsMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",reclamationVo.getDateArchivageMin(),reclamationVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",reclamationVo.getDateCreationMin(),reclamationVo.getDateCreationMax());
    if(reclamationVo.getAdherentVo()!=null){
        query += SearchUtil.addConstraint( "o", "adherent.id","=",reclamationVo.getAdherentVo().getId());
            query += SearchUtil.addConstraint( "o", "adherent.numeroMatricule","LIKE",reclamationVo.getAdherentVo().getNumeroMatricule());
    }

    if(reclamationVo.getEtatReclamationVo()!=null){
        query += SearchUtil.addConstraint( "o", "etatReclamation.id","=",reclamationVo.getEtatReclamationVo().getId());
            query += SearchUtil.addConstraint( "o", "etatReclamation.reference","LIKE",reclamationVo.getEtatReclamationVo().getReference());
    }

    query+= " ORDER BY o.dateReclamation";
return entityManager.createQuery(query).getResultList();
}
        private  void savePieceJointeReclamations(Reclamation reclamation,List<PieceJointeReclamation> pieceJointeReclamations){

        if (ListUtil.isNotEmpty(reclamation.getPieceJointeReclamations())) {
        List<PieceJointeReclamation> savedPieceJointeReclamations = new ArrayList<>();
        pieceJointeReclamations.forEach(element -> {
        element.setReclamation(reclamation);
         pieceJointeReclamationService.save(element);
        });
        reclamation.setPieceJointeReclamations(savedPieceJointeReclamations);
        }
        }

    private void findAdherent(Reclamation reclamation){
        Adherent loadedAdherent =adherentService.findByIdOrNumeroMatricule(reclamation.getAdherent());

    if(loadedAdherent==null ) {
    return;
    }
    reclamation.setAdherent(loadedAdherent);
    }
    private void findEtatReclamation(Reclamation reclamation){
        EtatReclamation loadedEtatReclamation =etatReclamationService.findByIdOrReference(reclamation.getEtatReclamation());

    if(loadedEtatReclamation==null ) {
    return;
    }
    reclamation.setEtatReclamation(loadedEtatReclamation);
    }

@Override
@Transactional
public void delete(List<Reclamation> reclamations){
if(ListUtil.isNotEmpty(reclamations)){
reclamations.forEach(e->reclamationDao.delete(e));
}
}
@Override
public void update(List<Reclamation> reclamations){
if(ListUtil.isNotEmpty(reclamations)){
reclamations.forEach(e->reclamationDao.save(e));
}
}

        private void associatePieceJointeReclamation(Reclamation reclamation, List<PieceJointeReclamation> pieceJointeReclamation) {
        if (ListUtil.isNotEmpty(pieceJointeReclamation)) {
        pieceJointeReclamation.forEach(e -> e.setReclamation(reclamation));
        }
        }




    }

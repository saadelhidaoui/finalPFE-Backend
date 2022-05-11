package com.ird.faa.service.chercheur.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
    import com.ird.faa.service.util.StringUtil;
    import com.ird.faa.security.common.SecurityUtil;
    import com.ird.faa.security.bean.User;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Convention;
        import com.ird.faa.bean.Organisme;
        import com.ird.faa.bean.PieceJointeConvention;
import com.ird.faa.dao.ConventionDao;
import com.ird.faa.service.chercheur.facade.ConventionChercheurService;
        import com.ird.faa.service.chercheur.facade.OrganismeChercheurService;
        import com.ird.faa.service.chercheur.facade.PieceJointeConventionChercheurService;

import com.ird.faa.ws.rest.provided.vo.ConventionVo;
import com.ird.faa.service.util.*;
        import com.ird.faa.bean.PieceJointeConvention;
        import com.ird.faa.service.chercheur.facade.PieceJointeConventionChercheurService;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class ConventionChercheurServiceImpl extends AbstractServiceImpl<Convention> implements ConventionChercheurService {

@Autowired
private ConventionDao conventionDao;

    @Autowired
    private ArchivableService<Convention> archivableService;
        @Autowired
        private OrganismeChercheurService organismeService ;
        @Autowired
        private PieceJointeConventionChercheurService pieceJointeConventionService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Convention> findAll(){
    List<Convention> resultat= new ArrayList();
    resultat.addAll(findAllNonArchive());
    resultat.addAll(findAllByOwner());
    return resultat;
}
        @Override
        public List<Convention> findByOrganismeId(Long id){
        return conventionDao.findByOrganismeId(id);
        }

        @Override
        @Transactional
        public int deleteByOrganismeId(Long id){
        return conventionDao.deleteByOrganismeId(id);
        }

    @Override
    public Convention findByReference(String reference){
    if( reference==null) return null;
    return conventionDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return conventionDao.deleteByReference(reference);
    }
    @Override
    public Convention findByIdOrReference(Convention convention){
    Convention resultat=null;
    if(convention != null){
    if(StringUtil.isNotEmpty(convention.getId())){
    resultat= conventionDao.getOne(convention.getId());
    }else if(StringUtil.isNotEmpty(convention.getReference())) {
    resultat= conventionDao.findByReference(convention.getReference());
    }
    }
    return resultat;
    }

@Override
public Convention findById(Long id){
if(id==null) return null;
return conventionDao.getOne(id);
}

@Override
public Convention findByIdWithAssociatedList(Long id){
    Convention convention  = findById(id);
    findAssociatedLists(convention);
    return convention;
}
    private void findAssociatedLists(Convention convention){
    if(convention!=null && convention.getId() != null) {
            List<PieceJointeConvention> pieceJointeConventions = pieceJointeConventionService.findByConventionId(convention.getId());
            convention.setPieceJointeConventions(pieceJointeConventions);
    }
    }
    private void deleteAssociatedLists(Long id){
    if(id != null ) {
            pieceJointeConventionService.deleteByConventionId(id);
    }
    }

    private void updateAssociatedLists(Convention convention){
    if(convention !=null && convention.getId() != null){
            List
            <List<PieceJointeConvention>> resultPieceJointeConventions= pieceJointeConventionService.getToBeSavedAndToBeDeleted(pieceJointeConventionService.findByConventionId(convention.getId()),convention.getPieceJointeConventions());
            pieceJointeConventionService.delete(resultPieceJointeConventions.get(1));
            associatePieceJointeConvention(convention,resultPieceJointeConventions.get(0));
            pieceJointeConventionService.update(resultPieceJointeConventions.get(0));

    }
    }

@Transactional
public int deleteById(Long id){
int res=0;
if(conventionDao.findById(id).isPresent())  {
    deleteAssociatedLists(id);
conventionDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Convention update(Convention convention){
Convention foundedConvention = findById(convention.getId());
if(foundedConvention==null) return null;
else{
    archivableService.prepare(convention);
    updateAssociatedLists(convention);
return  conventionDao.save(convention);
}
}
    private void prepareSave(Convention convention){
        convention.setDateCreation(new Date());
                    if(convention.getArchive() == null)
                convention.setArchive(false);
                    if(convention.getAdmin() == null)
                convention.setAdmin(false);
                    if(convention.getVisible() == null)
                convention.setVisible(false);

            convention.setAdmin(false);
            convention.setVisible(false);
            User currentUser = SecurityUtil.getCurrentUser();
            if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
            convention.setUsername(currentUser.getUsername());
            }


    }

@Override
public Convention save (Convention convention){
    prepareSave(convention);

    Convention result =null;
    Convention foundedConvention = findByReference(convention.getReference());
    if(foundedConvention == null){


    findOrganisme(convention);

    Convention savedConvention = conventionDao.save(convention);

        savePieceJointeConventions(savedConvention,convention.getPieceJointeConventions());
    result = savedConvention;
    }

    return result;
}

@Override
public List<Convention> save(List<Convention> conventions){
List<Convention> list = new ArrayList<>();
for(Convention convention: conventions){
list.add(save(convention));
}
return list;
}

        private List<PieceJointeConvention> preparePieceJointeConventions(Convention convention,List<PieceJointeConvention> pieceJointeConventions){
        for(PieceJointeConvention pieceJointeConvention:pieceJointeConventions ){
        pieceJointeConvention.setConvention(convention);
        }
        return pieceJointeConventions;
        }


@Override
@Transactional
public int delete(Convention convention){
    if(convention.getReference()==null) return -1;

    Convention foundedConvention = findByReference(convention.getReference());
    if(foundedConvention==null) return -1;
conventionDao.delete(foundedConvention);
return 1;
}


public List<Convention> findByCriteria(ConventionVo conventionVo){

String query = "SELECT o FROM Convention o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",conventionVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",conventionVo.getReference());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",conventionVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "description","LIKE",conventionVo.getDescription());
        query += SearchUtil.addConstraintDate( "o", "dateDebut","=",conventionVo.getDateDebut());
            query += SearchUtil.addConstraint( "o", "archive","=",conventionVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",conventionVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",conventionVo.getDateCreation());
            query += SearchUtil.addConstraint( "o", "admin","=",conventionVo.getAdmin());
            query += SearchUtil.addConstraint( "o", "visible","=",conventionVo.getVisible());
            query += SearchUtil.addConstraint( "o", "username","LIKE",conventionVo.getUsername());
            query += SearchUtil.addConstraintMinMaxDate("o","dateDebut",conventionVo.getDateDebutMin(),conventionVo.getDateDebutMax());
            query += SearchUtil.addConstraintMinMax("o","pieceJointeConventions",conventionVo.getPieceJointeConventionsMin(),conventionVo.getPieceJointeConventionsMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",conventionVo.getDateArchivageMin(),conventionVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",conventionVo.getDateCreationMin(),conventionVo.getDateCreationMax());
    if(conventionVo.getOrganismeVo()!=null){
        query += SearchUtil.addConstraint( "o", "organisme.id","=",conventionVo.getOrganismeVo().getId());
    }

return entityManager.createQuery(query).getResultList();
}
        private  void savePieceJointeConventions(Convention convention,List<PieceJointeConvention> pieceJointeConventions){

        if (ListUtil.isNotEmpty(convention.getPieceJointeConventions())) {
        List<PieceJointeConvention> savedPieceJointeConventions = new ArrayList<>();
        pieceJointeConventions.forEach(element -> {
        element.setConvention(convention);
         pieceJointeConventionService.save(element);
        });
        convention.setPieceJointeConventions(savedPieceJointeConventions);
        }
        }

    private void findOrganisme(Convention convention){
        Organisme loadedOrganisme = null;
        if(convention.getOrganisme() != null && convention.getOrganisme().getId() !=null)
        loadedOrganisme =organismeService.findById(convention.getOrganisme().getId());

    if(loadedOrganisme==null ) {
    return;
    }
    convention.setOrganisme(loadedOrganisme);
    }

@Override
@Transactional
public void delete(List<Convention> conventions){
if(ListUtil.isNotEmpty(conventions)){
conventions.forEach(e->conventionDao.delete(e));
}
}
@Override
public void update(List<Convention> conventions){
if(ListUtil.isNotEmpty(conventions)){
conventions.forEach(e->conventionDao.save(e));
}
}

        private void associatePieceJointeConvention(Convention convention, List<PieceJointeConvention> pieceJointeConvention) {
        if (ListUtil.isNotEmpty(pieceJointeConvention)) {
        pieceJointeConvention.forEach(e -> e.setConvention(convention));
        }
        }



        public List<Convention> findAllNonArchive(){
        String query = "SELECT o FROM Convention o  WHERE o.archive != true AND o.visible = true";
        return entityManager.createQuery(query).getResultList();
        }

        public List<Convention> findAllByOwner(){
        List<Convention> result= new ArrayList();
        User currentUser = SecurityUtil.getCurrentUser();
        if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
        String query = "SELECT o FROM Convention o  WHERE o.archive != true AND o.visible = false AND o.username = '"+ currentUser.getUsername()+"'";
        result = entityManager.createQuery(query).getResultList();
        }
        return result;
        }



    }

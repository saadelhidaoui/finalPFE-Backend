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
import com.ird.faa.bean.Estivage;
        import com.ird.faa.bean.CentreEstivage;
        import com.ird.faa.bean.NiveauImportance;
import com.ird.faa.dao.EstivageDao;
import com.ird.faa.service.chercheur.facade.EstivageChercheurService;
        import com.ird.faa.service.chercheur.facade.CentreEstivageChercheurService;
        import com.ird.faa.service.chercheur.facade.NiveauImportanceChercheurService;

import com.ird.faa.ws.rest.provided.vo.EstivageVo;
import com.ird.faa.service.util.*;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class EstivageChercheurServiceImpl extends AbstractServiceImpl<Estivage> implements EstivageChercheurService {

@Autowired
private EstivageDao estivageDao;

    @Autowired
    private ArchivableService<Estivage> archivableService;
        @Autowired
        private CentreEstivageChercheurService centreEstivageService ;
        @Autowired
        private NiveauImportanceChercheurService niveauImportanceService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Estivage> findAll(){
    List<Estivage> resultat= new ArrayList();
    resultat.addAll(findAllNonArchive());
    resultat.addAll(findAllByOwner());
    return resultat;
}
        @Override
        public List<Estivage> findByCentreEstivageId(Long id){
        return estivageDao.findByCentreEstivageId(id);
        }

        @Override
        @Transactional
        public int deleteByCentreEstivageId(Long id){
        return estivageDao.deleteByCentreEstivageId(id);
        }


        @Override
        public List<Estivage> findByNiveauImportanceReference(String reference){
        return estivageDao.findByNiveauImportanceReference(reference);
        }

        @Override
        @Transactional
        public int deleteByNiveauImportanceReference(String reference){
        return estivageDao.deleteByNiveauImportanceReference(reference);
        }

        @Override
        public List<Estivage> findByNiveauImportanceId(Long id){
        return estivageDao.findByNiveauImportanceId(id);
        }

        @Override
        @Transactional
        public int deleteByNiveauImportanceId(Long id){
        return estivageDao.deleteByNiveauImportanceId(id);
        }

    @Override
    public Estivage findByReference(String reference){
    if( reference==null) return null;
    return estivageDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return estivageDao.deleteByReference(reference);
    }
    @Override
    public Estivage findByIdOrReference(Estivage estivage){
    Estivage resultat=null;
    if(estivage != null){
    if(StringUtil.isNotEmpty(estivage.getId())){
    resultat= estivageDao.getOne(estivage.getId());
    }else if(StringUtil.isNotEmpty(estivage.getReference())) {
    resultat= estivageDao.findByReference(estivage.getReference());
    }
    }
    return resultat;
    }

@Override
public Estivage findById(Long id){
if(id==null) return null;
return estivageDao.getOne(id);
}

@Override
public Estivage findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(estivageDao.findById(id).isPresent())  {
estivageDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Estivage update(Estivage estivage){
Estivage foundedEstivage = findById(estivage.getId());
if(foundedEstivage==null) return null;
else{
    archivableService.prepare(estivage);
return  estivageDao.save(estivage);
}
}
    private void prepareSave(Estivage estivage){
        estivage.setDateCreation(new Date());
                    if(estivage.getEnvoye() == null)
                estivage.setEnvoye(false);
                    if(estivage.getResultat() == null)
                estivage.setResultat(false);
                    if(estivage.getArchive() == null)
                estivage.setArchive(false);
                    if(estivage.getAdmin() == null)
                estivage.setAdmin(false);
                    if(estivage.getVisible() == null)
                estivage.setVisible(false);

            estivage.setAdmin(false);
            estivage.setVisible(false);
            User currentUser = SecurityUtil.getCurrentUser();
            if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
            estivage.setUsername(currentUser.getUsername());
            }


    }

@Override
public Estivage save (Estivage estivage){
    prepareSave(estivage);

    Estivage result =null;
    Estivage foundedEstivage = findByReference(estivage.getReference());
    if(foundedEstivage == null){


    findCentreEstivage(estivage);
    findNiveauImportance(estivage);

    Estivage savedEstivage = estivageDao.save(estivage);

    result = savedEstivage;
    }

    return result;
}

@Override
public List<Estivage> save(List<Estivage> estivages){
List<Estivage> list = new ArrayList<>();
for(Estivage estivage: estivages){
list.add(save(estivage));
}
return list;
}



@Override
@Transactional
public int delete(Estivage estivage){
    if(estivage.getReference()==null) return -1;

    Estivage foundedEstivage = findByReference(estivage.getReference());
    if(foundedEstivage==null) return -1;
estivageDao.delete(foundedEstivage);
return 1;
}


public List<Estivage> findByCriteria(EstivageVo estivageVo){

String query = "SELECT o FROM Estivage o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",estivageVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",estivageVo.getReference());
            query += SearchUtil.addConstraint( "o", "numArrivee","LIKE",estivageVo.getNumArrivee());
            query += SearchUtil.addConstraint( "o", "envoye","=",estivageVo.getEnvoye());
        query += SearchUtil.addConstraintDate( "o", "dateEnvoi","=",estivageVo.getDateEnvoi());
            query += SearchUtil.addConstraint( "o", "notes","LIKE",estivageVo.getNotes());
            query += SearchUtil.addConstraint( "o", "chargeCas","LIKE",estivageVo.getChargeCas());
            query += SearchUtil.addConstraint( "o", "resultat","=",estivageVo.getResultat());
            query += SearchUtil.addConstraint( "o", "archive","=",estivageVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",estivageVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",estivageVo.getDateCreation());
            query += SearchUtil.addConstraint( "o", "admin","=",estivageVo.getAdmin());
            query += SearchUtil.addConstraint( "o", "visible","=",estivageVo.getVisible());
            query += SearchUtil.addConstraint( "o", "username","LIKE",estivageVo.getUsername());
            query += SearchUtil.addConstraintMinMaxDate("o","dateEnvoi",estivageVo.getDateEnvoiMin(),estivageVo.getDateEnvoiMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",estivageVo.getDateArchivageMin(),estivageVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",estivageVo.getDateCreationMin(),estivageVo.getDateCreationMax());
    if(estivageVo.getCentreEstivageVo()!=null){
        query += SearchUtil.addConstraint( "o", "centreEstivage.id","=",estivageVo.getCentreEstivageVo().getId());
    }

    if(estivageVo.getNiveauImportanceVo()!=null){
        query += SearchUtil.addConstraint( "o", "niveauImportance.id","=",estivageVo.getNiveauImportanceVo().getId());
            query += SearchUtil.addConstraint( "o", "niveauImportance.reference","LIKE",estivageVo.getNiveauImportanceVo().getReference());
    }

    query+= " ORDER BY o.dateEnvoi";
return entityManager.createQuery(query).getResultList();
}

    private void findCentreEstivage(Estivage estivage){
        CentreEstivage loadedCentreEstivage = null;
        if(estivage.getCentreEstivage() != null && estivage.getCentreEstivage().getId() !=null)
        loadedCentreEstivage =centreEstivageService.findById(estivage.getCentreEstivage().getId());

    if(loadedCentreEstivage==null ) {
    return;
    }
    estivage.setCentreEstivage(loadedCentreEstivage);
    }
    private void findNiveauImportance(Estivage estivage){
        NiveauImportance loadedNiveauImportance =niveauImportanceService.findByIdOrReference(estivage.getNiveauImportance());

    if(loadedNiveauImportance==null ) {
    return;
    }
    estivage.setNiveauImportance(loadedNiveauImportance);
    }

@Override
@Transactional
public void delete(List<Estivage> estivages){
if(ListUtil.isNotEmpty(estivages)){
estivages.forEach(e->estivageDao.delete(e));
}
}
@Override
public void update(List<Estivage> estivages){
if(ListUtil.isNotEmpty(estivages)){
estivages.forEach(e->estivageDao.save(e));
}
}




        public List<Estivage> findAllNonArchive(){
        String query = "SELECT o FROM Estivage o  WHERE o.archive != true AND o.visible = true";
            query+= " ORDER BY o.dateEnvoi";
        return entityManager.createQuery(query).getResultList();
        }

        public List<Estivage> findAllByOwner(){
        List<Estivage> result= new ArrayList();
        User currentUser = SecurityUtil.getCurrentUser();
        if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
        String query = "SELECT o FROM Estivage o  WHERE o.archive != true AND o.visible = false AND o.username = '"+ currentUser.getUsername()+"'";
            query+= " ORDER BY o.dateEnvoi";
        result = entityManager.createQuery(query).getResultList();
        }
        return result;
        }



    }

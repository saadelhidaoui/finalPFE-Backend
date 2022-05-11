package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Enfant;
        import com.ird.faa.bean.Qualite;
        import com.ird.faa.bean.Adherent;
import com.ird.faa.dao.EnfantDao;
import com.ird.faa.service.admin.facade.EnfantAdminService;
        import com.ird.faa.service.admin.facade.AdherentAdminService;
        import com.ird.faa.service.admin.facade.QualiteAdminService;

import com.ird.faa.ws.rest.provided.vo.EnfantVo;
import com.ird.faa.service.util.*;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class EnfantAdminServiceImpl extends AbstractServiceImpl<Enfant> implements EnfantAdminService {

@Autowired
private EnfantDao enfantDao;

    @Autowired
    private ArchivableService<Enfant> archivableService;
        @Autowired
        private AdherentAdminService adherentService ;
        @Autowired
        private QualiteAdminService qualiteService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Enfant> findAll(){
        return enfantDao.findAll();
}

        @Override
        public List<Enfant> findByQualiteReference(String reference){
        return enfantDao.findByQualiteReference(reference);
        }

        @Override
        @Transactional
        public int deleteByQualiteReference(String reference){
        return enfantDao.deleteByQualiteReference(reference);
        }

        @Override
        public List<Enfant> findByQualiteId(Long id){
        return enfantDao.findByQualiteId(id);
        }

        @Override
        @Transactional
        public int deleteByQualiteId(Long id){
        return enfantDao.deleteByQualiteId(id);
        }


        @Override
        public List<Enfant> findByAdherentNumeroMatricule(String numeroMatricule){
        return enfantDao.findByAdherentNumeroMatricule(numeroMatricule);
        }

        @Override
        @Transactional
        public int deleteByAdherentNumeroMatricule(String numeroMatricule){
        return enfantDao.deleteByAdherentNumeroMatricule(numeroMatricule);
        }

        @Override
        public List<Enfant> findByAdherentId(Long id){
        return enfantDao.findByAdherentId(id);
        }

        @Override
        @Transactional
        public int deleteByAdherentId(Long id){
        return enfantDao.deleteByAdherentId(id);
        }

    @Override
    public Enfant findByReference(String reference){
    if( reference==null) return null;
    return enfantDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return enfantDao.deleteByReference(reference);
    }
    @Override
    public Enfant findByIdOrReference(Enfant enfant){
    Enfant resultat=null;
    if(enfant != null){
    if(StringUtil.isNotEmpty(enfant.getId())){
    resultat= enfantDao.getOne(enfant.getId());
    }else if(StringUtil.isNotEmpty(enfant.getReference())) {
    resultat= enfantDao.findByReference(enfant.getReference());
    }
    }
    return resultat;
    }

@Override
public Enfant findById(Long id){
if(id==null) return null;
return enfantDao.getOne(id);
}

@Override
public Enfant findByIdWithAssociatedList(Long id){
    return findById(id);
}
    @Override
    public Enfant archiver(Enfant enfant) {
    if (enfant.getArchive() == null) {
    enfant.setArchive(false);
    }
    enfant.setArchive(true);
    enfant.setDateArchivage(new Date());
    enfantDao.save(enfant);
    return enfant;

    }

    @Override
    public Enfant desarchiver(Enfant enfant) {
    if (enfant.getArchive() == null) {
    enfant.setArchive(false);
    }
    enfant.setArchive(false);
    enfant.setDateArchivage(null);
    enfantDao.save(enfant);
    return enfant;
    }



@Transactional
public int deleteById(Long id){
int res=0;
if(enfantDao.findById(id).isPresent())  {
enfantDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Enfant update(Enfant enfant){
Enfant foundedEnfant = findById(enfant.getId());
if(foundedEnfant==null) return null;
else{
    archivableService.prepare(enfant);
return  enfantDao.save(enfant);
}
}
    private void prepareSave(Enfant enfant){
        enfant.setDateCreation(new Date());
                    if(enfant.getArchive() == null)
                enfant.setArchive(false);
                    if(enfant.getAdmin() == null)
                enfant.setAdmin(false);
                    if(enfant.getVisible() == null)
                enfant.setVisible(false);



    }

@Override
public Enfant save (Enfant enfant){
    prepareSave(enfant);

    Enfant result =null;
    Enfant foundedEnfant = findByReference(enfant.getReference());
    if(foundedEnfant == null){


    findQualite(enfant);
    findAdherent(enfant);

    Enfant savedEnfant = enfantDao.save(enfant);

    result = savedEnfant;
    }

    return result;
}

@Override
public List<Enfant> save(List<Enfant> enfants){
List<Enfant> list = new ArrayList<>();
for(Enfant enfant: enfants){
list.add(save(enfant));
}
return list;
}



@Override
@Transactional
public int delete(Enfant enfant){
    if(enfant.getReference()==null) return -1;

    Enfant foundedEnfant = findByReference(enfant.getReference());
    if(foundedEnfant==null) return -1;
enfantDao.delete(foundedEnfant);
return 1;
}


public List<Enfant> findByCriteria(EnfantVo enfantVo){

String query = "SELECT o FROM Enfant o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",enfantVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",enfantVo.getReference());
            query += SearchUtil.addConstraint( "o", "nom","LIKE",enfantVo.getNom());
            query += SearchUtil.addConstraint( "o", "prenom","LIKE",enfantVo.getPrenom());
            query += SearchUtil.addConstraint( "o", "age","=",enfantVo.getAge());
        query += SearchUtil.addConstraintDate( "o", "dateNaissance","=",enfantVo.getDateNaissance());
            query += SearchUtil.addConstraint( "o", "archive","=",enfantVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",enfantVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",enfantVo.getDateCreation());
            query += SearchUtil.addConstraint( "o", "admin","=",enfantVo.getAdmin());
            query += SearchUtil.addConstraint( "o", "visible","=",enfantVo.getVisible());
            query += SearchUtil.addConstraint( "o", "username","LIKE",enfantVo.getUsername());
            query += SearchUtil.addConstraintMinMax("o","age",enfantVo.getAgeMin(),enfantVo.getAgeMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateNaissance",enfantVo.getDateNaissanceMin(),enfantVo.getDateNaissanceMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",enfantVo.getDateArchivageMin(),enfantVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",enfantVo.getDateCreationMin(),enfantVo.getDateCreationMax());
    if(enfantVo.getQualiteVo()!=null){
        query += SearchUtil.addConstraint( "o", "qualite.id","=",enfantVo.getQualiteVo().getId());
            query += SearchUtil.addConstraint( "o", "qualite.reference","LIKE",enfantVo.getQualiteVo().getReference());
    }

    if(enfantVo.getAdherentVo()!=null){
        query += SearchUtil.addConstraint( "o", "adherent.id","=",enfantVo.getAdherentVo().getId());
            query += SearchUtil.addConstraint( "o", "adherent.numeroMatricule","LIKE",enfantVo.getAdherentVo().getNumeroMatricule());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findQualite(Enfant enfant){
        Qualite loadedQualite =qualiteService.findByIdOrReference(enfant.getQualite());

    if(loadedQualite==null ) {
    return;
    }
    enfant.setQualite(loadedQualite);
    }
    private void findAdherent(Enfant enfant){
        Adherent loadedAdherent =adherentService.findByIdOrNumeroMatricule(enfant.getAdherent());

    if(loadedAdherent==null ) {
    return;
    }
    enfant.setAdherent(loadedAdherent);
    }

@Override
@Transactional
public void delete(List<Enfant> enfants){
if(ListUtil.isNotEmpty(enfants)){
enfants.forEach(e->enfantDao.delete(e));
}
}
@Override
public void update(List<Enfant> enfants){
if(ListUtil.isNotEmpty(enfants)){
enfants.forEach(e->enfantDao.save(e));
}
}





    }

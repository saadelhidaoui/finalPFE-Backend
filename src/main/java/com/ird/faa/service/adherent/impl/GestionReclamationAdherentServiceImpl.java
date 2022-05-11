package com.ird.faa.service.adherent.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.GestionReclamation;
        import com.ird.faa.bean.Moderateur;
        import com.ird.faa.bean.Reclamation;
import com.ird.faa.dao.GestionReclamationDao;
import com.ird.faa.service.adherent.facade.GestionReclamationAdherentService;
        import com.ird.faa.service.adherent.facade.ReclamationAdherentService;
        import com.ird.faa.service.adherent.facade.ModerateurAdherentService;

import com.ird.faa.ws.rest.provided.vo.GestionReclamationVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class GestionReclamationAdherentServiceImpl extends AbstractServiceImpl<GestionReclamation> implements GestionReclamationAdherentService {

@Autowired
private GestionReclamationDao gestionReclamationDao;

        @Autowired
        private ReclamationAdherentService reclamationService ;
        @Autowired
        private ModerateurAdherentService moderateurService ;


@Autowired
private EntityManager entityManager;


@Override
public List<GestionReclamation> findAll(){
        return gestionReclamationDao.findAll();
}

        @Override
        public List<GestionReclamation> findByModerateurNumeroMatricule(String numeroMatricule){
        return gestionReclamationDao.findByModerateurNumeroMatricule(numeroMatricule);
        }

        @Override
        @Transactional
        public int deleteByModerateurNumeroMatricule(String numeroMatricule){
        return gestionReclamationDao.deleteByModerateurNumeroMatricule(numeroMatricule);
        }

        @Override
        public List<GestionReclamation> findByModerateurId(Long id){
        return gestionReclamationDao.findByModerateurId(id);
        }

        @Override
        @Transactional
        public int deleteByModerateurId(Long id){
        return gestionReclamationDao.deleteByModerateurId(id);
        }


        @Override
        public List<GestionReclamation> findByReclamationReference(String reference){
        return gestionReclamationDao.findByReclamationReference(reference);
        }

        @Override
        @Transactional
        public int deleteByReclamationReference(String reference){
        return gestionReclamationDao.deleteByReclamationReference(reference);
        }

        @Override
        public List<GestionReclamation> findByReclamationId(Long id){
        return gestionReclamationDao.findByReclamationId(id);
        }

        @Override
        @Transactional
        public int deleteByReclamationId(Long id){
        return gestionReclamationDao.deleteByReclamationId(id);
        }

    @Override
    public GestionReclamation findByReference(String reference){
    if( reference==null) return null;
    return gestionReclamationDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return gestionReclamationDao.deleteByReference(reference);
    }
    @Override
    public GestionReclamation findByIdOrReference(GestionReclamation gestionReclamation){
    GestionReclamation resultat=null;
    if(gestionReclamation != null){
    if(StringUtil.isNotEmpty(gestionReclamation.getId())){
    resultat= gestionReclamationDao.getOne(gestionReclamation.getId());
    }else if(StringUtil.isNotEmpty(gestionReclamation.getReference())) {
    resultat= gestionReclamationDao.findByReference(gestionReclamation.getReference());
    }
    }
    return resultat;
    }

@Override
public GestionReclamation findById(Long id){
if(id==null) return null;
return gestionReclamationDao.getOne(id);
}

@Override
public GestionReclamation findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(gestionReclamationDao.findById(id).isPresent())  {
gestionReclamationDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public GestionReclamation update(GestionReclamation gestionReclamation){
GestionReclamation foundedGestionReclamation = findById(gestionReclamation.getId());
if(foundedGestionReclamation==null) return null;
else{
return  gestionReclamationDao.save(gestionReclamation);
}
}

@Override
public GestionReclamation save (GestionReclamation gestionReclamation){

    GestionReclamation result =null;
    GestionReclamation foundedGestionReclamation = findByReference(gestionReclamation.getReference());
    if(foundedGestionReclamation == null){


    findModerateur(gestionReclamation);
    findReclamation(gestionReclamation);

    GestionReclamation savedGestionReclamation = gestionReclamationDao.save(gestionReclamation);

    result = savedGestionReclamation;
    }

    return result;
}

@Override
public List<GestionReclamation> save(List<GestionReclamation> gestionReclamations){
List<GestionReclamation> list = new ArrayList<>();
for(GestionReclamation gestionReclamation: gestionReclamations){
list.add(save(gestionReclamation));
}
return list;
}



@Override
@Transactional
public int delete(GestionReclamation gestionReclamation){
    if(gestionReclamation.getReference()==null) return -1;

    GestionReclamation foundedGestionReclamation = findByReference(gestionReclamation.getReference());
    if(foundedGestionReclamation==null) return -1;
gestionReclamationDao.delete(foundedGestionReclamation);
return 1;
}


public List<GestionReclamation> findByCriteria(GestionReclamationVo gestionReclamationVo){

String query = "SELECT o FROM GestionReclamation o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",gestionReclamationVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",gestionReclamationVo.getReference());
        query += SearchUtil.addConstraintDate( "o", "dateTraitement","=",gestionReclamationVo.getDateTraitement());
            query += SearchUtil.addConstraintMinMaxDate("o","dateTraitement",gestionReclamationVo.getDateTraitementMin(),gestionReclamationVo.getDateTraitementMax());
    if(gestionReclamationVo.getModerateurVo()!=null){
        query += SearchUtil.addConstraint( "o", "moderateur.id","=",gestionReclamationVo.getModerateurVo().getId());
            query += SearchUtil.addConstraint( "o", "moderateur.numeroMatricule","LIKE",gestionReclamationVo.getModerateurVo().getNumeroMatricule());
    }

    if(gestionReclamationVo.getReclamationVo()!=null){
        query += SearchUtil.addConstraint( "o", "reclamation.id","=",gestionReclamationVo.getReclamationVo().getId());
            query += SearchUtil.addConstraint( "o", "reclamation.reference","LIKE",gestionReclamationVo.getReclamationVo().getReference());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findModerateur(GestionReclamation gestionReclamation){
        Moderateur loadedModerateur =moderateurService.findByIdOrNumeroMatricule(gestionReclamation.getModerateur());

    if(loadedModerateur==null ) {
    return;
    }
    gestionReclamation.setModerateur(loadedModerateur);
    }
    private void findReclamation(GestionReclamation gestionReclamation){
        Reclamation loadedReclamation =reclamationService.findByIdOrReference(gestionReclamation.getReclamation());

    if(loadedReclamation==null ) {
    return;
    }
    gestionReclamation.setReclamation(loadedReclamation);
    }

@Override
@Transactional
public void delete(List<GestionReclamation> gestionReclamations){
if(ListUtil.isNotEmpty(gestionReclamations)){
gestionReclamations.forEach(e->gestionReclamationDao.delete(e));
}
}
@Override
public void update(List<GestionReclamation> gestionReclamations){
if(ListUtil.isNotEmpty(gestionReclamations)){
gestionReclamations.forEach(e->gestionReclamationDao.save(e));
}
}





    }

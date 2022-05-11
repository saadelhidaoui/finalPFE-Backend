package com.ird.faa.service.chercheur.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Tache;
        import com.ird.faa.bean.EtatTache;
        import com.ird.faa.bean.Moderateur;
import com.ird.faa.dao.TacheDao;
import com.ird.faa.service.chercheur.facade.TacheChercheurService;
        import com.ird.faa.service.chercheur.facade.EtatTacheChercheurService;
        import com.ird.faa.service.chercheur.facade.ModerateurChercheurService;

import com.ird.faa.ws.rest.provided.vo.TacheVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class TacheChercheurServiceImpl extends AbstractServiceImpl<Tache> implements TacheChercheurService {

@Autowired
private TacheDao tacheDao;

        @Autowired
        private EtatTacheChercheurService etatTacheService ;
        @Autowired
        private ModerateurChercheurService moderateurService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Tache> findAll(){
        return tacheDao.findAll();
}

        @Override
        public List<Tache> findByEtatTacheReference(String reference){
        return tacheDao.findByEtatTacheReference(reference);
        }

        @Override
        @Transactional
        public int deleteByEtatTacheReference(String reference){
        return tacheDao.deleteByEtatTacheReference(reference);
        }

        @Override
        public List<Tache> findByEtatTacheId(Long id){
        return tacheDao.findByEtatTacheId(id);
        }

        @Override
        @Transactional
        public int deleteByEtatTacheId(Long id){
        return tacheDao.deleteByEtatTacheId(id);
        }


        @Override
        public List<Tache> findByModerateurNumeroMatricule(String numeroMatricule){
        return tacheDao.findByModerateurNumeroMatricule(numeroMatricule);
        }

        @Override
        @Transactional
        public int deleteByModerateurNumeroMatricule(String numeroMatricule){
        return tacheDao.deleteByModerateurNumeroMatricule(numeroMatricule);
        }

        @Override
        public List<Tache> findByModerateurId(Long id){
        return tacheDao.findByModerateurId(id);
        }

        @Override
        @Transactional
        public int deleteByModerateurId(Long id){
        return tacheDao.deleteByModerateurId(id);
        }

    @Override
    public Tache findByReference(String reference){
    if( reference==null) return null;
    return tacheDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return tacheDao.deleteByReference(reference);
    }
    @Override
    public Tache findByIdOrReference(Tache tache){
    Tache resultat=null;
    if(tache != null){
    if(StringUtil.isNotEmpty(tache.getId())){
    resultat= tacheDao.getOne(tache.getId());
    }else if(StringUtil.isNotEmpty(tache.getReference())) {
    resultat= tacheDao.findByReference(tache.getReference());
    }
    }
    return resultat;
    }

@Override
public Tache findById(Long id){
if(id==null) return null;
return tacheDao.getOne(id);
}

@Override
public Tache findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(tacheDao.findById(id).isPresent())  {
tacheDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Tache update(Tache tache){
Tache foundedTache = findById(tache.getId());
if(foundedTache==null) return null;
else{
return  tacheDao.save(tache);
}
}

@Override
public Tache save (Tache tache){

    Tache result =null;
    Tache foundedTache = findByReference(tache.getReference());
    if(foundedTache == null){


    findEtatTache(tache);
    findModerateur(tache);

    Tache savedTache = tacheDao.save(tache);

    result = savedTache;
    }

    return result;
}

@Override
public List<Tache> save(List<Tache> taches){
List<Tache> list = new ArrayList<>();
for(Tache tache: taches){
list.add(save(tache));
}
return list;
}



@Override
@Transactional
public int delete(Tache tache){
    if(tache.getReference()==null) return -1;

    Tache foundedTache = findByReference(tache.getReference());
    if(foundedTache==null) return -1;
tacheDao.delete(foundedTache);
return 1;
}


public List<Tache> findByCriteria(TacheVo tacheVo){

String query = "SELECT o FROM Tache o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",tacheVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",tacheVo.getReference());
        query += SearchUtil.addConstraintDate( "o", "dateTache","=",tacheVo.getDateTache());
            query += SearchUtil.addConstraint( "o", "description","LIKE",tacheVo.getDescription());
            query += SearchUtil.addConstraintMinMaxDate("o","dateTache",tacheVo.getDateTacheMin(),tacheVo.getDateTacheMax());
    if(tacheVo.getEtatTacheVo()!=null){
        query += SearchUtil.addConstraint( "o", "etatTache.id","=",tacheVo.getEtatTacheVo().getId());
            query += SearchUtil.addConstraint( "o", "etatTache.reference","LIKE",tacheVo.getEtatTacheVo().getReference());
    }

    if(tacheVo.getModerateurVo()!=null){
        query += SearchUtil.addConstraint( "o", "moderateur.id","=",tacheVo.getModerateurVo().getId());
            query += SearchUtil.addConstraint( "o", "moderateur.numeroMatricule","LIKE",tacheVo.getModerateurVo().getNumeroMatricule());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findEtatTache(Tache tache){
        EtatTache loadedEtatTache =etatTacheService.findByIdOrReference(tache.getEtatTache());

    if(loadedEtatTache==null ) {
    return;
    }
    tache.setEtatTache(loadedEtatTache);
    }
    private void findModerateur(Tache tache){
        Moderateur loadedModerateur =moderateurService.findByIdOrNumeroMatricule(tache.getModerateur());

    if(loadedModerateur==null ) {
    return;
    }
    tache.setModerateur(loadedModerateur);
    }

@Override
@Transactional
public void delete(List<Tache> taches){
if(ListUtil.isNotEmpty(taches)){
taches.forEach(e->tacheDao.delete(e));
}
}
@Override
public void update(List<Tache> taches){
if(ListUtil.isNotEmpty(taches)){
taches.forEach(e->tacheDao.save(e));
}
}





    }

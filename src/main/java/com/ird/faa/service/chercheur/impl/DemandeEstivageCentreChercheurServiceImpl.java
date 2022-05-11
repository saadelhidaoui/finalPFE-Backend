package com.ird.faa.service.chercheur.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.DemandeEstivageCentre;
        import com.ird.faa.bean.DemandeEstivage;
        import com.ird.faa.bean.CentreEstivage;
import com.ird.faa.dao.DemandeEstivageCentreDao;
import com.ird.faa.service.chercheur.facade.DemandeEstivageCentreChercheurService;
        import com.ird.faa.service.chercheur.facade.DemandeEstivageChercheurService;
        import com.ird.faa.service.chercheur.facade.CentreEstivageChercheurService;

import com.ird.faa.ws.rest.provided.vo.DemandeEstivageCentreVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class DemandeEstivageCentreChercheurServiceImpl extends AbstractServiceImpl<DemandeEstivageCentre> implements DemandeEstivageCentreChercheurService {

@Autowired
private DemandeEstivageCentreDao demandeEstivageCentreDao;

        @Autowired
        private DemandeEstivageChercheurService demandeEstivageService ;
        @Autowired
        private CentreEstivageChercheurService centreEstivageService ;


@Autowired
private EntityManager entityManager;


@Override
public List<DemandeEstivageCentre> findAll(){
        return demandeEstivageCentreDao.findAll();
}

        @Override
        public List<DemandeEstivageCentre> findByDemandeEstivageReference(String reference){
        return demandeEstivageCentreDao.findByDemandeEstivageReference(reference);
        }

        @Override
        @Transactional
        public int deleteByDemandeEstivageReference(String reference){
        return demandeEstivageCentreDao.deleteByDemandeEstivageReference(reference);
        }

        @Override
        public List<DemandeEstivageCentre> findByDemandeEstivageId(Long id){
        return demandeEstivageCentreDao.findByDemandeEstivageId(id);
        }

        @Override
        @Transactional
        public int deleteByDemandeEstivageId(Long id){
        return demandeEstivageCentreDao.deleteByDemandeEstivageId(id);
        }

        @Override
        public List<DemandeEstivageCentre> findByCentreEstivageId(Long id){
        return demandeEstivageCentreDao.findByCentreEstivageId(id);
        }

        @Override
        @Transactional
        public int deleteByCentreEstivageId(Long id){
        return demandeEstivageCentreDao.deleteByCentreEstivageId(id);
        }

    @Override
    public DemandeEstivageCentre findByReference(String reference){
    if( reference==null) return null;
    return demandeEstivageCentreDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return demandeEstivageCentreDao.deleteByReference(reference);
    }
    @Override
    public DemandeEstivageCentre findByIdOrReference(DemandeEstivageCentre demandeEstivageCentre){
    DemandeEstivageCentre resultat=null;
    if(demandeEstivageCentre != null){
    if(StringUtil.isNotEmpty(demandeEstivageCentre.getId())){
    resultat= demandeEstivageCentreDao.getOne(demandeEstivageCentre.getId());
    }else if(StringUtil.isNotEmpty(demandeEstivageCentre.getReference())) {
    resultat= demandeEstivageCentreDao.findByReference(demandeEstivageCentre.getReference());
    }
    }
    return resultat;
    }

@Override
public DemandeEstivageCentre findById(Long id){
if(id==null) return null;
return demandeEstivageCentreDao.getOne(id);
}

@Override
public DemandeEstivageCentre findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(demandeEstivageCentreDao.findById(id).isPresent())  {
demandeEstivageCentreDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public DemandeEstivageCentre update(DemandeEstivageCentre demandeEstivageCentre){
DemandeEstivageCentre foundedDemandeEstivageCentre = findById(demandeEstivageCentre.getId());
if(foundedDemandeEstivageCentre==null) return null;
else{
return  demandeEstivageCentreDao.save(demandeEstivageCentre);
}
}

@Override
public DemandeEstivageCentre save (DemandeEstivageCentre demandeEstivageCentre){

    DemandeEstivageCentre result =null;
    DemandeEstivageCentre foundedDemandeEstivageCentre = findByReference(demandeEstivageCentre.getReference());
    if(foundedDemandeEstivageCentre == null){


    findDemandeEstivage(demandeEstivageCentre);
    findCentreEstivage(demandeEstivageCentre);

    DemandeEstivageCentre savedDemandeEstivageCentre = demandeEstivageCentreDao.save(demandeEstivageCentre);

    result = savedDemandeEstivageCentre;
    }

    return result;
}

@Override
public List<DemandeEstivageCentre> save(List<DemandeEstivageCentre> demandeEstivageCentres){
List<DemandeEstivageCentre> list = new ArrayList<>();
for(DemandeEstivageCentre demandeEstivageCentre: demandeEstivageCentres){
list.add(save(demandeEstivageCentre));
}
return list;
}



@Override
@Transactional
public int delete(DemandeEstivageCentre demandeEstivageCentre){
    if(demandeEstivageCentre.getReference()==null) return -1;

    DemandeEstivageCentre foundedDemandeEstivageCentre = findByReference(demandeEstivageCentre.getReference());
    if(foundedDemandeEstivageCentre==null) return -1;
demandeEstivageCentreDao.delete(foundedDemandeEstivageCentre);
return 1;
}


public List<DemandeEstivageCentre> findByCriteria(DemandeEstivageCentreVo demandeEstivageCentreVo){

String query = "SELECT o FROM DemandeEstivageCentre o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",demandeEstivageCentreVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",demandeEstivageCentreVo.getReference());
    if(demandeEstivageCentreVo.getDemandeEstivageVo()!=null){
        query += SearchUtil.addConstraint( "o", "demandeEstivage.id","=",demandeEstivageCentreVo.getDemandeEstivageVo().getId());
            query += SearchUtil.addConstraint( "o", "demandeEstivage.reference","LIKE",demandeEstivageCentreVo.getDemandeEstivageVo().getReference());
    }

    if(demandeEstivageCentreVo.getCentreEstivageVo()!=null){
        query += SearchUtil.addConstraint( "o", "centreEstivage.id","=",demandeEstivageCentreVo.getCentreEstivageVo().getId());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findDemandeEstivage(DemandeEstivageCentre demandeEstivageCentre){
        DemandeEstivage loadedDemandeEstivage =demandeEstivageService.findByIdOrReference(demandeEstivageCentre.getDemandeEstivage());

    if(loadedDemandeEstivage==null ) {
    return;
    }
    demandeEstivageCentre.setDemandeEstivage(loadedDemandeEstivage);
    }
    private void findCentreEstivage(DemandeEstivageCentre demandeEstivageCentre){
        CentreEstivage loadedCentreEstivage = null;
        if(demandeEstivageCentre.getCentreEstivage() != null && demandeEstivageCentre.getCentreEstivage().getId() !=null)
        loadedCentreEstivage =centreEstivageService.findById(demandeEstivageCentre.getCentreEstivage().getId());

    if(loadedCentreEstivage==null ) {
    return;
    }
    demandeEstivageCentre.setCentreEstivage(loadedCentreEstivage);
    }

@Override
@Transactional
public void delete(List<DemandeEstivageCentre> demandeEstivageCentres){
if(ListUtil.isNotEmpty(demandeEstivageCentres)){
demandeEstivageCentres.forEach(e->demandeEstivageCentreDao.delete(e));
}
}
@Override
public void update(List<DemandeEstivageCentre> demandeEstivageCentres){
if(ListUtil.isNotEmpty(demandeEstivageCentres)){
demandeEstivageCentres.forEach(e->demandeEstivageCentreDao.save(e));
}
}





    }

package com.ird.faa.service.moderateur.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.CentreEstivage;
        import com.ird.faa.bean.Ville;
import com.ird.faa.dao.CentreEstivageDao;
import com.ird.faa.service.moderateur.facade.CentreEstivageModerateurService;
        import com.ird.faa.service.moderateur.facade.VilleModerateurService;

import com.ird.faa.ws.rest.provided.vo.CentreEstivageVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class CentreEstivageModerateurServiceImpl extends AbstractServiceImpl<CentreEstivage> implements CentreEstivageModerateurService {

@Autowired
private CentreEstivageDao centreEstivageDao;

        @Autowired
        private VilleModerateurService villeService ;


@Autowired
private EntityManager entityManager;


@Override
public List<CentreEstivage> findAll(){
        return centreEstivageDao.findAll();
}
        @Override
        public List<CentreEstivage> findByVilleId(Long id){
        return centreEstivageDao.findByVilleId(id);
        }

        @Override
        @Transactional
        public int deleteByVilleId(Long id){
        return centreEstivageDao.deleteByVilleId(id);
        }


@Override
public CentreEstivage findById(Long id){
if(id==null) return null;
return centreEstivageDao.getOne(id);
}

@Override
public CentreEstivage findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(centreEstivageDao.findById(id).isPresent())  {
centreEstivageDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public CentreEstivage update(CentreEstivage centreEstivage){
CentreEstivage foundedCentreEstivage = findById(centreEstivage.getId());
if(foundedCentreEstivage==null) return null;
else{
return  centreEstivageDao.save(centreEstivage);
}
}
    private void prepareSave(CentreEstivage centreEstivage){
                    if(centreEstivage.getVip() == null)
                centreEstivage.setVip(false);



    }

@Override
public CentreEstivage save (CentreEstivage centreEstivage){
    prepareSave(centreEstivage);



    findVille(centreEstivage);

    return centreEstivageDao.save(centreEstivage);


}

@Override
public List<CentreEstivage> save(List<CentreEstivage> centreEstivages){
List<CentreEstivage> list = new ArrayList<>();
for(CentreEstivage centreEstivage: centreEstivages){
list.add(save(centreEstivage));
}
return list;
}



@Override
@Transactional
public int delete(CentreEstivage centreEstivage){
    if(centreEstivage.getId()==null) return -1;
    CentreEstivage foundedCentreEstivage = findById(centreEstivage.getId());
    if(foundedCentreEstivage==null) return -1;
centreEstivageDao.delete(foundedCentreEstivage);
return 1;
}


public List<CentreEstivage> findByCriteria(CentreEstivageVo centreEstivageVo){

String query = "SELECT o FROM CentreEstivage o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",centreEstivageVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",centreEstivageVo.getReference());
            query += SearchUtil.addConstraint( "o", "capacite","=",centreEstivageVo.getCapacite());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",centreEstivageVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "vip","=",centreEstivageVo.getVip());
            query += SearchUtil.addConstraintMinMax("o","capacite",centreEstivageVo.getCapaciteMin(),centreEstivageVo.getCapaciteMax());
    if(centreEstivageVo.getVilleVo()!=null){
        query += SearchUtil.addConstraint( "o", "ville.id","=",centreEstivageVo.getVilleVo().getId());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findVille(CentreEstivage centreEstivage){
        Ville loadedVille = null;
        if(centreEstivage.getVille() != null && centreEstivage.getVille().getId() !=null)
        loadedVille =villeService.findById(centreEstivage.getVille().getId());

    if(loadedVille==null ) {
    return;
    }
    centreEstivage.setVille(loadedVille);
    }

@Override
@Transactional
public void delete(List<CentreEstivage> centreEstivages){
if(ListUtil.isNotEmpty(centreEstivages)){
centreEstivages.forEach(e->centreEstivageDao.delete(e));
}
}
@Override
public void update(List<CentreEstivage> centreEstivages){
if(ListUtil.isNotEmpty(centreEstivages)){
centreEstivages.forEach(e->centreEstivageDao.save(e));
}
}





    }

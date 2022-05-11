package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Ville;
        import com.ird.faa.bean.Region;
import com.ird.faa.dao.VilleDao;
import com.ird.faa.service.admin.facade.VilleAdminService;
        import com.ird.faa.service.admin.facade.RegionAdminService;

import com.ird.faa.ws.rest.provided.vo.VilleVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class VilleAdminServiceImpl extends AbstractServiceImpl<Ville> implements VilleAdminService {

@Autowired
private VilleDao villeDao;

        @Autowired
        private RegionAdminService regionService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Ville> findAll(){
        return villeDao.findAll();
}
        @Override
        public List<Ville> findByRegionId(Long id){
        return villeDao.findByRegionId(id);
        }

        @Override
        @Transactional
        public int deleteByRegionId(Long id){
        return villeDao.deleteByRegionId(id);
        }


@Override
public Ville findById(Long id){
if(id==null) return null;
return villeDao.getOne(id);
}

@Override
public Ville findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(villeDao.findById(id).isPresent())  {
villeDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Ville update(Ville ville){
Ville foundedVille = findById(ville.getId());
if(foundedVille==null) return null;
else{
return  villeDao.save(ville);
}
}

@Override
public Ville save (Ville ville){



    findRegion(ville);

    return villeDao.save(ville);


}

@Override
public List<Ville> save(List<Ville> villes){
List<Ville> list = new ArrayList<>();
for(Ville ville: villes){
list.add(save(ville));
}
return list;
}



@Override
@Transactional
public int delete(Ville ville){
    if(ville.getId()==null) return -1;
    Ville foundedVille = findById(ville.getId());
    if(foundedVille==null) return -1;
villeDao.delete(foundedVille);
return 1;
}


public List<Ville> findByCriteria(VilleVo villeVo){

String query = "SELECT o FROM Ville o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",villeVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",villeVo.getReference());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",villeVo.getLibelle());
    if(villeVo.getRegionVo()!=null){
        query += SearchUtil.addConstraint( "o", "region.id","=",villeVo.getRegionVo().getId());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findRegion(Ville ville){
        Region loadedRegion = null;
        if(ville.getRegion() != null && ville.getRegion().getId() !=null)
        loadedRegion =regionService.findById(ville.getRegion().getId());

    if(loadedRegion==null ) {
    return;
    }
    ville.setRegion(loadedRegion);
    }

@Override
@Transactional
public void delete(List<Ville> villes){
if(ListUtil.isNotEmpty(villes)){
villes.forEach(e->villeDao.delete(e));
}
}
@Override
public void update(List<Ville> villes){
if(ListUtil.isNotEmpty(villes)){
villes.forEach(e->villeDao.save(e));
}
}





    }

package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.EstivageCentreEstivage;
        import com.ird.faa.bean.CentreEstivage;
        import com.ird.faa.bean.Estivage;
import com.ird.faa.dao.EstivageCentreEstivageDao;
import com.ird.faa.service.admin.facade.EstivageCentreEstivageAdminService;
        import com.ird.faa.service.admin.facade.CentreEstivageAdminService;
        import com.ird.faa.service.admin.facade.EstivageAdminService;

import com.ird.faa.ws.rest.provided.vo.EstivageCentreEstivageVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class EstivageCentreEstivageAdminServiceImpl extends AbstractServiceImpl<EstivageCentreEstivage> implements EstivageCentreEstivageAdminService {

@Autowired
private EstivageCentreEstivageDao estivageCentreEstivageDao;

        @Autowired
        private CentreEstivageAdminService centreEstivageService ;
        @Autowired
        private EstivageAdminService estivageService ;


@Autowired
private EntityManager entityManager;


@Override
public List<EstivageCentreEstivage> findAll(){
        return estivageCentreEstivageDao.findAll();
}
        @Override
        public List<EstivageCentreEstivage> findByCentreEstivageId(Long id){
        return estivageCentreEstivageDao.findByCentreEstivageId(id);
        }

        @Override
        @Transactional
        public int deleteByCentreEstivageId(Long id){
        return estivageCentreEstivageDao.deleteByCentreEstivageId(id);
        }


        @Override
        public List<EstivageCentreEstivage> findByEstivageReference(String reference){
        return estivageCentreEstivageDao.findByEstivageReference(reference);
        }

        @Override
        @Transactional
        public int deleteByEstivageReference(String reference){
        return estivageCentreEstivageDao.deleteByEstivageReference(reference);
        }

        @Override
        public List<EstivageCentreEstivage> findByEstivageId(Long id){
        return estivageCentreEstivageDao.findByEstivageId(id);
        }

        @Override
        @Transactional
        public int deleteByEstivageId(Long id){
        return estivageCentreEstivageDao.deleteByEstivageId(id);
        }

    @Override
    public EstivageCentreEstivage findByReference(String reference){
    if( reference==null) return null;
    return estivageCentreEstivageDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return estivageCentreEstivageDao.deleteByReference(reference);
    }
    @Override
    public EstivageCentreEstivage findByIdOrReference(EstivageCentreEstivage estivageCentreEstivage){
    EstivageCentreEstivage resultat=null;
    if(estivageCentreEstivage != null){
    if(StringUtil.isNotEmpty(estivageCentreEstivage.getId())){
    resultat= estivageCentreEstivageDao.getOne(estivageCentreEstivage.getId());
    }else if(StringUtil.isNotEmpty(estivageCentreEstivage.getReference())) {
    resultat= estivageCentreEstivageDao.findByReference(estivageCentreEstivage.getReference());
    }
    }
    return resultat;
    }

@Override
public EstivageCentreEstivage findById(Long id){
if(id==null) return null;
return estivageCentreEstivageDao.getOne(id);
}

@Override
public EstivageCentreEstivage findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(estivageCentreEstivageDao.findById(id).isPresent())  {
estivageCentreEstivageDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public EstivageCentreEstivage update(EstivageCentreEstivage estivageCentreEstivage){
EstivageCentreEstivage foundedEstivageCentreEstivage = findById(estivageCentreEstivage.getId());
if(foundedEstivageCentreEstivage==null) return null;
else{
return  estivageCentreEstivageDao.save(estivageCentreEstivage);
}
}

@Override
public EstivageCentreEstivage save (EstivageCentreEstivage estivageCentreEstivage){

    EstivageCentreEstivage result =null;
    EstivageCentreEstivage foundedEstivageCentreEstivage = findByReference(estivageCentreEstivage.getReference());
    if(foundedEstivageCentreEstivage == null){


    findCentreEstivage(estivageCentreEstivage);
    findEstivage(estivageCentreEstivage);

    EstivageCentreEstivage savedEstivageCentreEstivage = estivageCentreEstivageDao.save(estivageCentreEstivage);

    result = savedEstivageCentreEstivage;
    }

    return result;
}

@Override
public List<EstivageCentreEstivage> save(List<EstivageCentreEstivage> estivageCentreEstivages){
List<EstivageCentreEstivage> list = new ArrayList<>();
for(EstivageCentreEstivage estivageCentreEstivage: estivageCentreEstivages){
list.add(save(estivageCentreEstivage));
}
return list;
}



@Override
@Transactional
public int delete(EstivageCentreEstivage estivageCentreEstivage){
    if(estivageCentreEstivage.getReference()==null) return -1;

    EstivageCentreEstivage foundedEstivageCentreEstivage = findByReference(estivageCentreEstivage.getReference());
    if(foundedEstivageCentreEstivage==null) return -1;
estivageCentreEstivageDao.delete(foundedEstivageCentreEstivage);
return 1;
}


public List<EstivageCentreEstivage> findByCriteria(EstivageCentreEstivageVo estivageCentreEstivageVo){

String query = "SELECT o FROM EstivageCentreEstivage o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",estivageCentreEstivageVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",estivageCentreEstivageVo.getReference());
            query += SearchUtil.addConstraint( "o", "ordre","=",estivageCentreEstivageVo.getOrdre());
            query += SearchUtil.addConstraintMinMax("o","ordre",estivageCentreEstivageVo.getOrdreMin(),estivageCentreEstivageVo.getOrdreMax());
    if(estivageCentreEstivageVo.getCentreEstivageVo()!=null){
        query += SearchUtil.addConstraint( "o", "centreEstivage.id","=",estivageCentreEstivageVo.getCentreEstivageVo().getId());
    }

    if(estivageCentreEstivageVo.getEstivageVo()!=null){
        query += SearchUtil.addConstraint( "o", "estivage.id","=",estivageCentreEstivageVo.getEstivageVo().getId());
            query += SearchUtil.addConstraint( "o", "estivage.reference","LIKE",estivageCentreEstivageVo.getEstivageVo().getReference());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findCentreEstivage(EstivageCentreEstivage estivageCentreEstivage){
        CentreEstivage loadedCentreEstivage = null;
        if(estivageCentreEstivage.getCentreEstivage() != null && estivageCentreEstivage.getCentreEstivage().getId() !=null)
        loadedCentreEstivage =centreEstivageService.findById(estivageCentreEstivage.getCentreEstivage().getId());

    if(loadedCentreEstivage==null ) {
    return;
    }
    estivageCentreEstivage.setCentreEstivage(loadedCentreEstivage);
    }
    private void findEstivage(EstivageCentreEstivage estivageCentreEstivage){
        Estivage loadedEstivage =estivageService.findByIdOrReference(estivageCentreEstivage.getEstivage());

    if(loadedEstivage==null ) {
    return;
    }
    estivageCentreEstivage.setEstivage(loadedEstivage);
    }

@Override
@Transactional
public void delete(List<EstivageCentreEstivage> estivageCentreEstivages){
if(ListUtil.isNotEmpty(estivageCentreEstivages)){
estivageCentreEstivages.forEach(e->estivageCentreEstivageDao.delete(e));
}
}
@Override
public void update(List<EstivageCentreEstivage> estivageCentreEstivages){
if(ListUtil.isNotEmpty(estivageCentreEstivages)){
estivageCentreEstivages.forEach(e->estivageCentreEstivageDao.save(e));
}
}





    }

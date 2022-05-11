package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.EtatTache;
import com.ird.faa.dao.EtatTacheDao;
import com.ird.faa.service.admin.facade.EtatTacheAdminService;

import com.ird.faa.ws.rest.provided.vo.EtatTacheVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class EtatTacheAdminServiceImpl extends AbstractServiceImpl<EtatTache> implements EtatTacheAdminService {

@Autowired
private EtatTacheDao etatTacheDao;



@Autowired
private EntityManager entityManager;


@Override
public List<EtatTache> findAll(){
        return etatTacheDao.findAll();
}
    @Override
    public EtatTache findByReference(String reference){
    if( reference==null) return null;
    return etatTacheDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return etatTacheDao.deleteByReference(reference);
    }
    @Override
    public EtatTache findByIdOrReference(EtatTache etatTache){
    EtatTache resultat=null;
    if(etatTache != null){
    if(StringUtil.isNotEmpty(etatTache.getId())){
    resultat= etatTacheDao.getOne(etatTache.getId());
    }else if(StringUtil.isNotEmpty(etatTache.getReference())) {
    resultat= etatTacheDao.findByReference(etatTache.getReference());
    }
    }
    return resultat;
    }

@Override
public EtatTache findById(Long id){
if(id==null) return null;
return etatTacheDao.getOne(id);
}

@Override
public EtatTache findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(etatTacheDao.findById(id).isPresent())  {
etatTacheDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public EtatTache update(EtatTache etatTache){
EtatTache foundedEtatTache = findById(etatTache.getId());
if(foundedEtatTache==null) return null;
else{
return  etatTacheDao.save(etatTache);
}
}

@Override
public EtatTache save (EtatTache etatTache){

    EtatTache result =null;
    EtatTache foundedEtatTache = findByReference(etatTache.getReference());
    if(foundedEtatTache == null){



    EtatTache savedEtatTache = etatTacheDao.save(etatTache);

    result = savedEtatTache;
    }

    return result;
}

@Override
public List<EtatTache> save(List<EtatTache> etatTaches){
List<EtatTache> list = new ArrayList<>();
for(EtatTache etatTache: etatTaches){
list.add(save(etatTache));
}
return list;
}



@Override
@Transactional
public int delete(EtatTache etatTache){
    if(etatTache.getReference()==null) return -1;

    EtatTache foundedEtatTache = findByReference(etatTache.getReference());
    if(foundedEtatTache==null) return -1;
etatTacheDao.delete(foundedEtatTache);
return 1;
}


public List<EtatTache> findByCriteria(EtatTacheVo etatTacheVo){

String query = "SELECT o FROM EtatTache o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",etatTacheVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",etatTacheVo.getReference());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",etatTacheVo.getLibelle());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<EtatTache> etatTaches){
if(ListUtil.isNotEmpty(etatTaches)){
etatTaches.forEach(e->etatTacheDao.delete(e));
}
}
@Override
public void update(List<EtatTache> etatTaches){
if(ListUtil.isNotEmpty(etatTaches)){
etatTaches.forEach(e->etatTacheDao.save(e));
}
}





    }

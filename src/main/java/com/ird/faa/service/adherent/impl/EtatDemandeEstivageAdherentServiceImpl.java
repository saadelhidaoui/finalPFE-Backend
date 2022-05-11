package com.ird.faa.service.adherent.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.EtatDemandeEstivage;
import com.ird.faa.dao.EtatDemandeEstivageDao;
import com.ird.faa.service.adherent.facade.EtatDemandeEstivageAdherentService;

import com.ird.faa.ws.rest.provided.vo.EtatDemandeEstivageVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class EtatDemandeEstivageAdherentServiceImpl extends AbstractServiceImpl<EtatDemandeEstivage> implements EtatDemandeEstivageAdherentService {

@Autowired
private EtatDemandeEstivageDao etatDemandeEstivageDao;



@Autowired
private EntityManager entityManager;


@Override
public List<EtatDemandeEstivage> findAll(){
        return etatDemandeEstivageDao.findAll();
}
    @Override
    public EtatDemandeEstivage findByReference(String reference){
    if( reference==null) return null;
    return etatDemandeEstivageDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return etatDemandeEstivageDao.deleteByReference(reference);
    }
    @Override
    public EtatDemandeEstivage findByIdOrReference(EtatDemandeEstivage etatDemandeEstivage){
    EtatDemandeEstivage resultat=null;
    if(etatDemandeEstivage != null){
    if(StringUtil.isNotEmpty(etatDemandeEstivage.getId())){
    resultat= etatDemandeEstivageDao.getOne(etatDemandeEstivage.getId());
    }else if(StringUtil.isNotEmpty(etatDemandeEstivage.getReference())) {
    resultat= etatDemandeEstivageDao.findByReference(etatDemandeEstivage.getReference());
    }
    }
    return resultat;
    }

@Override
public EtatDemandeEstivage findById(Long id){
if(id==null) return null;
return etatDemandeEstivageDao.getOne(id);
}

@Override
public EtatDemandeEstivage findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(etatDemandeEstivageDao.findById(id).isPresent())  {
etatDemandeEstivageDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public EtatDemandeEstivage update(EtatDemandeEstivage etatDemandeEstivage){
EtatDemandeEstivage foundedEtatDemandeEstivage = findById(etatDemandeEstivage.getId());
if(foundedEtatDemandeEstivage==null) return null;
else{
return  etatDemandeEstivageDao.save(etatDemandeEstivage);
}
}

@Override
public EtatDemandeEstivage save (EtatDemandeEstivage etatDemandeEstivage){

    EtatDemandeEstivage result =null;
    EtatDemandeEstivage foundedEtatDemandeEstivage = findByReference(etatDemandeEstivage.getReference());
    if(foundedEtatDemandeEstivage == null){



    EtatDemandeEstivage savedEtatDemandeEstivage = etatDemandeEstivageDao.save(etatDemandeEstivage);

    result = savedEtatDemandeEstivage;
    }

    return result;
}

@Override
public List<EtatDemandeEstivage> save(List<EtatDemandeEstivage> etatDemandeEstivages){
List<EtatDemandeEstivage> list = new ArrayList<>();
for(EtatDemandeEstivage etatDemandeEstivage: etatDemandeEstivages){
list.add(save(etatDemandeEstivage));
}
return list;
}



@Override
@Transactional
public int delete(EtatDemandeEstivage etatDemandeEstivage){
    if(etatDemandeEstivage.getReference()==null) return -1;

    EtatDemandeEstivage foundedEtatDemandeEstivage = findByReference(etatDemandeEstivage.getReference());
    if(foundedEtatDemandeEstivage==null) return -1;
etatDemandeEstivageDao.delete(foundedEtatDemandeEstivage);
return 1;
}


public List<EtatDemandeEstivage> findByCriteria(EtatDemandeEstivageVo etatDemandeEstivageVo){

String query = "SELECT o FROM EtatDemandeEstivage o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",etatDemandeEstivageVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",etatDemandeEstivageVo.getReference());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",etatDemandeEstivageVo.getLibelle());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<EtatDemandeEstivage> etatDemandeEstivages){
if(ListUtil.isNotEmpty(etatDemandeEstivages)){
etatDemandeEstivages.forEach(e->etatDemandeEstivageDao.delete(e));
}
}
@Override
public void update(List<EtatDemandeEstivage> etatDemandeEstivages){
if(ListUtil.isNotEmpty(etatDemandeEstivages)){
etatDemandeEstivages.forEach(e->etatDemandeEstivageDao.save(e));
}
}





    }

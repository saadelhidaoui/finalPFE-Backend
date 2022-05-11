package com.ird.faa.service.chercheur.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.EtatPrestation;
import com.ird.faa.dao.EtatPrestationDao;
import com.ird.faa.service.chercheur.facade.EtatPrestationChercheurService;

import com.ird.faa.ws.rest.provided.vo.EtatPrestationVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class EtatPrestationChercheurServiceImpl extends AbstractServiceImpl<EtatPrestation> implements EtatPrestationChercheurService {

@Autowired
private EtatPrestationDao etatPrestationDao;



@Autowired
private EntityManager entityManager;


@Override
public List<EtatPrestation> findAll(){
        return etatPrestationDao.findAll();
}
    @Override
    public EtatPrestation findByReference(String reference){
    if( reference==null) return null;
    return etatPrestationDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return etatPrestationDao.deleteByReference(reference);
    }
    @Override
    public EtatPrestation findByIdOrReference(EtatPrestation etatPrestation){
    EtatPrestation resultat=null;
    if(etatPrestation != null){
    if(StringUtil.isNotEmpty(etatPrestation.getId())){
    resultat= etatPrestationDao.getOne(etatPrestation.getId());
    }else if(StringUtil.isNotEmpty(etatPrestation.getReference())) {
    resultat= etatPrestationDao.findByReference(etatPrestation.getReference());
    }
    }
    return resultat;
    }

@Override
public EtatPrestation findById(Long id){
if(id==null) return null;
return etatPrestationDao.getOne(id);
}

@Override
public EtatPrestation findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(etatPrestationDao.findById(id).isPresent())  {
etatPrestationDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public EtatPrestation update(EtatPrestation etatPrestation){
EtatPrestation foundedEtatPrestation = findById(etatPrestation.getId());
if(foundedEtatPrestation==null) return null;
else{
return  etatPrestationDao.save(etatPrestation);
}
}

@Override
public EtatPrestation save (EtatPrestation etatPrestation){

    EtatPrestation result =null;
    EtatPrestation foundedEtatPrestation = findByReference(etatPrestation.getReference());
    if(foundedEtatPrestation == null){



    EtatPrestation savedEtatPrestation = etatPrestationDao.save(etatPrestation);

    result = savedEtatPrestation;
    }

    return result;
}

@Override
public List<EtatPrestation> save(List<EtatPrestation> etatPrestations){
List<EtatPrestation> list = new ArrayList<>();
for(EtatPrestation etatPrestation: etatPrestations){
list.add(save(etatPrestation));
}
return list;
}



@Override
@Transactional
public int delete(EtatPrestation etatPrestation){
    if(etatPrestation.getReference()==null) return -1;

    EtatPrestation foundedEtatPrestation = findByReference(etatPrestation.getReference());
    if(foundedEtatPrestation==null) return -1;
etatPrestationDao.delete(foundedEtatPrestation);
return 1;
}


public List<EtatPrestation> findByCriteria(EtatPrestationVo etatPrestationVo){

String query = "SELECT o FROM EtatPrestation o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",etatPrestationVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",etatPrestationVo.getReference());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",etatPrestationVo.getLibelle());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<EtatPrestation> etatPrestations){
if(ListUtil.isNotEmpty(etatPrestations)){
etatPrestations.forEach(e->etatPrestationDao.delete(e));
}
}
@Override
public void update(List<EtatPrestation> etatPrestations){
if(ListUtil.isNotEmpty(etatPrestations)){
etatPrestations.forEach(e->etatPrestationDao.save(e));
}
}





    }

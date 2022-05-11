package com.ird.faa.service.chercheur.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.TypePrestation;
import com.ird.faa.dao.TypePrestationDao;
import com.ird.faa.service.chercheur.facade.TypePrestationChercheurService;

import com.ird.faa.ws.rest.provided.vo.TypePrestationVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class TypePrestationChercheurServiceImpl extends AbstractServiceImpl<TypePrestation> implements TypePrestationChercheurService {

@Autowired
private TypePrestationDao typePrestationDao;



@Autowired
private EntityManager entityManager;


@Override
public List<TypePrestation> findAll(){
        return typePrestationDao.findAll();
}
    @Override
    public TypePrestation findByReference(String reference){
    if( reference==null) return null;
    return typePrestationDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return typePrestationDao.deleteByReference(reference);
    }
    @Override
    public TypePrestation findByIdOrReference(TypePrestation typePrestation){
    TypePrestation resultat=null;
    if(typePrestation != null){
    if(StringUtil.isNotEmpty(typePrestation.getId())){
    resultat= typePrestationDao.getOne(typePrestation.getId());
    }else if(StringUtil.isNotEmpty(typePrestation.getReference())) {
    resultat= typePrestationDao.findByReference(typePrestation.getReference());
    }
    }
    return resultat;
    }

@Override
public TypePrestation findById(Long id){
if(id==null) return null;
return typePrestationDao.getOne(id);
}

@Override
public TypePrestation findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(typePrestationDao.findById(id).isPresent())  {
typePrestationDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public TypePrestation update(TypePrestation typePrestation){
TypePrestation foundedTypePrestation = findById(typePrestation.getId());
if(foundedTypePrestation==null) return null;
else{
return  typePrestationDao.save(typePrestation);
}
}

@Override
public TypePrestation save (TypePrestation typePrestation){

    TypePrestation result =null;
    TypePrestation foundedTypePrestation = findByReference(typePrestation.getReference());
    if(foundedTypePrestation == null){



    TypePrestation savedTypePrestation = typePrestationDao.save(typePrestation);

    result = savedTypePrestation;
    }

    return result;
}

@Override
public List<TypePrestation> save(List<TypePrestation> typePrestations){
List<TypePrestation> list = new ArrayList<>();
for(TypePrestation typePrestation: typePrestations){
list.add(save(typePrestation));
}
return list;
}



@Override
@Transactional
public int delete(TypePrestation typePrestation){
    if(typePrestation.getReference()==null) return -1;

    TypePrestation foundedTypePrestation = findByReference(typePrestation.getReference());
    if(foundedTypePrestation==null) return -1;
typePrestationDao.delete(foundedTypePrestation);
return 1;
}


public List<TypePrestation> findByCriteria(TypePrestationVo typePrestationVo){

String query = "SELECT o FROM TypePrestation o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",typePrestationVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",typePrestationVo.getReference());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",typePrestationVo.getLibelle());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<TypePrestation> typePrestations){
if(ListUtil.isNotEmpty(typePrestations)){
typePrestations.forEach(e->typePrestationDao.delete(e));
}
}
@Override
public void update(List<TypePrestation> typePrestations){
if(ListUtil.isNotEmpty(typePrestations)){
typePrestations.forEach(e->typePrestationDao.save(e));
}
}





    }

package com.ird.faa.service.chercheur.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Qualite;
import com.ird.faa.dao.QualiteDao;
import com.ird.faa.service.chercheur.facade.QualiteChercheurService;

import com.ird.faa.ws.rest.provided.vo.QualiteVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class QualiteChercheurServiceImpl extends AbstractServiceImpl<Qualite> implements QualiteChercheurService {

@Autowired
private QualiteDao qualiteDao;



@Autowired
private EntityManager entityManager;


@Override
public List<Qualite> findAll(){
        return qualiteDao.findAll();
}
    @Override
    public Qualite findByReference(String reference){
    if( reference==null) return null;
    return qualiteDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return qualiteDao.deleteByReference(reference);
    }
    @Override
    public Qualite findByIdOrReference(Qualite qualite){
    Qualite resultat=null;
    if(qualite != null){
    if(StringUtil.isNotEmpty(qualite.getId())){
    resultat= qualiteDao.getOne(qualite.getId());
    }else if(StringUtil.isNotEmpty(qualite.getReference())) {
    resultat= qualiteDao.findByReference(qualite.getReference());
    }
    }
    return resultat;
    }

@Override
public Qualite findById(Long id){
if(id==null) return null;
return qualiteDao.getOne(id);
}

@Override
public Qualite findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(qualiteDao.findById(id).isPresent())  {
qualiteDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Qualite update(Qualite qualite){
Qualite foundedQualite = findById(qualite.getId());
if(foundedQualite==null) return null;
else{
return  qualiteDao.save(qualite);
}
}

@Override
public Qualite save (Qualite qualite){

    Qualite result =null;
    Qualite foundedQualite = findByReference(qualite.getReference());
    if(foundedQualite == null){



    Qualite savedQualite = qualiteDao.save(qualite);

    result = savedQualite;
    }

    return result;
}

@Override
public List<Qualite> save(List<Qualite> qualites){
List<Qualite> list = new ArrayList<>();
for(Qualite qualite: qualites){
list.add(save(qualite));
}
return list;
}



@Override
@Transactional
public int delete(Qualite qualite){
    if(qualite.getReference()==null) return -1;

    Qualite foundedQualite = findByReference(qualite.getReference());
    if(foundedQualite==null) return -1;
qualiteDao.delete(foundedQualite);
return 1;
}


public List<Qualite> findByCriteria(QualiteVo qualiteVo){

String query = "SELECT o FROM Qualite o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",qualiteVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",qualiteVo.getReference());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",qualiteVo.getLibelle());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<Qualite> qualites){
if(ListUtil.isNotEmpty(qualites)){
qualites.forEach(e->qualiteDao.delete(e));
}
}
@Override
public void update(List<Qualite> qualites){
if(ListUtil.isNotEmpty(qualites)){
qualites.forEach(e->qualiteDao.save(e));
}
}





    }

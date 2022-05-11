package com.ird.faa.service.chercheur.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.EtatCarte;
import com.ird.faa.dao.EtatCarteDao;
import com.ird.faa.service.chercheur.facade.EtatCarteChercheurService;

import com.ird.faa.ws.rest.provided.vo.EtatCarteVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class EtatCarteChercheurServiceImpl extends AbstractServiceImpl<EtatCarte> implements EtatCarteChercheurService {

@Autowired
private EtatCarteDao etatCarteDao;



@Autowired
private EntityManager entityManager;


@Override
public List<EtatCarte> findAll(){
        return etatCarteDao.findAll();
}
    @Override
    public EtatCarte findByReference(String reference){
    if( reference==null) return null;
    return etatCarteDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return etatCarteDao.deleteByReference(reference);
    }
    @Override
    public EtatCarte findByIdOrReference(EtatCarte etatCarte){
    EtatCarte resultat=null;
    if(etatCarte != null){
    if(StringUtil.isNotEmpty(etatCarte.getId())){
    resultat= etatCarteDao.getOne(etatCarte.getId());
    }else if(StringUtil.isNotEmpty(etatCarte.getReference())) {
    resultat= etatCarteDao.findByReference(etatCarte.getReference());
    }
    }
    return resultat;
    }

@Override
public EtatCarte findById(Long id){
if(id==null) return null;
return etatCarteDao.getOne(id);
}

@Override
public EtatCarte findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(etatCarteDao.findById(id).isPresent())  {
etatCarteDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public EtatCarte update(EtatCarte etatCarte){
EtatCarte foundedEtatCarte = findById(etatCarte.getId());
if(foundedEtatCarte==null) return null;
else{
return  etatCarteDao.save(etatCarte);
}
}

@Override
public EtatCarte save (EtatCarte etatCarte){

    EtatCarte result =null;
    EtatCarte foundedEtatCarte = findByReference(etatCarte.getReference());
    if(foundedEtatCarte == null){



    EtatCarte savedEtatCarte = etatCarteDao.save(etatCarte);

    result = savedEtatCarte;
    }

    return result;
}

@Override
public List<EtatCarte> save(List<EtatCarte> etatCartes){
List<EtatCarte> list = new ArrayList<>();
for(EtatCarte etatCarte: etatCartes){
list.add(save(etatCarte));
}
return list;
}



@Override
@Transactional
public int delete(EtatCarte etatCarte){
    if(etatCarte.getReference()==null) return -1;

    EtatCarte foundedEtatCarte = findByReference(etatCarte.getReference());
    if(foundedEtatCarte==null) return -1;
etatCarteDao.delete(foundedEtatCarte);
return 1;
}


public List<EtatCarte> findByCriteria(EtatCarteVo etatCarteVo){

String query = "SELECT o FROM EtatCarte o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",etatCarteVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",etatCarteVo.getReference());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",etatCarteVo.getLibelle());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<EtatCarte> etatCartes){
if(ListUtil.isNotEmpty(etatCartes)){
etatCartes.forEach(e->etatCarteDao.delete(e));
}
}
@Override
public void update(List<EtatCarte> etatCartes){
if(ListUtil.isNotEmpty(etatCartes)){
etatCartes.forEach(e->etatCarteDao.save(e));
}
}





    }

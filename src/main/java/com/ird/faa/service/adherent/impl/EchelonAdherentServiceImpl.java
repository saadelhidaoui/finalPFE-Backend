package com.ird.faa.service.adherent.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Echelon;
import com.ird.faa.dao.EchelonDao;
import com.ird.faa.service.adherent.facade.EchelonAdherentService;

import com.ird.faa.ws.rest.provided.vo.EchelonVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class EchelonAdherentServiceImpl extends AbstractServiceImpl<Echelon> implements EchelonAdherentService {

@Autowired
private EchelonDao echelonDao;



@Autowired
private EntityManager entityManager;


@Override
public List<Echelon> findAll(){
        return echelonDao.findAll();
}
    @Override
    public Echelon findByReference(String reference){
    if( reference==null) return null;
    return echelonDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return echelonDao.deleteByReference(reference);
    }
    @Override
    public Echelon findByIdOrReference(Echelon echelon){
    Echelon resultat=null;
    if(echelon != null){
    if(StringUtil.isNotEmpty(echelon.getId())){
    resultat= echelonDao.getOne(echelon.getId());
    }else if(StringUtil.isNotEmpty(echelon.getReference())) {
    resultat= echelonDao.findByReference(echelon.getReference());
    }
    }
    return resultat;
    }

@Override
public Echelon findById(Long id){
if(id==null) return null;
return echelonDao.getOne(id);
}

@Override
public Echelon findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(echelonDao.findById(id).isPresent())  {
echelonDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Echelon update(Echelon echelon){
Echelon foundedEchelon = findById(echelon.getId());
if(foundedEchelon==null) return null;
else{
return  echelonDao.save(echelon);
}
}

@Override
public Echelon save (Echelon echelon){

    Echelon result =null;
    Echelon foundedEchelon = findByReference(echelon.getReference());
    if(foundedEchelon == null){



    Echelon savedEchelon = echelonDao.save(echelon);

    result = savedEchelon;
    }

    return result;
}

@Override
public List<Echelon> save(List<Echelon> echelons){
List<Echelon> list = new ArrayList<>();
for(Echelon echelon: echelons){
list.add(save(echelon));
}
return list;
}



@Override
@Transactional
public int delete(Echelon echelon){
    if(echelon.getReference()==null) return -1;

    Echelon foundedEchelon = findByReference(echelon.getReference());
    if(foundedEchelon==null) return -1;
echelonDao.delete(foundedEchelon);
return 1;
}


public List<Echelon> findByCriteria(EchelonVo echelonVo){

String query = "SELECT o FROM Echelon o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",echelonVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",echelonVo.getReference());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",echelonVo.getLibelle());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<Echelon> echelons){
if(ListUtil.isNotEmpty(echelons)){
echelons.forEach(e->echelonDao.delete(e));
}
}
@Override
public void update(List<Echelon> echelons){
if(ListUtil.isNotEmpty(echelons)){
echelons.forEach(e->echelonDao.save(e));
}
}





    }

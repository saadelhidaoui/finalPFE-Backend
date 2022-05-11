package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Statut;
import com.ird.faa.dao.StatutDao;
import com.ird.faa.service.admin.facade.StatutAdminService;

import com.ird.faa.ws.rest.provided.vo.StatutVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class StatutAdminServiceImpl extends AbstractServiceImpl<Statut> implements StatutAdminService {

@Autowired
private StatutDao statutDao;



@Autowired
private EntityManager entityManager;


@Override
public List<Statut> findAll(){
        return statutDao.findAll();
}
    @Override
    public Statut findByReference(String reference){
    if( reference==null) return null;
    return statutDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return statutDao.deleteByReference(reference);
    }
    @Override
    public Statut findByIdOrReference(Statut statut){
    Statut resultat=null;
    if(statut != null){
    if(StringUtil.isNotEmpty(statut.getId())){
    resultat= statutDao.getOne(statut.getId());
    }else if(StringUtil.isNotEmpty(statut.getReference())) {
    resultat= statutDao.findByReference(statut.getReference());
    }
    }
    return resultat;
    }

@Override
public Statut findById(Long id){
if(id==null) return null;
return statutDao.getOne(id);
}

@Override
public Statut findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(statutDao.findById(id).isPresent())  {
statutDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Statut update(Statut statut){
Statut foundedStatut = findById(statut.getId());
if(foundedStatut==null) return null;
else{
return  statutDao.save(statut);
}
}

@Override
public Statut save (Statut statut){

    Statut result =null;
    Statut foundedStatut = findByReference(statut.getReference());
    if(foundedStatut == null){



    Statut savedStatut = statutDao.save(statut);

    result = savedStatut;
    }

    return result;
}

@Override
public List<Statut> save(List<Statut> statuts){
List<Statut> list = new ArrayList<>();
for(Statut statut: statuts){
list.add(save(statut));
}
return list;
}



@Override
@Transactional
public int delete(Statut statut){
    if(statut.getReference()==null) return -1;

    Statut foundedStatut = findByReference(statut.getReference());
    if(foundedStatut==null) return -1;
statutDao.delete(foundedStatut);
return 1;
}


public List<Statut> findByCriteria(StatutVo statutVo){

String query = "SELECT o FROM Statut o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",statutVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",statutVo.getReference());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",statutVo.getLibelle());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<Statut> statuts){
if(ListUtil.isNotEmpty(statuts)){
statuts.forEach(e->statutDao.delete(e));
}
}
@Override
public void update(List<Statut> statuts){
if(ListUtil.isNotEmpty(statuts)){
statuts.forEach(e->statutDao.save(e));
}
}





    }

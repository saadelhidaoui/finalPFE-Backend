package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.NiveauImportance;
import com.ird.faa.dao.NiveauImportanceDao;
import com.ird.faa.service.admin.facade.NiveauImportanceAdminService;

import com.ird.faa.ws.rest.provided.vo.NiveauImportanceVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class NiveauImportanceAdminServiceImpl extends AbstractServiceImpl<NiveauImportance> implements NiveauImportanceAdminService {

@Autowired
private NiveauImportanceDao niveauImportanceDao;



@Autowired
private EntityManager entityManager;


@Override
public List<NiveauImportance> findAll(){
        return niveauImportanceDao.findAll();
}
    @Override
    public NiveauImportance findByReference(String reference){
    if( reference==null) return null;
    return niveauImportanceDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return niveauImportanceDao.deleteByReference(reference);
    }
    @Override
    public NiveauImportance findByIdOrReference(NiveauImportance niveauImportance){
    NiveauImportance resultat=null;
    if(niveauImportance != null){
    if(StringUtil.isNotEmpty(niveauImportance.getId())){
    resultat= niveauImportanceDao.getOne(niveauImportance.getId());
    }else if(StringUtil.isNotEmpty(niveauImportance.getReference())) {
    resultat= niveauImportanceDao.findByReference(niveauImportance.getReference());
    }
    }
    return resultat;
    }

@Override
public NiveauImportance findById(Long id){
if(id==null) return null;
return niveauImportanceDao.getOne(id);
}

@Override
public NiveauImportance findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(niveauImportanceDao.findById(id).isPresent())  {
niveauImportanceDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public NiveauImportance update(NiveauImportance niveauImportance){
NiveauImportance foundedNiveauImportance = findById(niveauImportance.getId());
if(foundedNiveauImportance==null) return null;
else{
return  niveauImportanceDao.save(niveauImportance);
}
}

@Override
public NiveauImportance save (NiveauImportance niveauImportance){

    NiveauImportance result =null;
    NiveauImportance foundedNiveauImportance = findByReference(niveauImportance.getReference());
    if(foundedNiveauImportance == null){



    NiveauImportance savedNiveauImportance = niveauImportanceDao.save(niveauImportance);

    result = savedNiveauImportance;
    }

    return result;
}

@Override
public List<NiveauImportance> save(List<NiveauImportance> niveauImportances){
List<NiveauImportance> list = new ArrayList<>();
for(NiveauImportance niveauImportance: niveauImportances){
list.add(save(niveauImportance));
}
return list;
}



@Override
@Transactional
public int delete(NiveauImportance niveauImportance){
    if(niveauImportance.getReference()==null) return -1;

    NiveauImportance foundedNiveauImportance = findByReference(niveauImportance.getReference());
    if(foundedNiveauImportance==null) return -1;
niveauImportanceDao.delete(foundedNiveauImportance);
return 1;
}


public List<NiveauImportance> findByCriteria(NiveauImportanceVo niveauImportanceVo){

String query = "SELECT o FROM NiveauImportance o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",niveauImportanceVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",niveauImportanceVo.getReference());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",niveauImportanceVo.getLibelle());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<NiveauImportance> niveauImportances){
if(ListUtil.isNotEmpty(niveauImportances)){
niveauImportances.forEach(e->niveauImportanceDao.delete(e));
}
}
@Override
public void update(List<NiveauImportance> niveauImportances){
if(ListUtil.isNotEmpty(niveauImportances)){
niveauImportances.forEach(e->niveauImportanceDao.save(e));
}
}





    }

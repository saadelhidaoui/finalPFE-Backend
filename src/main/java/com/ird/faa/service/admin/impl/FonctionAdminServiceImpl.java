package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Fonction;
import com.ird.faa.dao.FonctionDao;
import com.ird.faa.service.admin.facade.FonctionAdminService;

import com.ird.faa.ws.rest.provided.vo.FonctionVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class FonctionAdminServiceImpl extends AbstractServiceImpl<Fonction> implements FonctionAdminService {

@Autowired
private FonctionDao fonctionDao;



@Autowired
private EntityManager entityManager;


@Override
public List<Fonction> findAll(){
        return fonctionDao.findAll();
}
    @Override
    public Fonction findByReference(String reference){
    if( reference==null) return null;
    return fonctionDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return fonctionDao.deleteByReference(reference);
    }
    @Override
    public Fonction findByIdOrReference(Fonction fonction){
    Fonction resultat=null;
    if(fonction != null){
    if(StringUtil.isNotEmpty(fonction.getId())){
    resultat= fonctionDao.getOne(fonction.getId());
    }else if(StringUtil.isNotEmpty(fonction.getReference())) {
    resultat= fonctionDao.findByReference(fonction.getReference());
    }
    }
    return resultat;
    }

@Override
public Fonction findById(Long id){
if(id==null) return null;
return fonctionDao.getOne(id);
}

@Override
public Fonction findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(fonctionDao.findById(id).isPresent())  {
fonctionDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Fonction update(Fonction fonction){
Fonction foundedFonction = findById(fonction.getId());
if(foundedFonction==null) return null;
else{
return  fonctionDao.save(fonction);
}
}

@Override
public Fonction save (Fonction fonction){

    Fonction result =null;
    Fonction foundedFonction = findByReference(fonction.getReference());
    if(foundedFonction == null){



    Fonction savedFonction = fonctionDao.save(fonction);

    result = savedFonction;
    }

    return result;
}

@Override
public List<Fonction> save(List<Fonction> fonctions){
List<Fonction> list = new ArrayList<>();
for(Fonction fonction: fonctions){
list.add(save(fonction));
}
return list;
}



@Override
@Transactional
public int delete(Fonction fonction){
    if(fonction.getReference()==null) return -1;

    Fonction foundedFonction = findByReference(fonction.getReference());
    if(foundedFonction==null) return -1;
fonctionDao.delete(foundedFonction);
return 1;
}


public List<Fonction> findByCriteria(FonctionVo fonctionVo){

String query = "SELECT o FROM Fonction o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",fonctionVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",fonctionVo.getReference());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",fonctionVo.getLibelle());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<Fonction> fonctions){
if(ListUtil.isNotEmpty(fonctions)){
fonctions.forEach(e->fonctionDao.delete(e));
}
}
@Override
public void update(List<Fonction> fonctions){
if(ListUtil.isNotEmpty(fonctions)){
fonctions.forEach(e->fonctionDao.save(e));
}
}





    }

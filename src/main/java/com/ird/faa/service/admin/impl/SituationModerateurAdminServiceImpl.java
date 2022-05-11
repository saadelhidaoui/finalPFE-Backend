package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.SituationModerateur;
import com.ird.faa.dao.SituationModerateurDao;
import com.ird.faa.service.admin.facade.SituationModerateurAdminService;

import com.ird.faa.ws.rest.provided.vo.SituationModerateurVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class SituationModerateurAdminServiceImpl extends AbstractServiceImpl<SituationModerateur> implements SituationModerateurAdminService {

@Autowired
private SituationModerateurDao situationModerateurDao;



@Autowired
private EntityManager entityManager;


@Override
public List<SituationModerateur> findAll(){
        return situationModerateurDao.findAll();
}
    @Override
    public SituationModerateur findByReference(String reference){
    if( reference==null) return null;
    return situationModerateurDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return situationModerateurDao.deleteByReference(reference);
    }
    @Override
    public SituationModerateur findByIdOrReference(SituationModerateur situationModerateur){
    SituationModerateur resultat=null;
    if(situationModerateur != null){
    if(StringUtil.isNotEmpty(situationModerateur.getId())){
    resultat= situationModerateurDao.getOne(situationModerateur.getId());
    }else if(StringUtil.isNotEmpty(situationModerateur.getReference())) {
    resultat= situationModerateurDao.findByReference(situationModerateur.getReference());
    }
    }
    return resultat;
    }

@Override
public SituationModerateur findById(Long id){
if(id==null) return null;
return situationModerateurDao.getOne(id);
}

@Override
public SituationModerateur findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(situationModerateurDao.findById(id).isPresent())  {
situationModerateurDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public SituationModerateur update(SituationModerateur situationModerateur){
SituationModerateur foundedSituationModerateur = findById(situationModerateur.getId());
if(foundedSituationModerateur==null) return null;
else{
return  situationModerateurDao.save(situationModerateur);
}
}

@Override
public SituationModerateur save (SituationModerateur situationModerateur){

    SituationModerateur result =null;
    SituationModerateur foundedSituationModerateur = findByReference(situationModerateur.getReference());
    if(foundedSituationModerateur == null){



    SituationModerateur savedSituationModerateur = situationModerateurDao.save(situationModerateur);

    result = savedSituationModerateur;
    }

    return result;
}

@Override
public List<SituationModerateur> save(List<SituationModerateur> situationModerateurs){
List<SituationModerateur> list = new ArrayList<>();
for(SituationModerateur situationModerateur: situationModerateurs){
list.add(save(situationModerateur));
}
return list;
}



@Override
@Transactional
public int delete(SituationModerateur situationModerateur){
    if(situationModerateur.getReference()==null) return -1;

    SituationModerateur foundedSituationModerateur = findByReference(situationModerateur.getReference());
    if(foundedSituationModerateur==null) return -1;
situationModerateurDao.delete(foundedSituationModerateur);
return 1;
}


public List<SituationModerateur> findByCriteria(SituationModerateurVo situationModerateurVo){

String query = "SELECT o FROM SituationModerateur o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",situationModerateurVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",situationModerateurVo.getReference());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",situationModerateurVo.getLibelle());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<SituationModerateur> situationModerateurs){
if(ListUtil.isNotEmpty(situationModerateurs)){
situationModerateurs.forEach(e->situationModerateurDao.delete(e));
}
}
@Override
public void update(List<SituationModerateur> situationModerateurs){
if(ListUtil.isNotEmpty(situationModerateurs)){
situationModerateurs.forEach(e->situationModerateurDao.save(e));
}
}





    }

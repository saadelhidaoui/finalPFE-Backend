package com.ird.faa.service.chercheur.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Grade;
import com.ird.faa.dao.GradeDao;
import com.ird.faa.service.chercheur.facade.GradeChercheurService;

import com.ird.faa.ws.rest.provided.vo.GradeVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class GradeChercheurServiceImpl extends AbstractServiceImpl<Grade> implements GradeChercheurService {

@Autowired
private GradeDao gradeDao;



@Autowired
private EntityManager entityManager;


@Override
public List<Grade> findAll(){
        return gradeDao.findAll();
}
    @Override
    public Grade findByReference(String reference){
    if( reference==null) return null;
    return gradeDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return gradeDao.deleteByReference(reference);
    }
    @Override
    public Grade findByIdOrReference(Grade grade){
    Grade resultat=null;
    if(grade != null){
    if(StringUtil.isNotEmpty(grade.getId())){
    resultat= gradeDao.getOne(grade.getId());
    }else if(StringUtil.isNotEmpty(grade.getReference())) {
    resultat= gradeDao.findByReference(grade.getReference());
    }
    }
    return resultat;
    }

@Override
public Grade findById(Long id){
if(id==null) return null;
return gradeDao.getOne(id);
}

@Override
public Grade findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(gradeDao.findById(id).isPresent())  {
gradeDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Grade update(Grade grade){
Grade foundedGrade = findById(grade.getId());
if(foundedGrade==null) return null;
else{
return  gradeDao.save(grade);
}
}

@Override
public Grade save (Grade grade){

    Grade result =null;
    Grade foundedGrade = findByReference(grade.getReference());
    if(foundedGrade == null){



    Grade savedGrade = gradeDao.save(grade);

    result = savedGrade;
    }

    return result;
}

@Override
public List<Grade> save(List<Grade> grades){
List<Grade> list = new ArrayList<>();
for(Grade grade: grades){
list.add(save(grade));
}
return list;
}



@Override
@Transactional
public int delete(Grade grade){
    if(grade.getReference()==null) return -1;

    Grade foundedGrade = findByReference(grade.getReference());
    if(foundedGrade==null) return -1;
gradeDao.delete(foundedGrade);
return 1;
}


public List<Grade> findByCriteria(GradeVo gradeVo){

String query = "SELECT o FROM Grade o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",gradeVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",gradeVo.getReference());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",gradeVo.getLibelle());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<Grade> grades){
if(ListUtil.isNotEmpty(grades)){
grades.forEach(e->gradeDao.delete(e));
}
}
@Override
public void update(List<Grade> grades){
if(ListUtil.isNotEmpty(grades)){
grades.forEach(e->gradeDao.save(e));
}
}





    }

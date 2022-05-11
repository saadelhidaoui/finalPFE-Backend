package com.ird.faa.service.chercheur.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.ImpressionCarte;
import com.ird.faa.dao.ImpressionCarteDao;
import com.ird.faa.service.chercheur.facade.ImpressionCarteChercheurService;

import com.ird.faa.ws.rest.provided.vo.ImpressionCarteVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class ImpressionCarteChercheurServiceImpl extends AbstractServiceImpl<ImpressionCarte> implements ImpressionCarteChercheurService {

@Autowired
private ImpressionCarteDao impressionCarteDao;



@Autowired
private EntityManager entityManager;


@Override
public List<ImpressionCarte> findAll(){
        return impressionCarteDao.findAll();
}
    @Override
    public ImpressionCarte findByAff(String aff){
    if( aff==null) return null;
    return impressionCarteDao.findByAff(aff);
    }

    @Override
    @Transactional
    public int deleteByAff(String  aff) {
    return impressionCarteDao.deleteByAff(aff);
    }
    @Override
    public ImpressionCarte findByIdOrAff(ImpressionCarte impressionCarte){
    ImpressionCarte resultat=null;
    if(impressionCarte != null){
    if(StringUtil.isNotEmpty(impressionCarte.getId())){
    resultat= impressionCarteDao.getOne(impressionCarte.getId());
    }else if(StringUtil.isNotEmpty(impressionCarte.getAff())) {
    resultat= impressionCarteDao.findByAff(impressionCarte.getAff());
    }
    }
    return resultat;
    }

@Override
public ImpressionCarte findById(Long id){
if(id==null) return null;
return impressionCarteDao.getOne(id);
}

@Override
public ImpressionCarte findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(impressionCarteDao.findById(id).isPresent())  {
impressionCarteDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public ImpressionCarte update(ImpressionCarte impressionCarte){
ImpressionCarte foundedImpressionCarte = findById(impressionCarte.getId());
if(foundedImpressionCarte==null) return null;
else{
return  impressionCarteDao.save(impressionCarte);
}
}

@Override
public ImpressionCarte save (ImpressionCarte impressionCarte){

    ImpressionCarte result =null;
    ImpressionCarte foundedImpressionCarte = findByAff(impressionCarte.getAff());
    if(foundedImpressionCarte == null){



    ImpressionCarte savedImpressionCarte = impressionCarteDao.save(impressionCarte);

    result = savedImpressionCarte;
    }

    return result;
}

@Override
public List<ImpressionCarte> save(List<ImpressionCarte> impressionCartes){
List<ImpressionCarte> list = new ArrayList<>();
for(ImpressionCarte impressionCarte: impressionCartes){
list.add(save(impressionCarte));
}
return list;
}



@Override
@Transactional
public int delete(ImpressionCarte impressionCarte){
    if(impressionCarte.getAff()==null) return -1;

    ImpressionCarte foundedImpressionCarte = findByAff(impressionCarte.getAff());
    if(foundedImpressionCarte==null) return -1;
impressionCarteDao.delete(foundedImpressionCarte);
return 1;
}


public List<ImpressionCarte> findByCriteria(ImpressionCarteVo impressionCarteVo){

String query = "SELECT o FROM ImpressionCarte o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",impressionCarteVo.getId());
            query += SearchUtil.addConstraint( "o", "aff","LIKE",impressionCarteVo.getAff());
            query += SearchUtil.addConstraint( "o", "qualite","LIKE",impressionCarteVo.getQualite());
            query += SearchUtil.addConstraint( "o", "nom","LIKE",impressionCarteVo.getNom());
            query += SearchUtil.addConstraint( "o", "prenom","LIKE",impressionCarteVo.getPrenom());
            query += SearchUtil.addConstraint( "o", "nomprenomar","LIKE",impressionCarteVo.getNomprenomar());
            query += SearchUtil.addConstraint( "o", "nomAr","LIKE",impressionCarteVo.getNomAr());
            query += SearchUtil.addConstraint( "o", "prenomAr","LIKE",impressionCarteVo.getPrenomAr());
            query += SearchUtil.addConstraint( "o", "cinn","LIKE",impressionCarteVo.getCinn());
            query += SearchUtil.addConstraint( "o", "cin","LIKE",impressionCarteVo.getCin());
            query += SearchUtil.addConstraint( "o", "pprr","LIKE",impressionCarteVo.getPprr());
            query += SearchUtil.addConstraint( "o", "ppr","LIKE",impressionCarteVo.getPpr());
            query += SearchUtil.addConstraint( "o", "naissance","LIKE",impressionCarteVo.getNaissance());
        query += SearchUtil.addConstraintDate( "o", "dateNaissance","=",impressionCarteVo.getDateNaissance());
            query += SearchUtil.addConstraint( "o", "photo","LIKE",impressionCarteVo.getPhoto());
            query += SearchUtil.addConstraint( "o", "cinnConjoint","LIKE",impressionCarteVo.getCinnConjoint());
            query += SearchUtil.addConstraint( "o", "cinConjoint","LIKE",impressionCarteVo.getCinConjoint());
            query += SearchUtil.addConstraint( "o", "adherent","LIKE",impressionCarteVo.getAdherent());
            query += SearchUtil.addConstraint( "o", "nomAdherent","LIKE",impressionCarteVo.getNomAdherent());
            query += SearchUtil.addConstraint( "o", "prenomAdherent","LIKE",impressionCarteVo.getPrenomAdherent());
            query += SearchUtil.addConstraint( "o", "cinnAdherent","LIKE",impressionCarteVo.getCinnAdherent());
            query += SearchUtil.addConstraint( "o", "cinAdherent","LIKE",impressionCarteVo.getCinAdherent());
            query += SearchUtil.addConstraint( "o", "pprrAdherent","LIKE",impressionCarteVo.getPprrAdherent());
            query += SearchUtil.addConstraint( "o", "pprAdherent","LIKE",impressionCarteVo.getPprAdherent());
            query += SearchUtil.addConstraint( "o", "versocarte","LIKE",impressionCarteVo.getVersocarte());
            query += SearchUtil.addConstraint( "o", "aff1","LIKE",impressionCarteVo.getAff1());
            query += SearchUtil.addConstraint( "o", "aff2","LIKE",impressionCarteVo.getAff2());
            query += SearchUtil.addConstraint( "o", "nval","LIKE",impressionCarteVo.getNval());
            query += SearchUtil.addConstraintMinMaxDate("o","dateNaissance",impressionCarteVo.getDateNaissanceMin(),impressionCarteVo.getDateNaissanceMax());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<ImpressionCarte> impressionCartes){
if(ListUtil.isNotEmpty(impressionCartes)){
impressionCartes.forEach(e->impressionCarteDao.delete(e));
}
}
@Override
public void update(List<ImpressionCarte> impressionCartes){
if(ListUtil.isNotEmpty(impressionCartes)){
impressionCartes.forEach(e->impressionCarteDao.save(e));
}
}





    }

package com.ird.faa.service.adherent.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.EtatProjet;
import com.ird.faa.dao.EtatProjetDao;
import com.ird.faa.service.adherent.facade.EtatProjetAdherentService;

import com.ird.faa.ws.rest.provided.vo.EtatProjetVo;
import com.ird.faa.service.util.*;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class EtatProjetAdherentServiceImpl extends AbstractServiceImpl<EtatProjet> implements EtatProjetAdherentService {

@Autowired
private EtatProjetDao etatProjetDao;

    @Autowired
    private ArchivableService<EtatProjet> archivableService;


@Autowired
private EntityManager entityManager;


@Override
public List<EtatProjet> findAll(){
        return etatProjetDao.findAll();
}
    @Override
    public EtatProjet findByCode(String code){
    if( code==null) return null;
    return etatProjetDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return etatProjetDao.deleteByCode(code);
    }
    @Override
    public EtatProjet findByIdOrCode(EtatProjet etatProjet){
    EtatProjet resultat=null;
    if(etatProjet != null){
    if(StringUtil.isNotEmpty(etatProjet.getId())){
    resultat= etatProjetDao.getOne(etatProjet.getId());
    }else if(StringUtil.isNotEmpty(etatProjet.getCode())) {
    resultat= etatProjetDao.findByCode(etatProjet.getCode());
    }
    }
    return resultat;
    }

@Override
public EtatProjet findById(Long id){
if(id==null) return null;
return etatProjetDao.getOne(id);
}

@Override
public EtatProjet findByIdWithAssociatedList(Long id){
    return findById(id);
}
    @Override
    public EtatProjet archiver(EtatProjet etatProjet) {
    if (etatProjet.getArchive() == null) {
    etatProjet.setArchive(false);
    }
    etatProjet.setArchive(true);
    etatProjet.setDateArchivage(new Date());
    etatProjetDao.save(etatProjet);
    return etatProjet;

    }

    @Override
    public EtatProjet desarchiver(EtatProjet etatProjet) {
    if (etatProjet.getArchive() == null) {
    etatProjet.setArchive(false);
    }
    etatProjet.setArchive(false);
    etatProjet.setDateArchivage(null);
    etatProjetDao.save(etatProjet);
    return etatProjet;
    }



@Transactional
public int deleteById(Long id){
int res=0;
if(etatProjetDao.findById(id).isPresent())  {
etatProjetDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public EtatProjet update(EtatProjet etatProjet){
EtatProjet foundedEtatProjet = findById(etatProjet.getId());
if(foundedEtatProjet==null) return null;
else{
    archivableService.prepare(etatProjet);
return  etatProjetDao.save(etatProjet);
}
}
    private void prepareSave(EtatProjet etatProjet){
        etatProjet.setDateCreation(new Date());
                    if(etatProjet.getArchive() == null)
                etatProjet.setArchive(false);
                    if(etatProjet.getAdmin() == null)
                etatProjet.setAdmin(false);
                    if(etatProjet.getVisible() == null)
                etatProjet.setVisible(false);



    }

@Override
public EtatProjet save (EtatProjet etatProjet){
    prepareSave(etatProjet);

    EtatProjet result =null;
    EtatProjet foundedEtatProjet = findByCode(etatProjet.getCode());
    if(foundedEtatProjet == null){



    EtatProjet savedEtatProjet = etatProjetDao.save(etatProjet);

    result = savedEtatProjet;
    }

    return result;
}

@Override
public List<EtatProjet> save(List<EtatProjet> etatProjets){
List<EtatProjet> list = new ArrayList<>();
for(EtatProjet etatProjet: etatProjets){
list.add(save(etatProjet));
}
return list;
}



@Override
@Transactional
public int delete(EtatProjet etatProjet){
    if(etatProjet.getCode()==null) return -1;

    EtatProjet foundedEtatProjet = findByCode(etatProjet.getCode());
    if(foundedEtatProjet==null) return -1;
etatProjetDao.delete(foundedEtatProjet);
return 1;
}


public List<EtatProjet> findByCriteria(EtatProjetVo etatProjetVo){

String query = "SELECT o FROM EtatProjet o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",etatProjetVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",etatProjetVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",etatProjetVo.getCode());
            query += SearchUtil.addConstraint( "o", "archive","=",etatProjetVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",etatProjetVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",etatProjetVo.getDateCreation());
            query += SearchUtil.addConstraint( "o", "admin","=",etatProjetVo.getAdmin());
            query += SearchUtil.addConstraint( "o", "visible","=",etatProjetVo.getVisible());
            query += SearchUtil.addConstraint( "o", "username","LIKE",etatProjetVo.getUsername());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",etatProjetVo.getDateArchivageMin(),etatProjetVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",etatProjetVo.getDateCreationMin(),etatProjetVo.getDateCreationMax());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<EtatProjet> etatProjets){
if(ListUtil.isNotEmpty(etatProjets)){
etatProjets.forEach(e->etatProjetDao.delete(e));
}
}
@Override
public void update(List<EtatProjet> etatProjets){
if(ListUtil.isNotEmpty(etatProjets)){
etatProjets.forEach(e->etatProjetDao.save(e));
}
}





    }

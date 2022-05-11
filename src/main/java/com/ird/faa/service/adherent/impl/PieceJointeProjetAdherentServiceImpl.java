package com.ird.faa.service.adherent.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.PieceJointeProjet;
        import com.ird.faa.bean.Projet;
import com.ird.faa.dao.PieceJointeProjetDao;
import com.ird.faa.service.adherent.facade.PieceJointeProjetAdherentService;
        import com.ird.faa.service.adherent.facade.ProjetAdherentService;

import com.ird.faa.ws.rest.provided.vo.PieceJointeProjetVo;
import com.ird.faa.service.util.*;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class PieceJointeProjetAdherentServiceImpl extends AbstractServiceImpl<PieceJointeProjet> implements PieceJointeProjetAdherentService {

@Autowired
private PieceJointeProjetDao pieceJointeProjetDao;

    @Autowired
    private ArchivableService<PieceJointeProjet> archivableService;
        @Autowired
        private ProjetAdherentService projetService ;


@Autowired
private EntityManager entityManager;


@Override
public List<PieceJointeProjet> findAll(){
        return pieceJointeProjetDao.findAll();
}

        @Override
        public List<PieceJointeProjet> findByProjetReference(String reference){
        return pieceJointeProjetDao.findByProjetReference(reference);
        }

        @Override
        @Transactional
        public int deleteByProjetReference(String reference){
        return pieceJointeProjetDao.deleteByProjetReference(reference);
        }

        @Override
        public List<PieceJointeProjet> findByProjetId(Long id){
        return pieceJointeProjetDao.findByProjetId(id);
        }

        @Override
        @Transactional
        public int deleteByProjetId(Long id){
        return pieceJointeProjetDao.deleteByProjetId(id);
        }


@Override
public PieceJointeProjet findById(Long id){
if(id==null) return null;
return pieceJointeProjetDao.getOne(id);
}

@Override
public PieceJointeProjet findByIdWithAssociatedList(Long id){
    return findById(id);
}
    @Override
    public PieceJointeProjet archiver(PieceJointeProjet pieceJointeProjet) {
    if (pieceJointeProjet.getArchive() == null) {
    pieceJointeProjet.setArchive(false);
    }
    pieceJointeProjet.setArchive(true);
    pieceJointeProjet.setDateArchivage(new Date());
    pieceJointeProjetDao.save(pieceJointeProjet);
    return pieceJointeProjet;

    }

    @Override
    public PieceJointeProjet desarchiver(PieceJointeProjet pieceJointeProjet) {
    if (pieceJointeProjet.getArchive() == null) {
    pieceJointeProjet.setArchive(false);
    }
    pieceJointeProjet.setArchive(false);
    pieceJointeProjet.setDateArchivage(null);
    pieceJointeProjetDao.save(pieceJointeProjet);
    return pieceJointeProjet;
    }



@Transactional
public int deleteById(Long id){
int res=0;
if(pieceJointeProjetDao.findById(id).isPresent())  {
pieceJointeProjetDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public PieceJointeProjet update(PieceJointeProjet pieceJointeProjet){
PieceJointeProjet foundedPieceJointeProjet = findById(pieceJointeProjet.getId());
if(foundedPieceJointeProjet==null) return null;
else{
    archivableService.prepare(pieceJointeProjet);
return  pieceJointeProjetDao.save(pieceJointeProjet);
}
}
    private void prepareSave(PieceJointeProjet pieceJointeProjet){
        pieceJointeProjet.setDateCreation(new Date());
                    if(pieceJointeProjet.getArchive() == null)
                pieceJointeProjet.setArchive(false);
                    if(pieceJointeProjet.getAdmin() == null)
                pieceJointeProjet.setAdmin(false);
                    if(pieceJointeProjet.getVisible() == null)
                pieceJointeProjet.setVisible(false);



    }

@Override
public PieceJointeProjet save (PieceJointeProjet pieceJointeProjet){
    prepareSave(pieceJointeProjet);



    findProjet(pieceJointeProjet);

    return pieceJointeProjetDao.save(pieceJointeProjet);


}

@Override
public List<PieceJointeProjet> save(List<PieceJointeProjet> pieceJointeProjets){
List<PieceJointeProjet> list = new ArrayList<>();
for(PieceJointeProjet pieceJointeProjet: pieceJointeProjets){
list.add(save(pieceJointeProjet));
}
return list;
}



@Override
@Transactional
public int delete(PieceJointeProjet pieceJointeProjet){
    if(pieceJointeProjet.getId()==null) return -1;
    PieceJointeProjet foundedPieceJointeProjet = findById(pieceJointeProjet.getId());
    if(foundedPieceJointeProjet==null) return -1;
pieceJointeProjetDao.delete(foundedPieceJointeProjet);
return 1;
}


public List<PieceJointeProjet> findByCriteria(PieceJointeProjetVo pieceJointeProjetVo){

String query = "SELECT o FROM PieceJointeProjet o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",pieceJointeProjetVo.getId());
            query += SearchUtil.addConstraint( "o", "path","LIKE",pieceJointeProjetVo.getPath());
        query += SearchUtil.addConstraintDate( "o", "dateAjout","=",pieceJointeProjetVo.getDateAjout());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",pieceJointeProjetVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "archive","=",pieceJointeProjetVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",pieceJointeProjetVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",pieceJointeProjetVo.getDateCreation());
            query += SearchUtil.addConstraint( "o", "admin","=",pieceJointeProjetVo.getAdmin());
            query += SearchUtil.addConstraint( "o", "visible","=",pieceJointeProjetVo.getVisible());
            query += SearchUtil.addConstraint( "o", "username","LIKE",pieceJointeProjetVo.getUsername());
            query += SearchUtil.addConstraintMinMaxDate("o","dateAjout",pieceJointeProjetVo.getDateAjoutMin(),pieceJointeProjetVo.getDateAjoutMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",pieceJointeProjetVo.getDateArchivageMin(),pieceJointeProjetVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",pieceJointeProjetVo.getDateCreationMin(),pieceJointeProjetVo.getDateCreationMax());
    if(pieceJointeProjetVo.getProjetVo()!=null){
        query += SearchUtil.addConstraint( "o", "projet.id","=",pieceJointeProjetVo.getProjetVo().getId());
            query += SearchUtil.addConstraint( "o", "projet.reference","LIKE",pieceJointeProjetVo.getProjetVo().getReference());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findProjet(PieceJointeProjet pieceJointeProjet){
        Projet loadedProjet =projetService.findByIdOrReference(pieceJointeProjet.getProjet());

    if(loadedProjet==null ) {
    return;
    }
    pieceJointeProjet.setProjet(loadedProjet);
    }

@Override
@Transactional
public void delete(List<PieceJointeProjet> pieceJointeProjets){
if(ListUtil.isNotEmpty(pieceJointeProjets)){
pieceJointeProjets.forEach(e->pieceJointeProjetDao.delete(e));
}
}
@Override
public void update(List<PieceJointeProjet> pieceJointeProjets){
if(ListUtil.isNotEmpty(pieceJointeProjets)){
pieceJointeProjets.forEach(e->pieceJointeProjetDao.save(e));
}
}





    }

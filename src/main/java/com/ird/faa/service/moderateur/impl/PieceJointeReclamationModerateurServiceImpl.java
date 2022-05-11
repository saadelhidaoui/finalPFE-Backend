package com.ird.faa.service.moderateur.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.PieceJointeReclamation;
        import com.ird.faa.bean.Reclamation;
import com.ird.faa.dao.PieceJointeReclamationDao;
import com.ird.faa.service.moderateur.facade.PieceJointeReclamationModerateurService;
        import com.ird.faa.service.moderateur.facade.ReclamationModerateurService;

import com.ird.faa.ws.rest.provided.vo.PieceJointeReclamationVo;
import com.ird.faa.service.util.*;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class PieceJointeReclamationModerateurServiceImpl extends AbstractServiceImpl<PieceJointeReclamation> implements PieceJointeReclamationModerateurService {

@Autowired
private PieceJointeReclamationDao pieceJointeReclamationDao;

    @Autowired
    private ArchivableService<PieceJointeReclamation> archivableService;
        @Autowired
        private ReclamationModerateurService reclamationService ;


@Autowired
private EntityManager entityManager;


@Override
public List<PieceJointeReclamation> findAll(){
        return pieceJointeReclamationDao.findAll();
}

        @Override
        public List<PieceJointeReclamation> findByReclamationReference(String reference){
        return pieceJointeReclamationDao.findByReclamationReference(reference);
        }

        @Override
        @Transactional
        public int deleteByReclamationReference(String reference){
        return pieceJointeReclamationDao.deleteByReclamationReference(reference);
        }

        @Override
        public List<PieceJointeReclamation> findByReclamationId(Long id){
        return pieceJointeReclamationDao.findByReclamationId(id);
        }

        @Override
        @Transactional
        public int deleteByReclamationId(Long id){
        return pieceJointeReclamationDao.deleteByReclamationId(id);
        }


@Override
public PieceJointeReclamation findById(Long id){
if(id==null) return null;
return pieceJointeReclamationDao.getOne(id);
}

@Override
public PieceJointeReclamation findByIdWithAssociatedList(Long id){
    return findById(id);
}
    @Override
    public PieceJointeReclamation archiver(PieceJointeReclamation pieceJointeReclamation) {
    if (pieceJointeReclamation.getArchive() == null) {
    pieceJointeReclamation.setArchive(false);
    }
    pieceJointeReclamation.setArchive(true);
    pieceJointeReclamation.setDateArchivage(new Date());
    pieceJointeReclamationDao.save(pieceJointeReclamation);
    return pieceJointeReclamation;

    }

    @Override
    public PieceJointeReclamation desarchiver(PieceJointeReclamation pieceJointeReclamation) {
    if (pieceJointeReclamation.getArchive() == null) {
    pieceJointeReclamation.setArchive(false);
    }
    pieceJointeReclamation.setArchive(false);
    pieceJointeReclamation.setDateArchivage(null);
    pieceJointeReclamationDao.save(pieceJointeReclamation);
    return pieceJointeReclamation;
    }



@Transactional
public int deleteById(Long id){
int res=0;
if(pieceJointeReclamationDao.findById(id).isPresent())  {
pieceJointeReclamationDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public PieceJointeReclamation update(PieceJointeReclamation pieceJointeReclamation){
PieceJointeReclamation foundedPieceJointeReclamation = findById(pieceJointeReclamation.getId());
if(foundedPieceJointeReclamation==null) return null;
else{
    archivableService.prepare(pieceJointeReclamation);
return  pieceJointeReclamationDao.save(pieceJointeReclamation);
}
}
    private void prepareSave(PieceJointeReclamation pieceJointeReclamation){
        pieceJointeReclamation.setDateCreation(new Date());
                    if(pieceJointeReclamation.getArchive() == null)
                pieceJointeReclamation.setArchive(false);
                    if(pieceJointeReclamation.getAdmin() == null)
                pieceJointeReclamation.setAdmin(false);
                    if(pieceJointeReclamation.getVisible() == null)
                pieceJointeReclamation.setVisible(false);



    }

@Override
public PieceJointeReclamation save (PieceJointeReclamation pieceJointeReclamation){
    prepareSave(pieceJointeReclamation);



    findReclamation(pieceJointeReclamation);

    return pieceJointeReclamationDao.save(pieceJointeReclamation);


}

@Override
public List<PieceJointeReclamation> save(List<PieceJointeReclamation> pieceJointeReclamations){
List<PieceJointeReclamation> list = new ArrayList<>();
for(PieceJointeReclamation pieceJointeReclamation: pieceJointeReclamations){
list.add(save(pieceJointeReclamation));
}
return list;
}



@Override
@Transactional
public int delete(PieceJointeReclamation pieceJointeReclamation){
    if(pieceJointeReclamation.getId()==null) return -1;
    PieceJointeReclamation foundedPieceJointeReclamation = findById(pieceJointeReclamation.getId());
    if(foundedPieceJointeReclamation==null) return -1;
pieceJointeReclamationDao.delete(foundedPieceJointeReclamation);
return 1;
}


public List<PieceJointeReclamation> findByCriteria(PieceJointeReclamationVo pieceJointeReclamationVo){

String query = "SELECT o FROM PieceJointeReclamation o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",pieceJointeReclamationVo.getId());
            query += SearchUtil.addConstraint( "o", "path","LIKE",pieceJointeReclamationVo.getPath());
        query += SearchUtil.addConstraintDate( "o", "dateAjout","=",pieceJointeReclamationVo.getDateAjout());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",pieceJointeReclamationVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "archive","=",pieceJointeReclamationVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",pieceJointeReclamationVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",pieceJointeReclamationVo.getDateCreation());
            query += SearchUtil.addConstraint( "o", "admin","=",pieceJointeReclamationVo.getAdmin());
            query += SearchUtil.addConstraint( "o", "visible","=",pieceJointeReclamationVo.getVisible());
            query += SearchUtil.addConstraint( "o", "username","LIKE",pieceJointeReclamationVo.getUsername());
            query += SearchUtil.addConstraintMinMaxDate("o","dateAjout",pieceJointeReclamationVo.getDateAjoutMin(),pieceJointeReclamationVo.getDateAjoutMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",pieceJointeReclamationVo.getDateArchivageMin(),pieceJointeReclamationVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",pieceJointeReclamationVo.getDateCreationMin(),pieceJointeReclamationVo.getDateCreationMax());
    if(pieceJointeReclamationVo.getReclamationVo()!=null){
        query += SearchUtil.addConstraint( "o", "reclamation.id","=",pieceJointeReclamationVo.getReclamationVo().getId());
            query += SearchUtil.addConstraint( "o", "reclamation.reference","LIKE",pieceJointeReclamationVo.getReclamationVo().getReference());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findReclamation(PieceJointeReclamation pieceJointeReclamation){
        Reclamation loadedReclamation =reclamationService.findByIdOrReference(pieceJointeReclamation.getReclamation());

    if(loadedReclamation==null ) {
    return;
    }
    pieceJointeReclamation.setReclamation(loadedReclamation);
    }

@Override
@Transactional
public void delete(List<PieceJointeReclamation> pieceJointeReclamations){
if(ListUtil.isNotEmpty(pieceJointeReclamations)){
pieceJointeReclamations.forEach(e->pieceJointeReclamationDao.delete(e));
}
}
@Override
public void update(List<PieceJointeReclamation> pieceJointeReclamations){
if(ListUtil.isNotEmpty(pieceJointeReclamations)){
pieceJointeReclamations.forEach(e->pieceJointeReclamationDao.save(e));
}
}





    }

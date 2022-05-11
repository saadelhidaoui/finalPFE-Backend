package com.ird.faa.service.chercheur.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
    import com.ird.faa.service.util.StringUtil;
    import com.ird.faa.security.common.SecurityUtil;
    import com.ird.faa.security.bean.User;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.PieceJointeReclamation;
        import com.ird.faa.bean.Reclamation;
import com.ird.faa.dao.PieceJointeReclamationDao;
import com.ird.faa.service.chercheur.facade.PieceJointeReclamationChercheurService;
        import com.ird.faa.service.chercheur.facade.ReclamationChercheurService;

import com.ird.faa.ws.rest.provided.vo.PieceJointeReclamationVo;
import com.ird.faa.service.util.*;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class PieceJointeReclamationChercheurServiceImpl extends AbstractServiceImpl<PieceJointeReclamation> implements PieceJointeReclamationChercheurService {

@Autowired
private PieceJointeReclamationDao pieceJointeReclamationDao;

    @Autowired
    private ArchivableService<PieceJointeReclamation> archivableService;
        @Autowired
        private ReclamationChercheurService reclamationService ;


@Autowired
private EntityManager entityManager;


@Override
public List<PieceJointeReclamation> findAll(){
    List<PieceJointeReclamation> resultat= new ArrayList();
    resultat.addAll(findAllNonArchive());
    resultat.addAll(findAllByOwner());
    return resultat;
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

            pieceJointeReclamation.setAdmin(false);
            pieceJointeReclamation.setVisible(false);
            User currentUser = SecurityUtil.getCurrentUser();
            if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
            pieceJointeReclamation.setUsername(currentUser.getUsername());
            }


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




        public List<PieceJointeReclamation> findAllNonArchive(){
        String query = "SELECT o FROM PieceJointeReclamation o  WHERE o.archive != true AND o.visible = true";
        return entityManager.createQuery(query).getResultList();
        }

        public List<PieceJointeReclamation> findAllByOwner(){
        List<PieceJointeReclamation> result= new ArrayList();
        User currentUser = SecurityUtil.getCurrentUser();
        if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
        String query = "SELECT o FROM PieceJointeReclamation o  WHERE o.archive != true AND o.visible = false AND o.username = '"+ currentUser.getUsername()+"'";
        result = entityManager.createQuery(query).getResultList();
        }
        return result;
        }



    }

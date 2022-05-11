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
import com.ird.faa.bean.PieceJointeAdherent;
        import com.ird.faa.bean.Adherent;
import com.ird.faa.dao.PieceJointeAdherentDao;
import com.ird.faa.service.chercheur.facade.PieceJointeAdherentChercheurService;
        import com.ird.faa.service.chercheur.facade.AdherentChercheurService;

import com.ird.faa.ws.rest.provided.vo.PieceJointeAdherentVo;
import com.ird.faa.service.util.*;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class PieceJointeAdherentChercheurServiceImpl extends AbstractServiceImpl<PieceJointeAdherent> implements PieceJointeAdherentChercheurService {

@Autowired
private PieceJointeAdherentDao pieceJointeAdherentDao;

    @Autowired
    private ArchivableService<PieceJointeAdherent> archivableService;
        @Autowired
        private AdherentChercheurService adherentService ;


@Autowired
private EntityManager entityManager;


@Override
public List<PieceJointeAdherent> findAll(){
    List<PieceJointeAdherent> resultat= new ArrayList();
    resultat.addAll(findAllNonArchive());
    resultat.addAll(findAllByOwner());
    return resultat;
}

        @Override
        public List<PieceJointeAdherent> findByAdherentNumeroMatricule(String numeroMatricule){
        return pieceJointeAdherentDao.findByAdherentNumeroMatricule(numeroMatricule);
        }

        @Override
        @Transactional
        public int deleteByAdherentNumeroMatricule(String numeroMatricule){
        return pieceJointeAdherentDao.deleteByAdherentNumeroMatricule(numeroMatricule);
        }

        @Override
        public List<PieceJointeAdherent> findByAdherentId(Long id){
        return pieceJointeAdherentDao.findByAdherentId(id);
        }

        @Override
        @Transactional
        public int deleteByAdherentId(Long id){
        return pieceJointeAdherentDao.deleteByAdherentId(id);
        }


@Override
public PieceJointeAdherent findById(Long id){
if(id==null) return null;
return pieceJointeAdherentDao.getOne(id);
}

@Override
public PieceJointeAdherent findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(pieceJointeAdherentDao.findById(id).isPresent())  {
pieceJointeAdherentDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public PieceJointeAdherent update(PieceJointeAdherent pieceJointeAdherent){
PieceJointeAdherent foundedPieceJointeAdherent = findById(pieceJointeAdherent.getId());
if(foundedPieceJointeAdherent==null) return null;
else{
    archivableService.prepare(pieceJointeAdherent);
return  pieceJointeAdherentDao.save(pieceJointeAdherent);
}
}
    private void prepareSave(PieceJointeAdherent pieceJointeAdherent){
        pieceJointeAdherent.setDateCreation(new Date());
                    if(pieceJointeAdherent.getArchive() == null)
                pieceJointeAdherent.setArchive(false);
                    if(pieceJointeAdherent.getAdmin() == null)
                pieceJointeAdherent.setAdmin(false);
                    if(pieceJointeAdherent.getVisible() == null)
                pieceJointeAdherent.setVisible(false);

            pieceJointeAdherent.setAdmin(false);
            pieceJointeAdherent.setVisible(false);
            User currentUser = SecurityUtil.getCurrentUser();
            if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
            pieceJointeAdherent.setUsername(currentUser.getUsername());
            }


    }

@Override
public PieceJointeAdherent save (PieceJointeAdherent pieceJointeAdherent){
    prepareSave(pieceJointeAdherent);



    findAdherent(pieceJointeAdherent);

    return pieceJointeAdherentDao.save(pieceJointeAdherent);


}

@Override
public List<PieceJointeAdherent> save(List<PieceJointeAdherent> pieceJointeAdherents){
List<PieceJointeAdherent> list = new ArrayList<>();
for(PieceJointeAdherent pieceJointeAdherent: pieceJointeAdherents){
list.add(save(pieceJointeAdherent));
}
return list;
}



@Override
@Transactional
public int delete(PieceJointeAdherent pieceJointeAdherent){
    if(pieceJointeAdherent.getId()==null) return -1;
    PieceJointeAdherent foundedPieceJointeAdherent = findById(pieceJointeAdherent.getId());
    if(foundedPieceJointeAdherent==null) return -1;
pieceJointeAdherentDao.delete(foundedPieceJointeAdherent);
return 1;
}


public List<PieceJointeAdherent> findByCriteria(PieceJointeAdherentVo pieceJointeAdherentVo){

String query = "SELECT o FROM PieceJointeAdherent o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",pieceJointeAdherentVo.getId());
            query += SearchUtil.addConstraint( "o", "path","LIKE",pieceJointeAdherentVo.getPath());
        query += SearchUtil.addConstraintDate( "o", "dateAjout","=",pieceJointeAdherentVo.getDateAjout());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",pieceJointeAdherentVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "archive","=",pieceJointeAdherentVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",pieceJointeAdherentVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",pieceJointeAdherentVo.getDateCreation());
            query += SearchUtil.addConstraint( "o", "admin","=",pieceJointeAdherentVo.getAdmin());
            query += SearchUtil.addConstraint( "o", "visible","=",pieceJointeAdherentVo.getVisible());
            query += SearchUtil.addConstraint( "o", "username","LIKE",pieceJointeAdherentVo.getUsername());
            query += SearchUtil.addConstraintMinMaxDate("o","dateAjout",pieceJointeAdherentVo.getDateAjoutMin(),pieceJointeAdherentVo.getDateAjoutMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",pieceJointeAdherentVo.getDateArchivageMin(),pieceJointeAdherentVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",pieceJointeAdherentVo.getDateCreationMin(),pieceJointeAdherentVo.getDateCreationMax());
    if(pieceJointeAdherentVo.getAdherentVo()!=null){
        query += SearchUtil.addConstraint( "o", "adherent.id","=",pieceJointeAdherentVo.getAdherentVo().getId());
            query += SearchUtil.addConstraint( "o", "adherent.numeroMatricule","LIKE",pieceJointeAdherentVo.getAdherentVo().getNumeroMatricule());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findAdherent(PieceJointeAdherent pieceJointeAdherent){
        Adherent loadedAdherent =adherentService.findByIdOrNumeroMatricule(pieceJointeAdherent.getAdherent());

    if(loadedAdherent==null ) {
    return;
    }
    pieceJointeAdherent.setAdherent(loadedAdherent);
    }

@Override
@Transactional
public void delete(List<PieceJointeAdherent> pieceJointeAdherents){
if(ListUtil.isNotEmpty(pieceJointeAdherents)){
pieceJointeAdherents.forEach(e->pieceJointeAdherentDao.delete(e));
}
}
@Override
public void update(List<PieceJointeAdherent> pieceJointeAdherents){
if(ListUtil.isNotEmpty(pieceJointeAdherents)){
pieceJointeAdherents.forEach(e->pieceJointeAdherentDao.save(e));
}
}




        public List<PieceJointeAdherent> findAllNonArchive(){
        String query = "SELECT o FROM PieceJointeAdherent o  WHERE o.archive != true AND o.visible = true";
        return entityManager.createQuery(query).getResultList();
        }

        public List<PieceJointeAdherent> findAllByOwner(){
        List<PieceJointeAdherent> result= new ArrayList();
        User currentUser = SecurityUtil.getCurrentUser();
        if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
        String query = "SELECT o FROM PieceJointeAdherent o  WHERE o.archive != true AND o.visible = false AND o.username = '"+ currentUser.getUsername()+"'";
        result = entityManager.createQuery(query).getResultList();
        }
        return result;
        }



    }

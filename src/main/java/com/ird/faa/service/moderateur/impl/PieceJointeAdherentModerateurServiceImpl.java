package com.ird.faa.service.moderateur.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.PieceJointeAdherent;
        import com.ird.faa.bean.Adherent;
import com.ird.faa.dao.PieceJointeAdherentDao;
import com.ird.faa.service.moderateur.facade.PieceJointeAdherentModerateurService;
        import com.ird.faa.service.moderateur.facade.AdherentModerateurService;

import com.ird.faa.ws.rest.provided.vo.PieceJointeAdherentVo;
import com.ird.faa.service.util.*;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class PieceJointeAdherentModerateurServiceImpl extends AbstractServiceImpl<PieceJointeAdherent> implements PieceJointeAdherentModerateurService {

@Autowired
private PieceJointeAdherentDao pieceJointeAdherentDao;

    @Autowired
    private ArchivableService<PieceJointeAdherent> archivableService;
        @Autowired
        private AdherentModerateurService adherentService ;


@Autowired
private EntityManager entityManager;


@Override
public List<PieceJointeAdherent> findAll(){
        return pieceJointeAdherentDao.findAll();
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
    @Override
    public PieceJointeAdherent archiver(PieceJointeAdherent pieceJointeAdherent) {
    if (pieceJointeAdherent.getArchive() == null) {
    pieceJointeAdherent.setArchive(false);
    }
    pieceJointeAdherent.setArchive(true);
    pieceJointeAdherent.setDateArchivage(new Date());
    pieceJointeAdherentDao.save(pieceJointeAdherent);
    return pieceJointeAdherent;

    }

    @Override
    public PieceJointeAdherent desarchiver(PieceJointeAdherent pieceJointeAdherent) {
    if (pieceJointeAdherent.getArchive() == null) {
    pieceJointeAdherent.setArchive(false);
    }
    pieceJointeAdherent.setArchive(false);
    pieceJointeAdherent.setDateArchivage(null);
    pieceJointeAdherentDao.save(pieceJointeAdherent);
    return pieceJointeAdherent;
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





    }

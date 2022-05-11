package com.ird.faa.service.moderateur.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.PieceJointeRendezVous;
        import com.ird.faa.bean.RendezVous;
import com.ird.faa.dao.PieceJointeRendezVousDao;
import com.ird.faa.service.moderateur.facade.PieceJointeRendezVousModerateurService;
        import com.ird.faa.service.moderateur.facade.RendezVousModerateurService;

import com.ird.faa.ws.rest.provided.vo.PieceJointeRendezVousVo;
import com.ird.faa.service.util.*;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class PieceJointeRendezVousModerateurServiceImpl extends AbstractServiceImpl<PieceJointeRendezVous> implements PieceJointeRendezVousModerateurService {

@Autowired
private PieceJointeRendezVousDao pieceJointeRendezVousDao;

    @Autowired
    private ArchivableService<PieceJointeRendezVous> archivableService;
        @Autowired
        private RendezVousModerateurService rendezVousService ;


@Autowired
private EntityManager entityManager;


@Override
public List<PieceJointeRendezVous> findAll(){
        return pieceJointeRendezVousDao.findAll();
}

        @Override
        public List<PieceJointeRendezVous> findByRendezVousReference(String reference){
        return pieceJointeRendezVousDao.findByRendezVousReference(reference);
        }

        @Override
        @Transactional
        public int deleteByRendezVousReference(String reference){
        return pieceJointeRendezVousDao.deleteByRendezVousReference(reference);
        }

        @Override
        public List<PieceJointeRendezVous> findByRendezVousId(Long id){
        return pieceJointeRendezVousDao.findByRendezVousId(id);
        }

        @Override
        @Transactional
        public int deleteByRendezVousId(Long id){
        return pieceJointeRendezVousDao.deleteByRendezVousId(id);
        }


@Override
public PieceJointeRendezVous findById(Long id){
if(id==null) return null;
return pieceJointeRendezVousDao.getOne(id);
}

@Override
public PieceJointeRendezVous findByIdWithAssociatedList(Long id){
    return findById(id);
}
    @Override
    public PieceJointeRendezVous archiver(PieceJointeRendezVous pieceJointeRendezVous) {
    if (pieceJointeRendezVous.getArchive() == null) {
    pieceJointeRendezVous.setArchive(false);
    }
    pieceJointeRendezVous.setArchive(true);
    pieceJointeRendezVous.setDateArchivage(new Date());
    pieceJointeRendezVousDao.save(pieceJointeRendezVous);
    return pieceJointeRendezVous;

    }

    @Override
    public PieceJointeRendezVous desarchiver(PieceJointeRendezVous pieceJointeRendezVous) {
    if (pieceJointeRendezVous.getArchive() == null) {
    pieceJointeRendezVous.setArchive(false);
    }
    pieceJointeRendezVous.setArchive(false);
    pieceJointeRendezVous.setDateArchivage(null);
    pieceJointeRendezVousDao.save(pieceJointeRendezVous);
    return pieceJointeRendezVous;
    }



@Transactional
public int deleteById(Long id){
int res=0;
if(pieceJointeRendezVousDao.findById(id).isPresent())  {
pieceJointeRendezVousDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public PieceJointeRendezVous update(PieceJointeRendezVous pieceJointeRendezVous){
PieceJointeRendezVous foundedPieceJointeRendezVous = findById(pieceJointeRendezVous.getId());
if(foundedPieceJointeRendezVous==null) return null;
else{
    archivableService.prepare(pieceJointeRendezVous);
return  pieceJointeRendezVousDao.save(pieceJointeRendezVous);
}
}
    private void prepareSave(PieceJointeRendezVous pieceJointeRendezVous){
        pieceJointeRendezVous.setDateCreation(new Date());
                    if(pieceJointeRendezVous.getArchive() == null)
                pieceJointeRendezVous.setArchive(false);
                    if(pieceJointeRendezVous.getAdmin() == null)
                pieceJointeRendezVous.setAdmin(false);
                    if(pieceJointeRendezVous.getVisible() == null)
                pieceJointeRendezVous.setVisible(false);



    }

@Override
public PieceJointeRendezVous save (PieceJointeRendezVous pieceJointeRendezVous){
    prepareSave(pieceJointeRendezVous);



    findRendezVous(pieceJointeRendezVous);

    return pieceJointeRendezVousDao.save(pieceJointeRendezVous);


}

@Override
public List<PieceJointeRendezVous> save(List<PieceJointeRendezVous> pieceJointeRendezVouss){
List<PieceJointeRendezVous> list = new ArrayList<>();
for(PieceJointeRendezVous pieceJointeRendezVous: pieceJointeRendezVouss){
list.add(save(pieceJointeRendezVous));
}
return list;
}



@Override
@Transactional
public int delete(PieceJointeRendezVous pieceJointeRendezVous){
    if(pieceJointeRendezVous.getId()==null) return -1;
    PieceJointeRendezVous foundedPieceJointeRendezVous = findById(pieceJointeRendezVous.getId());
    if(foundedPieceJointeRendezVous==null) return -1;
pieceJointeRendezVousDao.delete(foundedPieceJointeRendezVous);
return 1;
}


public List<PieceJointeRendezVous> findByCriteria(PieceJointeRendezVousVo pieceJointeRendezVousVo){

String query = "SELECT o FROM PieceJointeRendezVous o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",pieceJointeRendezVousVo.getId());
            query += SearchUtil.addConstraint( "o", "path","LIKE",pieceJointeRendezVousVo.getPath());
        query += SearchUtil.addConstraintDate( "o", "dateAjout","=",pieceJointeRendezVousVo.getDateAjout());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",pieceJointeRendezVousVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "archive","=",pieceJointeRendezVousVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",pieceJointeRendezVousVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",pieceJointeRendezVousVo.getDateCreation());
            query += SearchUtil.addConstraint( "o", "admin","=",pieceJointeRendezVousVo.getAdmin());
            query += SearchUtil.addConstraint( "o", "visible","=",pieceJointeRendezVousVo.getVisible());
            query += SearchUtil.addConstraint( "o", "username","LIKE",pieceJointeRendezVousVo.getUsername());
            query += SearchUtil.addConstraintMinMaxDate("o","dateAjout",pieceJointeRendezVousVo.getDateAjoutMin(),pieceJointeRendezVousVo.getDateAjoutMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",pieceJointeRendezVousVo.getDateArchivageMin(),pieceJointeRendezVousVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",pieceJointeRendezVousVo.getDateCreationMin(),pieceJointeRendezVousVo.getDateCreationMax());
    if(pieceJointeRendezVousVo.getRendezVousVo()!=null){
        query += SearchUtil.addConstraint( "o", "rendezVous.id","=",pieceJointeRendezVousVo.getRendezVousVo().getId());
            query += SearchUtil.addConstraint( "o", "rendezVous.reference","LIKE",pieceJointeRendezVousVo.getRendezVousVo().getReference());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findRendezVous(PieceJointeRendezVous pieceJointeRendezVous){
        RendezVous loadedRendezVous =rendezVousService.findByIdOrReference(pieceJointeRendezVous.getRendezVous());

    if(loadedRendezVous==null ) {
    return;
    }
    pieceJointeRendezVous.setRendezVous(loadedRendezVous);
    }

@Override
@Transactional
public void delete(List<PieceJointeRendezVous> pieceJointeRendezVouss){
if(ListUtil.isNotEmpty(pieceJointeRendezVouss)){
pieceJointeRendezVouss.forEach(e->pieceJointeRendezVousDao.delete(e));
}
}
@Override
public void update(List<PieceJointeRendezVous> pieceJointeRendezVouss){
if(ListUtil.isNotEmpty(pieceJointeRendezVouss)){
pieceJointeRendezVouss.forEach(e->pieceJointeRendezVousDao.save(e));
}
}





    }

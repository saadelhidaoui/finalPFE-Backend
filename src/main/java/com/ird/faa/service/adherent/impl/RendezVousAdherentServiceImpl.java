package com.ird.faa.service.adherent.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.RendezVous;
        import com.ird.faa.bean.PieceJointeRendezVous;
import com.ird.faa.dao.RendezVousDao;
import com.ird.faa.service.adherent.facade.RendezVousAdherentService;
        import com.ird.faa.service.adherent.facade.PieceJointeRendezVousAdherentService;

import com.ird.faa.ws.rest.provided.vo.RendezVousVo;
import com.ird.faa.service.util.*;
        import com.ird.faa.bean.PieceJointeRendezVous;
        import com.ird.faa.service.adherent.facade.PieceJointeRendezVousAdherentService;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class RendezVousAdherentServiceImpl extends AbstractServiceImpl<RendezVous> implements RendezVousAdherentService {

@Autowired
private RendezVousDao rendezVousDao;

    @Autowired
    private ArchivableService<RendezVous> archivableService;
        @Autowired
        private PieceJointeRendezVousAdherentService pieceJointeRendezVousService ;


@Autowired
private EntityManager entityManager;


@Override
public List<RendezVous> findAll(){
        return rendezVousDao.findAll();
}
    @Override
    public RendezVous findByReference(String reference){
    if( reference==null) return null;
    return rendezVousDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return rendezVousDao.deleteByReference(reference);
    }
    @Override
    public RendezVous findByIdOrReference(RendezVous rendezVous){
    RendezVous resultat=null;
    if(rendezVous != null){
    if(StringUtil.isNotEmpty(rendezVous.getId())){
    resultat= rendezVousDao.getOne(rendezVous.getId());
    }else if(StringUtil.isNotEmpty(rendezVous.getReference())) {
    resultat= rendezVousDao.findByReference(rendezVous.getReference());
    }
    }
    return resultat;
    }

@Override
public RendezVous findById(Long id){
if(id==null) return null;
return rendezVousDao.getOne(id);
}

@Override
public RendezVous findByIdWithAssociatedList(Long id){
    RendezVous rendezVous  = findById(id);
    findAssociatedLists(rendezVous);
    return rendezVous;
}
    @Override
    public RendezVous archiver(RendezVous rendezVous) {
    if (rendezVous.getArchive() == null) {
    rendezVous.setArchive(false);
    }
    rendezVous.setArchive(true);
    rendezVous.setDateArchivage(new Date());
    rendezVousDao.save(rendezVous);
    return rendezVous;

    }

    @Override
    public RendezVous desarchiver(RendezVous rendezVous) {
    if (rendezVous.getArchive() == null) {
    rendezVous.setArchive(false);
    }
    rendezVous.setArchive(false);
    rendezVous.setDateArchivage(null);
    rendezVousDao.save(rendezVous);
    return rendezVous;
    }

    private void findAssociatedLists(RendezVous rendezVous){
    if(rendezVous!=null && rendezVous.getId() != null) {
            List<PieceJointeRendezVous> pieceJointeRendezVouss = pieceJointeRendezVousService.findByRendezVousId(rendezVous.getId());
            rendezVous.setPieceJointeRendezVouss(pieceJointeRendezVouss);
    }
    }
    private void deleteAssociatedLists(Long id){
    if(id != null ) {
            pieceJointeRendezVousService.deleteByRendezVousId(id);
    }
    }

    private void updateAssociatedLists(RendezVous rendezVous){
    if(rendezVous !=null && rendezVous.getId() != null){
            List
            <List<PieceJointeRendezVous>> resultPieceJointeRendezVouss= pieceJointeRendezVousService.getToBeSavedAndToBeDeleted(pieceJointeRendezVousService.findByRendezVousId(rendezVous.getId()),rendezVous.getPieceJointeRendezVouss());
            pieceJointeRendezVousService.delete(resultPieceJointeRendezVouss.get(1));
            associatePieceJointeRendezVous(rendezVous,resultPieceJointeRendezVouss.get(0));
            pieceJointeRendezVousService.update(resultPieceJointeRendezVouss.get(0));

    }
    }

@Transactional
public int deleteById(Long id){
int res=0;
if(rendezVousDao.findById(id).isPresent())  {
    deleteAssociatedLists(id);
rendezVousDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public RendezVous update(RendezVous rendezVous){
RendezVous foundedRendezVous = findById(rendezVous.getId());
if(foundedRendezVous==null) return null;
else{
    archivableService.prepare(rendezVous);
    updateAssociatedLists(rendezVous);
return  rendezVousDao.save(rendezVous);
}
}
    private void prepareSave(RendezVous rendezVous){
        rendezVous.setDateCreation(new Date());
                    if(rendezVous.getArchive() == null)
                rendezVous.setArchive(false);
                    if(rendezVous.getAdmin() == null)
                rendezVous.setAdmin(false);
                    if(rendezVous.getVisible() == null)
                rendezVous.setVisible(false);



    }

@Override
public RendezVous save (RendezVous rendezVous){
    prepareSave(rendezVous);

    RendezVous result =null;
    RendezVous foundedRendezVous = findByReference(rendezVous.getReference());
    if(foundedRendezVous == null){



    RendezVous savedRendezVous = rendezVousDao.save(rendezVous);

        savePieceJointeRendezVouss(savedRendezVous,rendezVous.getPieceJointeRendezVouss());
    result = savedRendezVous;
    }

    return result;
}

@Override
public List<RendezVous> save(List<RendezVous> rendezVouss){
List<RendezVous> list = new ArrayList<>();
for(RendezVous rendezVous: rendezVouss){
list.add(save(rendezVous));
}
return list;
}

        private List<PieceJointeRendezVous> preparePieceJointeRendezVouss(RendezVous rendezVous,List<PieceJointeRendezVous> pieceJointeRendezVouss){
        for(PieceJointeRendezVous pieceJointeRendezVous:pieceJointeRendezVouss ){
        pieceJointeRendezVous.setRendezVous(rendezVous);
        }
        return pieceJointeRendezVouss;
        }


@Override
@Transactional
public int delete(RendezVous rendezVous){
    if(rendezVous.getReference()==null) return -1;

    RendezVous foundedRendezVous = findByReference(rendezVous.getReference());
    if(foundedRendezVous==null) return -1;
rendezVousDao.delete(foundedRendezVous);
return 1;
}


public List<RendezVous> findByCriteria(RendezVousVo rendezVousVo){

String query = "SELECT o FROM RendezVous o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",rendezVousVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",rendezVousVo.getReference());
            query += SearchUtil.addConstraint( "o", "description","LIKE",rendezVousVo.getDescription());
        query += SearchUtil.addConstraintDate( "o", "dateDebut","=",rendezVousVo.getDateDebut());
            query += SearchUtil.addConstraint( "o", "pv","LIKE",rendezVousVo.getPv());
            query += SearchUtil.addConstraint( "o", "archive","=",rendezVousVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",rendezVousVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",rendezVousVo.getDateCreation());
            query += SearchUtil.addConstraint( "o", "admin","=",rendezVousVo.getAdmin());
            query += SearchUtil.addConstraint( "o", "visible","=",rendezVousVo.getVisible());
            query += SearchUtil.addConstraint( "o", "username","LIKE",rendezVousVo.getUsername());
            query += SearchUtil.addConstraintMinMaxDate("o","dateDebut",rendezVousVo.getDateDebutMin(),rendezVousVo.getDateDebutMax());
            query += SearchUtil.addConstraintMinMax("o","pieceJointeRendezVouss",rendezVousVo.getPieceJointeRendezVoussMin(),rendezVousVo.getPieceJointeRendezVoussMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",rendezVousVo.getDateArchivageMin(),rendezVousVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",rendezVousVo.getDateCreationMin(),rendezVousVo.getDateCreationMax());
return entityManager.createQuery(query).getResultList();
}
        private  void savePieceJointeRendezVouss(RendezVous rendezVous,List<PieceJointeRendezVous> pieceJointeRendezVouss){

        if (ListUtil.isNotEmpty(rendezVous.getPieceJointeRendezVouss())) {
        List<PieceJointeRendezVous> savedPieceJointeRendezVouss = new ArrayList<>();
        pieceJointeRendezVouss.forEach(element -> {
        element.setRendezVous(rendezVous);
         pieceJointeRendezVousService.save(element);
        });
        rendezVous.setPieceJointeRendezVouss(savedPieceJointeRendezVouss);
        }
        }


@Override
@Transactional
public void delete(List<RendezVous> rendezVouss){
if(ListUtil.isNotEmpty(rendezVouss)){
rendezVouss.forEach(e->rendezVousDao.delete(e));
}
}
@Override
public void update(List<RendezVous> rendezVouss){
if(ListUtil.isNotEmpty(rendezVouss)){
rendezVouss.forEach(e->rendezVousDao.save(e));
}
}

        private void associatePieceJointeRendezVous(RendezVous rendezVous, List<PieceJointeRendezVous> pieceJointeRendezVous) {
        if (ListUtil.isNotEmpty(pieceJointeRendezVous)) {
        pieceJointeRendezVous.forEach(e -> e.setRendezVous(rendezVous));
        }
        }




    }

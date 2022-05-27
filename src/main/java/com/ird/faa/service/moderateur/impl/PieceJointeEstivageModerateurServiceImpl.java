package com.ird.faa.service.moderateur.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.PieceJointeEstivage;
        import com.ird.faa.bean.Estivage;
import com.ird.faa.dao.PieceJointeEstivageDao;
import com.ird.faa.service.moderateur.facade.PieceJointeEstivageModerateurService;
        import com.ird.faa.service.moderateur.facade.EstivageModerateurService;

import com.ird.faa.ws.rest.provided.vo.PieceJointeEstivageVo;
import com.ird.faa.service.util.*;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class PieceJointeEstivageModerateurServiceImpl extends AbstractServiceImpl<PieceJointeEstivage> implements PieceJointeEstivageModerateurService {

@Autowired
private PieceJointeEstivageDao pieceJointeEstivageDao;

    @Autowired
    private ArchivableService<PieceJointeEstivage> archivableService;
        @Autowired
        private EstivageModerateurService estivageService ;


@Autowired
private EntityManager entityManager;


@Override
public List<PieceJointeEstivage> findAll(){
        return pieceJointeEstivageDao.findAll();
}

        @Override
        public List<PieceJointeEstivage> findByEstivageReference(String reference){
        return pieceJointeEstivageDao.findByEstivageReference(reference);
        }

        @Override
        @Transactional
        public int deleteByEstivageReference(String reference){
        return pieceJointeEstivageDao.deleteByEstivageReference(reference);
        }

        @Override
        public List<PieceJointeEstivage> findByEstivageId(Long id){
        return pieceJointeEstivageDao.findByEstivageId(id);
        }

        @Override
        @Transactional
        public int deleteByEstivageId(Long id){
        return pieceJointeEstivageDao.deleteByEstivageId(id);
        }


@Override
public PieceJointeEstivage findById(Long id){
if(id==null) return null;
return pieceJointeEstivageDao.getOne(id);
}

@Override
public PieceJointeEstivage findByIdWithAssociatedList(Long id){
    return findById(id);
}
    @Override
    public PieceJointeEstivage archiver(PieceJointeEstivage pieceJointeEstivage) {
    if (pieceJointeEstivage.getArchive() == null) {
    pieceJointeEstivage.setArchive(false);
    }
    pieceJointeEstivage.setArchive(true);
    pieceJointeEstivage.setDateArchivage(new Date());
    pieceJointeEstivageDao.save(pieceJointeEstivage);
    return pieceJointeEstivage;

    }

    @Override
    public PieceJointeEstivage desarchiver(PieceJointeEstivage pieceJointeEstivage) {
    if (pieceJointeEstivage.getArchive() == null) {
    pieceJointeEstivage.setArchive(false);
    }
    pieceJointeEstivage.setArchive(false);
    pieceJointeEstivage.setDateArchivage(null);
    pieceJointeEstivageDao.save(pieceJointeEstivage);
    return pieceJointeEstivage;
    }

    @Override
    public int deleteByDemandeEstivageId(Long id) {
        return 1;
    }

    @Override
    public List<PieceJointeEstivage> findByDemandeEstivageId(Long id) {
        return null;
    }


    @Transactional
public int deleteById(Long id){
int res=0;
if(pieceJointeEstivageDao.findById(id).isPresent())  {
pieceJointeEstivageDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public PieceJointeEstivage update(PieceJointeEstivage pieceJointeEstivage){
PieceJointeEstivage foundedPieceJointeEstivage = findById(pieceJointeEstivage.getId());
if(foundedPieceJointeEstivage==null) return null;
else{
    archivableService.prepare(pieceJointeEstivage);
return  pieceJointeEstivageDao.save(pieceJointeEstivage);
}
}
    private void prepareSave(PieceJointeEstivage pieceJointeEstivage){
        pieceJointeEstivage.setDateCreation(new Date());
                    if(pieceJointeEstivage.getArchive() == null)
                pieceJointeEstivage.setArchive(false);
                    if(pieceJointeEstivage.getAdmin() == null)
                pieceJointeEstivage.setAdmin(false);
                    if(pieceJointeEstivage.getVisible() == null)
                pieceJointeEstivage.setVisible(false);



    }

@Override
public PieceJointeEstivage save (PieceJointeEstivage pieceJointeEstivage){
    prepareSave(pieceJointeEstivage);



    findEstivage(pieceJointeEstivage);

    return pieceJointeEstivageDao.save(pieceJointeEstivage);


}

@Override
public List<PieceJointeEstivage> save(List<PieceJointeEstivage> pieceJointeEstivages){
List<PieceJointeEstivage> list = new ArrayList<>();
for(PieceJointeEstivage pieceJointeEstivage: pieceJointeEstivages){
list.add(save(pieceJointeEstivage));
}
return list;
}



@Override
@Transactional
public int delete(PieceJointeEstivage pieceJointeEstivage){
    if(pieceJointeEstivage.getId()==null) return -1;
    PieceJointeEstivage foundedPieceJointeEstivage = findById(pieceJointeEstivage.getId());
    if(foundedPieceJointeEstivage==null) return -1;
pieceJointeEstivageDao.delete(foundedPieceJointeEstivage);
return 1;
}


public List<PieceJointeEstivage> findByCriteria(PieceJointeEstivageVo pieceJointeEstivageVo){

String query = "SELECT o FROM PieceJointeEstivage o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",pieceJointeEstivageVo.getId());
            query += SearchUtil.addConstraint( "o", "path","LIKE",pieceJointeEstivageVo.getPath());
        query += SearchUtil.addConstraintDate( "o", "dateAjout","=",pieceJointeEstivageVo.getDateAjout());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",pieceJointeEstivageVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "archive","=",pieceJointeEstivageVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",pieceJointeEstivageVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",pieceJointeEstivageVo.getDateCreation());
            query += SearchUtil.addConstraint( "o", "admin","=",pieceJointeEstivageVo.getAdmin());
            query += SearchUtil.addConstraint( "o", "visible","=",pieceJointeEstivageVo.getVisible());
            query += SearchUtil.addConstraint( "o", "username","LIKE",pieceJointeEstivageVo.getUsername());
            query += SearchUtil.addConstraintMinMaxDate("o","dateAjout",pieceJointeEstivageVo.getDateAjoutMin(),pieceJointeEstivageVo.getDateAjoutMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",pieceJointeEstivageVo.getDateArchivageMin(),pieceJointeEstivageVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",pieceJointeEstivageVo.getDateCreationMin(),pieceJointeEstivageVo.getDateCreationMax());
    if(pieceJointeEstivageVo.getEstivageVo()!=null){
        query += SearchUtil.addConstraint( "o", "estivage.id","=",pieceJointeEstivageVo.getEstivageVo().getId());
            query += SearchUtil.addConstraint( "o", "estivage.reference","LIKE",pieceJointeEstivageVo.getEstivageVo().getReference());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findEstivage(PieceJointeEstivage pieceJointeEstivage){
        Estivage loadedEstivage =estivageService.findByIdOrReference(pieceJointeEstivage.getEstivage());

    if(loadedEstivage==null ) {
    return;
    }
    pieceJointeEstivage.setEstivage(loadedEstivage);
    }

@Override
@Transactional
public void delete(List<PieceJointeEstivage> pieceJointeEstivages){
if(ListUtil.isNotEmpty(pieceJointeEstivages)){
pieceJointeEstivages.forEach(e->pieceJointeEstivageDao.delete(e));
}
}
@Override
public void update(List<PieceJointeEstivage> pieceJointeEstivages){
if(ListUtil.isNotEmpty(pieceJointeEstivages)){
pieceJointeEstivages.forEach(e->pieceJointeEstivageDao.save(e));
}
}





    }

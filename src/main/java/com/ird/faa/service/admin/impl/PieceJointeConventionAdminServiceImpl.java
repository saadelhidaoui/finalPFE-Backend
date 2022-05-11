package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.PieceJointeConvention;
        import com.ird.faa.bean.Convention;
import com.ird.faa.dao.PieceJointeConventionDao;
import com.ird.faa.service.admin.facade.PieceJointeConventionAdminService;
        import com.ird.faa.service.admin.facade.ConventionAdminService;

import com.ird.faa.ws.rest.provided.vo.PieceJointeConventionVo;
import com.ird.faa.service.util.*;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class PieceJointeConventionAdminServiceImpl extends AbstractServiceImpl<PieceJointeConvention> implements PieceJointeConventionAdminService {

@Autowired
private PieceJointeConventionDao pieceJointeConventionDao;

    @Autowired
    private ArchivableService<PieceJointeConvention> archivableService;
        @Autowired
        private ConventionAdminService conventionService ;


@Autowired
private EntityManager entityManager;


@Override
public List<PieceJointeConvention> findAll(){
        return pieceJointeConventionDao.findAll();
}

        @Override
        public List<PieceJointeConvention> findByConventionReference(String reference){
        return pieceJointeConventionDao.findByConventionReference(reference);
        }

        @Override
        @Transactional
        public int deleteByConventionReference(String reference){
        return pieceJointeConventionDao.deleteByConventionReference(reference);
        }

        @Override
        public List<PieceJointeConvention> findByConventionId(Long id){
        return pieceJointeConventionDao.findByConventionId(id);
        }

        @Override
        @Transactional
        public int deleteByConventionId(Long id){
        return pieceJointeConventionDao.deleteByConventionId(id);
        }


@Override
public PieceJointeConvention findById(Long id){
if(id==null) return null;
return pieceJointeConventionDao.getOne(id);
}

@Override
public PieceJointeConvention findByIdWithAssociatedList(Long id){
    return findById(id);
}
    @Override
    public PieceJointeConvention archiver(PieceJointeConvention pieceJointeConvention) {
    if (pieceJointeConvention.getArchive() == null) {
    pieceJointeConvention.setArchive(false);
    }
    pieceJointeConvention.setArchive(true);
    pieceJointeConvention.setDateArchivage(new Date());
    pieceJointeConventionDao.save(pieceJointeConvention);
    return pieceJointeConvention;

    }

    @Override
    public PieceJointeConvention desarchiver(PieceJointeConvention pieceJointeConvention) {
    if (pieceJointeConvention.getArchive() == null) {
    pieceJointeConvention.setArchive(false);
    }
    pieceJointeConvention.setArchive(false);
    pieceJointeConvention.setDateArchivage(null);
    pieceJointeConventionDao.save(pieceJointeConvention);
    return pieceJointeConvention;
    }



@Transactional
public int deleteById(Long id){
int res=0;
if(pieceJointeConventionDao.findById(id).isPresent())  {
pieceJointeConventionDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public PieceJointeConvention update(PieceJointeConvention pieceJointeConvention){
PieceJointeConvention foundedPieceJointeConvention = findById(pieceJointeConvention.getId());
if(foundedPieceJointeConvention==null) return null;
else{
    archivableService.prepare(pieceJointeConvention);
return  pieceJointeConventionDao.save(pieceJointeConvention);
}
}
    private void prepareSave(PieceJointeConvention pieceJointeConvention){
        pieceJointeConvention.setDateCreation(new Date());
                    if(pieceJointeConvention.getArchive() == null)
                pieceJointeConvention.setArchive(false);
                    if(pieceJointeConvention.getAdmin() == null)
                pieceJointeConvention.setAdmin(false);
                    if(pieceJointeConvention.getVisible() == null)
                pieceJointeConvention.setVisible(false);



    }

@Override
public PieceJointeConvention save (PieceJointeConvention pieceJointeConvention){
    prepareSave(pieceJointeConvention);



    findConvention(pieceJointeConvention);

    return pieceJointeConventionDao.save(pieceJointeConvention);


}

@Override
public List<PieceJointeConvention> save(List<PieceJointeConvention> pieceJointeConventions){
List<PieceJointeConvention> list = new ArrayList<>();
for(PieceJointeConvention pieceJointeConvention: pieceJointeConventions){
list.add(save(pieceJointeConvention));
}
return list;
}



@Override
@Transactional
public int delete(PieceJointeConvention pieceJointeConvention){
    if(pieceJointeConvention.getId()==null) return -1;
    PieceJointeConvention foundedPieceJointeConvention = findById(pieceJointeConvention.getId());
    if(foundedPieceJointeConvention==null) return -1;
pieceJointeConventionDao.delete(foundedPieceJointeConvention);
return 1;
}


public List<PieceJointeConvention> findByCriteria(PieceJointeConventionVo pieceJointeConventionVo){

String query = "SELECT o FROM PieceJointeConvention o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",pieceJointeConventionVo.getId());
            query += SearchUtil.addConstraint( "o", "path","LIKE",pieceJointeConventionVo.getPath());
        query += SearchUtil.addConstraintDate( "o", "dateAjout","=",pieceJointeConventionVo.getDateAjout());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",pieceJointeConventionVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "archive","=",pieceJointeConventionVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",pieceJointeConventionVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",pieceJointeConventionVo.getDateCreation());
            query += SearchUtil.addConstraint( "o", "admin","=",pieceJointeConventionVo.getAdmin());
            query += SearchUtil.addConstraint( "o", "visible","=",pieceJointeConventionVo.getVisible());
            query += SearchUtil.addConstraint( "o", "username","LIKE",pieceJointeConventionVo.getUsername());
            query += SearchUtil.addConstraintMinMaxDate("o","dateAjout",pieceJointeConventionVo.getDateAjoutMin(),pieceJointeConventionVo.getDateAjoutMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",pieceJointeConventionVo.getDateArchivageMin(),pieceJointeConventionVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",pieceJointeConventionVo.getDateCreationMin(),pieceJointeConventionVo.getDateCreationMax());
    if(pieceJointeConventionVo.getConventionVo()!=null){
        query += SearchUtil.addConstraint( "o", "convention.id","=",pieceJointeConventionVo.getConventionVo().getId());
            query += SearchUtil.addConstraint( "o", "convention.reference","LIKE",pieceJointeConventionVo.getConventionVo().getReference());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findConvention(PieceJointeConvention pieceJointeConvention){
        Convention loadedConvention =conventionService.findByIdOrReference(pieceJointeConvention.getConvention());

    if(loadedConvention==null ) {
    return;
    }
    pieceJointeConvention.setConvention(loadedConvention);
    }

@Override
@Transactional
public void delete(List<PieceJointeConvention> pieceJointeConventions){
if(ListUtil.isNotEmpty(pieceJointeConventions)){
pieceJointeConventions.forEach(e->pieceJointeConventionDao.delete(e));
}
}
@Override
public void update(List<PieceJointeConvention> pieceJointeConventions){
if(ListUtil.isNotEmpty(pieceJointeConventions)){
pieceJointeConventions.forEach(e->pieceJointeConventionDao.save(e));
}
}





    }

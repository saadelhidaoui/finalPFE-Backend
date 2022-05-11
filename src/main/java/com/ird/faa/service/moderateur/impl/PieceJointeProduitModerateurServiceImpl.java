package com.ird.faa.service.moderateur.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.PieceJointeProduit;
        import com.ird.faa.bean.Produit;
import com.ird.faa.dao.PieceJointeProduitDao;
import com.ird.faa.service.moderateur.facade.PieceJointeProduitModerateurService;
        import com.ird.faa.service.moderateur.facade.ProduitModerateurService;

import com.ird.faa.ws.rest.provided.vo.PieceJointeProduitVo;
import com.ird.faa.service.util.*;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class PieceJointeProduitModerateurServiceImpl extends AbstractServiceImpl<PieceJointeProduit> implements PieceJointeProduitModerateurService {

@Autowired
private PieceJointeProduitDao pieceJointeProduitDao;

    @Autowired
    private ArchivableService<PieceJointeProduit> archivableService;
        @Autowired
        private ProduitModerateurService produitService ;


@Autowired
private EntityManager entityManager;


@Override
public List<PieceJointeProduit> findAll(){
        return pieceJointeProduitDao.findAll();
}

        @Override
        public List<PieceJointeProduit> findByProduitReference(String reference){
        return pieceJointeProduitDao.findByProduitReference(reference);
        }

        @Override
        @Transactional
        public int deleteByProduitReference(String reference){
        return pieceJointeProduitDao.deleteByProduitReference(reference);
        }

        @Override
        public List<PieceJointeProduit> findByProduitId(Long id){
        return pieceJointeProduitDao.findByProduitId(id);
        }

        @Override
        @Transactional
        public int deleteByProduitId(Long id){
        return pieceJointeProduitDao.deleteByProduitId(id);
        }


@Override
public PieceJointeProduit findById(Long id){
if(id==null) return null;
return pieceJointeProduitDao.getOne(id);
}

@Override
public PieceJointeProduit findByIdWithAssociatedList(Long id){
    return findById(id);
}
    @Override
    public PieceJointeProduit archiver(PieceJointeProduit pieceJointeProduit) {
    if (pieceJointeProduit.getArchive() == null) {
    pieceJointeProduit.setArchive(false);
    }
    pieceJointeProduit.setArchive(true);
    pieceJointeProduit.setDateArchivage(new Date());
    pieceJointeProduitDao.save(pieceJointeProduit);
    return pieceJointeProduit;

    }

    @Override
    public PieceJointeProduit desarchiver(PieceJointeProduit pieceJointeProduit) {
    if (pieceJointeProduit.getArchive() == null) {
    pieceJointeProduit.setArchive(false);
    }
    pieceJointeProduit.setArchive(false);
    pieceJointeProduit.setDateArchivage(null);
    pieceJointeProduitDao.save(pieceJointeProduit);
    return pieceJointeProduit;
    }



@Transactional
public int deleteById(Long id){
int res=0;
if(pieceJointeProduitDao.findById(id).isPresent())  {
pieceJointeProduitDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public PieceJointeProduit update(PieceJointeProduit pieceJointeProduit){
PieceJointeProduit foundedPieceJointeProduit = findById(pieceJointeProduit.getId());
if(foundedPieceJointeProduit==null) return null;
else{
    archivableService.prepare(pieceJointeProduit);
return  pieceJointeProduitDao.save(pieceJointeProduit);
}
}
    private void prepareSave(PieceJointeProduit pieceJointeProduit){
        pieceJointeProduit.setDateCreation(new Date());
                    if(pieceJointeProduit.getArchive() == null)
                pieceJointeProduit.setArchive(false);
                    if(pieceJointeProduit.getAdmin() == null)
                pieceJointeProduit.setAdmin(false);
                    if(pieceJointeProduit.getVisible() == null)
                pieceJointeProduit.setVisible(false);



    }

@Override
public PieceJointeProduit save (PieceJointeProduit pieceJointeProduit){
    prepareSave(pieceJointeProduit);



    findProduit(pieceJointeProduit);

    return pieceJointeProduitDao.save(pieceJointeProduit);


}

@Override
public List<PieceJointeProduit> save(List<PieceJointeProduit> pieceJointeProduits){
List<PieceJointeProduit> list = new ArrayList<>();
for(PieceJointeProduit pieceJointeProduit: pieceJointeProduits){
list.add(save(pieceJointeProduit));
}
return list;
}



@Override
@Transactional
public int delete(PieceJointeProduit pieceJointeProduit){
    if(pieceJointeProduit.getId()==null) return -1;
    PieceJointeProduit foundedPieceJointeProduit = findById(pieceJointeProduit.getId());
    if(foundedPieceJointeProduit==null) return -1;
pieceJointeProduitDao.delete(foundedPieceJointeProduit);
return 1;
}


public List<PieceJointeProduit> findByCriteria(PieceJointeProduitVo pieceJointeProduitVo){

String query = "SELECT o FROM PieceJointeProduit o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",pieceJointeProduitVo.getId());
            query += SearchUtil.addConstraint( "o", "path","LIKE",pieceJointeProduitVo.getPath());
        query += SearchUtil.addConstraintDate( "o", "dateAjout","=",pieceJointeProduitVo.getDateAjout());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",pieceJointeProduitVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "archive","=",pieceJointeProduitVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",pieceJointeProduitVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",pieceJointeProduitVo.getDateCreation());
            query += SearchUtil.addConstraint( "o", "admin","=",pieceJointeProduitVo.getAdmin());
            query += SearchUtil.addConstraint( "o", "visible","=",pieceJointeProduitVo.getVisible());
            query += SearchUtil.addConstraint( "o", "username","LIKE",pieceJointeProduitVo.getUsername());
            query += SearchUtil.addConstraintMinMaxDate("o","dateAjout",pieceJointeProduitVo.getDateAjoutMin(),pieceJointeProduitVo.getDateAjoutMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",pieceJointeProduitVo.getDateArchivageMin(),pieceJointeProduitVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",pieceJointeProduitVo.getDateCreationMin(),pieceJointeProduitVo.getDateCreationMax());
    if(pieceJointeProduitVo.getProduitVo()!=null){
        query += SearchUtil.addConstraint( "o", "produit.id","=",pieceJointeProduitVo.getProduitVo().getId());
            query += SearchUtil.addConstraint( "o", "produit.reference","LIKE",pieceJointeProduitVo.getProduitVo().getReference());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findProduit(PieceJointeProduit pieceJointeProduit){
        Produit loadedProduit =produitService.findByIdOrReference(pieceJointeProduit.getProduit());

    if(loadedProduit==null ) {
    return;
    }
    pieceJointeProduit.setProduit(loadedProduit);
    }

@Override
@Transactional
public void delete(List<PieceJointeProduit> pieceJointeProduits){
if(ListUtil.isNotEmpty(pieceJointeProduits)){
pieceJointeProduits.forEach(e->pieceJointeProduitDao.delete(e));
}
}
@Override
public void update(List<PieceJointeProduit> pieceJointeProduits){
if(ListUtil.isNotEmpty(pieceJointeProduits)){
pieceJointeProduits.forEach(e->pieceJointeProduitDao.save(e));
}
}





    }

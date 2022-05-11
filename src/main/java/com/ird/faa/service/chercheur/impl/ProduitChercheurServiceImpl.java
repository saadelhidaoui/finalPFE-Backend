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
import com.ird.faa.bean.Produit;
        import com.ird.faa.bean.PieceJointeProduit;
import com.ird.faa.dao.ProduitDao;
import com.ird.faa.service.chercheur.facade.ProduitChercheurService;
        import com.ird.faa.service.chercheur.facade.PieceJointeProduitChercheurService;

import com.ird.faa.ws.rest.provided.vo.ProduitVo;
import com.ird.faa.service.util.*;
        import com.ird.faa.bean.PieceJointeProduit;
        import com.ird.faa.service.chercheur.facade.PieceJointeProduitChercheurService;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class ProduitChercheurServiceImpl extends AbstractServiceImpl<Produit> implements ProduitChercheurService {

@Autowired
private ProduitDao produitDao;

    @Autowired
    private ArchivableService<Produit> archivableService;
        @Autowired
        private PieceJointeProduitChercheurService pieceJointeProduitService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Produit> findAll(){
    List<Produit> resultat= new ArrayList();
    resultat.addAll(findAllNonArchive());
    resultat.addAll(findAllByOwner());
    return resultat;
}
    @Override
    public Produit findByReference(String reference){
    if( reference==null) return null;
    return produitDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return produitDao.deleteByReference(reference);
    }
    @Override
    public Produit findByIdOrReference(Produit produit){
    Produit resultat=null;
    if(produit != null){
    if(StringUtil.isNotEmpty(produit.getId())){
    resultat= produitDao.getOne(produit.getId());
    }else if(StringUtil.isNotEmpty(produit.getReference())) {
    resultat= produitDao.findByReference(produit.getReference());
    }
    }
    return resultat;
    }

@Override
public Produit findById(Long id){
if(id==null) return null;
return produitDao.getOne(id);
}

@Override
public Produit findByIdWithAssociatedList(Long id){
    Produit produit  = findById(id);
    findAssociatedLists(produit);
    return produit;
}
    private void findAssociatedLists(Produit produit){
    if(produit!=null && produit.getId() != null) {
            List<PieceJointeProduit> pieceJointeProduits = pieceJointeProduitService.findByProduitId(produit.getId());
            produit.setPieceJointeProduits(pieceJointeProduits);
    }
    }
    private void deleteAssociatedLists(Long id){
    if(id != null ) {
            pieceJointeProduitService.deleteByProduitId(id);
    }
    }

    private void updateAssociatedLists(Produit produit){
    if(produit !=null && produit.getId() != null){
            List
            <List<PieceJointeProduit>> resultPieceJointeProduits= pieceJointeProduitService.getToBeSavedAndToBeDeleted(pieceJointeProduitService.findByProduitId(produit.getId()),produit.getPieceJointeProduits());
            pieceJointeProduitService.delete(resultPieceJointeProduits.get(1));
            associatePieceJointeProduit(produit,resultPieceJointeProduits.get(0));
            pieceJointeProduitService.update(resultPieceJointeProduits.get(0));

    }
    }

@Transactional
public int deleteById(Long id){
int res=0;
if(produitDao.findById(id).isPresent())  {
    deleteAssociatedLists(id);
produitDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Produit update(Produit produit){
Produit foundedProduit = findById(produit.getId());
if(foundedProduit==null) return null;
else{
    archivableService.prepare(produit);
    updateAssociatedLists(produit);
return  produitDao.save(produit);
}
}
    private void prepareSave(Produit produit){
        produit.setDateCreation(new Date());
                    if(produit.getArchive() == null)
                produit.setArchive(false);
                    if(produit.getAdmin() == null)
                produit.setAdmin(false);
                    if(produit.getVisible() == null)
                produit.setVisible(false);

            produit.setAdmin(false);
            produit.setVisible(false);
            User currentUser = SecurityUtil.getCurrentUser();
            if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
            produit.setUsername(currentUser.getUsername());
            }


    }

@Override
public Produit save (Produit produit){
    prepareSave(produit);

    Produit result =null;
    Produit foundedProduit = findByReference(produit.getReference());
    if(foundedProduit == null){



    Produit savedProduit = produitDao.save(produit);

        savePieceJointeProduits(savedProduit,produit.getPieceJointeProduits());
    result = savedProduit;
    }

    return result;
}

@Override
public List<Produit> save(List<Produit> produits){
List<Produit> list = new ArrayList<>();
for(Produit produit: produits){
list.add(save(produit));
}
return list;
}

        private List<PieceJointeProduit> preparePieceJointeProduits(Produit produit,List<PieceJointeProduit> pieceJointeProduits){
        for(PieceJointeProduit pieceJointeProduit:pieceJointeProduits ){
        pieceJointeProduit.setProduit(produit);
        }
        return pieceJointeProduits;
        }


@Override
@Transactional
public int delete(Produit produit){
    if(produit.getReference()==null) return -1;

    Produit foundedProduit = findByReference(produit.getReference());
    if(foundedProduit==null) return -1;
produitDao.delete(foundedProduit);
return 1;
}


public List<Produit> findByCriteria(ProduitVo produitVo){

String query = "SELECT o FROM Produit o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",produitVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",produitVo.getReference());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",produitVo.getLibelle());
        query += SearchUtil.addConstraintDate( "o", "dateArrivee","=",produitVo.getDateArrivee());
            query += SearchUtil.addConstraint( "o", "quantite","=",produitVo.getQuantite());
            query += SearchUtil.addConstraint( "o", "archive","=",produitVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",produitVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",produitVo.getDateCreation());
            query += SearchUtil.addConstraint( "o", "admin","=",produitVo.getAdmin());
            query += SearchUtil.addConstraint( "o", "visible","=",produitVo.getVisible());
            query += SearchUtil.addConstraint( "o", "username","LIKE",produitVo.getUsername());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArrivee",produitVo.getDateArriveeMin(),produitVo.getDateArriveeMax());
            query += SearchUtil.addConstraintMinMax("o","quantite",produitVo.getQuantiteMin(),produitVo.getQuantiteMax());
            query += SearchUtil.addConstraintMinMax("o","pieceJointeProduits",produitVo.getPieceJointeProduitsMin(),produitVo.getPieceJointeProduitsMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",produitVo.getDateArchivageMin(),produitVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",produitVo.getDateCreationMin(),produitVo.getDateCreationMax());
return entityManager.createQuery(query).getResultList();
}
        private  void savePieceJointeProduits(Produit produit,List<PieceJointeProduit> pieceJointeProduits){

        if (ListUtil.isNotEmpty(produit.getPieceJointeProduits())) {
        List<PieceJointeProduit> savedPieceJointeProduits = new ArrayList<>();
        pieceJointeProduits.forEach(element -> {
        element.setProduit(produit);
         pieceJointeProduitService.save(element);
        });
        produit.setPieceJointeProduits(savedPieceJointeProduits);
        }
        }


@Override
@Transactional
public void delete(List<Produit> produits){
if(ListUtil.isNotEmpty(produits)){
produits.forEach(e->produitDao.delete(e));
}
}
@Override
public void update(List<Produit> produits){
if(ListUtil.isNotEmpty(produits)){
produits.forEach(e->produitDao.save(e));
}
}

        private void associatePieceJointeProduit(Produit produit, List<PieceJointeProduit> pieceJointeProduit) {
        if (ListUtil.isNotEmpty(pieceJointeProduit)) {
        pieceJointeProduit.forEach(e -> e.setProduit(produit));
        }
        }



        public List<Produit> findAllNonArchive(){
        String query = "SELECT o FROM Produit o  WHERE o.archive != true AND o.visible = true";
        return entityManager.createQuery(query).getResultList();
        }

        public List<Produit> findAllByOwner(){
        List<Produit> result= new ArrayList();
        User currentUser = SecurityUtil.getCurrentUser();
        if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
        String query = "SELECT o FROM Produit o  WHERE o.archive != true AND o.visible = false AND o.username = '"+ currentUser.getUsername()+"'";
        result = entityManager.createQuery(query).getResultList();
        }
        return result;
        }



    }

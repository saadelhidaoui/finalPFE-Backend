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
import com.ird.faa.bean.Projet;
        import com.ird.faa.bean.EtatProjet;
        import com.ird.faa.bean.PieceJointeProjet;
import com.ird.faa.dao.ProjetDao;
import com.ird.faa.service.chercheur.facade.ProjetChercheurService;
        import com.ird.faa.service.chercheur.facade.PieceJointeProjetChercheurService;
        import com.ird.faa.service.chercheur.facade.EtatProjetChercheurService;

import com.ird.faa.ws.rest.provided.vo.ProjetVo;
import com.ird.faa.service.util.*;
        import com.ird.faa.bean.PieceJointeProjet;
        import com.ird.faa.service.chercheur.facade.PieceJointeProjetChercheurService;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class ProjetChercheurServiceImpl extends AbstractServiceImpl<Projet> implements ProjetChercheurService {

@Autowired
private ProjetDao projetDao;

    @Autowired
    private ArchivableService<Projet> archivableService;
        @Autowired
        private PieceJointeProjetChercheurService pieceJointeProjetService ;
        @Autowired
        private EtatProjetChercheurService etatProjetService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Projet> findAll(){
    List<Projet> resultat= new ArrayList();
    resultat.addAll(findAllNonArchive());
    resultat.addAll(findAllByOwner());
    return resultat;
}

        @Override
        public List<Projet> findByEtatProjetCode(String code){
        return projetDao.findByEtatProjetCode(code);
        }

        @Override
        @Transactional
        public int deleteByEtatProjetCode(String code){
        return projetDao.deleteByEtatProjetCode(code);
        }

        @Override
        public List<Projet> findByEtatProjetId(Long id){
        return projetDao.findByEtatProjetId(id);
        }

        @Override
        @Transactional
        public int deleteByEtatProjetId(Long id){
        return projetDao.deleteByEtatProjetId(id);
        }

    @Override
    public Projet findByReference(String reference){
    if( reference==null) return null;
    return projetDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return projetDao.deleteByReference(reference);
    }
    @Override
    public Projet findByIdOrReference(Projet projet){
    Projet resultat=null;
    if(projet != null){
    if(StringUtil.isNotEmpty(projet.getId())){
    resultat= projetDao.getOne(projet.getId());
    }else if(StringUtil.isNotEmpty(projet.getReference())) {
    resultat= projetDao.findByReference(projet.getReference());
    }
    }
    return resultat;
    }

@Override
public Projet findById(Long id){
if(id==null) return null;
return projetDao.getOne(id);
}

@Override
public Projet findByIdWithAssociatedList(Long id){
    Projet projet  = findById(id);
    findAssociatedLists(projet);
    return projet;
}
    private void findAssociatedLists(Projet projet){
    if(projet!=null && projet.getId() != null) {
            List<PieceJointeProjet> pieceJointeProjets = pieceJointeProjetService.findByProjetId(projet.getId());
            projet.setPieceJointeProjets(pieceJointeProjets);
    }
    }
    private void deleteAssociatedLists(Long id){
    if(id != null ) {
            pieceJointeProjetService.deleteByProjetId(id);
    }
    }

    private void updateAssociatedLists(Projet projet){
    if(projet !=null && projet.getId() != null){
            List
            <List<PieceJointeProjet>> resultPieceJointeProjets= pieceJointeProjetService.getToBeSavedAndToBeDeleted(pieceJointeProjetService.findByProjetId(projet.getId()),projet.getPieceJointeProjets());
            pieceJointeProjetService.delete(resultPieceJointeProjets.get(1));
            associatePieceJointeProjet(projet,resultPieceJointeProjets.get(0));
            pieceJointeProjetService.update(resultPieceJointeProjets.get(0));

    }
    }

@Transactional
public int deleteById(Long id){
int res=0;
if(projetDao.findById(id).isPresent())  {
    deleteAssociatedLists(id);
projetDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Projet update(Projet projet){
Projet foundedProjet = findById(projet.getId());
if(foundedProjet==null) return null;
else{
    archivableService.prepare(projet);
    updateAssociatedLists(projet);
return  projetDao.save(projet);
}
}
    private void prepareSave(Projet projet){
        projet.setDateCreation(new Date());
                    if(projet.getArchive() == null)
                projet.setArchive(false);
                    if(projet.getAdmin() == null)
                projet.setAdmin(false);
                    if(projet.getVisible() == null)
                projet.setVisible(false);

            projet.setAdmin(false);
            projet.setVisible(false);
            User currentUser = SecurityUtil.getCurrentUser();
            if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
            projet.setUsername(currentUser.getUsername());
            }


    }

@Override
public Projet save (Projet projet){
    prepareSave(projet);

    Projet result =null;
    Projet foundedProjet = findByReference(projet.getReference());
    if(foundedProjet == null){


    findEtatProjet(projet);

    Projet savedProjet = projetDao.save(projet);

        savePieceJointeProjets(savedProjet,projet.getPieceJointeProjets());
    result = savedProjet;
    }

    return result;
}

@Override
public List<Projet> save(List<Projet> projets){
List<Projet> list = new ArrayList<>();
for(Projet projet: projets){
list.add(save(projet));
}
return list;
}

        private List<PieceJointeProjet> preparePieceJointeProjets(Projet projet,List<PieceJointeProjet> pieceJointeProjets){
        for(PieceJointeProjet pieceJointeProjet:pieceJointeProjets ){
        pieceJointeProjet.setProjet(projet);
        }
        return pieceJointeProjets;
        }


@Override
@Transactional
public int delete(Projet projet){
    if(projet.getReference()==null) return -1;

    Projet foundedProjet = findByReference(projet.getReference());
    if(foundedProjet==null) return -1;
projetDao.delete(foundedProjet);
return 1;
}


public List<Projet> findByCriteria(ProjetVo projetVo){

String query = "SELECT o FROM Projet o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",projetVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",projetVo.getReference());
            query += SearchUtil.addConstraint( "o", "description","LIKE",projetVo.getDescription());
        query += SearchUtil.addConstraintDate( "o", "dateDebut","=",projetVo.getDateDebut());
            query += SearchUtil.addConstraint( "o", "pv","LIKE",projetVo.getPv());
            query += SearchUtil.addConstraint( "o", "archive","=",projetVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",projetVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",projetVo.getDateCreation());
            query += SearchUtil.addConstraint( "o", "admin","=",projetVo.getAdmin());
            query += SearchUtil.addConstraint( "o", "visible","=",projetVo.getVisible());
            query += SearchUtil.addConstraint( "o", "username","LIKE",projetVo.getUsername());
            query += SearchUtil.addConstraintMinMaxDate("o","dateDebut",projetVo.getDateDebutMin(),projetVo.getDateDebutMax());
            query += SearchUtil.addConstraintMinMax("o","pieceJointeProjets",projetVo.getPieceJointeProjetsMin(),projetVo.getPieceJointeProjetsMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",projetVo.getDateArchivageMin(),projetVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",projetVo.getDateCreationMin(),projetVo.getDateCreationMax());
    if(projetVo.getEtatProjetVo()!=null){
        query += SearchUtil.addConstraint( "o", "etatProjet.id","=",projetVo.getEtatProjetVo().getId());
            query += SearchUtil.addConstraint( "o", "etatProjet.code","LIKE",projetVo.getEtatProjetVo().getCode());
    }

return entityManager.createQuery(query).getResultList();
}
        private  void savePieceJointeProjets(Projet projet,List<PieceJointeProjet> pieceJointeProjets){

        if (ListUtil.isNotEmpty(projet.getPieceJointeProjets())) {
        List<PieceJointeProjet> savedPieceJointeProjets = new ArrayList<>();
        pieceJointeProjets.forEach(element -> {
        element.setProjet(projet);
         pieceJointeProjetService.save(element);
        });
        projet.setPieceJointeProjets(savedPieceJointeProjets);
        }
        }

    private void findEtatProjet(Projet projet){
        EtatProjet loadedEtatProjet =etatProjetService.findByIdOrCode(projet.getEtatProjet());

    if(loadedEtatProjet==null ) {
    return;
    }
    projet.setEtatProjet(loadedEtatProjet);
    }

@Override
@Transactional
public void delete(List<Projet> projets){
if(ListUtil.isNotEmpty(projets)){
projets.forEach(e->projetDao.delete(e));
}
}
@Override
public void update(List<Projet> projets){
if(ListUtil.isNotEmpty(projets)){
projets.forEach(e->projetDao.save(e));
}
}

        private void associatePieceJointeProjet(Projet projet, List<PieceJointeProjet> pieceJointeProjet) {
        if (ListUtil.isNotEmpty(pieceJointeProjet)) {
        pieceJointeProjet.forEach(e -> e.setProjet(projet));
        }
        }



        public List<Projet> findAllNonArchive(){
        String query = "SELECT o FROM Projet o  WHERE o.archive != true AND o.visible = true";
        return entityManager.createQuery(query).getResultList();
        }

        public List<Projet> findAllByOwner(){
        List<Projet> result= new ArrayList();
        User currentUser = SecurityUtil.getCurrentUser();
        if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
        String query = "SELECT o FROM Projet o  WHERE o.archive != true AND o.visible = false AND o.username = '"+ currentUser.getUsername()+"'";
        result = entityManager.createQuery(query).getResultList();
        }
        return result;
        }



    }

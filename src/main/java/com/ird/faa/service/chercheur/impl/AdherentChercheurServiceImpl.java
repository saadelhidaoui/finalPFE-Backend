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
import com.ird.faa.bean.Adherent;
        import com.ird.faa.bean.Ville;
        import com.ird.faa.bean.Qualite;
        import com.ird.faa.bean.EtatCarte;
        import com.ird.faa.bean.Statut;
        import com.ird.faa.bean.Fonction;
        import com.ird.faa.bean.Conjoint;
        import com.ird.faa.bean.Enfant;
        import com.ird.faa.bean.PieceJointeAdherent;
import com.ird.faa.dao.AdherentDao;
import com.ird.faa.service.chercheur.facade.AdherentChercheurService;
        import com.ird.faa.service.chercheur.facade.StatutChercheurService;
        import com.ird.faa.service.chercheur.facade.QualiteChercheurService;
        import com.ird.faa.service.chercheur.facade.EtatCarteChercheurService;
        import com.ird.faa.service.chercheur.facade.FonctionChercheurService;
        import com.ird.faa.service.chercheur.facade.EnfantChercheurService;
        import com.ird.faa.service.chercheur.facade.ConjointChercheurService;
        import com.ird.faa.service.chercheur.facade.VilleChercheurService;
        import com.ird.faa.service.chercheur.facade.PieceJointeAdherentChercheurService;

import com.ird.faa.ws.rest.provided.vo.AdherentVo;
import com.ird.faa.service.util.*;
        import com.ird.faa.bean.Conjoint;
        import com.ird.faa.service.chercheur.facade.ConjointChercheurService;
        import com.ird.faa.bean.Enfant;
        import com.ird.faa.service.chercheur.facade.EnfantChercheurService;
        import com.ird.faa.bean.PieceJointeAdherent;
        import com.ird.faa.service.chercheur.facade.PieceJointeAdherentChercheurService;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class AdherentChercheurServiceImpl extends AbstractServiceImpl<Adherent> implements AdherentChercheurService {

@Autowired
private AdherentDao adherentDao;

    @Autowired
    private ArchivableService<Adherent> archivableService;
        @Autowired
        private StatutChercheurService statutService ;
        @Autowired
        private QualiteChercheurService qualiteService ;
        @Autowired
        private EtatCarteChercheurService etatCarteService ;
        @Autowired
        private FonctionChercheurService fonctionService ;
        @Autowired
        private EnfantChercheurService enfantService ;
        @Autowired
        private ConjointChercheurService conjointService ;
        @Autowired
        private VilleChercheurService villeService ;
        @Autowired
        private PieceJointeAdherentChercheurService pieceJointeAdherentService ;


@Autowired
private EntityManager entityManager;

    @Override
    public Adherent findByUsername(String username){
    return adherentDao.findByUsername(username);
    }

@Override
public List<Adherent> findAll(){
    List<Adherent> resultat= new ArrayList();
    resultat.addAll(findAllNonArchive());
    resultat.addAll(findAllByOwner());
    return resultat;
}
        @Override
        public List<Adherent> findByVilleId(Long id){
        return adherentDao.findByVilleId(id);
        }

        @Override
        @Transactional
        public int deleteByVilleId(Long id){
        return adherentDao.deleteByVilleId(id);
        }


        @Override
        public List<Adherent> findByQualiteReference(String reference){
        return adherentDao.findByQualiteReference(reference);
        }

        @Override
        @Transactional
        public int deleteByQualiteReference(String reference){
        return adherentDao.deleteByQualiteReference(reference);
        }

        @Override
        public List<Adherent> findByQualiteId(Long id){
        return adherentDao.findByQualiteId(id);
        }

        @Override
        @Transactional
        public int deleteByQualiteId(Long id){
        return adherentDao.deleteByQualiteId(id);
        }


        @Override
        public List<Adherent> findByEtatCarteReference(String reference){
        return adherentDao.findByEtatCarteReference(reference);
        }

        @Override
        @Transactional
        public int deleteByEtatCarteReference(String reference){
        return adherentDao.deleteByEtatCarteReference(reference);
        }

        @Override
        public List<Adherent> findByEtatCarteId(Long id){
        return adherentDao.findByEtatCarteId(id);
        }

        @Override
        @Transactional
        public int deleteByEtatCarteId(Long id){
        return adherentDao.deleteByEtatCarteId(id);
        }


        @Override
        public List<Adherent> findByStatutReference(String reference){
        return adherentDao.findByStatutReference(reference);
        }

        @Override
        @Transactional
        public int deleteByStatutReference(String reference){
        return adherentDao.deleteByStatutReference(reference);
        }

        @Override
        public List<Adherent> findByStatutId(Long id){
        return adherentDao.findByStatutId(id);
        }

        @Override
        @Transactional
        public int deleteByStatutId(Long id){
        return adherentDao.deleteByStatutId(id);
        }


        @Override
        public List<Adherent> findByFonctionReference(String reference){
        return adherentDao.findByFonctionReference(reference);
        }

        @Override
        @Transactional
        public int deleteByFonctionReference(String reference){
        return adherentDao.deleteByFonctionReference(reference);
        }

        @Override
        public List<Adherent> findByFonctionId(Long id){
        return adherentDao.findByFonctionId(id);
        }

        @Override
        @Transactional
        public int deleteByFonctionId(Long id){
        return adherentDao.deleteByFonctionId(id);
        }

    @Override
    public Adherent findByNumeroMatricule(String numeroMatricule){
    if( numeroMatricule==null) return null;
    return adherentDao.findByNumeroMatricule(numeroMatricule);
    }

    @Override
    @Transactional
    public int deleteByNumeroMatricule(String  numeroMatricule) {
    return adherentDao.deleteByNumeroMatricule(numeroMatricule);
    }
    @Override
    public Adherent findByIdOrNumeroMatricule(Adherent adherent){
    Adherent resultat=null;
    if(adherent != null){
    if(StringUtil.isNotEmpty(adherent.getId())){
    resultat= adherentDao.getOne(adherent.getId());
    }else if(StringUtil.isNotEmpty(adherent.getNumeroMatricule())) {
    resultat= adherentDao.findByNumeroMatricule(adherent.getNumeroMatricule());
    }else if(StringUtil.isNotEmpty(adherent.getUsername())) {
    resultat = adherentDao.findByUsername(adherent.getUsername());
    }
    }
    return resultat;
    }

@Override
public Adherent findById(Long id){
if(id==null) return null;
return adherentDao.getOne(id);
}

@Override
public Adherent findByIdWithAssociatedList(Long id){
    Adherent adherent  = findById(id);
    findAssociatedLists(adherent);
    return adherent;
}
    private void findAssociatedLists(Adherent adherent){
    if(adherent!=null && adherent.getId() != null) {
            List<Conjoint> conjoints = conjointService.findByAdherentId(adherent.getId());
            adherent.setConjoints(conjoints);
            List<Enfant> enfants = enfantService.findByAdherentId(adherent.getId());
            adherent.setEnfants(enfants);
            List<PieceJointeAdherent> pieceJointeAdherents = pieceJointeAdherentService.findByAdherentId(adherent.getId());
            adherent.setPieceJointeAdherents(pieceJointeAdherents);
    }
    }
    private void deleteAssociatedLists(Long id){
    if(id != null ) {
            conjointService.deleteByAdherentId(id);
            enfantService.deleteByAdherentId(id);
            pieceJointeAdherentService.deleteByAdherentId(id);
    }
    }

    private void updateAssociatedLists(Adherent adherent){
    if(adherent !=null && adherent.getId() != null){
            List
            <List<Conjoint>> resultConjoints= conjointService.getToBeSavedAndToBeDeleted(conjointService.findByAdherentId(adherent.getId()),adherent.getConjoints());
            conjointService.delete(resultConjoints.get(1));
            associateConjoint(adherent,resultConjoints.get(0));
            conjointService.update(resultConjoints.get(0));

            List
            <List<Enfant>> resultEnfants= enfantService.getToBeSavedAndToBeDeleted(enfantService.findByAdherentId(adherent.getId()),adherent.getEnfants());
            enfantService.delete(resultEnfants.get(1));
            associateEnfant(adherent,resultEnfants.get(0));
            enfantService.update(resultEnfants.get(0));

            List
            <List<PieceJointeAdherent>> resultPieceJointeAdherents= pieceJointeAdherentService.getToBeSavedAndToBeDeleted(pieceJointeAdherentService.findByAdherentId(adherent.getId()),adherent.getPieceJointeAdherents());
            pieceJointeAdherentService.delete(resultPieceJointeAdherents.get(1));
            associatePieceJointeAdherent(adherent,resultPieceJointeAdherents.get(0));
            pieceJointeAdherentService.update(resultPieceJointeAdherents.get(0));

    }
    }

@Transactional
public int deleteById(Long id){
int res=0;
if(adherentDao.findById(id).isPresent())  {
    deleteAssociatedLists(id);
adherentDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Adherent update(Adherent adherent){
Adherent foundedAdherent = findById(adherent.getId());
if(foundedAdherent==null) return null;
else{
    archivableService.prepare(adherent);
    updateAssociatedLists(adherent);
return  adherentDao.save(adherent);
}
}
    private void prepareSave(Adherent adherent){
        adherent.setDateCreation(new Date());
                adherent.setCredentialsNonExpired(false);
                adherent.setEnabled(false);
                adherent.setAccountNonExpired(false);
                adherent.setAccountNonLocked(false);
                adherent.setPasswordChanged(false);
                    if(adherent.getArchive() == null)
                adherent.setArchive(false);
                    if(adherent.getAdmin() == null)
                adherent.setAdmin(false);
                    if(adherent.getVisible() == null)
                adherent.setVisible(false);

            adherent.setAdmin(false);
            adherent.setVisible(false);
            User currentUser = SecurityUtil.getCurrentUser();
            if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
            adherent.setUsername(currentUser.getUsername());
            }


    }

@Override
public Adherent save (Adherent adherent){
    prepareSave(adherent);

    Adherent result =null;
    Adherent foundedAdherent = findByNumeroMatricule(adherent.getNumeroMatricule());
    if(foundedAdherent == null){


    findVille(adherent);
    findQualite(adherent);
    findEtatCarte(adherent);
    findStatut(adherent);
    findFonction(adherent);

    Adherent savedAdherent = adherentDao.save(adherent);

        saveConjoints(savedAdherent,adherent.getConjoints());
        saveEnfants(savedAdherent,adherent.getEnfants());
        savePieceJointeAdherents(savedAdherent,adherent.getPieceJointeAdherents());
    result = savedAdherent;
    }

    return result;
}

@Override
public List<Adherent> save(List<Adherent> adherents){
List<Adherent> list = new ArrayList<>();
for(Adherent adherent: adherents){
list.add(save(adherent));
}
return list;
}

        private List<Conjoint> prepareConjoints(Adherent adherent,List<Conjoint> conjoints){
        for(Conjoint conjoint:conjoints ){
        conjoint.setAdherent(adherent);
        }
        return conjoints;
        }
        private List<Enfant> prepareEnfants(Adherent adherent,List<Enfant> enfants){
        for(Enfant enfant:enfants ){
        enfant.setAdherent(adherent);
        }
        return enfants;
        }
        private List<PieceJointeAdherent> preparePieceJointeAdherents(Adherent adherent,List<PieceJointeAdherent> pieceJointeAdherents){
        for(PieceJointeAdherent pieceJointeAdherent:pieceJointeAdherents ){
        pieceJointeAdherent.setAdherent(adherent);
        }
        return pieceJointeAdherents;
        }


@Override
@Transactional
public int delete(Adherent adherent){
    if(adherent.getNumeroMatricule()==null) return -1;

    Adherent foundedAdherent = findByNumeroMatricule(adherent.getNumeroMatricule());
    if(foundedAdherent==null) return -1;
adherentDao.delete(foundedAdherent);
return 1;
}


public List<Adherent> findByCriteria(AdherentVo adherentVo){

String query = "SELECT o FROM Adherent o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",adherentVo.getId());
            query += SearchUtil.addConstraint( "o", "numAdhesion","LIKE",adherentVo.getNumAdhesion());
            query += SearchUtil.addConstraint( "o", "cin","LIKE",adherentVo.getCin());
            query += SearchUtil.addConstraint( "o", "nom","LIKE",adherentVo.getNom());
            query += SearchUtil.addConstraint( "o", "prenom","LIKE",adherentVo.getPrenom());
            query += SearchUtil.addConstraint( "o", "origine","LIKE",adherentVo.getOrigine());
            query += SearchUtil.addConstraint( "o", "telephone","LIKE",adherentVo.getTelephone());
            query += SearchUtil.addConstraint( "o", "adresse","LIKE",adherentVo.getAdresse());
            query += SearchUtil.addConstraint( "o", "ppr","LIKE",adherentVo.getPpr());
        query += SearchUtil.addConstraintDate( "o", "dateNaissance","=",adherentVo.getDateNaissance());
        query += SearchUtil.addConstraintDate( "o", "dateArrivee","=",adherentVo.getDateArrivee());
        query += SearchUtil.addConstraintDate( "o", "dateReception","=",adherentVo.getDateReception());
            query += SearchUtil.addConstraint( "o", "numeroMatricule","LIKE",adherentVo.getNumeroMatricule());
            query += SearchUtil.addConstraint( "o", "emailPrincipale","LIKE",adherentVo.getEmailPrincipale());
            query += SearchUtil.addConstraint( "o", "credentialsNonExpired","=",adherentVo.getCredentialsNonExpired());
            query += SearchUtil.addConstraint( "o", "enabled","=",adherentVo.getEnabled());
            query += SearchUtil.addConstraint( "o", "accountNonExpired","=",adherentVo.getAccountNonExpired());
            query += SearchUtil.addConstraint( "o", "accountNonLocked","=",adherentVo.getAccountNonLocked());
            query += SearchUtil.addConstraint( "o", "passwordChanged","=",adherentVo.getPasswordChanged());
        query += SearchUtil.addConstraintDate( "o", "createdAt","=",adherentVo.getCreatedAt());
        query += SearchUtil.addConstraintDate( "o", "updatedAt","=",adherentVo.getUpdatedAt());
            query += SearchUtil.addConstraint( "o", "username","LIKE",adherentVo.getUsername());
            query += SearchUtil.addConstraint( "o", "password","LIKE",adherentVo.getPassword());
            query += SearchUtil.addConstraint( "o", "role","LIKE",adherentVo.getRole());
            query += SearchUtil.addConstraint( "o", "archive","=",adherentVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",adherentVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",adherentVo.getDateCreation());
            query += SearchUtil.addConstraint( "o", "admin","=",adherentVo.getAdmin());
            query += SearchUtil.addConstraint( "o", "visible","=",adherentVo.getVisible());
            query += SearchUtil.addConstraint( "o", "username","LIKE",adherentVo.getUsername());
            query += SearchUtil.addConstraintMinMaxDate("o","dateNaissance",adherentVo.getDateNaissanceMin(),adherentVo.getDateNaissanceMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArrivee",adherentVo.getDateArriveeMin(),adherentVo.getDateArriveeMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateReception",adherentVo.getDateReceptionMin(),adherentVo.getDateReceptionMax());
            query += SearchUtil.addConstraintMinMax("o","conjoints",adherentVo.getConjointsMin(),adherentVo.getConjointsMax());
            query += SearchUtil.addConstraintMinMax("o","pieceJointeAdherents",adherentVo.getPieceJointeAdherentsMin(),adherentVo.getPieceJointeAdherentsMax());
            query += SearchUtil.addConstraintMinMaxDate("o","createdAt",adherentVo.getCreatedAtMin(),adherentVo.getCreatedAtMax());
            query += SearchUtil.addConstraintMinMaxDate("o","updatedAt",adherentVo.getUpdatedAtMin(),adherentVo.getUpdatedAtMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",adherentVo.getDateArchivageMin(),adherentVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",adherentVo.getDateCreationMin(),adherentVo.getDateCreationMax());
    if(adherentVo.getVilleVo()!=null){
        query += SearchUtil.addConstraint( "o", "ville.id","=",adherentVo.getVilleVo().getId());
    }

    if(adherentVo.getQualiteVo()!=null){
        query += SearchUtil.addConstraint( "o", "qualite.id","=",adherentVo.getQualiteVo().getId());
            query += SearchUtil.addConstraint( "o", "qualite.reference","LIKE",adherentVo.getQualiteVo().getReference());
    }

    if(adherentVo.getEtatCarteVo()!=null){
        query += SearchUtil.addConstraint( "o", "etatCarte.id","=",adherentVo.getEtatCarteVo().getId());
            query += SearchUtil.addConstraint( "o", "etatCarte.reference","LIKE",adherentVo.getEtatCarteVo().getReference());
    }

    if(adherentVo.getStatutVo()!=null){
        query += SearchUtil.addConstraint( "o", "statut.id","=",adherentVo.getStatutVo().getId());
            query += SearchUtil.addConstraint( "o", "statut.reference","LIKE",adherentVo.getStatutVo().getReference());
    }

    if(adherentVo.getFonctionVo()!=null){
        query += SearchUtil.addConstraint( "o", "fonction.id","=",adherentVo.getFonctionVo().getId());
            query += SearchUtil.addConstraint( "o", "fonction.reference","LIKE",adherentVo.getFonctionVo().getReference());
    }

    query+= " ORDER BY o.numAdhesion";
return entityManager.createQuery(query).getResultList();
}
        private  void saveConjoints(Adherent adherent,List<Conjoint> conjoints){

        if (ListUtil.isNotEmpty(adherent.getConjoints())) {
        List<Conjoint> savedConjoints = new ArrayList<>();
        conjoints.forEach(element -> {
        element.setAdherent(adherent);
         conjointService.save(element);
        });
        adherent.setConjoints(savedConjoints);
        }
        }
        private  void saveEnfants(Adherent adherent,List<Enfant> enfants){

        if (ListUtil.isNotEmpty(adherent.getEnfants())) {
        List<Enfant> savedEnfants = new ArrayList<>();
        enfants.forEach(element -> {
        element.setAdherent(adherent);
         enfantService.save(element);
        });
        adherent.setEnfants(savedEnfants);
        }
        }
        private  void savePieceJointeAdherents(Adherent adherent,List<PieceJointeAdherent> pieceJointeAdherents){

        if (ListUtil.isNotEmpty(adherent.getPieceJointeAdherents())) {
        List<PieceJointeAdherent> savedPieceJointeAdherents = new ArrayList<>();
        pieceJointeAdherents.forEach(element -> {
        element.setAdherent(adherent);
         pieceJointeAdherentService.save(element);
        });
        adherent.setPieceJointeAdherents(savedPieceJointeAdherents);
        }
        }

    private void findVille(Adherent adherent){
        Ville loadedVille = null;
        if(adherent.getVille() != null && adherent.getVille().getId() !=null)
        loadedVille =villeService.findById(adherent.getVille().getId());

    if(loadedVille==null ) {
    return;
    }
    adherent.setVille(loadedVille);
    }
    private void findQualite(Adherent adherent){
        Qualite loadedQualite =qualiteService.findByIdOrReference(adherent.getQualite());

    if(loadedQualite==null ) {
    return;
    }
    adherent.setQualite(loadedQualite);
    }
    private void findEtatCarte(Adherent adherent){
        EtatCarte loadedEtatCarte =etatCarteService.findByIdOrReference(adherent.getEtatCarte());

    if(loadedEtatCarte==null ) {
    return;
    }
    adherent.setEtatCarte(loadedEtatCarte);
    }
    private void findStatut(Adherent adherent){
        Statut loadedStatut =statutService.findByIdOrReference(adherent.getStatut());

    if(loadedStatut==null ) {
    return;
    }
    adherent.setStatut(loadedStatut);
    }
    private void findFonction(Adherent adherent){
        Fonction loadedFonction =fonctionService.findByIdOrReference(adherent.getFonction());

    if(loadedFonction==null ) {
    return;
    }
    adherent.setFonction(loadedFonction);
    }

@Override
@Transactional
public void delete(List<Adherent> adherents){
if(ListUtil.isNotEmpty(adherents)){
adherents.forEach(e->adherentDao.delete(e));
}
}
@Override
public void update(List<Adherent> adherents){
if(ListUtil.isNotEmpty(adherents)){
adherents.forEach(e->adherentDao.save(e));
}
}

        private void associateConjoint(Adherent adherent, List<Conjoint> conjoint) {
        if (ListUtil.isNotEmpty(conjoint)) {
        conjoint.forEach(e -> e.setAdherent(adherent));
        }
        }
        private void associateEnfant(Adherent adherent, List<Enfant> enfant) {
        if (ListUtil.isNotEmpty(enfant)) {
        enfant.forEach(e -> e.setAdherent(adherent));
        }
        }
        private void associatePieceJointeAdherent(Adherent adherent, List<PieceJointeAdherent> pieceJointeAdherent) {
        if (ListUtil.isNotEmpty(pieceJointeAdherent)) {
        pieceJointeAdherent.forEach(e -> e.setAdherent(adherent));
        }
        }



        public List<Adherent> findAllNonArchive(){
        String query = "SELECT o FROM Adherent o  WHERE o.archive != true AND o.visible = true";
            query+= " ORDER BY o.numAdhesion";
        return entityManager.createQuery(query).getResultList();
        }

        public List<Adherent> findAllByOwner(){
        List<Adherent> result= new ArrayList();
        User currentUser = SecurityUtil.getCurrentUser();
        if (currentUser != null && StringUtil.isNotEmpty(currentUser.getUsername())){
        String query = "SELECT o FROM Adherent o  WHERE o.archive != true AND o.visible = false AND o.username = '"+ currentUser.getUsername()+"'";
            query+= " ORDER BY o.numAdhesion";
        result = entityManager.createQuery(query).getResultList();
        }
        return result;
        }



    }

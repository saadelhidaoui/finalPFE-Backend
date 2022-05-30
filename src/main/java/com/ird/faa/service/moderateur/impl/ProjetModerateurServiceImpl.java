package com.ird.faa.service.moderateur.impl;

import com.ird.faa.bean.EtatProjet;
import com.ird.faa.bean.PieceJointeProjet;
import com.ird.faa.bean.Projet;
import com.ird.faa.dao.ProjetDao;
import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.moderateur.facade.EtatProjetModerateurService;
import com.ird.faa.service.moderateur.facade.PieceJointeProjetModerateurService;
import com.ird.faa.service.moderateur.facade.ProjetModerateurService;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.ProjetVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProjetModerateurServiceImpl extends AbstractServiceImpl<Projet> implements ProjetModerateurService {

    @Autowired
    private ProjetDao projetDao;

    @Autowired
    private ArchivableService<Projet> archivableService;
    @Autowired
    private PieceJointeProjetModerateurService pieceJointeProjetService;
    @Autowired
    private EtatProjetModerateurService etatProjetService;


    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Projet> findAll() {
        return projetDao.findAll();
    }

    @Override
    public List<Projet> findByEtatProjetCode(String code) {
        return projetDao.findByEtatProjetCode(code);
    }

    @Override
    @Transactional
    public int deleteByEtatProjetCode(String code) {
        return projetDao.deleteByEtatProjetCode(code);
    }

    @Override
    public List<Projet> findByEtatProjetId(Long id) {
        return projetDao.findByEtatProjetId(id);
    }

    @Override
    @Transactional
    public int deleteByEtatProjetId(Long id) {
        return projetDao.deleteByEtatProjetId(id);
    }

    @Override
    public Projet findByReference(String reference) {
        if (reference == null) return null;
        return projetDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String reference) {
        return projetDao.deleteByReference(reference);
    }

    @Override
    public Projet findByIdOrReference(Projet projet) {
        Projet resultat = null;
        if (projet != null) {
            if (StringUtil.isNotEmpty(projet.getId())) {
                resultat = projetDao.getOne(projet.getId());
            } else if (StringUtil.isNotEmpty(projet.getReference())) {
                resultat = projetDao.findByReference(projet.getReference());
            }
        }
        return resultat;
    }

    @Override
    public Projet findById(Long id) {
        if (id == null) return null;
        return projetDao.getOne(id);
    }

    @Override
    public Projet findByIdWithAssociatedList(Long id) {
        Projet projet = findById(id);
        findAssociatedLists(projet);
        return projet;
    }

    @Override
    public Projet archiver(Projet projet) {
        if (projet.getArchive() == null) {
            projet.setArchive(false);
        }
        projet.setArchive(true);
        projet.setDateArchivage(new Date());
        projetDao.save(projet);
        return projet;

    }

    @Override
    public Projet desarchiver(Projet projet) {
        if (projet.getArchive() == null) {
            projet.setArchive(false);
        }
        projet.setArchive(false);
        projet.setDateArchivage(null);
        projetDao.save(projet);
        return projet;
    }

    private void findAssociatedLists(Projet projet) {
        if (projet != null && projet.getId() != null) {
            List<PieceJointeProjet> pieceJointeProjets = pieceJointeProjetService.findByProjetId(projet.getId());
            projet.setPieceJointeProjets(pieceJointeProjets);
        }
    }

    private void deleteAssociatedLists(Long id) {
        if (id != null) {
            pieceJointeProjetService.deleteByProjetId(id);
        }
    }

    private void updateAssociatedLists(Projet projet) {
        if (projet != null && projet.getId() != null) {
            List
                    <List<PieceJointeProjet>> resultPieceJointeProjets = pieceJointeProjetService.getToBeSavedAndToBeDeleted(pieceJointeProjetService.findByProjetId(projet.getId()), projet.getPieceJointeProjets());
            pieceJointeProjetService.delete(resultPieceJointeProjets.get(1));
            associatePieceJointeProjet(projet, resultPieceJointeProjets.get(0));
            pieceJointeProjetService.update(resultPieceJointeProjets.get(0));

        }
    }

    @Transactional
    public int deleteById(Long id) {
        int res = 0;
        if (projetDao.findById(id).isPresent()) {
            deleteAssociatedLists(id);
            projetDao.deleteById(id);
            res = 1;
        }
        return res;
    }


    @Override
    public Projet update(Projet projet) {
        Projet foundedProjet = findById(projet.getId());
        if (foundedProjet == null) return null;
        else {
            archivableService.prepare(projet);
            updateAssociatedLists(projet);
            return projetDao.save(projet);
        }
    }

    private void prepareSave(Projet projet) {
        projet.setDateCreation(new Date());
        if (projet.getArchive() == null)
            projet.setArchive(false);
        if (projet.getAdmin() == null)
            projet.setAdmin(false);
        if (projet.getVisible() == null)
            projet.setVisible(false);


    }

    @Override
    public Projet save(Projet projet) {
        prepareSave(projet);

        Projet result = null;
        Projet foundedProjet = findByReference(projet.getReference());
        if (foundedProjet == null) {


            findEtatProjet(projet);

            Projet savedProjet = projetDao.save(projet);

            savePieceJointeProjets(savedProjet, projet.getPieceJointeProjets());
            result = savedProjet;
        }

        return result;
    }

    @Override
    public List<Projet> save(List<Projet> projets) {
        List<Projet> list = new ArrayList<>();
        for (Projet projet : projets) {
            list.add(save(projet));
        }
        return list;
    }

    private List<PieceJointeProjet> preparePieceJointeProjets(Projet projet, List<PieceJointeProjet> pieceJointeProjets) {
        for (PieceJointeProjet pieceJointeProjet : pieceJointeProjets) {
            pieceJointeProjet.setProjet(projet);
        }
        return pieceJointeProjets;
    }


    @Override
    @Transactional
    public int delete(Projet projet) {
        if (projet.getReference() == null) return -1;

        Projet foundedProjet = findByReference(projet.getReference());
        if (foundedProjet == null) return -1;
        projetDao.delete(foundedProjet);
        return 1;
    }


    public List<Projet> findByCriteria(ProjetVo projetVo) {

        String query = "SELECT o FROM Projet o where 1=1 ";

        query += SearchUtil.addConstraint("o", "id", "=", projetVo.getId());
        query += SearchUtil.addConstraint("o", "reference", "LIKE", projetVo.getReference());
        query += SearchUtil.addConstraint("o", "description", "LIKE", projetVo.getDescription());
        query += SearchUtil.addConstraintDate("o", "dateDebut", "=", projetVo.getDateDebut());
        query += SearchUtil.addConstraint("o", "pv", "LIKE", projetVo.getPv());
        query += SearchUtil.addConstraint("o", "archive", "=", projetVo.getArchive());
        query += SearchUtil.addConstraintDate("o", "dateArchivage", "=", projetVo.getDateArchivage());
        query += SearchUtil.addConstraintDate("o", "dateCreation", "=", projetVo.getDateCreation());
        query += SearchUtil.addConstraint("o", "admin", "=", projetVo.getAdmin());
        query += SearchUtil.addConstraint("o", "visible", "=", projetVo.getVisible());
        query += SearchUtil.addConstraint("o", "username", "LIKE", projetVo.getUsername());
        query += SearchUtil.addConstraintMinMaxDate("o", "dateDebut", projetVo.getDateDebutMin(), projetVo.getDateDebutMax());
        query += SearchUtil.addConstraintMinMax("o", "pieceJointeProjets", projetVo.getPieceJointeProjetsMin(), projetVo.getPieceJointeProjetsMax());
        query += SearchUtil.addConstraintMinMaxDate("o", "dateArchivage", projetVo.getDateArchivageMin(), projetVo.getDateArchivageMax());
        query += SearchUtil.addConstraintMinMaxDate("o", "dateCreation", projetVo.getDateCreationMin(), projetVo.getDateCreationMax());
        if (projetVo.getEtatProjetVo() != null) {
            query += SearchUtil.addConstraint("o", "etatProjet.id", "=", projetVo.getEtatProjetVo().getId());
            query += SearchUtil.addConstraint("o", "etatProjet.code", "LIKE", projetVo.getEtatProjetVo().getCode());
        }

        return entityManager.createQuery(query).getResultList();
    }

    private void savePieceJointeProjets(Projet projet, List<PieceJointeProjet> pieceJointeProjets) {

        if (ListUtil.isNotEmpty(projet.getPieceJointeProjets())) {
            List<PieceJointeProjet> savedPieceJointeProjets = new ArrayList<>();
            pieceJointeProjets.forEach(element -> {
                element.setProjet(projet);
                pieceJointeProjetService.save(element);
            });
            projet.setPieceJointeProjets(savedPieceJointeProjets);
        }
    }

    private void findEtatProjet(Projet projet) {
        EtatProjet loadedEtatProjet = etatProjetService.findByIdOrCode(projet.getEtatProjet());

        if (loadedEtatProjet == null) {
            return;
        }
        projet.setEtatProjet(loadedEtatProjet);
    }

    @Override
    @Transactional
    public void delete(List<Projet> projets) {
        if (ListUtil.isNotEmpty(projets)) {
            projets.forEach(e -> projetDao.delete(e));
        }
    }

    @Override
    public void update(List<Projet> projets) {
        if (ListUtil.isNotEmpty(projets)) {
            projets.forEach(e -> projetDao.save(e));
        }
    }

    private void associatePieceJointeProjet(Projet projet, List<PieceJointeProjet> pieceJointeProjet) {
        if (ListUtil.isNotEmpty(pieceJointeProjet)) {
            pieceJointeProjet.forEach(e -> e.setProjet(projet));
        }
    }


}

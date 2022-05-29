package com.ird.faa.service.adherent.impl;

import com.ird.faa.bean.*;
import com.ird.faa.dao.PrestationDao;
import com.ird.faa.service.adherent.facade.*;
import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.service.util.StringUtil;
import com.ird.faa.ws.rest.provided.vo.PrestationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PrestationAdherentServiceImpl extends AbstractServiceImpl<Prestation> implements PrestationAdherentService {

    @Autowired
    private PrestationDao prestationDao;

    @Autowired
    private ArchivableService<Prestation> archivableService;
    @Autowired
    private AdherentAdherentService adherentService;
    @Autowired
    private EtatPrestationAdherentService etatPrestationService;
    @Autowired
    private PieceJointePrestationAdherentService pieceJointePrestationService;
    @Autowired
    private NiveauImportanceAdherentService niveauImportanceService;
    @Autowired
    private TypePrestationAdherentService typePrestationService;


    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Prestation> findAll() {
        String query = "SELECT o FROM Prestation o where 1=1 ";
        query += " ORDER BY o.niveauImportance";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Prestation> findByAdherentCin(String cin) {
        return prestationDao.findByAdherentCin(cin);
    }

    @Override
    public List<Prestation> findByEtatPrestationReference(String reference) {
        return prestationDao.findByEtatPrestationReference(reference);
    }

    @Override
    @Transactional
    public int deleteByEtatPrestationReference(String reference) {
        return prestationDao.deleteByEtatPrestationReference(reference);
    }

    @Override
    public List<Prestation> findByEtatPrestationId(Long id) {
        return prestationDao.findByEtatPrestationId(id);
    }

    @Override
    @Transactional
    public int deleteByEtatPrestationId(Long id) {
        return prestationDao.deleteByEtatPrestationId(id);
    }


    @Override
    public List<Prestation> findByNiveauImportanceReference(String reference) {
        return prestationDao.findByNiveauImportanceReference(reference);
    }

    @Override
    @Transactional
    public int deleteByNiveauImportanceReference(String reference) {
        return prestationDao.deleteByNiveauImportanceReference(reference);
    }

    @Override
    public List<Prestation> findByNiveauImportanceId(Long id) {
        return prestationDao.findByNiveauImportanceId(id);
    }

    @Override
    @Transactional
    public int deleteByNiveauImportanceId(Long id) {
        return prestationDao.deleteByNiveauImportanceId(id);
    }


    @Override
    public List<Prestation> findByTypePrestationReference(String reference) {
        return prestationDao.findByTypePrestationReference(reference);
    }

    @Override
    @Transactional
    public int deleteByTypePrestationReference(String reference) {
        return prestationDao.deleteByTypePrestationReference(reference);
    }

    @Override
    public List<Prestation> findByTypePrestationId(Long id) {
        return prestationDao.findByTypePrestationId(id);
    }

    @Override
    @Transactional
    public int deleteByTypePrestationId(Long id) {
        return prestationDao.deleteByTypePrestationId(id);
    }


    @Override
    public List<Prestation> findByAdherentNumeroMatricule(String numeroMatricule) {
        return prestationDao.findByAdherentNumeroMatricule(numeroMatricule);
    }

    @Override
    @Transactional
    public int deleteByAdherentNumeroMatricule(String numeroMatricule) {
        return prestationDao.deleteByAdherentNumeroMatricule(numeroMatricule);
    }

    @Override
    public List<Prestation> findByAdherentId(Long id) {
        return prestationDao.findByAdherentId(id);
    }

    @Override
    @Transactional
    public int deleteByAdherentId(Long id) {
        return prestationDao.deleteByAdherentId(id);
    }

    @Override
    public Prestation findByReference(String reference) {
        if (reference == null) return null;
        return prestationDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String reference) {
        return prestationDao.deleteByReference(reference);
    }

    @Override
    public Prestation findByIdOrReference(Prestation prestation) {
        Prestation resultat = null;
        if (prestation != null) {
            if (StringUtil.isNotEmpty(prestation.getId())) {
                resultat = prestationDao.getOne(prestation.getId());
            } else if (StringUtil.isNotEmpty(prestation.getReference())) {
                resultat = prestationDao.findByReference(prestation.getReference());
            }
        }
        return resultat;
    }

    @Override
    public Prestation findById(Long id) {
        if (id == null) return null;
        return prestationDao.getOne(id);
    }

    @Override
    public Prestation findByIdWithAssociatedList(Long id) {
        Prestation prestation = findById(id);
        findAssociatedLists(prestation);
        return prestation;
    }

    @Override
    public Prestation archiver(Prestation prestation) {
        if (prestation.getArchive() == null) {
            prestation.setArchive(false);
        }
        prestation.setArchive(true);
        prestation.setDateArchivage(new Date());
        prestationDao.save(prestation);
        return prestation;

    }

    @Override
    public Prestation desarchiver(Prestation prestation) {
        if (prestation.getArchive() == null) {
            prestation.setArchive(false);
        }
        prestation.setArchive(false);
        prestation.setDateArchivage(null);
        prestationDao.save(prestation);
        return prestation;
    }

    private void findAssociatedLists(Prestation prestation) {
        if (prestation != null && prestation.getId() != null) {
            List<PieceJointePrestation> pieceJointePrestations = pieceJointePrestationService.findByPrestationId(prestation.getId());
            prestation.setPieceJointePrestations(pieceJointePrestations);
        }
    }

    private void deleteAssociatedLists(Long id) {
        if (id != null) {
            pieceJointePrestationService.deleteByPrestationId(id);
        }
    }

    private void updateAssociatedLists(Prestation prestation) {
        if (prestation != null && prestation.getId() != null) {
            List
                    <List<PieceJointePrestation>> resultPieceJointePrestations = pieceJointePrestationService.getToBeSavedAndToBeDeleted(pieceJointePrestationService.findByPrestationId(prestation.getId()), prestation.getPieceJointePrestations());
            pieceJointePrestationService.delete(resultPieceJointePrestations.get(1));
            associatePieceJointePrestation(prestation, resultPieceJointePrestations.get(0));
            pieceJointePrestationService.update(resultPieceJointePrestations.get(0));

        }
    }

    @Transactional
    public int deleteById(Long id) {
        int res = 0;
        if (prestationDao.findById(id).isPresent()) {
            deleteAssociatedLists(id);
            prestationDao.deleteById(id);
            res = 1;
        }
        return res;
    }


    @Override
    public Prestation update(Prestation prestation) {
        Prestation foundedPrestation = findById(prestation.getId());
        if (foundedPrestation == null) return null;
        else {
            archivableService.prepare(prestation);
            updateAssociatedLists(prestation);
            return prestationDao.save(prestation);
        }
    }

    private void prepareSave(Prestation prestation) {
        prestation.setDateCreation(new Date());
        if (prestation.getEnvoye() == null)
            prestation.setEnvoye(false);
        if (prestation.getResultat() == null)
            prestation.setResultat(false);
        if (prestation.getArchive() == null)
            prestation.setArchive(false);
        if (prestation.getAdmin() == null)
            prestation.setAdmin(false);
        if (prestation.getVisible() == null)
            prestation.setVisible(false);


    }

    @Override
    public Prestation save(Prestation prestation) {
        prepareSave(prestation);

        Prestation result = null;
        Prestation foundedPrestation = findByReference(prestation.getReference());
        if (foundedPrestation == null) {


            findEtatPrestation(prestation);
            findNiveauImportance(prestation);
            findTypePrestation(prestation);
            findAdherent(prestation);

            Prestation savedPrestation = prestationDao.save(prestation);

            savePieceJointePrestations(savedPrestation, prestation.getPieceJointePrestations());
            result = savedPrestation;
        }

        return result;
    }

    @Override
    public List<Prestation> save(List<Prestation> prestations) {
        List<Prestation> list = new ArrayList<>();
        for (Prestation prestation : prestations) {
            list.add(save(prestation));
        }
        return list;
    }

    private List<PieceJointePrestation> preparePieceJointePrestations(Prestation prestation, List<PieceJointePrestation> pieceJointePrestations) {
        for (PieceJointePrestation pieceJointePrestation : pieceJointePrestations) {
            pieceJointePrestation.setPrestation(prestation);
        }
        return pieceJointePrestations;
    }


    @Override
    @Transactional
    public int delete(Prestation prestation) {
        if (prestation.getReference() == null) return -1;

        Prestation foundedPrestation = findByReference(prestation.getReference());
        if (foundedPrestation == null) return -1;
        prestationDao.delete(foundedPrestation);
        return 1;
    }


    public List<Prestation> findByCriteria(PrestationVo prestationVo) {

        String query = "SELECT o FROM Prestation o where 1=1 ";

        query += SearchUtil.addConstraint("o", "id", "=", prestationVo.getId());
        query += SearchUtil.addConstraint("o", "reference", "LIKE", prestationVo.getReference());
        query += SearchUtil.addConstraint("o", "numArrivee", "LIKE", prestationVo.getNumArrivee());
        query += SearchUtil.addConstraint("o", "envoye", "=", prestationVo.getEnvoye());
        query += SearchUtil.addConstraintDate("o", "dateEnvoi", "=", prestationVo.getDateEnvoi());
        query += SearchUtil.addConstraintDate("o", "dateTraitement", "=", prestationVo.getDateTraitement());
        query += SearchUtil.addConstraint("o", "chargeCas", "LIKE", prestationVo.getChargeCas());
        query += SearchUtil.addConstraint("o", "resultat", "=", prestationVo.getResultat());
        query += SearchUtil.addConstraint("o", "notes", "LIKE", prestationVo.getNotes());
        query += SearchUtil.addConstraint("o", "archive", "=", prestationVo.getArchive());
        query += SearchUtil.addConstraintDate("o", "dateArchivage", "=", prestationVo.getDateArchivage());
        query += SearchUtil.addConstraintDate("o", "dateCreation", "=", prestationVo.getDateCreation());
        query += SearchUtil.addConstraint("o", "admin", "=", prestationVo.getAdmin());
        query += SearchUtil.addConstraint("o", "visible", "=", prestationVo.getVisible());
        query += SearchUtil.addConstraint("o", "username", "LIKE", prestationVo.getUsername());
        query += SearchUtil.addConstraintMinMaxDate("o", "dateEnvoi", prestationVo.getDateEnvoiMin(), prestationVo.getDateEnvoiMax());
        query += SearchUtil.addConstraintMinMaxDate("o", "dateTraitement", prestationVo.getDateTraitementMin(), prestationVo.getDateTraitementMax());
        query += SearchUtil.addConstraintMinMax("o", "pieceJointePrestations", prestationVo.getPieceJointePrestationsMin(), prestationVo.getPieceJointePrestationsMax());
        query += SearchUtil.addConstraintMinMaxDate("o", "dateArchivage", prestationVo.getDateArchivageMin(), prestationVo.getDateArchivageMax());
        query += SearchUtil.addConstraintMinMaxDate("o", "dateCreation", prestationVo.getDateCreationMin(), prestationVo.getDateCreationMax());
        if (prestationVo.getEtatPrestationVo() != null) {
            query += SearchUtil.addConstraint("o", "etatPrestation.id", "=", prestationVo.getEtatPrestationVo().getId());
            query += SearchUtil.addConstraint("o", "etatPrestation.reference", "LIKE", prestationVo.getEtatPrestationVo().getReference());
        }

        if (prestationVo.getNiveauImportanceVo() != null) {
            query += SearchUtil.addConstraint("o", "niveauImportance.id", "=", prestationVo.getNiveauImportanceVo().getId());
            query += SearchUtil.addConstraint("o", "niveauImportance.reference", "LIKE", prestationVo.getNiveauImportanceVo().getReference());
        }

        if (prestationVo.getTypePrestationVo() != null) {
            query += SearchUtil.addConstraint("o", "typePrestation.id", "=", prestationVo.getTypePrestationVo().getId());
            query += SearchUtil.addConstraint("o", "typePrestation.reference", "LIKE", prestationVo.getTypePrestationVo().getReference());
        }

        if (prestationVo.getAdherentVo() != null) {
            query += SearchUtil.addConstraint("o", "adherent.id", "=", prestationVo.getAdherentVo().getId());
            query += SearchUtil.addConstraint("o", "adherent.numeroMatricule", "LIKE", prestationVo.getAdherentVo().getNumeroMatricule());
        }

        query += " ORDER BY o.niveauImportance";
        return entityManager.createQuery(query).getResultList();
    }

    private void savePieceJointePrestations(Prestation prestation, List<PieceJointePrestation> pieceJointePrestations) {

        if (ListUtil.isNotEmpty(prestation.getPieceJointePrestations())) {
            List<PieceJointePrestation> savedPieceJointePrestations = new ArrayList<>();
            pieceJointePrestations.forEach(element -> {
                element.setPrestation(prestation);
                pieceJointePrestationService.save(element);
            });
            prestation.setPieceJointePrestations(savedPieceJointePrestations);
        }
    }

    private void findEtatPrestation(Prestation prestation) {
        EtatPrestation loadedEtatPrestation = etatPrestationService.findByIdOrReference(prestation.getEtatPrestation());

        if (loadedEtatPrestation == null) {
            return;
        }
        prestation.setEtatPrestation(loadedEtatPrestation);
    }

    private void findNiveauImportance(Prestation prestation) {
        NiveauImportance loadedNiveauImportance = niveauImportanceService.findByIdOrReference(prestation.getNiveauImportance());

        if (loadedNiveauImportance == null) {
            return;
        }
        prestation.setNiveauImportance(loadedNiveauImportance);
    }

    private void findTypePrestation(Prestation prestation) {
        TypePrestation loadedTypePrestation = typePrestationService.findByIdOrReference(prestation.getTypePrestation());

        if (loadedTypePrestation == null) {
            return;
        }
        prestation.setTypePrestation(loadedTypePrestation);
    }

    private void findAdherent(Prestation prestation) {
        Adherent loadedAdherent = adherentService.findByIdOrNumeroMatricule(prestation.getAdherent());

        if (loadedAdherent == null) {
            return;
        }
        prestation.setAdherent(loadedAdherent);
    }

    @Override
    @Transactional
    public void delete(List<Prestation> prestations) {
        if (ListUtil.isNotEmpty(prestations)) {
            prestations.forEach(e -> prestationDao.delete(e));
        }
    }

    @Override
    public void update(List<Prestation> prestations) {
        if (ListUtil.isNotEmpty(prestations)) {
            prestations.forEach(e -> prestationDao.save(e));
        }
    }

    private void associatePieceJointePrestation(Prestation prestation, List<PieceJointePrestation> pieceJointePrestation) {
        if (ListUtil.isNotEmpty(pieceJointePrestation)) {
            pieceJointePrestation.forEach(e -> e.setPrestation(prestation));
        }
    }


}

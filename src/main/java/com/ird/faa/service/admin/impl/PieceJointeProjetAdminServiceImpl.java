package com.ird.faa.service.admin.impl;

import com.ird.faa.bean.PieceJointeProjet;
import com.ird.faa.bean.Projet;
import com.ird.faa.dao.PieceJointeProjetDao;
import com.ird.faa.service.admin.facade.PieceJointeProjetAdminService;
import com.ird.faa.service.admin.facade.ProjetAdminService;
import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.ws.rest.provided.vo.PieceJointeProjetVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PieceJointeProjetAdminServiceImpl extends AbstractServiceImpl<PieceJointeProjet> implements PieceJointeProjetAdminService {

    @Autowired
    private PieceJointeProjetDao pieceJointeProjetDao;

    @Autowired
    private ArchivableService<PieceJointeProjet> archivableService;
    @Autowired
    private ProjetAdminService projetService;
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<PieceJointeProjet> findAll() {
        return pieceJointeProjetDao.findAll();
    }
    @Override
    public List<PieceJointeProjet> findByProjetReference(String reference) {
        return pieceJointeProjetDao.findByProjetReference(reference);
    }

    @Override
    @Transactional
    public int deleteByProjetReference(String reference) {
        return pieceJointeProjetDao.deleteByProjetReference(reference);
    }

    @Override
    public List<PieceJointeProjet> findByProjetId(Long id) {
        return pieceJointeProjetDao.findByProjetId(id);
    }

    @Override
    @Transactional
    public int deleteByProjetId(Long id) {
        return pieceJointeProjetDao.deleteByProjetId(id);
    }


    @Override
    public PieceJointeProjet findById(Long id) {
        if (id == null) return null;
        return pieceJointeProjetDao.getOne(id);
    }

    @Override
    public PieceJointeProjet findByIdWithAssociatedList(Long id) {
        return findById(id);
    }

    @Override
    public PieceJointeProjet archiver(PieceJointeProjet pieceJointeProjet) {
        if (pieceJointeProjet.getArchive() == null) {
            pieceJointeProjet.setArchive(false);
        }
        pieceJointeProjet.setArchive(true);
        pieceJointeProjet.setDateArchivage(new Date());
        pieceJointeProjetDao.save(pieceJointeProjet);
        return pieceJointeProjet;

    }

    @Override
    public PieceJointeProjet desarchiver(PieceJointeProjet pieceJointeProjet) {
        if (pieceJointeProjet.getArchive() == null) {
            pieceJointeProjet.setArchive(false);
        }
        pieceJointeProjet.setArchive(false);
        pieceJointeProjet.setDateArchivage(null);
        pieceJointeProjetDao.save(pieceJointeProjet);
        return pieceJointeProjet;
    }


    @Transactional
    public int deleteById(Long id) {
        int res = 0;
        if (pieceJointeProjetDao.findById(id).isPresent()) {
            pieceJointeProjetDao.deleteById(id);
            res = 1;
        }
        return res;
    }


    @Override
    public PieceJointeProjet update(PieceJointeProjet pieceJointeProjet) {
        PieceJointeProjet foundedPieceJointeProjet = findById(pieceJointeProjet.getId());
        if (foundedPieceJointeProjet == null) return null;
        else {
            archivableService.prepare(pieceJointeProjet);
            return pieceJointeProjetDao.save(pieceJointeProjet);
        }
    }

    private void prepareSave(PieceJointeProjet pieceJointeProjet) {
        pieceJointeProjet.setDateCreation(new Date());
        if (pieceJointeProjet.getArchive() == null)
            pieceJointeProjet.setArchive(false);
        if (pieceJointeProjet.getAdmin() == null)
            pieceJointeProjet.setAdmin(false);
        if (pieceJointeProjet.getVisible() == null)
            pieceJointeProjet.setVisible(false);


    }

    @Override
    public PieceJointeProjet save(PieceJointeProjet pieceJointeProjet) {
        prepareSave(pieceJointeProjet);


        findProjet(pieceJointeProjet);

        return pieceJointeProjetDao.save(pieceJointeProjet);


    }

    @Override
    public List<PieceJointeProjet> save(List<PieceJointeProjet> pieceJointeProjets) {
        List<PieceJointeProjet> list = new ArrayList<>();
        for (PieceJointeProjet pieceJointeProjet : pieceJointeProjets) {
            list.add(save(pieceJointeProjet));
        }
        return list;
    }


    @Override
    @Transactional
    public int delete(PieceJointeProjet pieceJointeProjet) {
        if (pieceJointeProjet.getId() == null) return -1;
        PieceJointeProjet foundedPieceJointeProjet = findById(pieceJointeProjet.getId());
        if (foundedPieceJointeProjet == null) return -1;
        pieceJointeProjetDao.delete(foundedPieceJointeProjet);
        return 1;
    }


    public List<PieceJointeProjet> findByCriteria(PieceJointeProjetVo pieceJointeProjetVo) {

        String query = "SELECT o FROM PieceJointeProjet o where 1=1 ";

        query += SearchUtil.addConstraint("o", "id", "=", pieceJointeProjetVo.getId());
        query += SearchUtil.addConstraint("o", "path", "LIKE", pieceJointeProjetVo.getPath());
        query += SearchUtil.addConstraintDate("o", "dateAjout", "=", pieceJointeProjetVo.getDateAjout());
        query += SearchUtil.addConstraint("o", "libelle", "LIKE", pieceJointeProjetVo.getLibelle());
        query += SearchUtil.addConstraint("o", "archive", "=", pieceJointeProjetVo.getArchive());
        query += SearchUtil.addConstraintDate("o", "dateArchivage", "=", pieceJointeProjetVo.getDateArchivage());
        query += SearchUtil.addConstraintDate("o", "dateCreation", "=", pieceJointeProjetVo.getDateCreation());
        query += SearchUtil.addConstraint("o", "admin", "=", pieceJointeProjetVo.getAdmin());
        query += SearchUtil.addConstraint("o", "visible", "=", pieceJointeProjetVo.getVisible());
        query += SearchUtil.addConstraint("o", "username", "LIKE", pieceJointeProjetVo.getUsername());
        query += SearchUtil.addConstraintMinMaxDate("o", "dateAjout", pieceJointeProjetVo.getDateAjoutMin(), pieceJointeProjetVo.getDateAjoutMax());
        query += SearchUtil.addConstraintMinMaxDate("o", "dateArchivage", pieceJointeProjetVo.getDateArchivageMin(), pieceJointeProjetVo.getDateArchivageMax());
        query += SearchUtil.addConstraintMinMaxDate("o", "dateCreation", pieceJointeProjetVo.getDateCreationMin(), pieceJointeProjetVo.getDateCreationMax());
        if (pieceJointeProjetVo.getProjetVo() != null) {
            query += SearchUtil.addConstraint("o", "projet.id", "=", pieceJointeProjetVo.getProjetVo().getId());
            query += SearchUtil.addConstraint("o", "projet.reference", "LIKE", pieceJointeProjetVo.getProjetVo().getReference());
        }

        return entityManager.createQuery(query).getResultList();
    }

    private void findProjet(PieceJointeProjet pieceJointeProjet) {
        Projet loadedProjet = projetService.findByIdOrReference(pieceJointeProjet.getProjet());

        if (loadedProjet == null) {
            return;
        }
        pieceJointeProjet.setProjet(loadedProjet);
    }

    @Override
    @Transactional
    public void delete(List<PieceJointeProjet> pieceJointeProjets) {
        if (ListUtil.isNotEmpty(pieceJointeProjets)) {
            pieceJointeProjets.forEach(e -> pieceJointeProjetDao.delete(e));
        }
    }

    @Override
    public void update(List<PieceJointeProjet> pieceJointeProjets) {
        if (ListUtil.isNotEmpty(pieceJointeProjets)) {
            pieceJointeProjets.forEach(e -> pieceJointeProjetDao.save(e));
        }
    }

    @Override
    public void uploadFile(MultipartFile file, String projetRef) throws IOException {
        PieceJointeProjet pieceJointeProjet = new PieceJointeProjet();
        System.out.println(file.getOriginalFilename());
        String path = System.getProperty("user.home") + "\\projet-pieces-jointes\\";
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        pieceJointeProjet.setPath(path + fileName);
        pieceJointeProjet.setData(file.getBytes());
        pieceJointeProjet.setLibelle(fileName);
//        pieceJointeProjet.setType(file.getContentType());
        Projet projet = projetService.findByReference(projetRef);
        List<PieceJointeProjet>  ds =new ArrayList<>();
        ds.add(pieceJointeProjet);
        projet.setPieceJointeProjets(ds);
//        projet.setPieceJointeProjets(pieceJointeProjet);
        pieceJointeProjet.setProjet(projet);
        pieceJointeProjetDao.save(pieceJointeProjet);
        projetService.save(projet);

    }

    @Override
    public PieceJointeProjet getFile(Long id) {
        return pieceJointeProjetDao.findById(id).get();
    }
}

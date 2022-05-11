package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.GestionReclamation;
import com.ird.faa.ws.rest.provided.vo.GestionReclamationVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface GestionReclamationChercheurService extends AbstractService<GestionReclamation,Long,GestionReclamationVo>{


    /**
    * find GestionReclamation from database by reference (reference)
    * @param reference - reference of GestionReclamation
    * @return the founded GestionReclamation , If no GestionReclamation were
    *         found in database return  null.
    */
    GestionReclamation findByReference(String reference);

    /**
    * find GestionReclamation from database by id (PK) or reference (reference)
    * @param id - id of GestionReclamation
    * @param reference - reference of GestionReclamation
    * @return the founded GestionReclamation , If no GestionReclamation were
    *         found in database return  null.
    */
    GestionReclamation findByIdOrReference(GestionReclamation gestionReclamation);


/**
    * delete GestionReclamation from database
    * @param id - id of GestionReclamation to be deleted
    *
    */
    int deleteById(Long id);


    List<GestionReclamation> findByModerateurNumeroMatricule(String numeroMatricule);

    int deleteByModerateurNumeroMatricule(String numeroMatricule);

    List<GestionReclamation> findByModerateurId(Long id);

    int deleteByModerateurId(Long id);
    List<GestionReclamation> findByReclamationReference(String reference);

    int deleteByReclamationReference(String reference);

    List<GestionReclamation> findByReclamationId(Long id);

    int deleteByReclamationId(Long id);


    /**
    * delete GestionReclamation from database by reference (reference)
    *
    * @param reference - reference of GestionReclamation to be deleted
    * @return 1 if GestionReclamation deleted successfully
    */
    int deleteByReference(String reference);





}

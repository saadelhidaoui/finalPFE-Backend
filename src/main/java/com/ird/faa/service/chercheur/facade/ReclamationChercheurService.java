package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.Reclamation;
import com.ird.faa.ws.rest.provided.vo.ReclamationVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface ReclamationChercheurService extends AbstractService<Reclamation,Long,ReclamationVo>{


    /**
    * find Reclamation from database by reference (reference)
    * @param reference - reference of Reclamation
    * @return the founded Reclamation , If no Reclamation were
    *         found in database return  null.
    */
    Reclamation findByReference(String reference);

    /**
    * find Reclamation from database by id (PK) or reference (reference)
    * @param id - id of Reclamation
    * @param reference - reference of Reclamation
    * @return the founded Reclamation , If no Reclamation were
    *         found in database return  null.
    */
    Reclamation findByIdOrReference(Reclamation reclamation);


/**
    * delete Reclamation from database
    * @param id - id of Reclamation to be deleted
    *
    */
    int deleteById(Long id);


    List<Reclamation> findByAdherentNumeroMatricule(String numeroMatricule);

    int deleteByAdherentNumeroMatricule(String numeroMatricule);

    List<Reclamation> findByAdherentId(Long id);

    int deleteByAdherentId(Long id);
    List<Reclamation> findByEtatReclamationReference(String reference);

    int deleteByEtatReclamationReference(String reference);

    List<Reclamation> findByEtatReclamationId(Long id);

    int deleteByEtatReclamationId(Long id);


    /**
    * delete Reclamation from database by reference (reference)
    *
    * @param reference - reference of Reclamation to be deleted
    * @return 1 if Reclamation deleted successfully
    */
    int deleteByReference(String reference);





}

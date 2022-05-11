package com.ird.faa.service.moderateur.facade;

import java.util.List;
import com.ird.faa.bean.EtatReclamation;
import com.ird.faa.ws.rest.provided.vo.EtatReclamationVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface EtatReclamationModerateurService extends AbstractService<EtatReclamation,Long,EtatReclamationVo>{


    /**
    * find EtatReclamation from database by reference (reference)
    * @param reference - reference of EtatReclamation
    * @return the founded EtatReclamation , If no EtatReclamation were
    *         found in database return  null.
    */
    EtatReclamation findByReference(String reference);

    /**
    * find EtatReclamation from database by id (PK) or reference (reference)
    * @param id - id of EtatReclamation
    * @param reference - reference of EtatReclamation
    * @return the founded EtatReclamation , If no EtatReclamation were
    *         found in database return  null.
    */
    EtatReclamation findByIdOrReference(EtatReclamation etatReclamation);


/**
    * delete EtatReclamation from database
    * @param id - id of EtatReclamation to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete EtatReclamation from database by reference (reference)
    *
    * @param reference - reference of EtatReclamation to be deleted
    * @return 1 if EtatReclamation deleted successfully
    */
    int deleteByReference(String reference);





}

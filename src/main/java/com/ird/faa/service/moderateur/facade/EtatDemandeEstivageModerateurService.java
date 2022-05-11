package com.ird.faa.service.moderateur.facade;

import java.util.List;
import com.ird.faa.bean.EtatDemandeEstivage;
import com.ird.faa.ws.rest.provided.vo.EtatDemandeEstivageVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface EtatDemandeEstivageModerateurService extends AbstractService<EtatDemandeEstivage,Long,EtatDemandeEstivageVo>{


    /**
    * find EtatDemandeEstivage from database by reference (reference)
    * @param reference - reference of EtatDemandeEstivage
    * @return the founded EtatDemandeEstivage , If no EtatDemandeEstivage were
    *         found in database return  null.
    */
    EtatDemandeEstivage findByReference(String reference);

    /**
    * find EtatDemandeEstivage from database by id (PK) or reference (reference)
    * @param id - id of EtatDemandeEstivage
    * @param reference - reference of EtatDemandeEstivage
    * @return the founded EtatDemandeEstivage , If no EtatDemandeEstivage were
    *         found in database return  null.
    */
    EtatDemandeEstivage findByIdOrReference(EtatDemandeEstivage etatDemandeEstivage);


/**
    * delete EtatDemandeEstivage from database
    * @param id - id of EtatDemandeEstivage to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete EtatDemandeEstivage from database by reference (reference)
    *
    * @param reference - reference of EtatDemandeEstivage to be deleted
    * @return 1 if EtatDemandeEstivage deleted successfully
    */
    int deleteByReference(String reference);





}

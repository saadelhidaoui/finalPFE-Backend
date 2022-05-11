package com.ird.faa.service.moderateur.facade;

import java.util.List;
import com.ird.faa.bean.EtatProjet;
import com.ird.faa.ws.rest.provided.vo.EtatProjetVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface EtatProjetModerateurService extends AbstractService<EtatProjet,Long,EtatProjetVo>{


    /**
    * find EtatProjet from database by code (reference)
    * @param code - reference of EtatProjet
    * @return the founded EtatProjet , If no EtatProjet were
    *         found in database return  null.
    */
    EtatProjet findByCode(String code);

    /**
    * find EtatProjet from database by id (PK) or code (reference)
    * @param id - id of EtatProjet
    * @param code - reference of EtatProjet
    * @return the founded EtatProjet , If no EtatProjet were
    *         found in database return  null.
    */
    EtatProjet findByIdOrCode(EtatProjet etatProjet);


/**
    * delete EtatProjet from database
    * @param id - id of EtatProjet to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete EtatProjet from database by code (reference)
    *
    * @param code - reference of EtatProjet to be deleted
    * @return 1 if EtatProjet deleted successfully
    */
    int deleteByCode(String code);




    EtatProjet archiver(EtatProjet etatProjet) ;
    EtatProjet desarchiver(EtatProjet etatProjet);

}

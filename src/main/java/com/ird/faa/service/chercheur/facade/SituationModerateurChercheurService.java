package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.SituationModerateur;
import com.ird.faa.ws.rest.provided.vo.SituationModerateurVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface SituationModerateurChercheurService extends AbstractService<SituationModerateur,Long,SituationModerateurVo>{


    /**
    * find SituationModerateur from database by reference (reference)
    * @param reference - reference of SituationModerateur
    * @return the founded SituationModerateur , If no SituationModerateur were
    *         found in database return  null.
    */
    SituationModerateur findByReference(String reference);

    /**
    * find SituationModerateur from database by id (PK) or reference (reference)
    * @param id - id of SituationModerateur
    * @param reference - reference of SituationModerateur
    * @return the founded SituationModerateur , If no SituationModerateur were
    *         found in database return  null.
    */
    SituationModerateur findByIdOrReference(SituationModerateur situationModerateur);


/**
    * delete SituationModerateur from database
    * @param id - id of SituationModerateur to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete SituationModerateur from database by reference (reference)
    *
    * @param reference - reference of SituationModerateur to be deleted
    * @return 1 if SituationModerateur deleted successfully
    */
    int deleteByReference(String reference);





}

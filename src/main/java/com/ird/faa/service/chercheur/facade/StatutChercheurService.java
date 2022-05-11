package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.Statut;
import com.ird.faa.ws.rest.provided.vo.StatutVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface StatutChercheurService extends AbstractService<Statut,Long,StatutVo>{


    /**
    * find Statut from database by reference (reference)
    * @param reference - reference of Statut
    * @return the founded Statut , If no Statut were
    *         found in database return  null.
    */
    Statut findByReference(String reference);

    /**
    * find Statut from database by id (PK) or reference (reference)
    * @param id - id of Statut
    * @param reference - reference of Statut
    * @return the founded Statut , If no Statut were
    *         found in database return  null.
    */
    Statut findByIdOrReference(Statut statut);


/**
    * delete Statut from database
    * @param id - id of Statut to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete Statut from database by reference (reference)
    *
    * @param reference - reference of Statut to be deleted
    * @return 1 if Statut deleted successfully
    */
    int deleteByReference(String reference);





}

package com.ird.faa.service.moderateur.facade;

import java.util.List;
import com.ird.faa.bean.Convention;
import com.ird.faa.ws.rest.provided.vo.ConventionVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface ConventionModerateurService extends AbstractService<Convention,Long,ConventionVo>{


    /**
    * find Convention from database by reference (reference)
    * @param reference - reference of Convention
    * @return the founded Convention , If no Convention were
    *         found in database return  null.
    */
    Convention findByReference(String reference);

    /**
    * find Convention from database by id (PK) or reference (reference)
    * @param id - id of Convention
    * @param reference - reference of Convention
    * @return the founded Convention , If no Convention were
    *         found in database return  null.
    */
    Convention findByIdOrReference(Convention convention);


/**
    * delete Convention from database
    * @param id - id of Convention to be deleted
    *
    */
    int deleteById(Long id);



    List<Convention> findByOrganismeId(Long id);

    int deleteByOrganismeId(Long id);


    /**
    * delete Convention from database by reference (reference)
    *
    * @param reference - reference of Convention to be deleted
    * @return 1 if Convention deleted successfully
    */
    int deleteByReference(String reference);




    Convention archiver(Convention convention) ;
    Convention desarchiver(Convention convention);

}

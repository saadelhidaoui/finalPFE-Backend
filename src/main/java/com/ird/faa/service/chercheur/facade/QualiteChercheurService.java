package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.Qualite;
import com.ird.faa.ws.rest.provided.vo.QualiteVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface QualiteChercheurService extends AbstractService<Qualite,Long,QualiteVo>{


    /**
    * find Qualite from database by reference (reference)
    * @param reference - reference of Qualite
    * @return the founded Qualite , If no Qualite were
    *         found in database return  null.
    */
    Qualite findByReference(String reference);

    /**
    * find Qualite from database by id (PK) or reference (reference)
    * @param id - id of Qualite
    * @param reference - reference of Qualite
    * @return the founded Qualite , If no Qualite were
    *         found in database return  null.
    */
    Qualite findByIdOrReference(Qualite qualite);


/**
    * delete Qualite from database
    * @param id - id of Qualite to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete Qualite from database by reference (reference)
    *
    * @param reference - reference of Qualite to be deleted
    * @return 1 if Qualite deleted successfully
    */
    int deleteByReference(String reference);





}

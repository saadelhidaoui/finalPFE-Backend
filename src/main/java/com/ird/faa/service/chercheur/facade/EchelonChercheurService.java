package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.Echelon;
import com.ird.faa.ws.rest.provided.vo.EchelonVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface EchelonChercheurService extends AbstractService<Echelon,Long,EchelonVo>{


    /**
    * find Echelon from database by reference (reference)
    * @param reference - reference of Echelon
    * @return the founded Echelon , If no Echelon were
    *         found in database return  null.
    */
    Echelon findByReference(String reference);

    /**
    * find Echelon from database by id (PK) or reference (reference)
    * @param id - id of Echelon
    * @param reference - reference of Echelon
    * @return the founded Echelon , If no Echelon were
    *         found in database return  null.
    */
    Echelon findByIdOrReference(Echelon echelon);


/**
    * delete Echelon from database
    * @param id - id of Echelon to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete Echelon from database by reference (reference)
    *
    * @param reference - reference of Echelon to be deleted
    * @return 1 if Echelon deleted successfully
    */
    int deleteByReference(String reference);





}

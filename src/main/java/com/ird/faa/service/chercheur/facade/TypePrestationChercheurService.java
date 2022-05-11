package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.TypePrestation;
import com.ird.faa.ws.rest.provided.vo.TypePrestationVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface TypePrestationChercheurService extends AbstractService<TypePrestation,Long,TypePrestationVo>{


    /**
    * find TypePrestation from database by reference (reference)
    * @param reference - reference of TypePrestation
    * @return the founded TypePrestation , If no TypePrestation were
    *         found in database return  null.
    */
    TypePrestation findByReference(String reference);

    /**
    * find TypePrestation from database by id (PK) or reference (reference)
    * @param id - id of TypePrestation
    * @param reference - reference of TypePrestation
    * @return the founded TypePrestation , If no TypePrestation were
    *         found in database return  null.
    */
    TypePrestation findByIdOrReference(TypePrestation typePrestation);


/**
    * delete TypePrestation from database
    * @param id - id of TypePrestation to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete TypePrestation from database by reference (reference)
    *
    * @param reference - reference of TypePrestation to be deleted
    * @return 1 if TypePrestation deleted successfully
    */
    int deleteByReference(String reference);





}

package com.ird.faa.service.adherent.facade;

import java.util.List;
import com.ird.faa.bean.NiveauImportance;
import com.ird.faa.ws.rest.provided.vo.NiveauImportanceVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface NiveauImportanceAdherentService extends AbstractService<NiveauImportance,Long,NiveauImportanceVo>{


    /**
    * find NiveauImportance from database by reference (reference)
    * @param reference - reference of NiveauImportance
    * @return the founded NiveauImportance , If no NiveauImportance were
    *         found in database return  null.
    */
    NiveauImportance findByReference(String reference);

    /**
    * find NiveauImportance from database by id (PK) or reference (reference)
    * @param id - id of NiveauImportance
    * @param reference - reference of NiveauImportance
    * @return the founded NiveauImportance , If no NiveauImportance were
    *         found in database return  null.
    */
    NiveauImportance findByIdOrReference(NiveauImportance niveauImportance);


/**
    * delete NiveauImportance from database
    * @param id - id of NiveauImportance to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete NiveauImportance from database by reference (reference)
    *
    * @param reference - reference of NiveauImportance to be deleted
    * @return 1 if NiveauImportance deleted successfully
    */
    int deleteByReference(String reference);





}

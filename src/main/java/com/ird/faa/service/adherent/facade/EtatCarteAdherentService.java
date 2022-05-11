package com.ird.faa.service.adherent.facade;

import java.util.List;
import com.ird.faa.bean.EtatCarte;
import com.ird.faa.ws.rest.provided.vo.EtatCarteVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface EtatCarteAdherentService extends AbstractService<EtatCarte,Long,EtatCarteVo>{


    /**
    * find EtatCarte from database by reference (reference)
    * @param reference - reference of EtatCarte
    * @return the founded EtatCarte , If no EtatCarte were
    *         found in database return  null.
    */
    EtatCarte findByReference(String reference);

    /**
    * find EtatCarte from database by id (PK) or reference (reference)
    * @param id - id of EtatCarte
    * @param reference - reference of EtatCarte
    * @return the founded EtatCarte , If no EtatCarte were
    *         found in database return  null.
    */
    EtatCarte findByIdOrReference(EtatCarte etatCarte);


/**
    * delete EtatCarte from database
    * @param id - id of EtatCarte to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete EtatCarte from database by reference (reference)
    *
    * @param reference - reference of EtatCarte to be deleted
    * @return 1 if EtatCarte deleted successfully
    */
    int deleteByReference(String reference);





}

package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.EtatTache;
import com.ird.faa.ws.rest.provided.vo.EtatTacheVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface EtatTacheChercheurService extends AbstractService<EtatTache,Long,EtatTacheVo>{


    /**
    * find EtatTache from database by reference (reference)
    * @param reference - reference of EtatTache
    * @return the founded EtatTache , If no EtatTache were
    *         found in database return  null.
    */
    EtatTache findByReference(String reference);

    /**
    * find EtatTache from database by id (PK) or reference (reference)
    * @param id - id of EtatTache
    * @param reference - reference of EtatTache
    * @return the founded EtatTache , If no EtatTache were
    *         found in database return  null.
    */
    EtatTache findByIdOrReference(EtatTache etatTache);


/**
    * delete EtatTache from database
    * @param id - id of EtatTache to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete EtatTache from database by reference (reference)
    *
    * @param reference - reference of EtatTache to be deleted
    * @return 1 if EtatTache deleted successfully
    */
    int deleteByReference(String reference);





}

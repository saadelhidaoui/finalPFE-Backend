package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.EtatPrestation;
import com.ird.faa.ws.rest.provided.vo.EtatPrestationVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface EtatPrestationChercheurService extends AbstractService<EtatPrestation,Long,EtatPrestationVo>{


    /**
    * find EtatPrestation from database by reference (reference)
    * @param reference - reference of EtatPrestation
    * @return the founded EtatPrestation , If no EtatPrestation were
    *         found in database return  null.
    */
    EtatPrestation findByReference(String reference);

    /**
    * find EtatPrestation from database by id (PK) or reference (reference)
    * @param id - id of EtatPrestation
    * @param reference - reference of EtatPrestation
    * @return the founded EtatPrestation , If no EtatPrestation were
    *         found in database return  null.
    */
    EtatPrestation findByIdOrReference(EtatPrestation etatPrestation);


/**
    * delete EtatPrestation from database
    * @param id - id of EtatPrestation to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete EtatPrestation from database by reference (reference)
    *
    * @param reference - reference of EtatPrestation to be deleted
    * @return 1 if EtatPrestation deleted successfully
    */
    int deleteByReference(String reference);





}

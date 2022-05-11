package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.Prestation;
import com.ird.faa.ws.rest.provided.vo.PrestationVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface PrestationChercheurService extends AbstractService<Prestation,Long,PrestationVo>{


    /**
    * find Prestation from database by reference (reference)
    * @param reference - reference of Prestation
    * @return the founded Prestation , If no Prestation were
    *         found in database return  null.
    */
    Prestation findByReference(String reference);

    /**
    * find Prestation from database by id (PK) or reference (reference)
    * @param id - id of Prestation
    * @param reference - reference of Prestation
    * @return the founded Prestation , If no Prestation were
    *         found in database return  null.
    */
    Prestation findByIdOrReference(Prestation prestation);


/**
    * delete Prestation from database
    * @param id - id of Prestation to be deleted
    *
    */
    int deleteById(Long id);


    List<Prestation> findByEtatPrestationReference(String reference);

    int deleteByEtatPrestationReference(String reference);

    List<Prestation> findByEtatPrestationId(Long id);

    int deleteByEtatPrestationId(Long id);
    List<Prestation> findByNiveauImportanceReference(String reference);

    int deleteByNiveauImportanceReference(String reference);

    List<Prestation> findByNiveauImportanceId(Long id);

    int deleteByNiveauImportanceId(Long id);
    List<Prestation> findByTypePrestationReference(String reference);

    int deleteByTypePrestationReference(String reference);

    List<Prestation> findByTypePrestationId(Long id);

    int deleteByTypePrestationId(Long id);
    List<Prestation> findByAdherentNumeroMatricule(String numeroMatricule);

    int deleteByAdherentNumeroMatricule(String numeroMatricule);

    List<Prestation> findByAdherentId(Long id);

    int deleteByAdherentId(Long id);


    /**
    * delete Prestation from database by reference (reference)
    *
    * @param reference - reference of Prestation to be deleted
    * @return 1 if Prestation deleted successfully
    */
    int deleteByReference(String reference);





}

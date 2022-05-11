package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.RendezVous;
import com.ird.faa.ws.rest.provided.vo.RendezVousVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface RendezVousChercheurService extends AbstractService<RendezVous,Long,RendezVousVo>{


    /**
    * find RendezVous from database by reference (reference)
    * @param reference - reference of RendezVous
    * @return the founded RendezVous , If no RendezVous were
    *         found in database return  null.
    */
    RendezVous findByReference(String reference);

    /**
    * find RendezVous from database by id (PK) or reference (reference)
    * @param id - id of RendezVous
    * @param reference - reference of RendezVous
    * @return the founded RendezVous , If no RendezVous were
    *         found in database return  null.
    */
    RendezVous findByIdOrReference(RendezVous rendezVous);


/**
    * delete RendezVous from database
    * @param id - id of RendezVous to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete RendezVous from database by reference (reference)
    *
    * @param reference - reference of RendezVous to be deleted
    * @return 1 if RendezVous deleted successfully
    */
    int deleteByReference(String reference);





}

package com.ird.faa.service.moderateur.facade;

import java.util.List;
import com.ird.faa.bean.DemandeEstivageCentre;
import com.ird.faa.ws.rest.provided.vo.DemandeEstivageCentreVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface DemandeEstivageCentreModerateurService extends AbstractService<DemandeEstivageCentre,Long,DemandeEstivageCentreVo>{


    /**
    * find DemandeEstivageCentre from database by reference (reference)
    * @param reference - reference of DemandeEstivageCentre
    * @return the founded DemandeEstivageCentre , If no DemandeEstivageCentre were
    *         found in database return  null.
    */
    DemandeEstivageCentre findByReference(String reference);

    /**
    * find DemandeEstivageCentre from database by id (PK) or reference (reference)
    * @param id - id of DemandeEstivageCentre
    * @param reference - reference of DemandeEstivageCentre
    * @return the founded DemandeEstivageCentre , If no DemandeEstivageCentre were
    *         found in database return  null.
    */
    DemandeEstivageCentre findByIdOrReference(DemandeEstivageCentre demandeEstivageCentre);


/**
    * delete DemandeEstivageCentre from database
    * @param id - id of DemandeEstivageCentre to be deleted
    *
    */
    int deleteById(Long id);


    List<DemandeEstivageCentre> findByDemandeEstivageReference(String reference);

    int deleteByDemandeEstivageReference(String reference);

    List<DemandeEstivageCentre> findByDemandeEstivageId(Long id);

    int deleteByDemandeEstivageId(Long id);

    List<DemandeEstivageCentre> findByCentreEstivageId(Long id);

    int deleteByCentreEstivageId(Long id);


    /**
    * delete DemandeEstivageCentre from database by reference (reference)
    *
    * @param reference - reference of DemandeEstivageCentre to be deleted
    * @return 1 if DemandeEstivageCentre deleted successfully
    */
    int deleteByReference(String reference);





}

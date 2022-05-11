package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.DemandeEstivage;
import com.ird.faa.ws.rest.provided.vo.DemandeEstivageVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface DemandeEstivageAdminService extends AbstractService<DemandeEstivage,Long,DemandeEstivageVo>{


    /**
    * find DemandeEstivage from database by reference (reference)
    * @param reference - reference of DemandeEstivage
    * @return the founded DemandeEstivage , If no DemandeEstivage were
    *         found in database return  null.
    */
    DemandeEstivage findByReference(String reference);

    /**
    * find DemandeEstivage from database by id (PK) or reference (reference)
    * @param id - id of DemandeEstivage
    * @param reference - reference of DemandeEstivage
    * @return the founded DemandeEstivage , If no DemandeEstivage were
    *         found in database return  null.
    */
    DemandeEstivage findByIdOrReference(DemandeEstivage demandeEstivage);


/**
    * delete DemandeEstivage from database
    * @param id - id of DemandeEstivage to be deleted
    *
    */
    int deleteById(Long id);


    List<DemandeEstivage> findByDemandeEstivageCentreReference(String reference);

    int deleteByDemandeEstivageCentreReference(String reference);

    List<DemandeEstivage> findByDemandeEstivageCentreId(Long id);

    int deleteByDemandeEstivageCentreId(Long id);
    List<DemandeEstivage> findByAdherentNumeroMatricule(String numeroMatricule);

    int deleteByAdherentNumeroMatricule(String numeroMatricule);

    List<DemandeEstivage> findByAdherentId(Long id);

    int deleteByAdherentId(Long id);
    List<DemandeEstivage> findByEtatDemandeEstivageReference(String reference);

    int deleteByEtatDemandeEstivageReference(String reference);

    List<DemandeEstivage> findByEtatDemandeEstivageId(Long id);

    int deleteByEtatDemandeEstivageId(Long id);
    List<DemandeEstivage> findByEstivageCentreEstivageReference(String reference);

    int deleteByEstivageCentreEstivageReference(String reference);

    List<DemandeEstivage> findByEstivageCentreEstivageId(Long id);

    int deleteByEstivageCentreEstivageId(Long id);


    /**
    * delete DemandeEstivage from database by reference (reference)
    *
    * @param reference - reference of DemandeEstivage to be deleted
    * @return 1 if DemandeEstivage deleted successfully
    */
    int deleteByReference(String reference);





}

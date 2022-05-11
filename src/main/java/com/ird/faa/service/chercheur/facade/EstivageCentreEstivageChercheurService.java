package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.EstivageCentreEstivage;
import com.ird.faa.ws.rest.provided.vo.EstivageCentreEstivageVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface EstivageCentreEstivageChercheurService extends AbstractService<EstivageCentreEstivage,Long,EstivageCentreEstivageVo>{


    /**
    * find EstivageCentreEstivage from database by reference (reference)
    * @param reference - reference of EstivageCentreEstivage
    * @return the founded EstivageCentreEstivage , If no EstivageCentreEstivage were
    *         found in database return  null.
    */
    EstivageCentreEstivage findByReference(String reference);

    /**
    * find EstivageCentreEstivage from database by id (PK) or reference (reference)
    * @param id - id of EstivageCentreEstivage
    * @param reference - reference of EstivageCentreEstivage
    * @return the founded EstivageCentreEstivage , If no EstivageCentreEstivage were
    *         found in database return  null.
    */
    EstivageCentreEstivage findByIdOrReference(EstivageCentreEstivage estivageCentreEstivage);


/**
    * delete EstivageCentreEstivage from database
    * @param id - id of EstivageCentreEstivage to be deleted
    *
    */
    int deleteById(Long id);



    List<EstivageCentreEstivage> findByCentreEstivageId(Long id);

    int deleteByCentreEstivageId(Long id);
    List<EstivageCentreEstivage> findByEstivageReference(String reference);

    int deleteByEstivageReference(String reference);

    List<EstivageCentreEstivage> findByEstivageId(Long id);

    int deleteByEstivageId(Long id);


    /**
    * delete EstivageCentreEstivage from database by reference (reference)
    *
    * @param reference - reference of EstivageCentreEstivage to be deleted
    * @return 1 if EstivageCentreEstivage deleted successfully
    */
    int deleteByReference(String reference);





}

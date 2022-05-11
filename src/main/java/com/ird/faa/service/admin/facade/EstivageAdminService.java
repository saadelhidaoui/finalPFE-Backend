package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.Estivage;
import com.ird.faa.ws.rest.provided.vo.EstivageVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface EstivageAdminService extends AbstractService<Estivage,Long,EstivageVo>{


    /**
    * find Estivage from database by reference (reference)
    * @param reference - reference of Estivage
    * @return the founded Estivage , If no Estivage were
    *         found in database return  null.
    */
    Estivage findByReference(String reference);

    /**
    * find Estivage from database by id (PK) or reference (reference)
    * @param id - id of Estivage
    * @param reference - reference of Estivage
    * @return the founded Estivage , If no Estivage were
    *         found in database return  null.
    */
    Estivage findByIdOrReference(Estivage estivage);


/**
    * delete Estivage from database
    * @param id - id of Estivage to be deleted
    *
    */
    int deleteById(Long id);



    List<Estivage> findByCentreEstivageId(Long id);

    int deleteByCentreEstivageId(Long id);
    List<Estivage> findByNiveauImportanceReference(String reference);

    int deleteByNiveauImportanceReference(String reference);

    List<Estivage> findByNiveauImportanceId(Long id);

    int deleteByNiveauImportanceId(Long id);


    /**
    * delete Estivage from database by reference (reference)
    *
    * @param reference - reference of Estivage to be deleted
    * @return 1 if Estivage deleted successfully
    */
    int deleteByReference(String reference);




    Estivage archiver(Estivage estivage) ;
    Estivage desarchiver(Estivage estivage);

}

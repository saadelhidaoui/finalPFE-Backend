package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.Fonction;
import com.ird.faa.ws.rest.provided.vo.FonctionVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface FonctionAdminService extends AbstractService<Fonction,Long,FonctionVo>{


    /**
    * find Fonction from database by reference (reference)
    * @param reference - reference of Fonction
    * @return the founded Fonction , If no Fonction were
    *         found in database return  null.
    */
    Fonction findByReference(String reference);

    /**
    * find Fonction from database by id (PK) or reference (reference)
    * @param id - id of Fonction
    * @param reference - reference of Fonction
    * @return the founded Fonction , If no Fonction were
    *         found in database return  null.
    */
    Fonction findByIdOrReference(Fonction fonction);


/**
    * delete Fonction from database
    * @param id - id of Fonction to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete Fonction from database by reference (reference)
    *
    * @param reference - reference of Fonction to be deleted
    * @return 1 if Fonction deleted successfully
    */
    int deleteByReference(String reference);





}

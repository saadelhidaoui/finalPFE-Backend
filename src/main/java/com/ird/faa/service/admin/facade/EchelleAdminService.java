package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.Echelle;
import com.ird.faa.ws.rest.provided.vo.EchelleVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface EchelleAdminService extends AbstractService<Echelle,Long,EchelleVo>{


    /**
    * find Echelle from database by reference (reference)
    * @param reference - reference of Echelle
    * @return the founded Echelle , If no Echelle were
    *         found in database return  null.
    */
    Echelle findByReference(String reference);

    /**
    * find Echelle from database by id (PK) or reference (reference)
    * @param id - id of Echelle
    * @param reference - reference of Echelle
    * @return the founded Echelle , If no Echelle were
    *         found in database return  null.
    */
    Echelle findByIdOrReference(Echelle echelle);


/**
    * delete Echelle from database
    * @param id - id of Echelle to be deleted
    *
    */
    int deleteById(Long id);


    List<Echelle> findByEchelonReference(String reference);

    int deleteByEchelonReference(String reference);

    List<Echelle> findByEchelonId(Long id);

    int deleteByEchelonId(Long id);


    /**
    * delete Echelle from database by reference (reference)
    *
    * @param reference - reference of Echelle to be deleted
    * @return 1 if Echelle deleted successfully
    */
    int deleteByReference(String reference);





}

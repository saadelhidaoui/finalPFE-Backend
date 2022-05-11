package com.ird.faa.service.adherent.facade;

import java.util.List;
import com.ird.faa.bean.Enfant;
import com.ird.faa.ws.rest.provided.vo.EnfantVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface EnfantAdherentService extends AbstractService<Enfant,Long,EnfantVo>{


    /**
    * find Enfant from database by reference (reference)
    * @param reference - reference of Enfant
    * @return the founded Enfant , If no Enfant were
    *         found in database return  null.
    */
    Enfant findByReference(String reference);

    /**
    * find Enfant from database by id (PK) or reference (reference)
    * @param id - id of Enfant
    * @param reference - reference of Enfant
    * @return the founded Enfant , If no Enfant were
    *         found in database return  null.
    */
    Enfant findByIdOrReference(Enfant enfant);


/**
    * delete Enfant from database
    * @param id - id of Enfant to be deleted
    *
    */
    int deleteById(Long id);


    List<Enfant> findByQualiteReference(String reference);

    int deleteByQualiteReference(String reference);

    List<Enfant> findByQualiteId(Long id);

    int deleteByQualiteId(Long id);
    List<Enfant> findByAdherentNumeroMatricule(String numeroMatricule);

    int deleteByAdherentNumeroMatricule(String numeroMatricule);

    List<Enfant> findByAdherentId(Long id);

    int deleteByAdherentId(Long id);


    /**
    * delete Enfant from database by reference (reference)
    *
    * @param reference - reference of Enfant to be deleted
    * @return 1 if Enfant deleted successfully
    */
    int deleteByReference(String reference);




    Enfant archiver(Enfant enfant) ;
    Enfant desarchiver(Enfant enfant);

}

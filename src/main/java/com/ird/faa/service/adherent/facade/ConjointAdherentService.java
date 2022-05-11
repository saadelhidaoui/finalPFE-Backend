package com.ird.faa.service.adherent.facade;

import java.util.List;
import com.ird.faa.bean.Conjoint;
import com.ird.faa.ws.rest.provided.vo.ConjointVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface ConjointAdherentService extends AbstractService<Conjoint,Long,ConjointVo>{


    /**
    * find Conjoint from database by cin (reference)
    * @param cin - reference of Conjoint
    * @return the founded Conjoint , If no Conjoint were
    *         found in database return  null.
    */
    Conjoint findByCin(String cin);

    /**
    * find Conjoint from database by id (PK) or cin (reference)
    * @param id - id of Conjoint
    * @param cin - reference of Conjoint
    * @return the founded Conjoint , If no Conjoint were
    *         found in database return  null.
    */
    Conjoint findByIdOrCin(Conjoint conjoint);


/**
    * delete Conjoint from database
    * @param id - id of Conjoint to be deleted
    *
    */
    int deleteById(Long id);


    List<Conjoint> findByQualiteReference(String reference);

    int deleteByQualiteReference(String reference);

    List<Conjoint> findByQualiteId(Long id);

    int deleteByQualiteId(Long id);
    List<Conjoint> findByAdherentNumeroMatricule(String numeroMatricule);

    int deleteByAdherentNumeroMatricule(String numeroMatricule);

    List<Conjoint> findByAdherentId(Long id);

    int deleteByAdherentId(Long id);


    /**
    * delete Conjoint from database by cin (reference)
    *
    * @param cin - reference of Conjoint to be deleted
    * @return 1 if Conjoint deleted successfully
    */
    int deleteByCin(String cin);





}

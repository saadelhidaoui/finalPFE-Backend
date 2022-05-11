package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.Tache;
import com.ird.faa.ws.rest.provided.vo.TacheVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface TacheAdminService extends AbstractService<Tache,Long,TacheVo>{


    /**
    * find Tache from database by reference (reference)
    * @param reference - reference of Tache
    * @return the founded Tache , If no Tache were
    *         found in database return  null.
    */
    Tache findByReference(String reference);

    /**
    * find Tache from database by id (PK) or reference (reference)
    * @param id - id of Tache
    * @param reference - reference of Tache
    * @return the founded Tache , If no Tache were
    *         found in database return  null.
    */
    Tache findByIdOrReference(Tache tache);


/**
    * delete Tache from database
    * @param id - id of Tache to be deleted
    *
    */
    int deleteById(Long id);


    List<Tache> findByEtatTacheReference(String reference);

    int deleteByEtatTacheReference(String reference);

    List<Tache> findByEtatTacheId(Long id);

    int deleteByEtatTacheId(Long id);
    List<Tache> findByModerateurNumeroMatricule(String numeroMatricule);

    int deleteByModerateurNumeroMatricule(String numeroMatricule);

    List<Tache> findByModerateurId(Long id);

    int deleteByModerateurId(Long id);


    /**
    * delete Tache from database by reference (reference)
    *
    * @param reference - reference of Tache to be deleted
    * @return 1 if Tache deleted successfully
    */
    int deleteByReference(String reference);





}

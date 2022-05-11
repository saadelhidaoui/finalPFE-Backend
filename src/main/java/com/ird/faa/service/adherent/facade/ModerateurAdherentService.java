package com.ird.faa.service.adherent.facade;

import java.util.List;
import com.ird.faa.bean.Moderateur;
import com.ird.faa.ws.rest.provided.vo.ModerateurVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface ModerateurAdherentService extends AbstractService<Moderateur,Long,ModerateurVo>{

    Moderateur findByUsername(String username);

    /**
    * find Moderateur from database by numeroMatricule (reference)
    * @param numeroMatricule - reference of Moderateur
    * @return the founded Moderateur , If no Moderateur were
    *         found in database return  null.
    */
    Moderateur findByNumeroMatricule(String numeroMatricule);

    /**
    * find Moderateur from database by id (PK) or numeroMatricule (reference)
    * @param id - id of Moderateur
    * @param numeroMatricule - reference of Moderateur
    * @return the founded Moderateur , If no Moderateur were
    *         found in database return  null.
    */
    Moderateur findByIdOrNumeroMatricule(Moderateur moderateur);


/**
    * delete Moderateur from database
    * @param id - id of Moderateur to be deleted
    *
    */
    int deleteById(Long id);


    List<Moderateur> findBySituationModerateurReference(String reference);

    int deleteBySituationModerateurReference(String reference);

    List<Moderateur> findBySituationModerateurId(Long id);

    int deleteBySituationModerateurId(Long id);
    List<Moderateur> findByProfilReference(String reference);

    int deleteByProfilReference(String reference);

    List<Moderateur> findByProfilId(Long id);

    int deleteByProfilId(Long id);


    /**
    * delete Moderateur from database by numeroMatricule (reference)
    *
    * @param numeroMatricule - reference of Moderateur to be deleted
    * @return 1 if Moderateur deleted successfully
    */
    int deleteByNumeroMatricule(String numeroMatricule);





}

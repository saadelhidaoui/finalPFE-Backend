package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.Adherent;
import com.ird.faa.ws.rest.provided.vo.AdherentVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface AdherentChercheurService extends AbstractService<Adherent,Long,AdherentVo>{

    Adherent findByUsername(String username);

    /**
    * find Adherent from database by numeroMatricule (reference)
    * @param numeroMatricule - reference of Adherent
    * @return the founded Adherent , If no Adherent were
    *         found in database return  null.
    */
    Adherent findByNumeroMatricule(String numeroMatricule);

    /**
    * find Adherent from database by id (PK) or numeroMatricule (reference)
    * @param id - id of Adherent
    * @param numeroMatricule - reference of Adherent
    * @return the founded Adherent , If no Adherent were
    *         found in database return  null.
    */
    Adherent findByIdOrNumeroMatricule(Adherent adherent);


/**
    * delete Adherent from database
    * @param id - id of Adherent to be deleted
    *
    */
    int deleteById(Long id);



    List<Adherent> findByVilleId(Long id);

    int deleteByVilleId(Long id);
    List<Adherent> findByQualiteReference(String reference);

    int deleteByQualiteReference(String reference);

    List<Adherent> findByQualiteId(Long id);

    int deleteByQualiteId(Long id);
    List<Adherent> findByEtatCarteReference(String reference);

    int deleteByEtatCarteReference(String reference);

    List<Adherent> findByEtatCarteId(Long id);

    int deleteByEtatCarteId(Long id);
    List<Adherent> findByStatutReference(String reference);

    int deleteByStatutReference(String reference);

    List<Adherent> findByStatutId(Long id);

    int deleteByStatutId(Long id);
    List<Adherent> findByFonctionReference(String reference);

    int deleteByFonctionReference(String reference);

    List<Adherent> findByFonctionId(Long id);

    int deleteByFonctionId(Long id);


    /**
    * delete Adherent from database by numeroMatricule (reference)
    *
    * @param numeroMatricule - reference of Adherent to be deleted
    * @return 1 if Adherent deleted successfully
    */
    int deleteByNumeroMatricule(String numeroMatricule);





}

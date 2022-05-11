package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.Projet;
import com.ird.faa.ws.rest.provided.vo.ProjetVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface ProjetChercheurService extends AbstractService<Projet,Long,ProjetVo>{


    /**
    * find Projet from database by reference (reference)
    * @param reference - reference of Projet
    * @return the founded Projet , If no Projet were
    *         found in database return  null.
    */
    Projet findByReference(String reference);

    /**
    * find Projet from database by id (PK) or reference (reference)
    * @param id - id of Projet
    * @param reference - reference of Projet
    * @return the founded Projet , If no Projet were
    *         found in database return  null.
    */
    Projet findByIdOrReference(Projet projet);


/**
    * delete Projet from database
    * @param id - id of Projet to be deleted
    *
    */
    int deleteById(Long id);


    List<Projet> findByEtatProjetCode(String code);

    int deleteByEtatProjetCode(String code);

    List<Projet> findByEtatProjetId(Long id);

    int deleteByEtatProjetId(Long id);


    /**
    * delete Projet from database by reference (reference)
    *
    * @param reference - reference of Projet to be deleted
    * @return 1 if Projet deleted successfully
    */
    int deleteByReference(String reference);





}

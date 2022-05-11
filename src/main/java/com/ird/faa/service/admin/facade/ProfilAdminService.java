package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.Profil;
import com.ird.faa.ws.rest.provided.vo.ProfilVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface ProfilAdminService extends AbstractService<Profil,Long,ProfilVo>{


    /**
    * find Profil from database by reference (reference)
    * @param reference - reference of Profil
    * @return the founded Profil , If no Profil were
    *         found in database return  null.
    */
    Profil findByReference(String reference);

    /**
    * find Profil from database by id (PK) or reference (reference)
    * @param id - id of Profil
    * @param reference - reference of Profil
    * @return the founded Profil , If no Profil were
    *         found in database return  null.
    */
    Profil findByIdOrReference(Profil profil);


/**
    * delete Profil from database
    * @param id - id of Profil to be deleted
    *
    */
    int deleteById(Long id);


    List<Profil> findByGradeReference(String reference);

    int deleteByGradeReference(String reference);

    List<Profil> findByGradeId(Long id);

    int deleteByGradeId(Long id);
    List<Profil> findByEchelleReference(String reference);

    int deleteByEchelleReference(String reference);

    List<Profil> findByEchelleId(Long id);

    int deleteByEchelleId(Long id);


    /**
    * delete Profil from database by reference (reference)
    *
    * @param reference - reference of Profil to be deleted
    * @return 1 if Profil deleted successfully
    */
    int deleteByReference(String reference);





}

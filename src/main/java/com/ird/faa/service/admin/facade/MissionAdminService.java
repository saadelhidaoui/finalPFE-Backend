package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.Mission;
import com.ird.faa.ws.rest.provided.vo.MissionVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface MissionAdminService extends AbstractService<Mission,Long,MissionVo>{


    /**
    * find Mission from database by reference (reference)
    * @param reference - reference of Mission
    * @return the founded Mission , If no Mission were
    *         found in database return  null.
    */
    Mission findByReference(String reference);

    /**
    * find Mission from database by id (PK) or reference (reference)
    * @param id - id of Mission
    * @param reference - reference of Mission
    * @return the founded Mission , If no Mission were
    *         found in database return  null.
    */
    Mission findByIdOrReference(Mission mission);


/**
    * delete Mission from database
    * @param id - id of Mission to be deleted
    *
    */
    int deleteById(Long id);



    List<Mission> findByVilleId(Long id);

    int deleteByVilleId(Long id);
    List<Mission> findByModerateurNumeroMatricule(String numeroMatricule);

    int deleteByModerateurNumeroMatricule(String numeroMatricule);

    List<Mission> findByModerateurId(Long id);

    int deleteByModerateurId(Long id);


    /**
    * delete Mission from database by reference (reference)
    *
    * @param reference - reference of Mission to be deleted
    * @return 1 if Mission deleted successfully
    */
    int deleteByReference(String reference);




    Mission archiver(Mission mission) ;
    Mission desarchiver(Mission mission);

}

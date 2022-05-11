package com.ird.faa.service.adherent.facade;

import java.util.List;
import com.ird.faa.bean.ImpressionCarte;
import com.ird.faa.ws.rest.provided.vo.ImpressionCarteVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface ImpressionCarteAdherentService extends AbstractService<ImpressionCarte,Long,ImpressionCarteVo>{


    /**
    * find ImpressionCarte from database by aff (reference)
    * @param aff - reference of ImpressionCarte
    * @return the founded ImpressionCarte , If no ImpressionCarte were
    *         found in database return  null.
    */
    ImpressionCarte findByAff(String aff);

    /**
    * find ImpressionCarte from database by id (PK) or aff (reference)
    * @param id - id of ImpressionCarte
    * @param aff - reference of ImpressionCarte
    * @return the founded ImpressionCarte , If no ImpressionCarte were
    *         found in database return  null.
    */
    ImpressionCarte findByIdOrAff(ImpressionCarte impressionCarte);


/**
    * delete ImpressionCarte from database
    * @param id - id of ImpressionCarte to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete ImpressionCarte from database by aff (reference)
    *
    * @param aff - reference of ImpressionCarte to be deleted
    * @return 1 if ImpressionCarte deleted successfully
    */
    int deleteByAff(String aff);





}

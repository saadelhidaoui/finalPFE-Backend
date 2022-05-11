package com.ird.faa.service.adherent.facade;

import java.util.List;
import com.ird.faa.bean.Region;
import com.ird.faa.ws.rest.provided.vo.RegionVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface RegionAdherentService extends AbstractService<Region,Long,RegionVo>{




/**
    * delete Region from database
    * @param id - id of Region to be deleted
    *
    */
    int deleteById(Long id);









}

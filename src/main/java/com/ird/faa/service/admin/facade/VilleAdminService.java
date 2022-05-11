package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.Ville;
import com.ird.faa.ws.rest.provided.vo.VilleVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface VilleAdminService extends AbstractService<Ville,Long,VilleVo>{




/**
    * delete Ville from database
    * @param id - id of Ville to be deleted
    *
    */
    int deleteById(Long id);



    List<Ville> findByRegionId(Long id);

    int deleteByRegionId(Long id);







}

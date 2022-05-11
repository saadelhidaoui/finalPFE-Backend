package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.CentreEstivage;
import com.ird.faa.ws.rest.provided.vo.CentreEstivageVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface CentreEstivageAdminService extends AbstractService<CentreEstivage,Long,CentreEstivageVo>{




/**
    * delete CentreEstivage from database
    * @param id - id of CentreEstivage to be deleted
    *
    */
    int deleteById(Long id);



    List<CentreEstivage> findByVilleId(Long id);

    int deleteByVilleId(Long id);







}

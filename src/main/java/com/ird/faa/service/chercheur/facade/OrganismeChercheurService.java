package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.Organisme;
import com.ird.faa.ws.rest.provided.vo.OrganismeVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface OrganismeChercheurService extends AbstractService<Organisme,Long,OrganismeVo>{




/**
    * delete Organisme from database
    * @param id - id of Organisme to be deleted
    *
    */
    int deleteById(Long id);



    List<Organisme> findByVilleId(Long id);

    int deleteByVilleId(Long id);







}

package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.PieceJointeConvention;
import com.ird.faa.ws.rest.provided.vo.PieceJointeConventionVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface PieceJointeConventionChercheurService extends AbstractService<PieceJointeConvention,Long,PieceJointeConventionVo>{




/**
    * delete PieceJointeConvention from database
    * @param id - id of PieceJointeConvention to be deleted
    *
    */
    int deleteById(Long id);


    List<PieceJointeConvention> findByConventionReference(String reference);

    int deleteByConventionReference(String reference);

    List<PieceJointeConvention> findByConventionId(Long id);

    int deleteByConventionId(Long id);







}

package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.PieceJointeProduit;
import com.ird.faa.ws.rest.provided.vo.PieceJointeProduitVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface PieceJointeProduitChercheurService extends AbstractService<PieceJointeProduit,Long,PieceJointeProduitVo>{




/**
    * delete PieceJointeProduit from database
    * @param id - id of PieceJointeProduit to be deleted
    *
    */
    int deleteById(Long id);


    List<PieceJointeProduit> findByProduitReference(String reference);

    int deleteByProduitReference(String reference);

    List<PieceJointeProduit> findByProduitId(Long id);

    int deleteByProduitId(Long id);







}

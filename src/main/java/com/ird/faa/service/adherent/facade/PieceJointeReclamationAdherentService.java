package com.ird.faa.service.adherent.facade;

import java.util.List;
import com.ird.faa.bean.PieceJointeReclamation;
import com.ird.faa.ws.rest.provided.vo.PieceJointeReclamationVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface PieceJointeReclamationAdherentService extends AbstractService<PieceJointeReclamation,Long,PieceJointeReclamationVo>{




/**
    * delete PieceJointeReclamation from database
    * @param id - id of PieceJointeReclamation to be deleted
    *
    */
    int deleteById(Long id);


    List<PieceJointeReclamation> findByReclamationReference(String reference);

    int deleteByReclamationReference(String reference);

    List<PieceJointeReclamation> findByReclamationId(Long id);

    int deleteByReclamationId(Long id);






    PieceJointeReclamation archiver(PieceJointeReclamation pieceJointeReclamation) ;
    PieceJointeReclamation desarchiver(PieceJointeReclamation pieceJointeReclamation);

}

package com.ird.faa.service.moderateur.facade;

import java.util.List;
import com.ird.faa.bean.PieceJointeProjet;
import com.ird.faa.ws.rest.provided.vo.PieceJointeProjetVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface PieceJointeProjetModerateurService extends AbstractService<PieceJointeProjet,Long,PieceJointeProjetVo>{




/**
    * delete PieceJointeProjet from database
    * @param id - id of PieceJointeProjet to be deleted
    *
    */
    int deleteById(Long id);


    List<PieceJointeProjet> findByProjetReference(String reference);

    int deleteByProjetReference(String reference);

    List<PieceJointeProjet> findByProjetId(Long id);

    int deleteByProjetId(Long id);






    PieceJointeProjet archiver(PieceJointeProjet pieceJointeProjet) ;
    PieceJointeProjet desarchiver(PieceJointeProjet pieceJointeProjet);

}

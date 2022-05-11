package com.ird.faa.service.moderateur.facade;

import java.util.List;
import com.ird.faa.bean.PieceJointeAdherent;
import com.ird.faa.ws.rest.provided.vo.PieceJointeAdherentVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface PieceJointeAdherentModerateurService extends AbstractService<PieceJointeAdherent,Long,PieceJointeAdherentVo>{




/**
    * delete PieceJointeAdherent from database
    * @param id - id of PieceJointeAdherent to be deleted
    *
    */
    int deleteById(Long id);


    List<PieceJointeAdherent> findByAdherentNumeroMatricule(String numeroMatricule);

    int deleteByAdherentNumeroMatricule(String numeroMatricule);

    List<PieceJointeAdherent> findByAdherentId(Long id);

    int deleteByAdherentId(Long id);






    PieceJointeAdherent archiver(PieceJointeAdherent pieceJointeAdherent) ;
    PieceJointeAdherent desarchiver(PieceJointeAdherent pieceJointeAdherent);

}

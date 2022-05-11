package com.ird.faa.service.moderateur.facade;

import java.util.List;
import com.ird.faa.bean.PieceJointeEstivage;
import com.ird.faa.ws.rest.provided.vo.PieceJointeEstivageVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface PieceJointeEstivageModerateurService extends AbstractService<PieceJointeEstivage,Long,PieceJointeEstivageVo>{




/**
    * delete PieceJointeEstivage from database
    * @param id - id of PieceJointeEstivage to be deleted
    *
    */
    int deleteById(Long id);


    List<PieceJointeEstivage> findByEstivageReference(String reference);

    int deleteByEstivageReference(String reference);

    List<PieceJointeEstivage> findByEstivageId(Long id);

    int deleteByEstivageId(Long id);






    PieceJointeEstivage archiver(PieceJointeEstivage pieceJointeEstivage) ;
    PieceJointeEstivage desarchiver(PieceJointeEstivage pieceJointeEstivage);

    int deleteByDemandeEstivageId(Long id);

    List<PieceJointeEstivage> findByDemandeEstivageId(Long id);
}

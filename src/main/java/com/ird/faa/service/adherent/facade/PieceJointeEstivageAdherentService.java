package com.ird.faa.service.adherent.facade;

import java.util.List;
import com.ird.faa.bean.PieceJointeEstivage;
import com.ird.faa.ws.rest.provided.vo.PieceJointeEstivageVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface PieceJointeEstivageAdherentService extends AbstractService<PieceJointeEstivage,Long,PieceJointeEstivageVo>{




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

    List<PieceJointeEstivage> findByDemandeEstivageId(Long id);

    int deleteByDemandeEstivageId(Long id);
}

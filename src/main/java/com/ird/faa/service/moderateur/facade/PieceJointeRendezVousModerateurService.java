package com.ird.faa.service.moderateur.facade;

import java.io.IOException;
import java.util.List;
import com.ird.faa.bean.PieceJointeRendezVous;
import com.ird.faa.ws.rest.provided.vo.PieceJointeRendezVousVo;
import com.ird.faa.service.core.facade.AbstractService;
import org.springframework.web.multipart.MultipartFile;

public interface PieceJointeRendezVousModerateurService extends AbstractService<PieceJointeRendezVous,Long,PieceJointeRendezVousVo>{




/**
    * delete PieceJointeRendezVous from database
    * @param id - id of PieceJointeRendezVous to be deleted
    *
    */
    int deleteById(Long id);


    List<PieceJointeRendezVous> findByRendezVousReference(String reference);

    int deleteByRendezVousReference(String reference);

    List<PieceJointeRendezVous> findByRendezVousId(Long id);

    int deleteByRendezVousId(Long id);






    PieceJointeRendezVous archiver(PieceJointeRendezVous pieceJointeRendezVous) ;
    PieceJointeRendezVous desarchiver(PieceJointeRendezVous pieceJointeRendezVous);

    void uploadFile(MultipartFile file, String reference) throws IOException;

    PieceJointeRendezVous getFile(Long id);
}

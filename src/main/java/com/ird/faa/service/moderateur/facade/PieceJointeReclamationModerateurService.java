package com.ird.faa.service.moderateur.facade;

import java.io.IOException;
import java.util.List;
import com.ird.faa.bean.PieceJointeReclamation;
import com.ird.faa.ws.rest.provided.vo.PieceJointeReclamationVo;
import com.ird.faa.service.core.facade.AbstractService;
import org.springframework.web.multipart.MultipartFile;

public interface PieceJointeReclamationModerateurService extends AbstractService<PieceJointeReclamation,Long,PieceJointeReclamationVo>{




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

    void uploadFile(MultipartFile file, String reference) throws IOException;

    PieceJointeReclamation getFile(Long id);
}

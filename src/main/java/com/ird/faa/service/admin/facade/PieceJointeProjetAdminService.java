package com.ird.faa.service.admin.facade;

import java.io.IOException;
import java.util.List;
import com.ird.faa.bean.PieceJointeProjet;
import com.ird.faa.ws.rest.provided.vo.PieceJointeProjetVo;
import com.ird.faa.service.core.facade.AbstractService;
import org.springframework.web.multipart.MultipartFile;

public interface PieceJointeProjetAdminService extends AbstractService<PieceJointeProjet,Long,PieceJointeProjetVo>{




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

    void uploadFile(MultipartFile file, String projetRef) throws IOException;


    PieceJointeProjet getFile(Long id);
}

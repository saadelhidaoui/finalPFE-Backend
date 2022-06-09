package com.ird.faa.service.admin.facade;

import java.io.IOException;
import java.util.List;
import com.ird.faa.bean.PieceJointeConvention;
import com.ird.faa.bean.Projet;
import com.ird.faa.ws.rest.provided.vo.PieceJointeConventionVo;
import com.ird.faa.service.core.facade.AbstractService;
import org.springframework.web.multipart.MultipartFile;

public interface PieceJointeConventionAdminService extends AbstractService<PieceJointeConvention,Long,PieceJointeConventionVo>{




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






    PieceJointeConvention archiver(PieceJointeConvention pieceJointeConvention) ;
    PieceJointeConvention desarchiver(PieceJointeConvention pieceJointeConvention);

    Projet findByReference(String reference);

    void uploadFile(MultipartFile file, String reference) throws IOException;

    PieceJointeConvention getFile(Long id);
}

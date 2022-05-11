package com.ird.faa.service.moderateur.facade;

import java.util.List;
import com.ird.faa.bean.PieceJointeMission;
import com.ird.faa.ws.rest.provided.vo.PieceJointeMissionVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface PieceJointeMissionModerateurService extends AbstractService<PieceJointeMission,Long,PieceJointeMissionVo>{




/**
    * delete PieceJointeMission from database
    * @param id - id of PieceJointeMission to be deleted
    *
    */
    int deleteById(Long id);


    List<PieceJointeMission> findByMissionReference(String reference);

    int deleteByMissionReference(String reference);

    List<PieceJointeMission> findByMissionId(Long id);

    int deleteByMissionId(Long id);






    PieceJointeMission archiver(PieceJointeMission pieceJointeMission) ;
    PieceJointeMission desarchiver(PieceJointeMission pieceJointeMission);

}

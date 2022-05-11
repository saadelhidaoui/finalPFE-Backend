package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.PieceJointeMission;


@Repository
public interface PieceJointeMissionDao extends JpaRepository<PieceJointeMission,Long> {





    List<PieceJointeMission> findByMissionReference(String reference);
    int deleteByMissionReference(String reference);

    List<PieceJointeMission> findByMissionId(Long id);

    int deleteByMissionId(Long id);


}

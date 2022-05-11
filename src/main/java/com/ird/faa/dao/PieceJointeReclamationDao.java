package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.PieceJointeReclamation;


@Repository
public interface PieceJointeReclamationDao extends JpaRepository<PieceJointeReclamation,Long> {





    List<PieceJointeReclamation> findByReclamationReference(String reference);
    int deleteByReclamationReference(String reference);

    List<PieceJointeReclamation> findByReclamationId(Long id);

    int deleteByReclamationId(Long id);


}

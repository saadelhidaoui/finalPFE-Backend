package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.PieceJointeConvention;


@Repository
public interface PieceJointeConventionDao extends JpaRepository<PieceJointeConvention,Long> {





    List<PieceJointeConvention> findByConventionReference(String reference);
    int deleteByConventionReference(String reference);

    List<PieceJointeConvention> findByConventionId(Long id);

    int deleteByConventionId(Long id);


}

package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.PieceJointePrestation;


@Repository
public interface PieceJointePrestationDao extends JpaRepository<PieceJointePrestation,Long> {





    List<PieceJointePrestation> findByPrestationReference(String reference);
    int deleteByPrestationReference(String reference);

    List<PieceJointePrestation> findByPrestationId(Long id);

    int deleteByPrestationId(Long id);


}

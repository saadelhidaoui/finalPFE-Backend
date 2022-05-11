package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.PieceJointeProduit;


@Repository
public interface PieceJointeProduitDao extends JpaRepository<PieceJointeProduit,Long> {





    List<PieceJointeProduit> findByProduitReference(String reference);
    int deleteByProduitReference(String reference);

    List<PieceJointeProduit> findByProduitId(Long id);

    int deleteByProduitId(Long id);


}

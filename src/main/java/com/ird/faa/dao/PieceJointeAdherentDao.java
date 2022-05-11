package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.PieceJointeAdherent;


@Repository
public interface PieceJointeAdherentDao extends JpaRepository<PieceJointeAdherent,Long> {





    List<PieceJointeAdherent> findByAdherentNumeroMatricule(String numeroMatricule);
    int deleteByAdherentNumeroMatricule(String numeroMatricule);

    List<PieceJointeAdherent> findByAdherentId(Long id);

    int deleteByAdherentId(Long id);


}

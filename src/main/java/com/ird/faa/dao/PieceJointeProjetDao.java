package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.PieceJointeProjet;


@Repository
public interface PieceJointeProjetDao extends JpaRepository<PieceJointeProjet,Long> {





    List<PieceJointeProjet> findByProjetReference(String reference);
    int deleteByProjetReference(String reference);

    List<PieceJointeProjet> findByProjetId(Long id);

    int deleteByProjetId(Long id);


}

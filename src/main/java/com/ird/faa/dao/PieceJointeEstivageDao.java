package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.PieceJointeEstivage;


@Repository
public interface PieceJointeEstivageDao extends JpaRepository<PieceJointeEstivage,Long> {





    List<PieceJointeEstivage> findByEstivageReference(String reference);
    int deleteByEstivageReference(String reference);

    List<PieceJointeEstivage> findByEstivageId(Long id);

    int deleteByEstivageId(Long id);


}

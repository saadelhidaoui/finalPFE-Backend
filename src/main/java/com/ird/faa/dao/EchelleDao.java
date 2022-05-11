package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Echelle;


@Repository
public interface EchelleDao extends JpaRepository<Echelle,Long> {




    Echelle findByReference(String reference);

    int deleteByReference(String reference);

    List<Echelle> findByEchelonReference(String reference);
    int deleteByEchelonReference(String reference);

    List<Echelle> findByEchelonId(Long id);

    int deleteByEchelonId(Long id);


}

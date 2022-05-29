package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Qualite;


@Repository
public interface QualiteDao extends JpaRepository<Qualite,Long> {




    Qualite findByReference(String reference);

    int deleteByReference(String reference);

    Qualite findByLibelle(String libelle);


}

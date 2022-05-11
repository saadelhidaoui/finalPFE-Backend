package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.EtatProjet;


@Repository
public interface EtatProjetDao extends JpaRepository<EtatProjet,Long> {




    EtatProjet findByCode(String code);

    int deleteByCode(String code);



}

package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.EtatCarte;


@Repository
public interface EtatCarteDao extends JpaRepository<EtatCarte,Long> {




    EtatCarte findByReference(String reference);

    int deleteByReference(String reference);



}

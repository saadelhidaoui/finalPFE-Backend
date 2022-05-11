package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Fonction;


@Repository
public interface FonctionDao extends JpaRepository<Fonction,Long> {




    Fonction findByReference(String reference);

    int deleteByReference(String reference);



}

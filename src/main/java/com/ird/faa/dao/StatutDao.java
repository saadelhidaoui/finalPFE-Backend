package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Statut;


@Repository
public interface StatutDao extends JpaRepository<Statut,Long> {




    Statut findByReference(String reference);

    int deleteByReference(String reference);



}

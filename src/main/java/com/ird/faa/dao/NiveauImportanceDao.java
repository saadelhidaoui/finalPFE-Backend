package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.NiveauImportance;


@Repository
public interface NiveauImportanceDao extends JpaRepository<NiveauImportance,Long> {




    NiveauImportance findByReference(String reference);

    int deleteByReference(String reference);



}

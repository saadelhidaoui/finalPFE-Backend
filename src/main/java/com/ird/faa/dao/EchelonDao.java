package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Echelon;


@Repository
public interface EchelonDao extends JpaRepository<Echelon,Long> {




    Echelon findByReference(String reference);

    int deleteByReference(String reference);



}

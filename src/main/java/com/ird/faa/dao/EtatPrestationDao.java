package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.EtatPrestation;


@Repository
public interface EtatPrestationDao extends JpaRepository<EtatPrestation,Long> {




    EtatPrestation findByReference(String reference);

    int deleteByReference(String reference);



}

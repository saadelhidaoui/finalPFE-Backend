package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.TypePrestation;


@Repository
public interface TypePrestationDao extends JpaRepository<TypePrestation,Long> {




    TypePrestation findByReference(String reference);

    int deleteByReference(String reference);



}

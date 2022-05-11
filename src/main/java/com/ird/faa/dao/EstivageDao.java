package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Estivage;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface EstivageDao extends JpaRepository<Estivage,Long> {



    @Query("SELECT item FROM Estivage item ORDER BY item.dateEnvoi ASC")
    List<Estivage> findAll();

    Estivage findByReference(String reference);

    int deleteByReference(String reference);


    List<Estivage> findByCentreEstivageId(Long id);

    int deleteByCentreEstivageId(Long id);
    List<Estivage> findByNiveauImportanceReference(String reference);
    int deleteByNiveauImportanceReference(String reference);

    List<Estivage> findByNiveauImportanceId(Long id);

    int deleteByNiveauImportanceId(Long id);


}

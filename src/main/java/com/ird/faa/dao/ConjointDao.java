package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Conjoint;


@Repository
public interface ConjointDao extends JpaRepository<Conjoint,Long> {




    Conjoint findByCin(String cin);

    int deleteByCin(String cin);

    List<Conjoint> findByQualiteReference(String reference);
    int deleteByQualiteReference(String reference);

    List<Conjoint> findByQualiteId(Long id);

    int deleteByQualiteId(Long id);
    List<Conjoint> findByAdherentNumeroMatricule(String numeroMatricule);
    int deleteByAdherentNumeroMatricule(String numeroMatricule);

    List<Conjoint> findByAdherentId(Long id);

    int deleteByAdherentId(Long id);


}

package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Enfant;


@Repository
public interface EnfantDao extends JpaRepository<Enfant,Long> {




    Enfant findByReference(String reference);

    int deleteByReference(String reference);

    List<Enfant> findByQualiteReference(String reference);
    int deleteByQualiteReference(String reference);

    List<Enfant> findByQualiteId(Long id);

    int deleteByQualiteId(Long id);
    List<Enfant> findByAdherentNumeroMatricule(String numeroMatricule);
    int deleteByAdherentNumeroMatricule(String numeroMatricule);

    List<Enfant> findByAdherentId(Long id);

    int deleteByAdherentId(Long id);


}

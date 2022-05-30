package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.EtatReclamation;


@Repository
public interface EtatReclamationDao extends JpaRepository<EtatReclamation,Long> {




    EtatReclamation findByReference(String reference);

    int deleteByReference(String reference);


    EtatReclamation findByLibelle(String libelle);
}

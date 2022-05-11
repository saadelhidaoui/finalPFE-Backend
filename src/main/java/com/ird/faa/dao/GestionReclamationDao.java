package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.GestionReclamation;


@Repository
public interface GestionReclamationDao extends JpaRepository<GestionReclamation,Long> {




    GestionReclamation findByReference(String reference);

    int deleteByReference(String reference);

    List<GestionReclamation> findByModerateurNumeroMatricule(String numeroMatricule);
    int deleteByModerateurNumeroMatricule(String numeroMatricule);

    List<GestionReclamation> findByModerateurId(Long id);

    int deleteByModerateurId(Long id);
    List<GestionReclamation> findByReclamationReference(String reference);
    int deleteByReclamationReference(String reference);

    List<GestionReclamation> findByReclamationId(Long id);

    int deleteByReclamationId(Long id);


}

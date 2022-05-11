package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Reclamation;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface ReclamationDao extends JpaRepository<Reclamation,Long> {



    @Query("SELECT item FROM Reclamation item ORDER BY item.dateReclamation ASC")
    List<Reclamation> findAll();

    Reclamation findByReference(String reference);

    int deleteByReference(String reference);

    List<Reclamation> findByAdherentNumeroMatricule(String numeroMatricule);
    int deleteByAdherentNumeroMatricule(String numeroMatricule);

    List<Reclamation> findByAdherentId(Long id);

    int deleteByAdherentId(Long id);
    List<Reclamation> findByEtatReclamationReference(String reference);
    int deleteByEtatReclamationReference(String reference);

    List<Reclamation> findByEtatReclamationId(Long id);

    int deleteByEtatReclamationId(Long id);


}

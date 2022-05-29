package com.ird.faa.dao;

import com.ird.faa.bean.Prestation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestationDao extends JpaRepository<Prestation, Long> {


    @Query("SELECT item FROM Prestation item ORDER BY item.niveauImportance ASC")
    List<Prestation> findAll();

    List<Prestation> findByAdherentCin(String cin);

    Prestation findByReference(String reference);

    int deleteByReference(String reference);

    List<Prestation> findByEtatPrestationReference(String reference);

    int deleteByEtatPrestationReference(String reference);

    List<Prestation> findByEtatPrestationId(Long id);

    int deleteByEtatPrestationId(Long id);

    List<Prestation> findByNiveauImportanceReference(String reference);

    int deleteByNiveauImportanceReference(String reference);

    List<Prestation> findByNiveauImportanceId(Long id);

    int deleteByNiveauImportanceId(Long id);

    List<Prestation> findByTypePrestationReference(String reference);

    int deleteByTypePrestationReference(String reference);

    List<Prestation> findByTypePrestationId(Long id);

    int deleteByTypePrestationId(Long id);

    List<Prestation> findByAdherentNumeroMatricule(String numeroMatricule);

    int deleteByAdherentNumeroMatricule(String numeroMatricule);

    List<Prestation> findByAdherentId(Long id);

    int deleteByAdherentId(Long id);


}

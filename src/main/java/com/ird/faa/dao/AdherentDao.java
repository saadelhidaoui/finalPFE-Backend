package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Adherent;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface AdherentDao extends JpaRepository<Adherent,Long> {

    Adherent findByUsername(String username);


    @Query("SELECT item FROM Adherent item ORDER BY item.numAdhesion ASC")
    List<Adherent> findAll();

    Adherent findByNumeroMatricule(String numeroMatricule);

    int deleteByNumeroMatricule(String numeroMatricule);


    List<Adherent> findByVilleId(Long id);

    int deleteByVilleId(Long id);
    List<Adherent> findByQualiteReference(String reference);
    int deleteByQualiteReference(String reference);

    List<Adherent> findByQualiteId(Long id);

    int deleteByQualiteId(Long id);
    List<Adherent> findByEtatCarteReference(String reference);
    int deleteByEtatCarteReference(String reference);

    List<Adherent> findByEtatCarteId(Long id);

    int deleteByEtatCarteId(Long id);
    List<Adherent> findByStatutReference(String reference);
    int deleteByStatutReference(String reference);

    List<Adherent> findByStatutId(Long id);

    int deleteByStatutId(Long id);
    List<Adherent> findByFonctionReference(String reference);
    int deleteByFonctionReference(String reference);

    List<Adherent> findByFonctionId(Long id);

    int deleteByFonctionId(Long id);

    Adherent findByCin(String cin);


}

package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Chercheur;


@Repository
public interface ChercheurDao extends JpaRepository<Chercheur,Long> {

    Chercheur findByUsername(String username);



    Chercheur findByNumeroMatricule(String numeroMatricule);

    int deleteByNumeroMatricule(String numeroMatricule);

    List<Chercheur> findBySituationModerateurReference(String reference);
    int deleteBySituationModerateurReference(String reference);

    List<Chercheur> findBySituationModerateurId(Long id);

    int deleteBySituationModerateurId(Long id);
    List<Chercheur> findByProfilReference(String reference);
    int deleteByProfilReference(String reference);

    List<Chercheur> findByProfilId(Long id);

    int deleteByProfilId(Long id);


}

package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Tache;


@Repository
public interface TacheDao extends JpaRepository<Tache,Long> {




    Tache findByReference(String reference);

    int deleteByReference(String reference);

    List<Tache> findByEtatTacheReference(String reference);
    int deleteByEtatTacheReference(String reference);

    List<Tache> findByEtatTacheId(Long id);

    int deleteByEtatTacheId(Long id);
    List<Tache> findByModerateurNumeroMatricule(String numeroMatricule);
    int deleteByModerateurNumeroMatricule(String numeroMatricule);

    List<Tache> findByModerateurId(Long id);

    int deleteByModerateurId(Long id);


}

package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Moderateur;


@Repository
public interface ModerateurDao extends JpaRepository<Moderateur,Long> {

    Moderateur findByUsername(String username);



    Moderateur findByNumeroMatricule(String numeroMatricule);

    int deleteByNumeroMatricule(String numeroMatricule);

    List<Moderateur> findBySituationModerateurReference(String reference);
    int deleteBySituationModerateurReference(String reference);

    List<Moderateur> findBySituationModerateurId(Long id);

    int deleteBySituationModerateurId(Long id);
    List<Moderateur> findByProfilReference(String reference);
    int deleteByProfilReference(String reference);

    List<Moderateur> findByProfilId(Long id);

    int deleteByProfilId(Long id);


}

package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Projet;


@Repository
public interface ProjetDao extends JpaRepository<Projet,Long> {




    Projet findByReference(String reference);

    int deleteByReference(String reference);

    List<Projet> findByEtatProjetCode(String code);
    int deleteByEtatProjetCode(String code);

    List<Projet> findByEtatProjetId(Long id);

    int deleteByEtatProjetId(Long id);


}

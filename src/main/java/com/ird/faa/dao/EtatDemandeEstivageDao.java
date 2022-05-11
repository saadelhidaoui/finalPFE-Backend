package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.EtatDemandeEstivage;


@Repository
public interface EtatDemandeEstivageDao extends JpaRepository<EtatDemandeEstivage,Long> {




    EtatDemandeEstivage findByReference(String reference);

    int deleteByReference(String reference);



}

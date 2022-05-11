package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.SituationModerateur;


@Repository
public interface SituationModerateurDao extends JpaRepository<SituationModerateur,Long> {




    SituationModerateur findByReference(String reference);

    int deleteByReference(String reference);



}

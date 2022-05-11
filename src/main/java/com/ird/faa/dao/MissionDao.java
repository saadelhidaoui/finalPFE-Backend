package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Mission;


@Repository
public interface MissionDao extends JpaRepository<Mission,Long> {




    Mission findByReference(String reference);

    int deleteByReference(String reference);


    List<Mission> findByVilleId(Long id);

    int deleteByVilleId(Long id);
    List<Mission> findByModerateurNumeroMatricule(String numeroMatricule);
    int deleteByModerateurNumeroMatricule(String numeroMatricule);

    List<Mission> findByModerateurId(Long id);

    int deleteByModerateurId(Long id);


}

package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Ville;


@Repository
public interface VilleDao extends JpaRepository<Ville,Long> {






    List<Ville> findByRegionId(Long id);

    int deleteByRegionId(Long id);


}

package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.CentreEstivage;


@Repository
public interface CentreEstivageDao extends JpaRepository<CentreEstivage,Long> {






    List<CentreEstivage> findByVilleId(Long id);

    int deleteByVilleId(Long id);


}

package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Organisme;


@Repository
public interface OrganismeDao extends JpaRepository<Organisme,Long> {






    List<Organisme> findByVilleId(Long id);

    int deleteByVilleId(Long id);


}

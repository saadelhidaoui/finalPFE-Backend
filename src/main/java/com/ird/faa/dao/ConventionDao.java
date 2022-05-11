package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Convention;


@Repository
public interface ConventionDao extends JpaRepository<Convention,Long> {




    Convention findByReference(String reference);

    int deleteByReference(String reference);


    List<Convention> findByOrganismeId(Long id);

    int deleteByOrganismeId(Long id);


}

package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.RendezVous;


@Repository
public interface RendezVousDao extends JpaRepository<RendezVous,Long> {




    RendezVous findByReference(String reference);

    int deleteByReference(String reference);



}

package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Profil;


@Repository
public interface ProfilDao extends JpaRepository<Profil,Long> {




    Profil findByReference(String reference);

    int deleteByReference(String reference);

    List<Profil> findByGradeReference(String reference);
    int deleteByGradeReference(String reference);

    List<Profil> findByGradeId(Long id);

    int deleteByGradeId(Long id);
    List<Profil> findByEchelleReference(String reference);
    int deleteByEchelleReference(String reference);

    List<Profil> findByEchelleId(Long id);

    int deleteByEchelleId(Long id);


}

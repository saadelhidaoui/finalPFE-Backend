package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.ImpressionCarte;


@Repository
public interface ImpressionCarteDao extends JpaRepository<ImpressionCarte,Long> {




    ImpressionCarte findByAff(String aff);

    int deleteByAff(String aff);



}

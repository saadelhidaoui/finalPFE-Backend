package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.EstivageCentreEstivage;


@Repository
public interface EstivageCentreEstivageDao extends JpaRepository<EstivageCentreEstivage,Long> {




    EstivageCentreEstivage findByReference(String reference);

    int deleteByReference(String reference);


    List<EstivageCentreEstivage> findByCentreEstivageId(Long id);

    int deleteByCentreEstivageId(Long id);
    List<EstivageCentreEstivage> findByEstivageReference(String reference);
    int deleteByEstivageReference(String reference);

    List<EstivageCentreEstivage> findByEstivageId(Long id);

    int deleteByEstivageId(Long id);


}

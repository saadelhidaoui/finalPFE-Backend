package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.DemandeEstivageCentre;


@Repository
public interface DemandeEstivageCentreDao extends JpaRepository<DemandeEstivageCentre,Long> {




    DemandeEstivageCentre findByReference(String reference);

    int deleteByReference(String reference);

    List<DemandeEstivageCentre> findByDemandeEstivageReference(String reference);
    int deleteByDemandeEstivageReference(String reference);

    List<DemandeEstivageCentre> findByDemandeEstivageId(Long id);

    int deleteByDemandeEstivageId(Long id);

    List<DemandeEstivageCentre> findByCentreEstivageId(Long id);

    int deleteByCentreEstivageId(Long id);
}

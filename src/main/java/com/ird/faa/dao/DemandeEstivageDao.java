package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.DemandeEstivage;


@Repository
public interface DemandeEstivageDao extends JpaRepository<DemandeEstivage,Long> {




    DemandeEstivage findByReference(String reference);

    int deleteByReference(String reference);

    List<DemandeEstivage> findByDemandeEstivageCentreReference(String reference);
    int deleteByDemandeEstivageCentreReference(String reference);

    List<DemandeEstivage> findByDemandeEstivageCentreId(Long id);

    int deleteByDemandeEstivageCentreId(Long id);
    List<DemandeEstivage> findByAdherentNumeroMatricule(String numeroMatricule);
    int deleteByAdherentNumeroMatricule(String numeroMatricule);

    List<DemandeEstivage> findByAdherentId(Long id);

    int deleteByAdherentId(Long id);
    List<DemandeEstivage> findByEtatDemandeEstivageReference(String reference);
    int deleteByEtatDemandeEstivageReference(String reference);

    List<DemandeEstivage> findByEtatDemandeEstivageId(Long id);

    int deleteByEtatDemandeEstivageId(Long id);
    List<DemandeEstivage> findByEstivageCentreEstivageReference(String reference);
    int deleteByEstivageCentreEstivageReference(String reference);

    List<DemandeEstivage> findByEstivageCentreEstivageId(Long id);

    int deleteByEstivageCentreEstivageId(Long id);


}

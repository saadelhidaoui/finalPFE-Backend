package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.DemandeEstivage;
        import com.ird.faa.bean.DemandeEstivageCentre;
        import com.ird.faa.bean.Adherent;
        import com.ird.faa.bean.EtatDemandeEstivage;
        import com.ird.faa.bean.EstivageCentreEstivage;
        import com.ird.faa.bean.PieceJointeEstivage;
import com.ird.faa.dao.DemandeEstivageDao;
import com.ird.faa.service.admin.facade.DemandeEstivageAdminService;
        import com.ird.faa.service.admin.facade.AdherentAdminService;
        import com.ird.faa.service.admin.facade.EtatDemandeEstivageAdminService;
        import com.ird.faa.service.admin.facade.PieceJointeEstivageAdminService;
        import com.ird.faa.service.admin.facade.DemandeEstivageCentreAdminService;
        import com.ird.faa.service.admin.facade.EstivageCentreEstivageAdminService;

import com.ird.faa.ws.rest.provided.vo.DemandeEstivageVo;
import com.ird.faa.service.util.*;
        import com.ird.faa.bean.PieceJointeEstivage;
        import com.ird.faa.service.admin.facade.PieceJointeEstivageAdminService;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class DemandeEstivageAdminServiceImpl extends AbstractServiceImpl<DemandeEstivage> implements DemandeEstivageAdminService {

@Autowired
private DemandeEstivageDao demandeEstivageDao;

        @Autowired
        private AdherentAdminService adherentService ;
        @Autowired
        private EtatDemandeEstivageAdminService etatDemandeEstivageService ;
        @Autowired
        private PieceJointeEstivageAdminService pieceJointeEstivageService ;
        @Autowired
        private DemandeEstivageCentreAdminService demandeEstivageCentreService ;
        @Autowired
        private EstivageCentreEstivageAdminService estivageCentreEstivageService ;


@Autowired
private EntityManager entityManager;


@Override
public List<DemandeEstivage> findAll(){
        return demandeEstivageDao.findAll();
}

        @Override
        public List<DemandeEstivage> findByDemandeEstivageCentreReference(String reference){
        return demandeEstivageDao.findByDemandeEstivageCentreReference(reference);
        }

        @Override
        @Transactional
        public int deleteByDemandeEstivageCentreReference(String reference){
        return demandeEstivageDao.deleteByDemandeEstivageCentreReference(reference);
        }

        @Override
        public List<DemandeEstivage> findByDemandeEstivageCentreId(Long id){
        return demandeEstivageDao.findByDemandeEstivageCentreId(id);
        }

        @Override
        @Transactional
        public int deleteByDemandeEstivageCentreId(Long id){
        return demandeEstivageDao.deleteByDemandeEstivageCentreId(id);
        }


        @Override
        public List<DemandeEstivage> findByAdherentNumeroMatricule(String numeroMatricule){
        return demandeEstivageDao.findByAdherentNumeroMatricule(numeroMatricule);
        }

        @Override
        @Transactional
        public int deleteByAdherentNumeroMatricule(String numeroMatricule){
        return demandeEstivageDao.deleteByAdherentNumeroMatricule(numeroMatricule);
        }

        @Override
        public List<DemandeEstivage> findByAdherentId(Long id){
        return demandeEstivageDao.findByAdherentId(id);
        }

        @Override
        @Transactional
        public int deleteByAdherentId(Long id){
        return demandeEstivageDao.deleteByAdherentId(id);
        }


        @Override
        public List<DemandeEstivage> findByEtatDemandeEstivageReference(String reference){
        return demandeEstivageDao.findByEtatDemandeEstivageReference(reference);
        }

        @Override
        @Transactional
        public int deleteByEtatDemandeEstivageReference(String reference){
        return demandeEstivageDao.deleteByEtatDemandeEstivageReference(reference);
        }

        @Override
        public List<DemandeEstivage> findByEtatDemandeEstivageId(Long id){
        return demandeEstivageDao.findByEtatDemandeEstivageId(id);
        }

        @Override
        @Transactional
        public int deleteByEtatDemandeEstivageId(Long id){
        return demandeEstivageDao.deleteByEtatDemandeEstivageId(id);
        }


        @Override
        public List<DemandeEstivage> findByEstivageCentreEstivageReference(String reference){
        return demandeEstivageDao.findByEstivageCentreEstivageReference(reference);
        }

        @Override
        @Transactional
        public int deleteByEstivageCentreEstivageReference(String reference){
        return demandeEstivageDao.deleteByEstivageCentreEstivageReference(reference);
        }

        @Override
        public List<DemandeEstivage> findByEstivageCentreEstivageId(Long id){
        return demandeEstivageDao.findByEstivageCentreEstivageId(id);
        }

        @Override
        @Transactional
        public int deleteByEstivageCentreEstivageId(Long id){
        return demandeEstivageDao.deleteByEstivageCentreEstivageId(id);
        }

    @Override
    public DemandeEstivage findByReference(String reference){
    if( reference==null) return null;
    return demandeEstivageDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return demandeEstivageDao.deleteByReference(reference);
    }
    @Override
    public DemandeEstivage findByIdOrReference(DemandeEstivage demandeEstivage){
    DemandeEstivage resultat=null;
    if(demandeEstivage != null){
    if(StringUtil.isNotEmpty(demandeEstivage.getId())){
    resultat= demandeEstivageDao.getOne(demandeEstivage.getId());
    }else if(StringUtil.isNotEmpty(demandeEstivage.getReference())) {
    resultat= demandeEstivageDao.findByReference(demandeEstivage.getReference());
    }
    }
    return resultat;
    }

@Override
public DemandeEstivage findById(Long id){
if(id==null) return null;
return demandeEstivageDao.getOne(id);
}

@Override
public DemandeEstivage findByIdWithAssociatedList(Long id){
    DemandeEstivage demandeEstivage  = findById(id);
    findAssociatedLists(demandeEstivage);
    return demandeEstivage;
}
    private void findAssociatedLists(DemandeEstivage demandeEstivage){
    if(demandeEstivage!=null && demandeEstivage.getId() != null) {
            List<PieceJointeEstivage> pieceJointeEstivages = pieceJointeEstivageService.findByDemandeEstivageId(demandeEstivage.getId());
            demandeEstivage.setPieceJointeEstivages(pieceJointeEstivages);
    }
    }
    private void deleteAssociatedLists(Long id){
    if(id != null ) {
            pieceJointeEstivageService.deleteByDemandeEstivageId(id);
    }
    }

    private void updateAssociatedLists(DemandeEstivage demandeEstivage){
    if(demandeEstivage !=null && demandeEstivage.getId() != null){
            List
            <List<PieceJointeEstivage>> resultPieceJointeEstivages= pieceJointeEstivageService.getToBeSavedAndToBeDeleted(pieceJointeEstivageService.findByDemandeEstivageId(demandeEstivage.getId()),demandeEstivage.getPieceJointeEstivages());
            pieceJointeEstivageService.delete(resultPieceJointeEstivages.get(1));
            associatePieceJointeEstivage(demandeEstivage,resultPieceJointeEstivages.get(0));
            pieceJointeEstivageService.update(resultPieceJointeEstivages.get(0));

    }
    }

@Transactional
public int deleteById(Long id){
int res=0;
if(demandeEstivageDao.findById(id).isPresent())  {
    deleteAssociatedLists(id);
demandeEstivageDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public DemandeEstivage update(DemandeEstivage demandeEstivage){
DemandeEstivage foundedDemandeEstivage = findById(demandeEstivage.getId());
if(foundedDemandeEstivage==null) return null;
else{
    updateAssociatedLists(demandeEstivage);
return  demandeEstivageDao.save(demandeEstivage);
}
}

@Override
public DemandeEstivage save (DemandeEstivage demandeEstivage){

    DemandeEstivage result =null;
    DemandeEstivage foundedDemandeEstivage = findByReference(demandeEstivage.getReference());
    if(foundedDemandeEstivage == null){


    findDemandeEstivageCentre(demandeEstivage);
    findAdherent(demandeEstivage);
    findEtatDemandeEstivage(demandeEstivage);
    findEstivageCentreEstivage(demandeEstivage);

    DemandeEstivage savedDemandeEstivage = demandeEstivageDao.save(demandeEstivage);

        savePieceJointeEstivages(savedDemandeEstivage,demandeEstivage.getPieceJointeEstivages());
    result = savedDemandeEstivage;
    }

    return result;
}

@Override
public List<DemandeEstivage> save(List<DemandeEstivage> demandeEstivages){
List<DemandeEstivage> list = new ArrayList<>();
for(DemandeEstivage demandeEstivage: demandeEstivages){
list.add(save(demandeEstivage));
}
return list;
}



@Override
@Transactional
public int delete(DemandeEstivage demandeEstivage){
    if(demandeEstivage.getReference()==null) return -1;

    DemandeEstivage foundedDemandeEstivage = findByReference(demandeEstivage.getReference());
    if(foundedDemandeEstivage==null) return -1;
demandeEstivageDao.delete(foundedDemandeEstivage);
return 1;
}


public List<DemandeEstivage> findByCriteria(DemandeEstivageVo demandeEstivageVo){

String query = "SELECT o FROM DemandeEstivage o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",demandeEstivageVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",demandeEstivageVo.getReference());
        query += SearchUtil.addConstraintDate( "o", "dateDebutEstivage","=",demandeEstivageVo.getDateDebutEstivage());
        query += SearchUtil.addConstraintDate( "o", "dateFinEstivage","=",demandeEstivageVo.getDateFinEstivage());
        query += SearchUtil.addConstraintDate( "o", "dateTraitement","=",demandeEstivageVo.getDateTraitement());
            query += SearchUtil.addConstraintMinMaxDate("o","dateDebutEstivage",demandeEstivageVo.getDateDebutEstivageMin(),demandeEstivageVo.getDateDebutEstivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateFinEstivage",demandeEstivageVo.getDateFinEstivageMin(),demandeEstivageVo.getDateFinEstivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateTraitement",demandeEstivageVo.getDateTraitementMin(),demandeEstivageVo.getDateTraitementMax());
            query += SearchUtil.addConstraintMinMax("o","pieceJointeEstivages",demandeEstivageVo.getPieceJointeEstivagesMin(),demandeEstivageVo.getPieceJointeEstivagesMax());
    if(demandeEstivageVo.getDemandeEstivageCentreVo()!=null){
        query += SearchUtil.addConstraint( "o", "demandeEstivageCentre.id","=",demandeEstivageVo.getDemandeEstivageCentreVo().getId());
            query += SearchUtil.addConstraint( "o", "demandeEstivageCentre.reference","LIKE",demandeEstivageVo.getDemandeEstivageCentreVo().getReference());
    }

    if(demandeEstivageVo.getAdherentVo()!=null){
        query += SearchUtil.addConstraint( "o", "adherent.id","=",demandeEstivageVo.getAdherentVo().getId());
            query += SearchUtil.addConstraint( "o", "adherent.numeroMatricule","LIKE",demandeEstivageVo.getAdherentVo().getNumeroMatricule());
    }

    if(demandeEstivageVo.getEtatDemandeEstivageVo()!=null){
        query += SearchUtil.addConstraint( "o", "etatDemandeEstivage.id","=",demandeEstivageVo.getEtatDemandeEstivageVo().getId());
            query += SearchUtil.addConstraint( "o", "etatDemandeEstivage.reference","LIKE",demandeEstivageVo.getEtatDemandeEstivageVo().getReference());
    }

    if(demandeEstivageVo.getEstivageCentreEstivageVo()!=null){
        query += SearchUtil.addConstraint( "o", "estivageCentreEstivage.id","=",demandeEstivageVo.getEstivageCentreEstivageVo().getId());
            query += SearchUtil.addConstraint( "o", "estivageCentreEstivage.reference","LIKE",demandeEstivageVo.getEstivageCentreEstivageVo().getReference());
    }

return entityManager.createQuery(query).getResultList();
}
        private  void savePieceJointeEstivages(DemandeEstivage demandeEstivage,List<PieceJointeEstivage> pieceJointeEstivages){

        if (ListUtil.isNotEmpty(demandeEstivage.getPieceJointeEstivages())) {
        List<PieceJointeEstivage> savedPieceJointeEstivages = new ArrayList<>();
        pieceJointeEstivages.forEach(element -> {
        element.setDemandeEstivage(demandeEstivage);
         pieceJointeEstivageService.save(element);
        });
        demandeEstivage.setPieceJointeEstivages(savedPieceJointeEstivages);
        }
        }

    private void findDemandeEstivageCentre(DemandeEstivage demandeEstivage){
        DemandeEstivageCentre loadedDemandeEstivageCentre =demandeEstivageCentreService.findByIdOrReference(demandeEstivage.getDemandeEstivageCentre());

    if(loadedDemandeEstivageCentre==null ) {
    return;
    }
    demandeEstivage.setDemandeEstivageCentre(loadedDemandeEstivageCentre);
    }
    private void findAdherent(DemandeEstivage demandeEstivage){
        Adherent loadedAdherent =adherentService.findByIdOrNumeroMatricule(demandeEstivage.getAdherent());

    if(loadedAdherent==null ) {
    return;
    }
    demandeEstivage.setAdherent(loadedAdherent);
    }
    private void findEtatDemandeEstivage(DemandeEstivage demandeEstivage){
        EtatDemandeEstivage loadedEtatDemandeEstivage =etatDemandeEstivageService.findByIdOrReference(demandeEstivage.getEtatDemandeEstivage());

    if(loadedEtatDemandeEstivage==null ) {
    return;
    }
    demandeEstivage.setEtatDemandeEstivage(loadedEtatDemandeEstivage);
    }
    private void findEstivageCentreEstivage(DemandeEstivage demandeEstivage){
        EstivageCentreEstivage loadedEstivageCentreEstivage =estivageCentreEstivageService.findByIdOrReference(demandeEstivage.getEstivageCentreEstivage());

    if(loadedEstivageCentreEstivage==null ) {
    return;
    }
    demandeEstivage.setEstivageCentreEstivage(loadedEstivageCentreEstivage);
    }

@Override
@Transactional
public void delete(List<DemandeEstivage> demandeEstivages){
if(ListUtil.isNotEmpty(demandeEstivages)){
demandeEstivages.forEach(e->demandeEstivageDao.delete(e));
}
}
@Override
public void update(List<DemandeEstivage> demandeEstivages){
if(ListUtil.isNotEmpty(demandeEstivages)){
demandeEstivages.forEach(e->demandeEstivageDao.save(e));
}
}

        private void associatePieceJointeEstivage(DemandeEstivage demandeEstivage, List<PieceJointeEstivage> pieceJointeEstivage) {
        if (ListUtil.isNotEmpty(pieceJointeEstivage)) {
        pieceJointeEstivage.forEach(e -> e.setDemandeEstivage(demandeEstivage));
        }
        }




    }

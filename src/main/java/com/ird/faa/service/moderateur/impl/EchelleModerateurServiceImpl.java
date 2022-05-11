package com.ird.faa.service.moderateur.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Echelle;
        import com.ird.faa.bean.Echelon;
import com.ird.faa.dao.EchelleDao;
import com.ird.faa.service.moderateur.facade.EchelleModerateurService;
        import com.ird.faa.service.moderateur.facade.EchelonModerateurService;

import com.ird.faa.ws.rest.provided.vo.EchelleVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class EchelleModerateurServiceImpl extends AbstractServiceImpl<Echelle> implements EchelleModerateurService {

@Autowired
private EchelleDao echelleDao;

        @Autowired
        private EchelonModerateurService echelonService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Echelle> findAll(){
        return echelleDao.findAll();
}

        @Override
        public List<Echelle> findByEchelonReference(String reference){
        return echelleDao.findByEchelonReference(reference);
        }

        @Override
        @Transactional
        public int deleteByEchelonReference(String reference){
        return echelleDao.deleteByEchelonReference(reference);
        }

        @Override
        public List<Echelle> findByEchelonId(Long id){
        return echelleDao.findByEchelonId(id);
        }

        @Override
        @Transactional
        public int deleteByEchelonId(Long id){
        return echelleDao.deleteByEchelonId(id);
        }

    @Override
    public Echelle findByReference(String reference){
    if( reference==null) return null;
    return echelleDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return echelleDao.deleteByReference(reference);
    }
    @Override
    public Echelle findByIdOrReference(Echelle echelle){
    Echelle resultat=null;
    if(echelle != null){
    if(StringUtil.isNotEmpty(echelle.getId())){
    resultat= echelleDao.getOne(echelle.getId());
    }else if(StringUtil.isNotEmpty(echelle.getReference())) {
    resultat= echelleDao.findByReference(echelle.getReference());
    }
    }
    return resultat;
    }

@Override
public Echelle findById(Long id){
if(id==null) return null;
return echelleDao.getOne(id);
}

@Override
public Echelle findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(echelleDao.findById(id).isPresent())  {
echelleDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Echelle update(Echelle echelle){
Echelle foundedEchelle = findById(echelle.getId());
if(foundedEchelle==null) return null;
else{
return  echelleDao.save(echelle);
}
}

@Override
public Echelle save (Echelle echelle){

    Echelle result =null;
    Echelle foundedEchelle = findByReference(echelle.getReference());
    if(foundedEchelle == null){


    findEchelon(echelle);

    Echelle savedEchelle = echelleDao.save(echelle);

    result = savedEchelle;
    }

    return result;
}

@Override
public List<Echelle> save(List<Echelle> echelles){
List<Echelle> list = new ArrayList<>();
for(Echelle echelle: echelles){
list.add(save(echelle));
}
return list;
}



@Override
@Transactional
public int delete(Echelle echelle){
    if(echelle.getReference()==null) return -1;

    Echelle foundedEchelle = findByReference(echelle.getReference());
    if(foundedEchelle==null) return -1;
echelleDao.delete(foundedEchelle);
return 1;
}


public List<Echelle> findByCriteria(EchelleVo echelleVo){

String query = "SELECT o FROM Echelle o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",echelleVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",echelleVo.getReference());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",echelleVo.getLibelle());
    if(echelleVo.getEchelonVo()!=null){
        query += SearchUtil.addConstraint( "o", "echelon.id","=",echelleVo.getEchelonVo().getId());
            query += SearchUtil.addConstraint( "o", "echelon.reference","LIKE",echelleVo.getEchelonVo().getReference());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findEchelon(Echelle echelle){
        Echelon loadedEchelon =echelonService.findByIdOrReference(echelle.getEchelon());

    if(loadedEchelon==null ) {
    return;
    }
    echelle.setEchelon(loadedEchelon);
    }

@Override
@Transactional
public void delete(List<Echelle> echelles){
if(ListUtil.isNotEmpty(echelles)){
echelles.forEach(e->echelleDao.delete(e));
}
}
@Override
public void update(List<Echelle> echelles){
if(ListUtil.isNotEmpty(echelles)){
echelles.forEach(e->echelleDao.save(e));
}
}





    }

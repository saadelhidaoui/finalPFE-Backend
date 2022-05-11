package com.ird.faa.service.chercheur.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Conjoint;
        import com.ird.faa.bean.Qualite;
        import com.ird.faa.bean.Adherent;
import com.ird.faa.dao.ConjointDao;
import com.ird.faa.service.chercheur.facade.ConjointChercheurService;
        import com.ird.faa.service.chercheur.facade.AdherentChercheurService;
        import com.ird.faa.service.chercheur.facade.QualiteChercheurService;

import com.ird.faa.ws.rest.provided.vo.ConjointVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class ConjointChercheurServiceImpl extends AbstractServiceImpl<Conjoint> implements ConjointChercheurService {

@Autowired
private ConjointDao conjointDao;

        @Autowired
        private AdherentChercheurService adherentService ;
        @Autowired
        private QualiteChercheurService qualiteService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Conjoint> findAll(){
        return conjointDao.findAll();
}

        @Override
        public List<Conjoint> findByQualiteReference(String reference){
        return conjointDao.findByQualiteReference(reference);
        }

        @Override
        @Transactional
        public int deleteByQualiteReference(String reference){
        return conjointDao.deleteByQualiteReference(reference);
        }

        @Override
        public List<Conjoint> findByQualiteId(Long id){
        return conjointDao.findByQualiteId(id);
        }

        @Override
        @Transactional
        public int deleteByQualiteId(Long id){
        return conjointDao.deleteByQualiteId(id);
        }


        @Override
        public List<Conjoint> findByAdherentNumeroMatricule(String numeroMatricule){
        return conjointDao.findByAdherentNumeroMatricule(numeroMatricule);
        }

        @Override
        @Transactional
        public int deleteByAdherentNumeroMatricule(String numeroMatricule){
        return conjointDao.deleteByAdherentNumeroMatricule(numeroMatricule);
        }

        @Override
        public List<Conjoint> findByAdherentId(Long id){
        return conjointDao.findByAdherentId(id);
        }

        @Override
        @Transactional
        public int deleteByAdherentId(Long id){
        return conjointDao.deleteByAdherentId(id);
        }

    @Override
    public Conjoint findByCin(String cin){
    if( cin==null) return null;
    return conjointDao.findByCin(cin);
    }

    @Override
    @Transactional
    public int deleteByCin(String  cin) {
    return conjointDao.deleteByCin(cin);
    }
    @Override
    public Conjoint findByIdOrCin(Conjoint conjoint){
    Conjoint resultat=null;
    if(conjoint != null){
    if(StringUtil.isNotEmpty(conjoint.getId())){
    resultat= conjointDao.getOne(conjoint.getId());
    }else if(StringUtil.isNotEmpty(conjoint.getCin())) {
    resultat= conjointDao.findByCin(conjoint.getCin());
    }
    }
    return resultat;
    }

@Override
public Conjoint findById(Long id){
if(id==null) return null;
return conjointDao.getOne(id);
}

@Override
public Conjoint findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(conjointDao.findById(id).isPresent())  {
conjointDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Conjoint update(Conjoint conjoint){
Conjoint foundedConjoint = findById(conjoint.getId());
if(foundedConjoint==null) return null;
else{
return  conjointDao.save(conjoint);
}
}

@Override
public Conjoint save (Conjoint conjoint){

    Conjoint result =null;
    Conjoint foundedConjoint = findByCin(conjoint.getCin());
    if(foundedConjoint == null){


    findQualite(conjoint);
    findAdherent(conjoint);

    Conjoint savedConjoint = conjointDao.save(conjoint);

    result = savedConjoint;
    }

    return result;
}

@Override
public List<Conjoint> save(List<Conjoint> conjoints){
List<Conjoint> list = new ArrayList<>();
for(Conjoint conjoint: conjoints){
list.add(save(conjoint));
}
return list;
}



@Override
@Transactional
public int delete(Conjoint conjoint){
    if(conjoint.getCin()==null) return -1;

    Conjoint foundedConjoint = findByCin(conjoint.getCin());
    if(foundedConjoint==null) return -1;
conjointDao.delete(foundedConjoint);
return 1;
}


public List<Conjoint> findByCriteria(ConjointVo conjointVo){

String query = "SELECT o FROM Conjoint o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",conjointVo.getId());
            query += SearchUtil.addConstraint( "o", "cin","LIKE",conjointVo.getCin());
            query += SearchUtil.addConstraint( "o", "nom","LIKE",conjointVo.getNom());
            query += SearchUtil.addConstraint( "o", "prenom","LIKE",conjointVo.getPrenom());
            query += SearchUtil.addConstraint( "o", "origin","LIKE",conjointVo.getOrigin());
            query += SearchUtil.addConstraint( "o", "email","LIKE",conjointVo.getEmail());
            query += SearchUtil.addConstraint( "o", "telephone","LIKE",conjointVo.getTelephone());
    if(conjointVo.getQualiteVo()!=null){
        query += SearchUtil.addConstraint( "o", "qualite.id","=",conjointVo.getQualiteVo().getId());
            query += SearchUtil.addConstraint( "o", "qualite.reference","LIKE",conjointVo.getQualiteVo().getReference());
    }

    if(conjointVo.getAdherentVo()!=null){
        query += SearchUtil.addConstraint( "o", "adherent.id","=",conjointVo.getAdherentVo().getId());
            query += SearchUtil.addConstraint( "o", "adherent.numeroMatricule","LIKE",conjointVo.getAdherentVo().getNumeroMatricule());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findQualite(Conjoint conjoint){
        Qualite loadedQualite =qualiteService.findByIdOrReference(conjoint.getQualite());

    if(loadedQualite==null ) {
    return;
    }
    conjoint.setQualite(loadedQualite);
    }
    private void findAdherent(Conjoint conjoint){
        Adherent loadedAdherent =adherentService.findByIdOrNumeroMatricule(conjoint.getAdherent());

    if(loadedAdherent==null ) {
    return;
    }
    conjoint.setAdherent(loadedAdherent);
    }

@Override
@Transactional
public void delete(List<Conjoint> conjoints){
if(ListUtil.isNotEmpty(conjoints)){
conjoints.forEach(e->conjointDao.delete(e));
}
}
@Override
public void update(List<Conjoint> conjoints){
if(ListUtil.isNotEmpty(conjoints)){
conjoints.forEach(e->conjointDao.save(e));
}
}





    }

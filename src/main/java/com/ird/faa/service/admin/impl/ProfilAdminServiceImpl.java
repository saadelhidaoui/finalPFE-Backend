package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Profil;
        import com.ird.faa.bean.Grade;
        import com.ird.faa.bean.Echelle;
import com.ird.faa.dao.ProfilDao;
import com.ird.faa.service.admin.facade.ProfilAdminService;
        import com.ird.faa.service.admin.facade.GradeAdminService;
        import com.ird.faa.service.admin.facade.EchelleAdminService;

import com.ird.faa.ws.rest.provided.vo.ProfilVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class ProfilAdminServiceImpl extends AbstractServiceImpl<Profil> implements ProfilAdminService {

@Autowired
private ProfilDao profilDao;

        @Autowired
        private GradeAdminService gradeService ;
        @Autowired
        private EchelleAdminService echelleService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Profil> findAll(){
        return profilDao.findAll();
}

        @Override
        public List<Profil> findByGradeReference(String reference){
        return profilDao.findByGradeReference(reference);
        }

        @Override
        @Transactional
        public int deleteByGradeReference(String reference){
        return profilDao.deleteByGradeReference(reference);
        }

        @Override
        public List<Profil> findByGradeId(Long id){
        return profilDao.findByGradeId(id);
        }

        @Override
        @Transactional
        public int deleteByGradeId(Long id){
        return profilDao.deleteByGradeId(id);
        }


        @Override
        public List<Profil> findByEchelleReference(String reference){
        return profilDao.findByEchelleReference(reference);
        }

        @Override
        @Transactional
        public int deleteByEchelleReference(String reference){
        return profilDao.deleteByEchelleReference(reference);
        }

        @Override
        public List<Profil> findByEchelleId(Long id){
        return profilDao.findByEchelleId(id);
        }

        @Override
        @Transactional
        public int deleteByEchelleId(Long id){
        return profilDao.deleteByEchelleId(id);
        }

    @Override
    public Profil findByReference(String reference){
    if( reference==null) return null;
    return profilDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return profilDao.deleteByReference(reference);
    }
    @Override
    public Profil findByIdOrReference(Profil profil){
    Profil resultat=null;
    if(profil != null){
    if(StringUtil.isNotEmpty(profil.getId())){
    resultat= profilDao.getOne(profil.getId());
    }else if(StringUtil.isNotEmpty(profil.getReference())) {
    resultat= profilDao.findByReference(profil.getReference());
    }
    }
    return resultat;
    }

@Override
public Profil findById(Long id){
if(id==null) return null;
return profilDao.getOne(id);
}

@Override
public Profil findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(profilDao.findById(id).isPresent())  {
profilDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Profil update(Profil profil){
Profil foundedProfil = findById(profil.getId());
if(foundedProfil==null) return null;
else{
return  profilDao.save(profil);
}
}

@Override
public Profil save (Profil profil){

    Profil result =null;
    Profil foundedProfil = findByReference(profil.getReference());
    if(foundedProfil == null){


    findGrade(profil);
    findEchelle(profil);

    Profil savedProfil = profilDao.save(profil);

    result = savedProfil;
    }

    return result;
}

@Override
public List<Profil> save(List<Profil> profils){
List<Profil> list = new ArrayList<>();
for(Profil profil: profils){
list.add(save(profil));
}
return list;
}



@Override
@Transactional
public int delete(Profil profil){
    if(profil.getReference()==null) return -1;

    Profil foundedProfil = findByReference(profil.getReference());
    if(foundedProfil==null) return -1;
profilDao.delete(foundedProfil);
return 1;
}


public List<Profil> findByCriteria(ProfilVo profilVo){

String query = "SELECT o FROM Profil o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",profilVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",profilVo.getReference());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",profilVo.getLibelle());
    if(profilVo.getGradeVo()!=null){
        query += SearchUtil.addConstraint( "o", "grade.id","=",profilVo.getGradeVo().getId());
            query += SearchUtil.addConstraint( "o", "grade.reference","LIKE",profilVo.getGradeVo().getReference());
    }

    if(profilVo.getEchelleVo()!=null){
        query += SearchUtil.addConstraint( "o", "echelle.id","=",profilVo.getEchelleVo().getId());
            query += SearchUtil.addConstraint( "o", "echelle.reference","LIKE",profilVo.getEchelleVo().getReference());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findGrade(Profil profil){
        Grade loadedGrade =gradeService.findByIdOrReference(profil.getGrade());

    if(loadedGrade==null ) {
    return;
    }
    profil.setGrade(loadedGrade);
    }
    private void findEchelle(Profil profil){
        Echelle loadedEchelle =echelleService.findByIdOrReference(profil.getEchelle());

    if(loadedEchelle==null ) {
    return;
    }
    profil.setEchelle(loadedEchelle);
    }

@Override
@Transactional
public void delete(List<Profil> profils){
if(ListUtil.isNotEmpty(profils)){
profils.forEach(e->profilDao.delete(e));
}
}
@Override
public void update(List<Profil> profils){
if(ListUtil.isNotEmpty(profils)){
profils.forEach(e->profilDao.save(e));
}
}





    }

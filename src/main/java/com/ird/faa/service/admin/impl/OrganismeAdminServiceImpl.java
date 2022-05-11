package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Organisme;
        import com.ird.faa.bean.Ville;
import com.ird.faa.dao.OrganismeDao;
import com.ird.faa.service.admin.facade.OrganismeAdminService;
        import com.ird.faa.service.admin.facade.VilleAdminService;

import com.ird.faa.ws.rest.provided.vo.OrganismeVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class OrganismeAdminServiceImpl extends AbstractServiceImpl<Organisme> implements OrganismeAdminService {

@Autowired
private OrganismeDao organismeDao;

        @Autowired
        private VilleAdminService villeService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Organisme> findAll(){
        return organismeDao.findAll();
}
        @Override
        public List<Organisme> findByVilleId(Long id){
        return organismeDao.findByVilleId(id);
        }

        @Override
        @Transactional
        public int deleteByVilleId(Long id){
        return organismeDao.deleteByVilleId(id);
        }


@Override
public Organisme findById(Long id){
if(id==null) return null;
return organismeDao.getOne(id);
}

@Override
public Organisme findByIdWithAssociatedList(Long id){
    return findById(id);
}


@Transactional
public int deleteById(Long id){
int res=0;
if(organismeDao.findById(id).isPresent())  {
organismeDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Organisme update(Organisme organisme){
Organisme foundedOrganisme = findById(organisme.getId());
if(foundedOrganisme==null) return null;
else{
return  organismeDao.save(organisme);
}
}

@Override
public Organisme save (Organisme organisme){



    findVille(organisme);

    return organismeDao.save(organisme);


}

@Override
public List<Organisme> save(List<Organisme> organismes){
List<Organisme> list = new ArrayList<>();
for(Organisme organisme: organismes){
list.add(save(organisme));
}
return list;
}



@Override
@Transactional
public int delete(Organisme organisme){
    if(organisme.getId()==null) return -1;
    Organisme foundedOrganisme = findById(organisme.getId());
    if(foundedOrganisme==null) return -1;
organismeDao.delete(foundedOrganisme);
return 1;
}


public List<Organisme> findByCriteria(OrganismeVo organismeVo){

String query = "SELECT o FROM Organisme o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",organismeVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",organismeVo.getReference());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",organismeVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "telephone","LIKE",organismeVo.getTelephone());
            query += SearchUtil.addConstraint( "o", "email","LIKE",organismeVo.getEmail());
            query += SearchUtil.addConstraint( "o", "fix","LIKE",organismeVo.getFix());
            query += SearchUtil.addConstraint( "o", "fax","LIKE",organismeVo.getFax());
    if(organismeVo.getVilleVo()!=null){
        query += SearchUtil.addConstraint( "o", "ville.id","=",organismeVo.getVilleVo().getId());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findVille(Organisme organisme){
        Ville loadedVille = null;
        if(organisme.getVille() != null && organisme.getVille().getId() !=null)
        loadedVille =villeService.findById(organisme.getVille().getId());

    if(loadedVille==null ) {
    return;
    }
    organisme.setVille(loadedVille);
    }

@Override
@Transactional
public void delete(List<Organisme> organismes){
if(ListUtil.isNotEmpty(organismes)){
organismes.forEach(e->organismeDao.delete(e));
}
}
@Override
public void update(List<Organisme> organismes){
if(ListUtil.isNotEmpty(organismes)){
organismes.forEach(e->organismeDao.save(e));
}
}





    }

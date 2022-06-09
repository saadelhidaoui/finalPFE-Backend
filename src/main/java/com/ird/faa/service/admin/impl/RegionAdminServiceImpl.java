package com.ird.faa.service.admin.impl;

import com.ird.faa.bean.Region;
import com.ird.faa.dao.RegionDao;
import com.ird.faa.service.admin.facade.RegionAdminService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;
import com.ird.faa.service.util.ListUtil;
import com.ird.faa.service.util.SearchUtil;
import com.ird.faa.ws.rest.provided.vo.RegionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class RegionAdminServiceImpl extends AbstractServiceImpl<Region> implements RegionAdminService {

    @Autowired
    private RegionDao regionDao;


    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Region> findAll() {
        return regionDao.findAll();
    }

    @Override
    public Region findById(Long id) {
        if (id == null) return null;
        return regionDao.getOne(id);
    }

    @Override
    public Region findByIdWithAssociatedList(Long id) {
        return findById(id);
    }


    @Transactional
    public int deleteById(Long id) {
        int res = 0;
        if (regionDao.findById(id).isPresent()) {
            regionDao.deleteById(id);
            res = 1;
        }
        return res;
    }


    @Override
    public Region update(Region region) {
        Region foundedRegion = findById(region.getId());
        if (foundedRegion == null) return null;
        else {
            return regionDao.save(region);
        }
    }

    @Override
    public Region save(Region region) {
        Region res = null;
        Region region1 = regionDao.findByReference(region.getReference());
        if(region1 == null){
            res = regionDao.save(region);
        }
        return res;
    }

    private Region findByReference(String reference) {
        return regionDao.findByReference(reference);
    }

    @Override
    public List<Region> save(List<Region> regions) {
        List<Region> list = new ArrayList<>();
        for (Region region : regions) {
            list.add(save(region));
        }
        return list;
    }


    @Override
    @Transactional
    public int delete(Region region) {
        if (region.getId() == null) return -1;
        Region foundedRegion = findById(region.getId());
        if (foundedRegion == null) return -1;
        regionDao.delete(foundedRegion);
        return 1;
    }


    public List<Region> findByCriteria(RegionVo regionVo) {

        String query = "SELECT o FROM Region o where 1=1 ";

        query += SearchUtil.addConstraint("o", "id", "=", regionVo.getId());
        query += SearchUtil.addConstraint("o", "reference", "LIKE", regionVo.getReference());
        query += SearchUtil.addConstraint("o", "libelle", "LIKE", regionVo.getLibelle());
        return entityManager.createQuery(query).getResultList();
    }


    @Override
    @Transactional
    public void delete(List<Region> regions) {
        if (ListUtil.isNotEmpty(regions)) {
            regions.forEach(e -> regionDao.delete(e));
        }
    }

    @Override
    public void update(List<Region> regions) {
        if (ListUtil.isNotEmpty(regions)) {
            regions.forEach(e -> regionDao.save(e));
        }
    }


}

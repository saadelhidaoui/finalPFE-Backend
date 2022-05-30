package com.ird.faa.service.moderateur.facade;

import java.util.List;
import com.ird.faa.bean.Produit;
import com.ird.faa.ws.rest.provided.vo.ProduitVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface ProduitModerateurService extends AbstractService<Produit,Long,ProduitVo>{


    /**
    * find Produit from database by reference (reference)
    * @param reference - reference of Produit
    * @return the founded Produit , If no Produit were
    *         found in database return  null.
    */
    Produit findByReference(String reference);

    /**
    * find Produit from database by id (PK) or reference (reference)
    * @param id - id of Produit
    * @param reference - reference of Produit
    * @return the founded Produit , If no Produit were
    *         found in database return  null.
    */
    Produit findByIdOrReference(Produit produit);


/**
    * delete Produit from database
    * @param id - id of Produit to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete Produit from database by reference (reference)
    *
    * @param reference - reference of Produit to be deleted
    * @return 1 if Produit deleted successfully
    */
    int deleteByReference(String reference);




    Produit archiver(Produit produit) ;
    Produit desarchiver(Produit produit);

    Produit addQuantite(Produit produit);

    Produit substractQuantite(Produit produit);
}

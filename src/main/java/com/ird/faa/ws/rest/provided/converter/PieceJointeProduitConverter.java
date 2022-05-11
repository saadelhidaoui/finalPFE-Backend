package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.PieceJointeProduit;
import com.ird.faa.ws.rest.provided.vo.PieceJointeProduitVo;

@Component
public class PieceJointeProduitConverter extends AbstractConverter<PieceJointeProduit,PieceJointeProduitVo>{

        @Autowired
        private ProduitConverter produitConverter ;
    private Boolean produit;

public  PieceJointeProduitConverter(){
init(true);
}

@Override
public PieceJointeProduit toItem(PieceJointeProduitVo vo) {
if (vo == null) {
return null;
} else {
PieceJointeProduit item = new PieceJointeProduit();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getPath()))
        item.setPath(vo.getPath());
        if(StringUtil.isNotEmpty(vo.getDateAjout()))
        item.setDateAjout(DateUtil.parse(vo.getDateAjout()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
            if(vo.getArchive() != null)
            item.setArchive(vo.getArchive());
        if(StringUtil.isNotEmpty(vo.getDateArchivage()))
        item.setDateArchivage(DateUtil.parse(vo.getDateArchivage()));
        if(StringUtil.isNotEmpty(vo.getDateCreation()))
        item.setDateCreation(DateUtil.parse(vo.getDateCreation()));
            if(vo.getAdmin() != null)
            item.setAdmin(vo.getAdmin());
            if(vo.getVisible() != null)
            item.setVisible(vo.getVisible());
        if(StringUtil.isNotEmpty(vo.getUsername()))
        item.setUsername(vo.getUsername());
    if(vo.getProduitVo()!=null && this.produit)
        item.setProduit(produitConverter.toItem(vo.getProduitVo())) ;


return item;
}
}

@Override
public PieceJointeProduitVo toVo(PieceJointeProduit item) {
if (item == null) {
return null;
} else {
PieceJointeProduitVo vo = new PieceJointeProduitVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getPath()))
        vo.setPath(item.getPath());

        if(item.getDateAjout()!=null)
        vo.setDateAjout(DateUtil.formateDate(item.getDateAjout()));
        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(item.getArchive()!=null)
        vo.setArchive(item.getArchive());
        if(item.getDateArchivage()!=null)
        vo.setDateArchivage(DateUtil.formateDate(item.getDateArchivage()));
        if(item.getDateCreation()!=null)
        vo.setDateCreation(DateUtil.formateDate(item.getDateCreation()));
        if(item.getAdmin()!=null)
        vo.setAdmin(item.getAdmin());
        if(item.getVisible()!=null)
        vo.setVisible(item.getVisible());
        if(StringUtil.isNotEmpty(item.getUsername()))
        vo.setUsername(item.getUsername());

    if(item.getProduit()!=null && this.produit) {
        vo.setProduitVo(produitConverter.toVo(item.getProduit())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    produit = value;
}


        public ProduitConverter getProduitConverter(){
        return this.produitConverter;
        }
        public void setProduitConverter(ProduitConverter produitConverter ){
        this.produitConverter = produitConverter;
        }

    public boolean  isProduit(){
    return this.produit;
    }
    public void  setProduit(boolean produit){
    this.produit = produit;
    }






















}

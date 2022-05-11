package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Produit;
import com.ird.faa.ws.rest.provided.vo.ProduitVo;

@Component
public class ProduitConverter extends AbstractConverter<Produit,ProduitVo>{

        @Autowired
        private PieceJointeProduitConverter pieceJointeProduitConverter ;
        private Boolean pieceJointeProduits;

public  ProduitConverter(){
init(true);
}

@Override
public Produit toItem(ProduitVo vo) {
if (vo == null) {
return null;
} else {
Produit item = new Produit();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getDateArrivee()))
        item.setDateArrivee(DateUtil.parse(vo.getDateArrivee()));
        if(StringUtil.isNotEmpty(vo.getQuantite()))
        item.setQuantite(NumberUtil.toLong(vo.getQuantite()));
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

    if(ListUtil.isNotEmpty(vo.getPieceJointeProduitsVo()) && this.pieceJointeProduits)
        item.setPieceJointeProduits(pieceJointeProduitConverter.toItem(vo.getPieceJointeProduitsVo()));

return item;
}
}

@Override
public ProduitVo toVo(Produit item) {
if (item == null) {
return null;
} else {
ProduitVo vo = new ProduitVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(item.getDateArrivee()!=null)
        vo.setDateArrivee(DateUtil.formateDate(item.getDateArrivee()));
        if(item.getQuantite()!=null)
        vo.setQuantite(NumberUtil.toString(item.getQuantite()));

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

        if(ListUtil.isNotEmpty(item.getPieceJointeProduits()) && this.pieceJointeProduits){
        pieceJointeProduitConverter.init(true);
        pieceJointeProduitConverter.setProduit(false);
        vo.setPieceJointeProduitsVo(pieceJointeProduitConverter.toVo(item.getPieceJointeProduits()));
        pieceJointeProduitConverter.setProduit(true);
        }

return vo;
}
}

public void init(Boolean value) {
        pieceJointeProduits = value;
}


        public PieceJointeProduitConverter getPieceJointeProduitConverter(){
        return this.pieceJointeProduitConverter;
        }
        public void setPieceJointeProduitConverter(PieceJointeProduitConverter pieceJointeProduitConverter ){
        this.pieceJointeProduitConverter = pieceJointeProduitConverter;
        }












        public Boolean  isPieceJointeProduits(){
        return this.pieceJointeProduits ;
        }
        public void  setPieceJointeProduits(Boolean pieceJointeProduits ){
        this.pieceJointeProduits  = pieceJointeProduits ;
        }














}

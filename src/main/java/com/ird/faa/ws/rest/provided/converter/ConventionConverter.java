package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Convention;
import com.ird.faa.ws.rest.provided.vo.ConventionVo;

@Component
public class ConventionConverter extends AbstractConverter<Convention,ConventionVo>{

        @Autowired
        private OrganismeConverter organismeConverter ;
        @Autowired
        private PieceJointeConventionConverter pieceJointeConventionConverter ;
        private Boolean organisme;
        private Boolean pieceJointeConventions;

public  ConventionConverter(){
init(true);
}

@Override
public Convention toItem(ConventionVo vo) {
if (vo == null) {
return null;
} else {
Convention item = new Convention();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getDescription()))
        item.setDescription(vo.getDescription());
        if(StringUtil.isNotEmpty(vo.getDateDebut()))
        item.setDateDebut(DateUtil.parse(vo.getDateDebut()));
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
    if(vo.getOrganismeVo()!=null && this.organisme)
        item.setOrganisme(organismeConverter.toItem(vo.getOrganismeVo())) ;

    if(ListUtil.isNotEmpty(vo.getPieceJointeConventionsVo()) && this.pieceJointeConventions)
        item.setPieceJointeConventions(pieceJointeConventionConverter.toItem(vo.getPieceJointeConventionsVo()));

return item;
}
}

@Override
public ConventionVo toVo(Convention item) {
if (item == null) {
return null;
} else {
ConventionVo vo = new ConventionVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(StringUtil.isNotEmpty(item.getDescription()))
        vo.setDescription(item.getDescription());

        if(item.getDateDebut()!=null)
        vo.setDateDebut(DateUtil.formateDate(item.getDateDebut()));

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

    if(item.getOrganisme()!=null && this.organisme) {
        vo.setOrganismeVo(organismeConverter.toVo(item.getOrganisme())) ;
    }
        if(ListUtil.isNotEmpty(item.getPieceJointeConventions()) && this.pieceJointeConventions){
        pieceJointeConventionConverter.init(true);
        pieceJointeConventionConverter.setConvention(false);
        vo.setPieceJointeConventionsVo(pieceJointeConventionConverter.toVo(item.getPieceJointeConventions()));
        pieceJointeConventionConverter.setConvention(true);
        }

return vo;
}
}

public void init(Boolean value) {
    organisme = value;
        pieceJointeConventions = value;
}


        public OrganismeConverter getOrganismeConverter(){
        return this.organismeConverter;
        }
        public void setOrganismeConverter(OrganismeConverter organismeConverter ){
        this.organismeConverter = organismeConverter;
        }
        public PieceJointeConventionConverter getPieceJointeConventionConverter(){
        return this.pieceJointeConventionConverter;
        }
        public void setPieceJointeConventionConverter(PieceJointeConventionConverter pieceJointeConventionConverter ){
        this.pieceJointeConventionConverter = pieceJointeConventionConverter;
        }

    public boolean  isOrganisme(){
    return this.organisme;
    }
    public void  setOrganisme(boolean organisme){
    this.organisme = organisme;
    }













        public Boolean  isPieceJointeConventions(){
        return this.pieceJointeConventions ;
        }
        public void  setPieceJointeConventions(Boolean pieceJointeConventions ){
        this.pieceJointeConventions  = pieceJointeConventions ;
        }














}

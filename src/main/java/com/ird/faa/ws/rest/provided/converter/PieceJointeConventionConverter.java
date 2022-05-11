package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.PieceJointeConvention;
import com.ird.faa.ws.rest.provided.vo.PieceJointeConventionVo;

@Component
public class PieceJointeConventionConverter extends AbstractConverter<PieceJointeConvention,PieceJointeConventionVo>{

        @Autowired
        private ConventionConverter conventionConverter ;
    private Boolean convention;

public  PieceJointeConventionConverter(){
init(true);
}

@Override
public PieceJointeConvention toItem(PieceJointeConventionVo vo) {
if (vo == null) {
return null;
} else {
PieceJointeConvention item = new PieceJointeConvention();
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
    if(vo.getConventionVo()!=null && this.convention)
        item.setConvention(conventionConverter.toItem(vo.getConventionVo())) ;


return item;
}
}

@Override
public PieceJointeConventionVo toVo(PieceJointeConvention item) {
if (item == null) {
return null;
} else {
PieceJointeConventionVo vo = new PieceJointeConventionVo();
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

    if(item.getConvention()!=null && this.convention) {
        vo.setConventionVo(conventionConverter.toVo(item.getConvention())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    convention = value;
}


        public ConventionConverter getConventionConverter(){
        return this.conventionConverter;
        }
        public void setConventionConverter(ConventionConverter conventionConverter ){
        this.conventionConverter = conventionConverter;
        }

    public boolean  isConvention(){
    return this.convention;
    }
    public void  setConvention(boolean convention){
    this.convention = convention;
    }






















}

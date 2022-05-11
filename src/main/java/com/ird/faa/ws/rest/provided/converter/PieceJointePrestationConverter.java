package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.PieceJointePrestation;
import com.ird.faa.ws.rest.provided.vo.PieceJointePrestationVo;

@Component
public class PieceJointePrestationConverter extends AbstractConverter<PieceJointePrestation,PieceJointePrestationVo>{

        @Autowired
        private PrestationConverter prestationConverter ;
    private Boolean prestation;

public  PieceJointePrestationConverter(){
init(true);
}

@Override
public PieceJointePrestation toItem(PieceJointePrestationVo vo) {
if (vo == null) {
return null;
} else {
PieceJointePrestation item = new PieceJointePrestation();
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
    if(vo.getPrestationVo()!=null && this.prestation)
        item.setPrestation(prestationConverter.toItem(vo.getPrestationVo())) ;


return item;
}
}

@Override
public PieceJointePrestationVo toVo(PieceJointePrestation item) {
if (item == null) {
return null;
} else {
PieceJointePrestationVo vo = new PieceJointePrestationVo();
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

    if(item.getPrestation()!=null && this.prestation) {
        vo.setPrestationVo(prestationConverter.toVo(item.getPrestation())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    prestation = value;
}


        public PrestationConverter getPrestationConverter(){
        return this.prestationConverter;
        }
        public void setPrestationConverter(PrestationConverter prestationConverter ){
        this.prestationConverter = prestationConverter;
        }

    public boolean  isPrestation(){
    return this.prestation;
    }
    public void  setPrestation(boolean prestation){
    this.prestation = prestation;
    }






















}

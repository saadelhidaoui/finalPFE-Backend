package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.PieceJointeReclamation;
import com.ird.faa.ws.rest.provided.vo.PieceJointeReclamationVo;

@Component
public class PieceJointeReclamationConverter extends AbstractConverter<PieceJointeReclamation,PieceJointeReclamationVo>{

        @Autowired
        private ReclamationConverter reclamationConverter ;
    private Boolean reclamation;

public  PieceJointeReclamationConverter(){
init(true);
}

@Override
public PieceJointeReclamation toItem(PieceJointeReclamationVo vo) {
if (vo == null) {
return null;
} else {
PieceJointeReclamation item = new PieceJointeReclamation();
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
    if(vo.getReclamationVo()!=null && this.reclamation)
        item.setReclamation(reclamationConverter.toItem(vo.getReclamationVo())) ;


return item;
}
}

@Override
public PieceJointeReclamationVo toVo(PieceJointeReclamation item) {
if (item == null) {
return null;
} else {
PieceJointeReclamationVo vo = new PieceJointeReclamationVo();
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

    if(item.getReclamation()!=null && this.reclamation) {
        vo.setReclamationVo(reclamationConverter.toVo(item.getReclamation())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    reclamation = value;
}


        public ReclamationConverter getReclamationConverter(){
        return this.reclamationConverter;
        }
        public void setReclamationConverter(ReclamationConverter reclamationConverter ){
        this.reclamationConverter = reclamationConverter;
        }

    public boolean  isReclamation(){
    return this.reclamation;
    }
    public void  setReclamation(boolean reclamation){
    this.reclamation = reclamation;
    }






















}

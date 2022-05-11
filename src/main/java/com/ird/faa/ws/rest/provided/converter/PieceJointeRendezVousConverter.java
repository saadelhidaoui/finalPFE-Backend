package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.PieceJointeRendezVous;
import com.ird.faa.ws.rest.provided.vo.PieceJointeRendezVousVo;

@Component
public class PieceJointeRendezVousConverter extends AbstractConverter<PieceJointeRendezVous,PieceJointeRendezVousVo>{

        @Autowired
        private RendezVousConverter rendezVousConverter ;
    private Boolean rendezVous;

public  PieceJointeRendezVousConverter(){
init(true);
}

@Override
public PieceJointeRendezVous toItem(PieceJointeRendezVousVo vo) {
if (vo == null) {
return null;
} else {
PieceJointeRendezVous item = new PieceJointeRendezVous();
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
    if(vo.getRendezVousVo()!=null && this.rendezVous)
        item.setRendezVous(rendezVousConverter.toItem(vo.getRendezVousVo())) ;


return item;
}
}

@Override
public PieceJointeRendezVousVo toVo(PieceJointeRendezVous item) {
if (item == null) {
return null;
} else {
PieceJointeRendezVousVo vo = new PieceJointeRendezVousVo();
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

    if(item.getRendezVous()!=null && this.rendezVous) {
        vo.setRendezVousVo(rendezVousConverter.toVo(item.getRendezVous())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    rendezVous = value;
}


        public RendezVousConverter getRendezVousConverter(){
        return this.rendezVousConverter;
        }
        public void setRendezVousConverter(RendezVousConverter rendezVousConverter ){
        this.rendezVousConverter = rendezVousConverter;
        }

    public boolean  isRendezVous(){
    return this.rendezVous;
    }
    public void  setRendezVous(boolean rendezVous){
    this.rendezVous = rendezVous;
    }






















}

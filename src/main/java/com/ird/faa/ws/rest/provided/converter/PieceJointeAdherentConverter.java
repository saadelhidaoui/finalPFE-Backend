package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.PieceJointeAdherent;
import com.ird.faa.ws.rest.provided.vo.PieceJointeAdherentVo;

@Component
public class PieceJointeAdherentConverter extends AbstractConverter<PieceJointeAdherent,PieceJointeAdherentVo>{

        @Autowired
        private AdherentConverter adherentConverter ;
    private Boolean adherent;

public  PieceJointeAdherentConverter(){
init(true);
}

@Override
public PieceJointeAdherent toItem(PieceJointeAdherentVo vo) {
if (vo == null) {
return null;
} else {
PieceJointeAdherent item = new PieceJointeAdherent();
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
    if(vo.getAdherentVo()!=null && this.adherent)
        item.setAdherent(adherentConverter.toItem(vo.getAdherentVo())) ;


return item;
}
}

@Override
public PieceJointeAdherentVo toVo(PieceJointeAdherent item) {
if (item == null) {
return null;
} else {
PieceJointeAdherentVo vo = new PieceJointeAdherentVo();
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

    if(item.getAdherent()!=null && this.adherent) {
        vo.setAdherentVo(adherentConverter.toVo(item.getAdherent())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    adherent = value;
}


        public AdherentConverter getAdherentConverter(){
        return this.adherentConverter;
        }
        public void setAdherentConverter(AdherentConverter adherentConverter ){
        this.adherentConverter = adherentConverter;
        }

    public boolean  isAdherent(){
    return this.adherent;
    }
    public void  setAdherent(boolean adherent){
    this.adherent = adherent;
    }






















}

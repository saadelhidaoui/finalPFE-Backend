package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.PieceJointeProjet;
import com.ird.faa.ws.rest.provided.vo.PieceJointeProjetVo;

@Component
public class PieceJointeProjetConverter extends AbstractConverter<PieceJointeProjet,PieceJointeProjetVo>{

        @Autowired
        private ProjetConverter projetConverter ;
    private Boolean projet;

public  PieceJointeProjetConverter(){
init(true);
}

@Override
public PieceJointeProjet toItem(PieceJointeProjetVo vo) {
if (vo == null) {
return null;
} else {
PieceJointeProjet item = new PieceJointeProjet();
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
    if(vo.getProjetVo()!=null && this.projet)
        item.setProjet(projetConverter.toItem(vo.getProjetVo())) ;


return item;
}
}

@Override
public PieceJointeProjetVo toVo(PieceJointeProjet item) {
if (item == null) {
return null;
} else {
PieceJointeProjetVo vo = new PieceJointeProjetVo();
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

    if(item.getProjet()!=null && this.projet) {
        vo.setProjetVo(projetConverter.toVo(item.getProjet())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    projet = value;
}


        public ProjetConverter getProjetConverter(){
        return this.projetConverter;
        }
        public void setProjetConverter(ProjetConverter projetConverter ){
        this.projetConverter = projetConverter;
        }

    public boolean  isProjet(){
    return this.projet;
    }
    public void  setProjet(boolean projet){
    this.projet = projet;
    }






















}

package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.RendezVous;
import com.ird.faa.ws.rest.provided.vo.RendezVousVo;

@Component
public class RendezVousConverter extends AbstractConverter<RendezVous,RendezVousVo>{

        @Autowired
        private PieceJointeRendezVousConverter pieceJointeRendezVousConverter ;
        private Boolean pieceJointeRendezVouss;

public  RendezVousConverter(){
init(true);
}

@Override
public RendezVous toItem(RendezVousVo vo) {
if (vo == null) {
return null;
} else {
RendezVous item = new RendezVous();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getDescription()))
        item.setDescription(vo.getDescription());
        if(StringUtil.isNotEmpty(vo.getDateDebut()))
        item.setDateDebut(DateUtil.parse(vo.getDateDebut()));
        if(StringUtil.isNotEmpty(vo.getPv()))
        item.setPv(vo.getPv());
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

    if(ListUtil.isNotEmpty(vo.getPieceJointeRendezVoussVo()) && this.pieceJointeRendezVouss)
        item.setPieceJointeRendezVouss(pieceJointeRendezVousConverter.toItem(vo.getPieceJointeRendezVoussVo()));

return item;
}
}

@Override
public RendezVousVo toVo(RendezVous item) {
if (item == null) {
return null;
} else {
RendezVousVo vo = new RendezVousVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(StringUtil.isNotEmpty(item.getDescription()))
        vo.setDescription(item.getDescription());

        if(item.getDateDebut()!=null)
        vo.setDateDebut(DateUtil.formateDate(item.getDateDebut()));
        if(StringUtil.isNotEmpty(item.getPv()))
        vo.setPv(item.getPv());


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

        if(ListUtil.isNotEmpty(item.getPieceJointeRendezVouss()) && this.pieceJointeRendezVouss){
        pieceJointeRendezVousConverter.init(true);
        pieceJointeRendezVousConverter.setRendezVous(false);
        vo.setPieceJointeRendezVoussVo(pieceJointeRendezVousConverter.toVo(item.getPieceJointeRendezVouss()));
        pieceJointeRendezVousConverter.setRendezVous(true);
        }

return vo;
}
}

public void init(Boolean value) {
        pieceJointeRendezVouss = value;
}


        public PieceJointeRendezVousConverter getPieceJointeRendezVousConverter(){
        return this.pieceJointeRendezVousConverter;
        }
        public void setPieceJointeRendezVousConverter(PieceJointeRendezVousConverter pieceJointeRendezVousConverter ){
        this.pieceJointeRendezVousConverter = pieceJointeRendezVousConverter;
        }












        public Boolean  isPieceJointeRendezVouss(){
        return this.pieceJointeRendezVouss ;
        }
        public void  setPieceJointeRendezVouss(Boolean pieceJointeRendezVouss ){
        this.pieceJointeRendezVouss  = pieceJointeRendezVouss ;
        }














}

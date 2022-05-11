package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Mission;
import com.ird.faa.ws.rest.provided.vo.MissionVo;

@Component
public class MissionConverter extends AbstractConverter<Mission,MissionVo>{

        @Autowired
        private VilleConverter villeConverter ;
        @Autowired
        private ModerateurConverter moderateurConverter ;
        @Autowired
        private PieceJointeMissionConverter pieceJointeMissionConverter ;
        private Boolean villeDestination;
        private Boolean moderateur;
        private Boolean pieceJointeMissions;

public  MissionConverter(){
init(true);
}

@Override
public Mission toItem(MissionVo vo) {
if (vo == null) {
return null;
} else {
Mission item = new Mission();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getDateDebut()))
        item.setDateDebut(DateUtil.parse(vo.getDateDebut()));
        if(StringUtil.isNotEmpty(vo.getDateFin()))
        item.setDateFin(DateUtil.parse(vo.getDateFin()));
        if(StringUtil.isNotEmpty(vo.getMoyenDeTransport()))
        item.setMoyenDeTransport(vo.getMoyenDeTransport());
        if(StringUtil.isNotEmpty(vo.getDistance()))
        item.setDistance(NumberUtil.toLong(vo.getDistance()));
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
    if(vo.getVilleDestinationVo()!=null && this.villeDestination)
        item.setVilleDestination(villeConverter.toItem(vo.getVilleDestinationVo())) ;
    if(vo.getModerateurVo()!=null && this.moderateur)
        item.setModerateur(moderateurConverter.toItem(vo.getModerateurVo())) ;

    if(ListUtil.isNotEmpty(vo.getPieceJointeMissionsVo()) && this.pieceJointeMissions)
        item.setPieceJointeMissions(pieceJointeMissionConverter.toItem(vo.getPieceJointeMissionsVo()));

return item;
}
}

@Override
public MissionVo toVo(Mission item) {
if (item == null) {
return null;
} else {
MissionVo vo = new MissionVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(item.getDateDebut()!=null)
        vo.setDateDebut(DateUtil.formateDate(item.getDateDebut()));
        if(item.getDateFin()!=null)
        vo.setDateFin(DateUtil.formateDate(item.getDateFin()));
        if(StringUtil.isNotEmpty(item.getMoyenDeTransport()))
        vo.setMoyenDeTransport(item.getMoyenDeTransport());

        if(item.getDistance()!=null)
        vo.setDistance(NumberUtil.toString(item.getDistance()));

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

    if(item.getVilleDestination()!=null && this.villeDestination) {
        vo.setVilleDestinationVo(villeConverter.toVo(item.getVilleDestination())) ;
    }
    if(item.getModerateur()!=null && this.moderateur) {
        vo.setModerateurVo(moderateurConverter.toVo(item.getModerateur())) ;
    }
        if(ListUtil.isNotEmpty(item.getPieceJointeMissions()) && this.pieceJointeMissions){
        pieceJointeMissionConverter.init(true);
        pieceJointeMissionConverter.setMission(false);
        vo.setPieceJointeMissionsVo(pieceJointeMissionConverter.toVo(item.getPieceJointeMissions()));
        pieceJointeMissionConverter.setMission(true);
        }

return vo;
}
}

public void init(Boolean value) {
    villeDestination = value;
    moderateur = value;
        pieceJointeMissions = value;
}


        public VilleConverter getVilleConverter(){
        return this.villeConverter;
        }
        public void setVilleConverter(VilleConverter villeConverter ){
        this.villeConverter = villeConverter;
        }
        public ModerateurConverter getModerateurConverter(){
        return this.moderateurConverter;
        }
        public void setModerateurConverter(ModerateurConverter moderateurConverter ){
        this.moderateurConverter = moderateurConverter;
        }
        public PieceJointeMissionConverter getPieceJointeMissionConverter(){
        return this.pieceJointeMissionConverter;
        }
        public void setPieceJointeMissionConverter(PieceJointeMissionConverter pieceJointeMissionConverter ){
        this.pieceJointeMissionConverter = pieceJointeMissionConverter;
        }

    public boolean  isVilleDestination(){
    return this.villeDestination;
    }
    public void  setVilleDestination(boolean villeDestination){
    this.villeDestination = villeDestination;
    }
    public boolean  isModerateur(){
    return this.moderateur;
    }
    public void  setModerateur(boolean moderateur){
    this.moderateur = moderateur;
    }



















        public Boolean  isPieceJointeMissions(){
        return this.pieceJointeMissions ;
        }
        public void  setPieceJointeMissions(Boolean pieceJointeMissions ){
        this.pieceJointeMissions  = pieceJointeMissions ;
        }














}

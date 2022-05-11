package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.PieceJointeMission;
import com.ird.faa.ws.rest.provided.vo.PieceJointeMissionVo;

@Component
public class PieceJointeMissionConverter extends AbstractConverter<PieceJointeMission,PieceJointeMissionVo>{

        @Autowired
        private MissionConverter missionConverter ;
    private Boolean mission;

public  PieceJointeMissionConverter(){
init(true);
}

@Override
public PieceJointeMission toItem(PieceJointeMissionVo vo) {
if (vo == null) {
return null;
} else {
PieceJointeMission item = new PieceJointeMission();
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
    if(vo.getMissionVo()!=null && this.mission)
        item.setMission(missionConverter.toItem(vo.getMissionVo())) ;


return item;
}
}

@Override
public PieceJointeMissionVo toVo(PieceJointeMission item) {
if (item == null) {
return null;
} else {
PieceJointeMissionVo vo = new PieceJointeMissionVo();
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

    if(item.getMission()!=null && this.mission) {
        vo.setMissionVo(missionConverter.toVo(item.getMission())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    mission = value;
}


        public MissionConverter getMissionConverter(){
        return this.missionConverter;
        }
        public void setMissionConverter(MissionConverter missionConverter ){
        this.missionConverter = missionConverter;
        }

    public boolean  isMission(){
    return this.mission;
    }
    public void  setMission(boolean mission){
    this.mission = mission;
    }






















}

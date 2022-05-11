package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.SituationModerateur;
import com.ird.faa.ws.rest.provided.vo.SituationModerateurVo;

@Component
public class SituationModerateurConverter extends AbstractConverter<SituationModerateur,SituationModerateurVo>{


public  SituationModerateurConverter(){
init(true);
}

@Override
public SituationModerateur toItem(SituationModerateurVo vo) {
if (vo == null) {
return null;
} else {
SituationModerateur item = new SituationModerateur();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());


return item;
}
}

@Override
public SituationModerateurVo toVo(SituationModerateur item) {
if (item == null) {
return null;
} else {
SituationModerateurVo vo = new SituationModerateurVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());


return vo;
}
}

public void init(Boolean value) {
}









}

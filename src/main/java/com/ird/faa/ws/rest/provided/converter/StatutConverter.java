package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Statut;
import com.ird.faa.ws.rest.provided.vo.StatutVo;

@Component
public class StatutConverter extends AbstractConverter<Statut,StatutVo>{


public  StatutConverter(){
init(true);
}

@Override
public Statut toItem(StatutVo vo) {
if (vo == null) {
return null;
} else {
Statut item = new Statut();
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
public StatutVo toVo(Statut item) {
if (item == null) {
return null;
} else {
StatutVo vo = new StatutVo();
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

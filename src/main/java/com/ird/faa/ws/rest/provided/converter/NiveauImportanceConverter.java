package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.NiveauImportance;
import com.ird.faa.ws.rest.provided.vo.NiveauImportanceVo;

@Component
public class NiveauImportanceConverter extends AbstractConverter<NiveauImportance,NiveauImportanceVo>{


public  NiveauImportanceConverter(){
init(true);
}

@Override
public NiveauImportance toItem(NiveauImportanceVo vo) {
if (vo == null) {
return null;
} else {
NiveauImportance item = new NiveauImportance();
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
public NiveauImportanceVo toVo(NiveauImportance item) {
if (item == null) {
return null;
} else {
NiveauImportanceVo vo = new NiveauImportanceVo();
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

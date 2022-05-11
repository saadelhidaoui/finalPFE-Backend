package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.TypePrestation;
import com.ird.faa.ws.rest.provided.vo.TypePrestationVo;

@Component
public class TypePrestationConverter extends AbstractConverter<TypePrestation,TypePrestationVo>{


public  TypePrestationConverter(){
init(true);
}

@Override
public TypePrestation toItem(TypePrestationVo vo) {
if (vo == null) {
return null;
} else {
TypePrestation item = new TypePrestation();
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
public TypePrestationVo toVo(TypePrestation item) {
if (item == null) {
return null;
} else {
TypePrestationVo vo = new TypePrestationVo();
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

package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Echelon;
import com.ird.faa.ws.rest.provided.vo.EchelonVo;

@Component
public class EchelonConverter extends AbstractConverter<Echelon,EchelonVo>{


public  EchelonConverter(){
init(true);
}

@Override
public Echelon toItem(EchelonVo vo) {
if (vo == null) {
return null;
} else {
Echelon item = new Echelon();
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
public EchelonVo toVo(Echelon item) {
if (item == null) {
return null;
} else {
EchelonVo vo = new EchelonVo();
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

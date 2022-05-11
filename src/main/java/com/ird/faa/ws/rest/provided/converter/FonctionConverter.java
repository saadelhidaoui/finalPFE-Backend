package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Fonction;
import com.ird.faa.ws.rest.provided.vo.FonctionVo;

@Component
public class FonctionConverter extends AbstractConverter<Fonction,FonctionVo>{


public  FonctionConverter(){
init(true);
}

@Override
public Fonction toItem(FonctionVo vo) {
if (vo == null) {
return null;
} else {
Fonction item = new Fonction();
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
public FonctionVo toVo(Fonction item) {
if (item == null) {
return null;
} else {
FonctionVo vo = new FonctionVo();
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

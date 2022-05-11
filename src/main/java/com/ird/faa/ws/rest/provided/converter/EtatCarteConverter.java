package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.EtatCarte;
import com.ird.faa.ws.rest.provided.vo.EtatCarteVo;

@Component
public class EtatCarteConverter extends AbstractConverter<EtatCarte,EtatCarteVo>{


public  EtatCarteConverter(){
init(true);
}

@Override
public EtatCarte toItem(EtatCarteVo vo) {
if (vo == null) {
return null;
} else {
EtatCarte item = new EtatCarte();
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
public EtatCarteVo toVo(EtatCarte item) {
if (item == null) {
return null;
} else {
EtatCarteVo vo = new EtatCarteVo();
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

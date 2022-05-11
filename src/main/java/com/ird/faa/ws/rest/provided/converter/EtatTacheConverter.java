package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.EtatTache;
import com.ird.faa.ws.rest.provided.vo.EtatTacheVo;

@Component
public class EtatTacheConverter extends AbstractConverter<EtatTache,EtatTacheVo>{


public  EtatTacheConverter(){
init(true);
}

@Override
public EtatTache toItem(EtatTacheVo vo) {
if (vo == null) {
return null;
} else {
EtatTache item = new EtatTache();
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
public EtatTacheVo toVo(EtatTache item) {
if (item == null) {
return null;
} else {
EtatTacheVo vo = new EtatTacheVo();
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

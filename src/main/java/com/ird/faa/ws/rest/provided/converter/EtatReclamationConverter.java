package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.EtatReclamation;
import com.ird.faa.ws.rest.provided.vo.EtatReclamationVo;

@Component
public class EtatReclamationConverter extends AbstractConverter<EtatReclamation,EtatReclamationVo>{


public  EtatReclamationConverter(){
init(true);
}

@Override
public EtatReclamation toItem(EtatReclamationVo vo) {
if (vo == null) {
return null;
} else {
EtatReclamation item = new EtatReclamation();
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
public EtatReclamationVo toVo(EtatReclamation item) {
if (item == null) {
return null;
} else {
EtatReclamationVo vo = new EtatReclamationVo();
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

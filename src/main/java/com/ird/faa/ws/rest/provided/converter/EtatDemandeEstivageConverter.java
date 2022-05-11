package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.EtatDemandeEstivage;
import com.ird.faa.ws.rest.provided.vo.EtatDemandeEstivageVo;

@Component
public class EtatDemandeEstivageConverter extends AbstractConverter<EtatDemandeEstivage,EtatDemandeEstivageVo>{


public  EtatDemandeEstivageConverter(){
init(true);
}

@Override
public EtatDemandeEstivage toItem(EtatDemandeEstivageVo vo) {
if (vo == null) {
return null;
} else {
EtatDemandeEstivage item = new EtatDemandeEstivage();
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
public EtatDemandeEstivageVo toVo(EtatDemandeEstivage item) {
if (item == null) {
return null;
} else {
EtatDemandeEstivageVo vo = new EtatDemandeEstivageVo();
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

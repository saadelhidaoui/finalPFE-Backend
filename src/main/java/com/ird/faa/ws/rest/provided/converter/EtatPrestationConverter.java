package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.EtatPrestation;
import com.ird.faa.ws.rest.provided.vo.EtatPrestationVo;

@Component
public class EtatPrestationConverter extends AbstractConverter<EtatPrestation,EtatPrestationVo>{


public  EtatPrestationConverter(){
init(true);
}

@Override
public EtatPrestation toItem(EtatPrestationVo vo) {
if (vo == null) {
return null;
} else {
EtatPrestation item = new EtatPrestation();
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
public EtatPrestationVo toVo(EtatPrestation item) {
if (item == null) {
return null;
} else {
EtatPrestationVo vo = new EtatPrestationVo();
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

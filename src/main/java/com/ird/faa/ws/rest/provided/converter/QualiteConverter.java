package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Qualite;
import com.ird.faa.ws.rest.provided.vo.QualiteVo;

@Component
public class QualiteConverter extends AbstractConverter<Qualite,QualiteVo>{


public  QualiteConverter(){
init(true);
}

@Override
public Qualite toItem(QualiteVo vo) {
if (vo == null) {
return null;
} else {
Qualite item = new Qualite();
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
public QualiteVo toVo(Qualite item) {
if (item == null) {
return null;
} else {
QualiteVo vo = new QualiteVo();
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

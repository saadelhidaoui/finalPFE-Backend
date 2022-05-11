package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Grade;
import com.ird.faa.ws.rest.provided.vo.GradeVo;

@Component
public class GradeConverter extends AbstractConverter<Grade,GradeVo>{


public  GradeConverter(){
init(true);
}

@Override
public Grade toItem(GradeVo vo) {
if (vo == null) {
return null;
} else {
Grade item = new Grade();
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
public GradeVo toVo(Grade item) {
if (item == null) {
return null;
} else {
GradeVo vo = new GradeVo();
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

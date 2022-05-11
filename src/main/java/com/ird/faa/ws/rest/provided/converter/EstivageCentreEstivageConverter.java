package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.EstivageCentreEstivage;
import com.ird.faa.ws.rest.provided.vo.EstivageCentreEstivageVo;

@Component
public class EstivageCentreEstivageConverter extends AbstractConverter<EstivageCentreEstivage,EstivageCentreEstivageVo>{

        @Autowired
        private CentreEstivageConverter centreEstivageConverter ;
        @Autowired
        private EstivageConverter estivageConverter ;
    private Boolean centreEstivage;
    private Boolean estivage;

public  EstivageCentreEstivageConverter(){
init(true);
}

@Override
public EstivageCentreEstivage toItem(EstivageCentreEstivageVo vo) {
if (vo == null) {
return null;
} else {
EstivageCentreEstivage item = new EstivageCentreEstivage();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getOrdre()))
        item.setOrdre(NumberUtil.toLong(vo.getOrdre()));
    if(vo.getCentreEstivageVo()!=null && this.centreEstivage)
        item.setCentreEstivage(centreEstivageConverter.toItem(vo.getCentreEstivageVo())) ;
    if(vo.getEstivageVo()!=null && this.estivage)
        item.setEstivage(estivageConverter.toItem(vo.getEstivageVo())) ;


return item;
}
}

@Override
public EstivageCentreEstivageVo toVo(EstivageCentreEstivage item) {
if (item == null) {
return null;
} else {
EstivageCentreEstivageVo vo = new EstivageCentreEstivageVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(item.getOrdre()!=null)
        vo.setOrdre(NumberUtil.toString(item.getOrdre()));

    if(item.getCentreEstivage()!=null && this.centreEstivage) {
        vo.setCentreEstivageVo(centreEstivageConverter.toVo(item.getCentreEstivage())) ;
    }
    if(item.getEstivage()!=null && this.estivage) {
        vo.setEstivageVo(estivageConverter.toVo(item.getEstivage())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    centreEstivage = value;
    estivage = value;
}


        public CentreEstivageConverter getCentreEstivageConverter(){
        return this.centreEstivageConverter;
        }
        public void setCentreEstivageConverter(CentreEstivageConverter centreEstivageConverter ){
        this.centreEstivageConverter = centreEstivageConverter;
        }
        public EstivageConverter getEstivageConverter(){
        return this.estivageConverter;
        }
        public void setEstivageConverter(EstivageConverter estivageConverter ){
        this.estivageConverter = estivageConverter;
        }

    public boolean  isCentreEstivage(){
    return this.centreEstivage;
    }
    public void  setCentreEstivage(boolean centreEstivage){
    this.centreEstivage = centreEstivage;
    }
    public boolean  isEstivage(){
    return this.estivage;
    }
    public void  setEstivage(boolean estivage){
    this.estivage = estivage;
    }










}

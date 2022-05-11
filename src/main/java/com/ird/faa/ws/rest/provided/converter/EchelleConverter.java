package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Echelle;
import com.ird.faa.ws.rest.provided.vo.EchelleVo;

@Component
public class EchelleConverter extends AbstractConverter<Echelle,EchelleVo>{

        @Autowired
        private EchelonConverter echelonConverter ;
    private Boolean echelon;

public  EchelleConverter(){
init(true);
}

@Override
public Echelle toItem(EchelleVo vo) {
if (vo == null) {
return null;
} else {
Echelle item = new Echelle();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
    if(vo.getEchelonVo()!=null && this.echelon)
        item.setEchelon(echelonConverter.toItem(vo.getEchelonVo())) ;


return item;
}
}

@Override
public EchelleVo toVo(Echelle item) {
if (item == null) {
return null;
} else {
EchelleVo vo = new EchelleVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

    if(item.getEchelon()!=null && this.echelon) {
        vo.setEchelonVo(echelonConverter.toVo(item.getEchelon())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    echelon = value;
}


        public EchelonConverter getEchelonConverter(){
        return this.echelonConverter;
        }
        public void setEchelonConverter(EchelonConverter echelonConverter ){
        this.echelonConverter = echelonConverter;
        }

    public boolean  isEchelon(){
    return this.echelon;
    }
    public void  setEchelon(boolean echelon){
    this.echelon = echelon;
    }








}

package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.DemandeEstivageCentre;
import com.ird.faa.ws.rest.provided.vo.DemandeEstivageCentreVo;

@Component
public class DemandeEstivageCentreConverter extends AbstractConverter<DemandeEstivageCentre,DemandeEstivageCentreVo>{

        @Autowired
        private DemandeEstivageConverter demandeEstivageConverter ;
        @Autowired
        private CentreEstivageConverter centreEstivageConverter ;
    private Boolean demandeEstivage;
    private Boolean CentreEstivage;

public  DemandeEstivageCentreConverter(){
init(true);
}

@Override
public DemandeEstivageCentre toItem(DemandeEstivageCentreVo vo) {
if (vo == null) {
return null;
} else {
DemandeEstivageCentre item = new DemandeEstivageCentre();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
    if(vo.getDemandeEstivageVo()!=null && this.demandeEstivage)
        item.setDemandeEstivage(demandeEstivageConverter.toItem(vo.getDemandeEstivageVo())) ;
    if(vo.getCentreEstivageVo()!=null && this.CentreEstivage)
        item.setCentreEstivage(centreEstivageConverter.toItem(vo.getCentreEstivageVo())) ;


return item;
}
}

@Override
public DemandeEstivageCentreVo toVo(DemandeEstivageCentre item) {
if (item == null) {
return null;
} else {
DemandeEstivageCentreVo vo = new DemandeEstivageCentreVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

    if(item.getDemandeEstivage()!=null && this.demandeEstivage) {
                demandeEstivageConverter.setDemandeEstivageCentre(false);
        vo.setDemandeEstivageVo(demandeEstivageConverter.toVo(item.getDemandeEstivage())) ;
                demandeEstivageConverter.setDemandeEstivageCentre(true);
    }
    if(item.getCentreEstivage()!=null && this.CentreEstivage) {
        vo.setCentreEstivageVo(centreEstivageConverter.toVo(item.getCentreEstivage())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    demandeEstivage = value;
    CentreEstivage = value;
}


        public DemandeEstivageConverter getDemandeEstivageConverter(){
        return this.demandeEstivageConverter;
        }
        public void setDemandeEstivageConverter(DemandeEstivageConverter demandeEstivageConverter ){
        this.demandeEstivageConverter = demandeEstivageConverter;
        }
        public CentreEstivageConverter getCentreEstivageConverter(){
        return this.centreEstivageConverter;
        }
        public void setCentreEstivageConverter(CentreEstivageConverter centreEstivageConverter ){
        this.centreEstivageConverter = centreEstivageConverter;
        }

    public boolean  isDemandeEstivage(){
    return this.demandeEstivage;
    }
    public void  setDemandeEstivage(boolean demandeEstivage){
    this.demandeEstivage = demandeEstivage;
    }
    public boolean  isCentreEstivage(){
    return this.CentreEstivage;
    }
    public void  setCentreEstivage(boolean CentreEstivage){
    this.CentreEstivage = CentreEstivage;
    }








}

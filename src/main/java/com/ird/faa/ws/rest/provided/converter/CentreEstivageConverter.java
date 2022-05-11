package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.CentreEstivage;
import com.ird.faa.ws.rest.provided.vo.CentreEstivageVo;

@Component
public class CentreEstivageConverter extends AbstractConverter<CentreEstivage,CentreEstivageVo>{

        @Autowired
        private VilleConverter villeConverter ;
    private Boolean ville;

public  CentreEstivageConverter(){
init(true);
}

@Override
public CentreEstivage toItem(CentreEstivageVo vo) {
if (vo == null) {
return null;
} else {
CentreEstivage item = new CentreEstivage();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getCapacite()))
        item.setCapacite(NumberUtil.toLong(vo.getCapacite()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
            if(vo.getVip() != null)
            item.setVip(vo.getVip());
    if(vo.getVilleVo()!=null && this.ville)
        item.setVille(villeConverter.toItem(vo.getVilleVo())) ;


return item;
}
}

@Override
public CentreEstivageVo toVo(CentreEstivage item) {
if (item == null) {
return null;
} else {
CentreEstivageVo vo = new CentreEstivageVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(item.getCapacite()!=null)
        vo.setCapacite(NumberUtil.toString(item.getCapacite()));

        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(item.getVip()!=null)
        vo.setVip(item.getVip());
    if(item.getVille()!=null && this.ville) {
        vo.setVilleVo(villeConverter.toVo(item.getVille())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    ville = value;
}


        public VilleConverter getVilleConverter(){
        return this.villeConverter;
        }
        public void setVilleConverter(VilleConverter villeConverter ){
        this.villeConverter = villeConverter;
        }

    public boolean  isVille(){
    return this.ville;
    }
    public void  setVille(boolean ville){
    this.ville = ville;
    }












}

package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Ville;
import com.ird.faa.ws.rest.provided.vo.VilleVo;

@Component
public class VilleConverter extends AbstractConverter<Ville,VilleVo>{

        @Autowired
        private RegionConverter regionConverter ;
    private Boolean region;

public  VilleConverter(){
init(true);
}

@Override
public Ville toItem(VilleVo vo) {
if (vo == null) {
return null;
} else {
Ville item = new Ville();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
    if(vo.getRegionVo()!=null && this.region)
        item.setRegion(regionConverter.toItem(vo.getRegionVo())) ;


return item;
}
}

@Override
public VilleVo toVo(Ville item) {
if (item == null) {
return null;
} else {
VilleVo vo = new VilleVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

    if(item.getRegion()!=null && this.region) {
        vo.setRegionVo(regionConverter.toVo(item.getRegion())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    region = value;
}


        public RegionConverter getRegionConverter(){
        return this.regionConverter;
        }
        public void setRegionConverter(RegionConverter regionConverter ){
        this.regionConverter = regionConverter;
        }

    public boolean  isRegion(){
    return this.region;
    }
    public void  setRegion(boolean region){
    this.region = region;
    }








}

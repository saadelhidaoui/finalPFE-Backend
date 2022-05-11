package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Organisme;
import com.ird.faa.ws.rest.provided.vo.OrganismeVo;

@Component
public class OrganismeConverter extends AbstractConverter<Organisme,OrganismeVo>{

        @Autowired
        private VilleConverter villeConverter ;
    private Boolean ville;

public  OrganismeConverter(){
init(true);
}

@Override
public Organisme toItem(OrganismeVo vo) {
if (vo == null) {
return null;
} else {
Organisme item = new Organisme();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getTelephone()))
        item.setTelephone(vo.getTelephone());
        if(StringUtil.isNotEmpty(vo.getEmail()))
        item.setEmail(vo.getEmail());
        if(StringUtil.isNotEmpty(vo.getFix()))
        item.setFix(vo.getFix());
        if(StringUtil.isNotEmpty(vo.getFax()))
        item.setFax(vo.getFax());
    if(vo.getVilleVo()!=null && this.ville)
        item.setVille(villeConverter.toItem(vo.getVilleVo())) ;


return item;
}
}

@Override
public OrganismeVo toVo(Organisme item) {
if (item == null) {
return null;
} else {
OrganismeVo vo = new OrganismeVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(StringUtil.isNotEmpty(item.getTelephone()))
        vo.setTelephone(item.getTelephone());

        if(StringUtil.isNotEmpty(item.getEmail()))
        vo.setEmail(item.getEmail());

        if(StringUtil.isNotEmpty(item.getFix()))
        vo.setFix(item.getFix());

        if(StringUtil.isNotEmpty(item.getFax()))
        vo.setFax(item.getFax());

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

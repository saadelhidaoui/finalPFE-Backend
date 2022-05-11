package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Profil;
import com.ird.faa.ws.rest.provided.vo.ProfilVo;

@Component
public class ProfilConverter extends AbstractConverter<Profil,ProfilVo>{

        @Autowired
        private GradeConverter gradeConverter ;
        @Autowired
        private EchelleConverter echelleConverter ;
    private Boolean grade;
    private Boolean echelle;

public  ProfilConverter(){
init(true);
}

@Override
public Profil toItem(ProfilVo vo) {
if (vo == null) {
return null;
} else {
Profil item = new Profil();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
    if(vo.getGradeVo()!=null && this.grade)
        item.setGrade(gradeConverter.toItem(vo.getGradeVo())) ;
    if(vo.getEchelleVo()!=null && this.echelle)
        item.setEchelle(echelleConverter.toItem(vo.getEchelleVo())) ;


return item;
}
}

@Override
public ProfilVo toVo(Profil item) {
if (item == null) {
return null;
} else {
ProfilVo vo = new ProfilVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

    if(item.getGrade()!=null && this.grade) {
        vo.setGradeVo(gradeConverter.toVo(item.getGrade())) ;
    }
    if(item.getEchelle()!=null && this.echelle) {
        vo.setEchelleVo(echelleConverter.toVo(item.getEchelle())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    grade = value;
    echelle = value;
}


        public GradeConverter getGradeConverter(){
        return this.gradeConverter;
        }
        public void setGradeConverter(GradeConverter gradeConverter ){
        this.gradeConverter = gradeConverter;
        }
        public EchelleConverter getEchelleConverter(){
        return this.echelleConverter;
        }
        public void setEchelleConverter(EchelleConverter echelleConverter ){
        this.echelleConverter = echelleConverter;
        }

    public boolean  isGrade(){
    return this.grade;
    }
    public void  setGrade(boolean grade){
    this.grade = grade;
    }
    public boolean  isEchelle(){
    return this.echelle;
    }
    public void  setEchelle(boolean echelle){
    this.echelle = echelle;
    }










}

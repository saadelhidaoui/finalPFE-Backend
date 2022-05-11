package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.ImpressionCarte;
import com.ird.faa.ws.rest.provided.vo.ImpressionCarteVo;

@Component
public class ImpressionCarteConverter extends AbstractConverter<ImpressionCarte,ImpressionCarteVo>{


public  ImpressionCarteConverter(){
init(true);
}

@Override
public ImpressionCarte toItem(ImpressionCarteVo vo) {
if (vo == null) {
return null;
} else {
ImpressionCarte item = new ImpressionCarte();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getAff()))
        item.setAff(vo.getAff());
        if(StringUtil.isNotEmpty(vo.getQualite()))
        item.setQualite(vo.getQualite());
        if(StringUtil.isNotEmpty(vo.getNom()))
        item.setNom(vo.getNom());
        if(StringUtil.isNotEmpty(vo.getPrenom()))
        item.setPrenom(vo.getPrenom());
        if(StringUtil.isNotEmpty(vo.getNomprenomar()))
        item.setNomprenomar(vo.getNomprenomar());
        if(StringUtil.isNotEmpty(vo.getNomAr()))
        item.setNomAr(vo.getNomAr());
        if(StringUtil.isNotEmpty(vo.getPrenomAr()))
        item.setPrenomAr(vo.getPrenomAr());
        if(StringUtil.isNotEmpty(vo.getCinn()))
        item.setCinn(vo.getCinn());
        if(StringUtil.isNotEmpty(vo.getCin()))
        item.setCin(vo.getCin());
        if(StringUtil.isNotEmpty(vo.getPprr()))
        item.setPprr(vo.getPprr());
        if(StringUtil.isNotEmpty(vo.getPpr()))
        item.setPpr(vo.getPpr());
        if(StringUtil.isNotEmpty(vo.getNaissance()))
        item.setNaissance(vo.getNaissance());
        if(StringUtil.isNotEmpty(vo.getDateNaissance()))
        item.setDateNaissance(DateUtil.parse(vo.getDateNaissance()));
        if(StringUtil.isNotEmpty(vo.getPhoto()))
        item.setPhoto(vo.getPhoto());
        if(StringUtil.isNotEmpty(vo.getCinnConjoint()))
        item.setCinnConjoint(vo.getCinnConjoint());
        if(StringUtil.isNotEmpty(vo.getCinConjoint()))
        item.setCinConjoint(vo.getCinConjoint());
        if(StringUtil.isNotEmpty(vo.getAdherent()))
        item.setAdherent(vo.getAdherent());
        if(StringUtil.isNotEmpty(vo.getNomAdherent()))
        item.setNomAdherent(vo.getNomAdherent());
        if(StringUtil.isNotEmpty(vo.getPrenomAdherent()))
        item.setPrenomAdherent(vo.getPrenomAdherent());
        if(StringUtil.isNotEmpty(vo.getCinnAdherent()))
        item.setCinnAdherent(vo.getCinnAdherent());
        if(StringUtil.isNotEmpty(vo.getCinAdherent()))
        item.setCinAdherent(vo.getCinAdherent());
        if(StringUtil.isNotEmpty(vo.getPprrAdherent()))
        item.setPprrAdherent(vo.getPprrAdherent());
        if(StringUtil.isNotEmpty(vo.getPprAdherent()))
        item.setPprAdherent(vo.getPprAdherent());
        if(StringUtil.isNotEmpty(vo.getVersocarte()))
        item.setVersocarte(vo.getVersocarte());
        if(StringUtil.isNotEmpty(vo.getAff1()))
        item.setAff1(vo.getAff1());
        if(StringUtil.isNotEmpty(vo.getAff2()))
        item.setAff2(vo.getAff2());
        if(StringUtil.isNotEmpty(vo.getNval()))
        item.setNval(vo.getNval());


return item;
}
}

@Override
public ImpressionCarteVo toVo(ImpressionCarte item) {
if (item == null) {
return null;
} else {
ImpressionCarteVo vo = new ImpressionCarteVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getAff()))
        vo.setAff(item.getAff());

        if(StringUtil.isNotEmpty(item.getQualite()))
        vo.setQualite(item.getQualite());

        if(StringUtil.isNotEmpty(item.getNom()))
        vo.setNom(item.getNom());

        if(StringUtil.isNotEmpty(item.getPrenom()))
        vo.setPrenom(item.getPrenom());

        if(StringUtil.isNotEmpty(item.getNomprenomar()))
        vo.setNomprenomar(item.getNomprenomar());

        if(StringUtil.isNotEmpty(item.getNomAr()))
        vo.setNomAr(item.getNomAr());

        if(StringUtil.isNotEmpty(item.getPrenomAr()))
        vo.setPrenomAr(item.getPrenomAr());

        if(StringUtil.isNotEmpty(item.getCinn()))
        vo.setCinn(item.getCinn());

        if(StringUtil.isNotEmpty(item.getCin()))
        vo.setCin(item.getCin());

        if(StringUtil.isNotEmpty(item.getPprr()))
        vo.setPprr(item.getPprr());

        if(StringUtil.isNotEmpty(item.getPpr()))
        vo.setPpr(item.getPpr());

        if(StringUtil.isNotEmpty(item.getNaissance()))
        vo.setNaissance(item.getNaissance());

        if(item.getDateNaissance()!=null)
        vo.setDateNaissance(DateUtil.formateDate(item.getDateNaissance()));
        if(StringUtil.isNotEmpty(item.getPhoto()))
        vo.setPhoto(item.getPhoto());

        if(StringUtil.isNotEmpty(item.getCinnConjoint()))
        vo.setCinnConjoint(item.getCinnConjoint());

        if(StringUtil.isNotEmpty(item.getCinConjoint()))
        vo.setCinConjoint(item.getCinConjoint());

        if(StringUtil.isNotEmpty(item.getAdherent()))
        vo.setAdherent(item.getAdherent());

        if(StringUtil.isNotEmpty(item.getNomAdherent()))
        vo.setNomAdherent(item.getNomAdherent());

        if(StringUtil.isNotEmpty(item.getPrenomAdherent()))
        vo.setPrenomAdherent(item.getPrenomAdherent());

        if(StringUtil.isNotEmpty(item.getCinnAdherent()))
        vo.setCinnAdherent(item.getCinnAdherent());

        if(StringUtil.isNotEmpty(item.getCinAdherent()))
        vo.setCinAdherent(item.getCinAdherent());

        if(StringUtil.isNotEmpty(item.getPprrAdherent()))
        vo.setPprrAdherent(item.getPprrAdherent());

        if(StringUtil.isNotEmpty(item.getPprAdherent()))
        vo.setPprAdherent(item.getPprAdherent());

        if(StringUtil.isNotEmpty(item.getVersocarte()))
        vo.setVersocarte(item.getVersocarte());

        if(StringUtil.isNotEmpty(item.getAff1()))
        vo.setAff1(item.getAff1());

        if(StringUtil.isNotEmpty(item.getAff2()))
        vo.setAff2(item.getAff2());

        if(StringUtil.isNotEmpty(item.getNval()))
        vo.setNval(item.getNval());


return vo;
}
}

public void init(Boolean value) {
}



























































}

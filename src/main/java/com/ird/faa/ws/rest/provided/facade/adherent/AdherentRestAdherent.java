package com.ird.faa.ws.rest.provided.facade.adherent;

import com.ird.faa.bean.Adherent;
import com.ird.faa.service.adherent.facade.AdherentAdherentService;
import com.ird.faa.ws.rest.provided.converter.AdherentConverter;
import com.ird.faa.ws.rest.provided.vo.AdherentVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Api("Manages adherent services")
@RestController
@RequestMapping("api/adherent/adherent")
public class AdherentRestAdherent {

    @Autowired
    private AdherentAdherentService adherentService;

    @Autowired
    private AdherentConverter adherentConverter;


    @ApiOperation("Updates the specified  adherent")
    @PutMapping("/")
    public AdherentVo update(@RequestBody AdherentVo adherentVo) {
        Adherent adherent = adherentConverter.toItem(adherentVo);
        adherent = adherentService.update(adherent);
        return adherentConverter.toVo(adherent);
    }

    @ApiOperation("Finds a list of all adherents")
    @GetMapping("/")
    public List<AdherentVo> findAll() {
        return adherentConverter.toVo(adherentService.findAll());
    }

    @ApiOperation("Finds a adherent with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public AdherentVo findByIdWithAssociatedList(@PathVariable Long id) {
        return adherentConverter.toVo(adherentService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search adherent by a specific criteria")
    @PostMapping("/search")
    public List<AdherentVo> findByCriteria(@RequestBody AdherentVo adherentVo) {
        return adherentConverter.toVo(adherentService.findByCriteria(adherentVo));
    }

    @ApiOperation("Finds a adherent by id")
    @GetMapping("/id/{id}")
    public AdherentVo findById(@PathVariable Long id) {
        return adherentConverter.toVo(adherentService.findById(id));
    }

    @ApiOperation("Saves the specified  adherent")
    @PostMapping("/")
    public AdherentVo save(@RequestBody AdherentVo adherentVo) {
        Adherent adherent = adherentConverter.toItem(adherentVo);
        adherent = adherentService.save(adherent);
        return adherentConverter.toVo(adherent);
    }

    @ApiOperation("Delete the specified adherent")
    @DeleteMapping("/")
    public int delete(@RequestBody AdherentVo adherentVo) {
        Adherent adherent = adherentConverter.toItem(adherentVo);
        return adherentService.delete(adherent);
    }

    @ApiOperation("Deletes a adherent by id")
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return adherentService.deleteById(id);
    }

    @ApiOperation("find by ville id")
    @GetMapping("/ville/id/{id}")
    public List<Adherent> findByVilleId(@PathVariable Long id) {
        return adherentService.findByVilleId(id);
    }

    @ApiOperation("delete by ville id")
    @DeleteMapping("/ville/id/{id}")
    public int deleteByVilleId(@PathVariable Long id) {
        return adherentService.deleteByVilleId(id);
    }

    @ApiOperation("find by qualite reference")
    @GetMapping("/qualite/reference/{reference}")
    public List<Adherent> findByQualiteReference(@PathVariable String reference) {
        return adherentService.findByQualiteReference(reference);
    }

    @ApiOperation("delete by qualite reference")
    @DeleteMapping("/qualite/reference/{reference}")
    public int deleteByQualiteReference(@PathVariable String reference) {
        return adherentService.deleteByQualiteReference(reference);
    }

    @ApiOperation("find by qualite id")
    @GetMapping("/qualite/id/{id}")
    public List<Adherent> findByQualiteId(@PathVariable Long id) {
        return adherentService.findByQualiteId(id);
    }

    @ApiOperation("delete by qualite id")
    @DeleteMapping("/qualite/id/{id}")
    public int deleteByQualiteId(@PathVariable Long id) {
        return adherentService.deleteByQualiteId(id);
    }

    @ApiOperation("find by etatCarte reference")
    @GetMapping("/etatCarte/reference/{reference}")
    public List<Adherent> findByEtatCarteReference(@PathVariable String reference) {
        return adherentService.findByEtatCarteReference(reference);
    }

    @ApiOperation("delete by etatCarte reference")
    @DeleteMapping("/etatCarte/reference/{reference}")
    public int deleteByEtatCarteReference(@PathVariable String reference) {
        return adherentService.deleteByEtatCarteReference(reference);
    }

    @ApiOperation("find by etatCarte id")
    @GetMapping("/etatCarte/id/{id}")
    public List<Adherent> findByEtatCarteId(@PathVariable Long id) {
        return adherentService.findByEtatCarteId(id);
    }

    @ApiOperation("delete by etatCarte id")
    @DeleteMapping("/etatCarte/id/{id}")
    public int deleteByEtatCarteId(@PathVariable Long id) {
        return adherentService.deleteByEtatCarteId(id);
    }

    @ApiOperation("find by statut reference")
    @GetMapping("/statut/reference/{reference}")
    public List<Adherent> findByStatutReference(@PathVariable String reference) {
        return adherentService.findByStatutReference(reference);
    }

    @ApiOperation("delete by statut reference")
    @DeleteMapping("/statut/reference/{reference}")
    public int deleteByStatutReference(@PathVariable String reference) {
        return adherentService.deleteByStatutReference(reference);
    }

    @ApiOperation("find by statut id")
    @GetMapping("/statut/id/{id}")
    public List<Adherent> findByStatutId(@PathVariable Long id) {
        return adherentService.findByStatutId(id);
    }

    @ApiOperation("delete by statut id")
    @DeleteMapping("/statut/id/{id}")
    public int deleteByStatutId(@PathVariable Long id) {
        return adherentService.deleteByStatutId(id);
    }

    @ApiOperation("find by fonction reference")
    @GetMapping("/fonction/reference/{reference}")
    public List<Adherent> findByFonctionReference(@PathVariable String reference) {
        return adherentService.findByFonctionReference(reference);
    }

    @ApiOperation("delete by fonction reference")
    @DeleteMapping("/fonction/reference/{reference}")
    public int deleteByFonctionReference(@PathVariable String reference) {
        return adherentService.deleteByFonctionReference(reference);
    }

    @ApiOperation("find by fonction id")
    @GetMapping("/fonction/id/{id}")
    public List<Adherent> findByFonctionId(@PathVariable Long id) {
        return adherentService.findByFonctionId(id);
    }

    @ApiOperation("delete by fonction id")
    @DeleteMapping("/fonction/id/{id}")
    public int deleteByFonctionId(@PathVariable Long id) {
        return adherentService.deleteByFonctionId(id);
    }


    @PutMapping("/archiver/")
    public AdherentVo archiver(@RequestBody AdherentVo adherentVo) {
        Adherent adherent = adherentService.archiver(adherentConverter.toItem(adherentVo));
        return adherentConverter.toVo(adherent);
    }

    @PutMapping("/desarchiver/")
    public AdherentVo desarchiver(@RequestBody AdherentVo adherentVo) {
        Adherent adherent = adherentService.desarchiver(adherentConverter.toItem(adherentVo));
        return adherentConverter.toVo(adherent);
    }

    @PostMapping("/save2")
    public int save2(@RequestBody AdherentVo adherentVo) throws ParseException {
        return adherentService.save2(adherentVo);
    }
}



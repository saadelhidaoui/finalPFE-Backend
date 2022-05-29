package com.ird.faa.ws.rest.provided.facade.adherent;

import com.ird.faa.bean.Prestation;
import com.ird.faa.service.adherent.facade.PrestationAdherentService;
import com.ird.faa.ws.rest.provided.converter.PrestationConverter;
import com.ird.faa.ws.rest.provided.vo.PrestationVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Manages prestation services")
@RestController
@RequestMapping("api/adherent/prestation")
public class PrestationRestAdherent {

    @Autowired
    private PrestationAdherentService prestationService;

    @Autowired
    private PrestationConverter prestationConverter;


    @ApiOperation("Updates the specified  prestation")
    @PutMapping("/")
    public PrestationVo update(@RequestBody PrestationVo prestationVo) {
        Prestation prestation = prestationConverter.toItem(prestationVo);
        prestation = prestationService.update(prestation);
        return prestationConverter.toVo(prestation);
    }

    @ApiOperation("Finds a list of all prestations")
    @GetMapping("/")
    public List<PrestationVo> findAll() {
        return prestationConverter.toVo(prestationService.findAll());
    }

    @ApiOperation("Finds a prestation with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public PrestationVo findByIdWithAssociatedList(@PathVariable Long id) {
        return prestationConverter.toVo(prestationService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search prestation by a specific criteria")
    @PostMapping("/search")
    public List<PrestationVo> findByCriteria(@RequestBody PrestationVo prestationVo) {
        return prestationConverter.toVo(prestationService.findByCriteria(prestationVo));
    }

    @ApiOperation("Finds a prestation by id")
    @GetMapping("/id/{id}")
    public PrestationVo findById(@PathVariable Long id) {
        return prestationConverter.toVo(prestationService.findById(id));
    }

    @ApiOperation("Saves the specified  prestation")
    @PostMapping("/")
    public PrestationVo save(@RequestBody PrestationVo prestationVo) {
        Prestation prestation = prestationConverter.toItem(prestationVo);
        prestation = prestationService.save(prestation);
        return prestationConverter.toVo(prestation);
    }

    @ApiOperation("Delete the specified prestation")
    @DeleteMapping("/")
    public int delete(@RequestBody PrestationVo prestationVo) {
        Prestation prestation = prestationConverter.toItem(prestationVo);
        return prestationService.delete(prestation);
    }

    @ApiOperation("Deletes a prestation by id")
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return prestationService.deleteById(id);
    }

    @ApiOperation("find by etatPrestation reference")
    @GetMapping("/etatPrestation/reference/{reference}")
    public List<Prestation> findByEtatPrestationReference(@PathVariable String reference) {
        return prestationService.findByEtatPrestationReference(reference);
    }

    @ApiOperation("delete by etatPrestation reference")
    @DeleteMapping("/etatPrestation/reference/{reference}")
    public int deleteByEtatPrestationReference(@PathVariable String reference) {
        return prestationService.deleteByEtatPrestationReference(reference);
    }

    @ApiOperation("find by etatPrestation id")
    @GetMapping("/etatPrestation/id/{id}")
    public List<Prestation> findByEtatPrestationId(@PathVariable Long id) {
        return prestationService.findByEtatPrestationId(id);
    }

    @ApiOperation("delete by etatPrestation id")
    @DeleteMapping("/etatPrestation/id/{id}")
    public int deleteByEtatPrestationId(@PathVariable Long id) {
        return prestationService.deleteByEtatPrestationId(id);
    }

    @ApiOperation("find by niveauImportance reference")
    @GetMapping("/niveauImportance/reference/{reference}")
    public List<Prestation> findByNiveauImportanceReference(@PathVariable String reference) {
        return prestationService.findByNiveauImportanceReference(reference);
    }

    @ApiOperation("delete by niveauImportance reference")
    @DeleteMapping("/niveauImportance/reference/{reference}")
    public int deleteByNiveauImportanceReference(@PathVariable String reference) {
        return prestationService.deleteByNiveauImportanceReference(reference);
    }

    @ApiOperation("find by niveauImportance id")
    @GetMapping("/niveauImportance/id/{id}")
    public List<Prestation> findByNiveauImportanceId(@PathVariable Long id) {
        return prestationService.findByNiveauImportanceId(id);
    }

    @ApiOperation("delete by niveauImportance id")
    @DeleteMapping("/niveauImportance/id/{id}")
    public int deleteByNiveauImportanceId(@PathVariable Long id) {
        return prestationService.deleteByNiveauImportanceId(id);
    }

    @ApiOperation("find by typePrestation reference")
    @GetMapping("/typePrestation/reference/{reference}")
    public List<Prestation> findByTypePrestationReference(@PathVariable String reference) {
        return prestationService.findByTypePrestationReference(reference);
    }

    @ApiOperation("delete by typePrestation reference")
    @DeleteMapping("/typePrestation/reference/{reference}")
    public int deleteByTypePrestationReference(@PathVariable String reference) {
        return prestationService.deleteByTypePrestationReference(reference);
    }

    @ApiOperation("find by typePrestation id")
    @GetMapping("/typePrestation/id/{id}")
    public List<Prestation> findByTypePrestationId(@PathVariable Long id) {
        return prestationService.findByTypePrestationId(id);
    }

    @ApiOperation("delete by typePrestation id")
    @DeleteMapping("/typePrestation/id/{id}")
    public int deleteByTypePrestationId(@PathVariable Long id) {
        return prestationService.deleteByTypePrestationId(id);
    }

    @ApiOperation("find by adherent numeroMatricule")
    @GetMapping("/adherent/numeroMatricule/{numeroMatricule}")
    public List<Prestation> findByAdherentNumeroMatricule(@PathVariable String numeroMatricule) {
        return prestationService.findByAdherentNumeroMatricule(numeroMatricule);
    }

    @ApiOperation("delete by adherent numeroMatricule")
    @DeleteMapping("/adherent/numeroMatricule/{numeroMatricule}")
    public int deleteByAdherentNumeroMatricule(@PathVariable String numeroMatricule) {
        return prestationService.deleteByAdherentNumeroMatricule(numeroMatricule);
    }

    @ApiOperation("find by adherent id")
    @GetMapping("/adherent/id/{id}")
    public List<Prestation> findByAdherentId(@PathVariable Long id) {
        return prestationService.findByAdherentId(id);
    }

    @ApiOperation("delete by adherent id")
    @DeleteMapping("/adherent/id/{id}")
    public int deleteByAdherentId(@PathVariable Long id) {
        return prestationService.deleteByAdherentId(id);
    }


    @PutMapping("/archiver/")
    public PrestationVo archiver(@RequestBody PrestationVo prestationVo) {
        Prestation prestation = prestationService.archiver(prestationConverter.toItem(prestationVo));
        return prestationConverter.toVo(prestation);
    }

    @PutMapping("/desarchiver/")
    public PrestationVo desarchiver(@RequestBody PrestationVo prestationVo) {
        Prestation prestation = prestationService.desarchiver(prestationConverter.toItem(prestationVo));
        return prestationConverter.toVo(prestation);
    }

    @GetMapping("/adherent/cin/{cin}")
    public List<Prestation> findByAdherentCin(@PathVariable String cin) {
        return prestationService.findByAdherentCin(cin);
    }
}

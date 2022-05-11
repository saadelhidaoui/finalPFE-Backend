package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.EtatPrestationChercheurService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.ird.faa.bean.EtatPrestation;
import com.ird.faa.ws.rest.provided.converter.EtatPrestationConverter;
import com.ird.faa.ws.rest.provided.vo.EtatPrestationVo;

@Api("Manages etatPrestation services")
@RestController
@RequestMapping("api/chercheur/etatPrestation")
public class EtatPrestationRestChercheur {

@Autowired
private EtatPrestationChercheurService etatPrestationService;

@Autowired
private EtatPrestationConverter etatPrestationConverter;


            @ApiOperation("Updates the specified  etatPrestation")
            @PutMapping("/")
            public  EtatPrestationVo update(@RequestBody  EtatPrestationVo  etatPrestationVo){
            EtatPrestation etatPrestation = etatPrestationConverter.toItem(etatPrestationVo);
            etatPrestation = etatPrestationService.update(etatPrestation);
            return etatPrestationConverter.toVo(etatPrestation);
            }

    @ApiOperation("Finds a list of all etatPrestations")
    @GetMapping("/")
    public List<EtatPrestationVo> findAll(){
        return etatPrestationConverter.toVo(etatPrestationService.findAll());
    }

    @ApiOperation("Finds a etatPrestation with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EtatPrestationVo findByIdWithAssociatedList(@PathVariable Long id){
    return etatPrestationConverter.toVo(etatPrestationService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search etatPrestation by a specific criteria")
    @PostMapping("/search")
    public List<EtatPrestationVo> findByCriteria(@RequestBody EtatPrestationVo etatPrestationVo){
        return etatPrestationConverter.toVo(etatPrestationService.findByCriteria(etatPrestationVo));
        }

            @ApiOperation("Finds a etatPrestation by id")
            @GetMapping("/id/{id}")
            public EtatPrestationVo findById(@PathVariable Long id){
            return etatPrestationConverter.toVo(etatPrestationService.findById(id));
            }

            @ApiOperation("Saves the specified  etatPrestation")
            @PostMapping("/")
            public EtatPrestationVo save(@RequestBody EtatPrestationVo etatPrestationVo){
            EtatPrestation etatPrestation = etatPrestationConverter.toItem(etatPrestationVo);
            etatPrestation = etatPrestationService.save(etatPrestation);
            return etatPrestationConverter.toVo(etatPrestation);
            }

            @ApiOperation("Delete the specified etatPrestation")
            @DeleteMapping("/")
            public int delete(@RequestBody EtatPrestationVo etatPrestationVo){
            EtatPrestation etatPrestation = etatPrestationConverter.toItem(etatPrestationVo);
            return etatPrestationService.delete(etatPrestation);
            }

            @ApiOperation("Deletes a etatPrestation by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return etatPrestationService.deleteById(id);
            }


            }

package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.GestionReclamationChercheurService;

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
import com.ird.faa.bean.GestionReclamation;
import com.ird.faa.ws.rest.provided.converter.GestionReclamationConverter;
import com.ird.faa.ws.rest.provided.vo.GestionReclamationVo;

@Api("Manages gestionReclamation services")
@RestController
@RequestMapping("api/chercheur/gestionReclamation")
public class GestionReclamationRestChercheur {

@Autowired
private GestionReclamationChercheurService gestionReclamationService;

@Autowired
private GestionReclamationConverter gestionReclamationConverter;


            @ApiOperation("Updates the specified  gestionReclamation")
            @PutMapping("/")
            public  GestionReclamationVo update(@RequestBody  GestionReclamationVo  gestionReclamationVo){
            GestionReclamation gestionReclamation = gestionReclamationConverter.toItem(gestionReclamationVo);
            gestionReclamation = gestionReclamationService.update(gestionReclamation);
            return gestionReclamationConverter.toVo(gestionReclamation);
            }

    @ApiOperation("Finds a list of all gestionReclamations")
    @GetMapping("/")
    public List<GestionReclamationVo> findAll(){
        return gestionReclamationConverter.toVo(gestionReclamationService.findAll());
    }

    @ApiOperation("Finds a gestionReclamation with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public GestionReclamationVo findByIdWithAssociatedList(@PathVariable Long id){
    return gestionReclamationConverter.toVo(gestionReclamationService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search gestionReclamation by a specific criteria")
    @PostMapping("/search")
    public List<GestionReclamationVo> findByCriteria(@RequestBody GestionReclamationVo gestionReclamationVo){
        return gestionReclamationConverter.toVo(gestionReclamationService.findByCriteria(gestionReclamationVo));
        }

            @ApiOperation("Finds a gestionReclamation by id")
            @GetMapping("/id/{id}")
            public GestionReclamationVo findById(@PathVariable Long id){
            return gestionReclamationConverter.toVo(gestionReclamationService.findById(id));
            }

            @ApiOperation("Saves the specified  gestionReclamation")
            @PostMapping("/")
            public GestionReclamationVo save(@RequestBody GestionReclamationVo gestionReclamationVo){
            GestionReclamation gestionReclamation = gestionReclamationConverter.toItem(gestionReclamationVo);
            gestionReclamation = gestionReclamationService.save(gestionReclamation);
            return gestionReclamationConverter.toVo(gestionReclamation);
            }

            @ApiOperation("Delete the specified gestionReclamation")
            @DeleteMapping("/")
            public int delete(@RequestBody GestionReclamationVo gestionReclamationVo){
            GestionReclamation gestionReclamation = gestionReclamationConverter.toItem(gestionReclamationVo);
            return gestionReclamationService.delete(gestionReclamation);
            }

            @ApiOperation("Deletes a gestionReclamation by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return gestionReclamationService.deleteById(id);
            }
        @ApiOperation("find by moderateur numeroMatricule")
        @GetMapping("/moderateur/numeroMatricule/{numeroMatricule}")
        public List<GestionReclamation> findByModerateurNumeroMatricule(@PathVariable String numeroMatricule){
        return gestionReclamationService.findByModerateurNumeroMatricule(numeroMatricule);
        }

        @ApiOperation("delete by moderateur numeroMatricule")
        @DeleteMapping("/moderateur/numeroMatricule/{numeroMatricule}")
        public int deleteByModerateurNumeroMatricule(@PathVariable String numeroMatricule){
        return gestionReclamationService.deleteByModerateurNumeroMatricule(numeroMatricule);
        }

        @ApiOperation("find by moderateur id")
        @GetMapping("/moderateur/id/{id}")
        public List<GestionReclamation> findByModerateurId(@PathVariable Long id){
        return gestionReclamationService.findByModerateurId(id);
        }

        @ApiOperation("delete by moderateur id")
        @DeleteMapping("/moderateur/id/{id}")
        public int deleteByModerateurId(@PathVariable Long id){
        return gestionReclamationService.deleteByModerateurId(id);
        }

        @ApiOperation("find by reclamation reference")
        @GetMapping("/reclamation/reference/{reference}")
        public List<GestionReclamation> findByReclamationReference(@PathVariable String reference){
        return gestionReclamationService.findByReclamationReference(reference);
        }

        @ApiOperation("delete by reclamation reference")
        @DeleteMapping("/reclamation/reference/{reference}")
        public int deleteByReclamationReference(@PathVariable String reference){
        return gestionReclamationService.deleteByReclamationReference(reference);
        }

        @ApiOperation("find by reclamation id")
        @GetMapping("/reclamation/id/{id}")
        public List<GestionReclamation> findByReclamationId(@PathVariable Long id){
        return gestionReclamationService.findByReclamationId(id);
        }

        @ApiOperation("delete by reclamation id")
        @DeleteMapping("/reclamation/id/{id}")
        public int deleteByReclamationId(@PathVariable Long id){
        return gestionReclamationService.deleteByReclamationId(id);
        }



            }

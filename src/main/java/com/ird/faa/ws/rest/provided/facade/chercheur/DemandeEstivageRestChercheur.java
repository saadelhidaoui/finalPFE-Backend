package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.DemandeEstivageChercheurService;

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
import com.ird.faa.bean.DemandeEstivage;
import com.ird.faa.ws.rest.provided.converter.DemandeEstivageConverter;
import com.ird.faa.ws.rest.provided.vo.DemandeEstivageVo;

@Api("Manages demandeEstivage services")
@RestController
@RequestMapping("api/chercheur/demandeEstivage")
public class DemandeEstivageRestChercheur {

@Autowired
private DemandeEstivageChercheurService demandeEstivageService;

@Autowired
private DemandeEstivageConverter demandeEstivageConverter;


            @ApiOperation("Updates the specified  demandeEstivage")
            @PutMapping("/")
            public  DemandeEstivageVo update(@RequestBody  DemandeEstivageVo  demandeEstivageVo){
            DemandeEstivage demandeEstivage = demandeEstivageConverter.toItem(demandeEstivageVo);
            demandeEstivage = demandeEstivageService.update(demandeEstivage);
            return demandeEstivageConverter.toVo(demandeEstivage);
            }

    @ApiOperation("Finds a list of all demandeEstivages")
    @GetMapping("/")
    public List<DemandeEstivageVo> findAll(){
        return demandeEstivageConverter.toVo(demandeEstivageService.findAll());
    }

    @ApiOperation("Finds a demandeEstivage with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public DemandeEstivageVo findByIdWithAssociatedList(@PathVariable Long id){
    return demandeEstivageConverter.toVo(demandeEstivageService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search demandeEstivage by a specific criteria")
    @PostMapping("/search")
    public List<DemandeEstivageVo> findByCriteria(@RequestBody DemandeEstivageVo demandeEstivageVo){
        return demandeEstivageConverter.toVo(demandeEstivageService.findByCriteria(demandeEstivageVo));
        }

            @ApiOperation("Finds a demandeEstivage by id")
            @GetMapping("/id/{id}")
            public DemandeEstivageVo findById(@PathVariable Long id){
            return demandeEstivageConverter.toVo(demandeEstivageService.findById(id));
            }

            @ApiOperation("Saves the specified  demandeEstivage")
            @PostMapping("/")
            public DemandeEstivageVo save(@RequestBody DemandeEstivageVo demandeEstivageVo){
            DemandeEstivage demandeEstivage = demandeEstivageConverter.toItem(demandeEstivageVo);
            demandeEstivage = demandeEstivageService.save(demandeEstivage);
            return demandeEstivageConverter.toVo(demandeEstivage);
            }

            @ApiOperation("Delete the specified demandeEstivage")
            @DeleteMapping("/")
            public int delete(@RequestBody DemandeEstivageVo demandeEstivageVo){
            DemandeEstivage demandeEstivage = demandeEstivageConverter.toItem(demandeEstivageVo);
            return demandeEstivageService.delete(demandeEstivage);
            }

            @ApiOperation("Deletes a demandeEstivage by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return demandeEstivageService.deleteById(id);
            }
        @ApiOperation("find by demandeEstivageCentre reference")
        @GetMapping("/demandeEstivageCentre/reference/{reference}")
        public List<DemandeEstivage> findByDemandeEstivageCentreReference(@PathVariable String reference){
        return demandeEstivageService.findByDemandeEstivageCentreReference(reference);
        }

        @ApiOperation("delete by demandeEstivageCentre reference")
        @DeleteMapping("/demandeEstivageCentre/reference/{reference}")
        public int deleteByDemandeEstivageCentreReference(@PathVariable String reference){
        return demandeEstivageService.deleteByDemandeEstivageCentreReference(reference);
        }

        @ApiOperation("find by demandeEstivageCentre id")
        @GetMapping("/demandeEstivageCentre/id/{id}")
        public List<DemandeEstivage> findByDemandeEstivageCentreId(@PathVariable Long id){
        return demandeEstivageService.findByDemandeEstivageCentreId(id);
        }

        @ApiOperation("delete by demandeEstivageCentre id")
        @DeleteMapping("/demandeEstivageCentre/id/{id}")
        public int deleteByDemandeEstivageCentreId(@PathVariable Long id){
        return demandeEstivageService.deleteByDemandeEstivageCentreId(id);
        }

        @ApiOperation("find by adherent numeroMatricule")
        @GetMapping("/adherent/numeroMatricule/{numeroMatricule}")
        public List<DemandeEstivage> findByAdherentNumeroMatricule(@PathVariable String numeroMatricule){
        return demandeEstivageService.findByAdherentNumeroMatricule(numeroMatricule);
        }

        @ApiOperation("delete by adherent numeroMatricule")
        @DeleteMapping("/adherent/numeroMatricule/{numeroMatricule}")
        public int deleteByAdherentNumeroMatricule(@PathVariable String numeroMatricule){
        return demandeEstivageService.deleteByAdherentNumeroMatricule(numeroMatricule);
        }

        @ApiOperation("find by adherent id")
        @GetMapping("/adherent/id/{id}")
        public List<DemandeEstivage> findByAdherentId(@PathVariable Long id){
        return demandeEstivageService.findByAdherentId(id);
        }

        @ApiOperation("delete by adherent id")
        @DeleteMapping("/adherent/id/{id}")
        public int deleteByAdherentId(@PathVariable Long id){
        return demandeEstivageService.deleteByAdherentId(id);
        }

        @ApiOperation("find by etatDemandeEstivage reference")
        @GetMapping("/etatDemandeEstivage/reference/{reference}")
        public List<DemandeEstivage> findByEtatDemandeEstivageReference(@PathVariable String reference){
        return demandeEstivageService.findByEtatDemandeEstivageReference(reference);
        }

        @ApiOperation("delete by etatDemandeEstivage reference")
        @DeleteMapping("/etatDemandeEstivage/reference/{reference}")
        public int deleteByEtatDemandeEstivageReference(@PathVariable String reference){
        return demandeEstivageService.deleteByEtatDemandeEstivageReference(reference);
        }

        @ApiOperation("find by etatDemandeEstivage id")
        @GetMapping("/etatDemandeEstivage/id/{id}")
        public List<DemandeEstivage> findByEtatDemandeEstivageId(@PathVariable Long id){
        return demandeEstivageService.findByEtatDemandeEstivageId(id);
        }

        @ApiOperation("delete by etatDemandeEstivage id")
        @DeleteMapping("/etatDemandeEstivage/id/{id}")
        public int deleteByEtatDemandeEstivageId(@PathVariable Long id){
        return demandeEstivageService.deleteByEtatDemandeEstivageId(id);
        }

        @ApiOperation("find by estivageCentreEstivage reference")
        @GetMapping("/estivageCentreEstivage/reference/{reference}")
        public List<DemandeEstivage> findByEstivageCentreEstivageReference(@PathVariable String reference){
        return demandeEstivageService.findByEstivageCentreEstivageReference(reference);
        }

        @ApiOperation("delete by estivageCentreEstivage reference")
        @DeleteMapping("/estivageCentreEstivage/reference/{reference}")
        public int deleteByEstivageCentreEstivageReference(@PathVariable String reference){
        return demandeEstivageService.deleteByEstivageCentreEstivageReference(reference);
        }

        @ApiOperation("find by estivageCentreEstivage id")
        @GetMapping("/estivageCentreEstivage/id/{id}")
        public List<DemandeEstivage> findByEstivageCentreEstivageId(@PathVariable Long id){
        return demandeEstivageService.findByEstivageCentreEstivageId(id);
        }

        @ApiOperation("delete by estivageCentreEstivage id")
        @DeleteMapping("/estivageCentreEstivage/id/{id}")
        public int deleteByEstivageCentreEstivageId(@PathVariable Long id){
        return demandeEstivageService.deleteByEstivageCentreEstivageId(id);
        }



            }

package  com.ird.faa.ws.rest.provided.facade.moderateur;

import com.ird.faa.service.moderateur.facade.EnfantModerateurService;

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
import com.ird.faa.bean.Enfant;
import com.ird.faa.ws.rest.provided.converter.EnfantConverter;
import com.ird.faa.ws.rest.provided.vo.EnfantVo;

@Api("Manages enfant services")
@RestController
@RequestMapping("api/moderateur/enfant")
public class EnfantRestModerateur {

@Autowired
private EnfantModerateurService enfantService;

@Autowired
private EnfantConverter enfantConverter;


            @ApiOperation("Updates the specified  enfant")
            @PutMapping("/")
            public  EnfantVo update(@RequestBody  EnfantVo  enfantVo){
            Enfant enfant = enfantConverter.toItem(enfantVo);
            enfant = enfantService.update(enfant);
            return enfantConverter.toVo(enfant);
            }

    @ApiOperation("Finds a list of all enfants")
    @GetMapping("/")
    public List<EnfantVo> findAll(){
        return enfantConverter.toVo(enfantService.findAll());
    }

    @ApiOperation("Finds a enfant with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EnfantVo findByIdWithAssociatedList(@PathVariable Long id){
    return enfantConverter.toVo(enfantService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search enfant by a specific criteria")
    @PostMapping("/search")
    public List<EnfantVo> findByCriteria(@RequestBody EnfantVo enfantVo){
        return enfantConverter.toVo(enfantService.findByCriteria(enfantVo));
        }

            @ApiOperation("Finds a enfant by id")
            @GetMapping("/id/{id}")
            public EnfantVo findById(@PathVariable Long id){
            return enfantConverter.toVo(enfantService.findById(id));
            }

            @ApiOperation("Saves the specified  enfant")
            @PostMapping("/")
            public EnfantVo save(@RequestBody EnfantVo enfantVo){
            Enfant enfant = enfantConverter.toItem(enfantVo);
            enfant = enfantService.save(enfant);
            return enfantConverter.toVo(enfant);
            }

            @ApiOperation("Delete the specified enfant")
            @DeleteMapping("/")
            public int delete(@RequestBody EnfantVo enfantVo){
            Enfant enfant = enfantConverter.toItem(enfantVo);
            return enfantService.delete(enfant);
            }

            @ApiOperation("Deletes a enfant by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return enfantService.deleteById(id);
            }
        @ApiOperation("find by qualite reference")
        @GetMapping("/qualite/reference/{reference}")
        public List<Enfant> findByQualiteReference(@PathVariable String reference){
        return enfantService.findByQualiteReference(reference);
        }

        @ApiOperation("delete by qualite reference")
        @DeleteMapping("/qualite/reference/{reference}")
        public int deleteByQualiteReference(@PathVariable String reference){
        return enfantService.deleteByQualiteReference(reference);
        }

        @ApiOperation("find by qualite id")
        @GetMapping("/qualite/id/{id}")
        public List<Enfant> findByQualiteId(@PathVariable Long id){
        return enfantService.findByQualiteId(id);
        }

        @ApiOperation("delete by qualite id")
        @DeleteMapping("/qualite/id/{id}")
        public int deleteByQualiteId(@PathVariable Long id){
        return enfantService.deleteByQualiteId(id);
        }

        @ApiOperation("find by adherent numeroMatricule")
        @GetMapping("/adherent/numeroMatricule/{numeroMatricule}")
        public List<Enfant> findByAdherentNumeroMatricule(@PathVariable String numeroMatricule){
        return enfantService.findByAdherentNumeroMatricule(numeroMatricule);
        }

        @ApiOperation("delete by adherent numeroMatricule")
        @DeleteMapping("/adherent/numeroMatricule/{numeroMatricule}")
        public int deleteByAdherentNumeroMatricule(@PathVariable String numeroMatricule){
        return enfantService.deleteByAdherentNumeroMatricule(numeroMatricule);
        }

        @ApiOperation("find by adherent id")
        @GetMapping("/adherent/id/{id}")
        public List<Enfant> findByAdherentId(@PathVariable Long id){
        return enfantService.findByAdherentId(id);
        }

        @ApiOperation("delete by adherent id")
        @DeleteMapping("/adherent/id/{id}")
        public int deleteByAdherentId(@PathVariable Long id){
        return enfantService.deleteByAdherentId(id);
        }



            @PutMapping("/archiver/")
            public EnfantVo archiver(@RequestBody EnfantVo enfantVo){
                Enfant enfant = enfantService.archiver(enfantConverter.toItem(enfantVo));
                return enfantConverter.toVo(enfant);
                }

            @PutMapping("/desarchiver/")
            public EnfantVo desarchiver(@RequestBody EnfantVo enfantVo){
                Enfant enfant = enfantService.desarchiver(enfantConverter.toItem(enfantVo));
                return enfantConverter.toVo(enfant);}
            }

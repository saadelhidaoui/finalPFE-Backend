package  com.ird.faa.ws.rest.provided.facade.adherent;

import com.ird.faa.service.adherent.facade.ChercheurAdherentService;

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
import com.ird.faa.bean.Chercheur;
import com.ird.faa.ws.rest.provided.converter.ChercheurConverter;
import com.ird.faa.ws.rest.provided.vo.ChercheurVo;

@Api("Manages chercheur services")
@RestController
@RequestMapping("api/adherent/chercheur")
public class ChercheurRestAdherent {

@Autowired
private ChercheurAdherentService chercheurService;

@Autowired
private ChercheurConverter chercheurConverter;


            @ApiOperation("Updates the specified  chercheur")
            @PutMapping("/")
            public  ChercheurVo update(@RequestBody  ChercheurVo  chercheurVo){
            Chercheur chercheur = chercheurConverter.toItem(chercheurVo);
            chercheur = chercheurService.update(chercheur);
            return chercheurConverter.toVo(chercheur);
            }

    @ApiOperation("Finds a list of all chercheurs")
    @GetMapping("/")
    public List<ChercheurVo> findAll(){
        return chercheurConverter.toVo(chercheurService.findAll());
    }

    @ApiOperation("Finds a chercheur with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public ChercheurVo findByIdWithAssociatedList(@PathVariable Long id){
    return chercheurConverter.toVo(chercheurService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search chercheur by a specific criteria")
    @PostMapping("/search")
    public List<ChercheurVo> findByCriteria(@RequestBody ChercheurVo chercheurVo){
        return chercheurConverter.toVo(chercheurService.findByCriteria(chercheurVo));
        }

            @ApiOperation("Finds a chercheur by id")
            @GetMapping("/id/{id}")
            public ChercheurVo findById(@PathVariable Long id){
            return chercheurConverter.toVo(chercheurService.findById(id));
            }

            @ApiOperation("Saves the specified  chercheur")
            @PostMapping("/")
            public ChercheurVo save(@RequestBody ChercheurVo chercheurVo){
            Chercheur chercheur = chercheurConverter.toItem(chercheurVo);
            chercheur = chercheurService.save(chercheur);
            return chercheurConverter.toVo(chercheur);
            }

            @ApiOperation("Delete the specified chercheur")
            @DeleteMapping("/")
            public int delete(@RequestBody ChercheurVo chercheurVo){
            Chercheur chercheur = chercheurConverter.toItem(chercheurVo);
            return chercheurService.delete(chercheur);
            }

            @ApiOperation("Deletes a chercheur by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return chercheurService.deleteById(id);
            }
        @ApiOperation("find by situationModerateur reference")
        @GetMapping("/situationModerateur/reference/{reference}")
        public List<Chercheur> findBySituationModerateurReference(@PathVariable String reference){
        return chercheurService.findBySituationModerateurReference(reference);
        }

        @ApiOperation("delete by situationModerateur reference")
        @DeleteMapping("/situationModerateur/reference/{reference}")
        public int deleteBySituationModerateurReference(@PathVariable String reference){
        return chercheurService.deleteBySituationModerateurReference(reference);
        }

        @ApiOperation("find by situationModerateur id")
        @GetMapping("/situationModerateur/id/{id}")
        public List<Chercheur> findBySituationModerateurId(@PathVariable Long id){
        return chercheurService.findBySituationModerateurId(id);
        }

        @ApiOperation("delete by situationModerateur id")
        @DeleteMapping("/situationModerateur/id/{id}")
        public int deleteBySituationModerateurId(@PathVariable Long id){
        return chercheurService.deleteBySituationModerateurId(id);
        }

        @ApiOperation("find by profil reference")
        @GetMapping("/profil/reference/{reference}")
        public List<Chercheur> findByProfilReference(@PathVariable String reference){
        return chercheurService.findByProfilReference(reference);
        }

        @ApiOperation("delete by profil reference")
        @DeleteMapping("/profil/reference/{reference}")
        public int deleteByProfilReference(@PathVariable String reference){
        return chercheurService.deleteByProfilReference(reference);
        }

        @ApiOperation("find by profil id")
        @GetMapping("/profil/id/{id}")
        public List<Chercheur> findByProfilId(@PathVariable Long id){
        return chercheurService.findByProfilId(id);
        }

        @ApiOperation("delete by profil id")
        @DeleteMapping("/profil/id/{id}")
        public int deleteByProfilId(@PathVariable Long id){
        return chercheurService.deleteByProfilId(id);
        }



            }

package  com.ird.faa.ws.rest.provided.facade.adherent;

import com.ird.faa.service.adherent.facade.ModerateurAdherentService;

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
import com.ird.faa.bean.Moderateur;
import com.ird.faa.ws.rest.provided.converter.ModerateurConverter;
import com.ird.faa.ws.rest.provided.vo.ModerateurVo;

@Api("Manages moderateur services")
@RestController
@RequestMapping("api/adherent/moderateur")
public class ModerateurRestAdherent {

@Autowired
private ModerateurAdherentService moderateurService;

@Autowired
private ModerateurConverter moderateurConverter;


            @ApiOperation("Updates the specified  moderateur")
            @PutMapping("/")
            public  ModerateurVo update(@RequestBody  ModerateurVo  moderateurVo){
            Moderateur moderateur = moderateurConverter.toItem(moderateurVo);
            moderateur = moderateurService.update(moderateur);
            return moderateurConverter.toVo(moderateur);
            }

    @ApiOperation("Finds a list of all moderateurs")
    @GetMapping("/")
    public List<ModerateurVo> findAll(){
        return moderateurConverter.toVo(moderateurService.findAll());
    }

    @ApiOperation("Finds a moderateur with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public ModerateurVo findByIdWithAssociatedList(@PathVariable Long id){
    return moderateurConverter.toVo(moderateurService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search moderateur by a specific criteria")
    @PostMapping("/search")
    public List<ModerateurVo> findByCriteria(@RequestBody ModerateurVo moderateurVo){
        return moderateurConverter.toVo(moderateurService.findByCriteria(moderateurVo));
        }

            @ApiOperation("Finds a moderateur by id")
            @GetMapping("/id/{id}")
            public ModerateurVo findById(@PathVariable Long id){
            return moderateurConverter.toVo(moderateurService.findById(id));
            }

            @ApiOperation("Saves the specified  moderateur")
            @PostMapping("/")
            public ModerateurVo save(@RequestBody ModerateurVo moderateurVo){
            Moderateur moderateur = moderateurConverter.toItem(moderateurVo);
            moderateur = moderateurService.save(moderateur);
            return moderateurConverter.toVo(moderateur);
            }

            @ApiOperation("Delete the specified moderateur")
            @DeleteMapping("/")
            public int delete(@RequestBody ModerateurVo moderateurVo){
            Moderateur moderateur = moderateurConverter.toItem(moderateurVo);
            return moderateurService.delete(moderateur);
            }

            @ApiOperation("Deletes a moderateur by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return moderateurService.deleteById(id);
            }
        @ApiOperation("find by situationModerateur reference")
        @GetMapping("/situationModerateur/reference/{reference}")
        public List<Moderateur> findBySituationModerateurReference(@PathVariable String reference){
        return moderateurService.findBySituationModerateurReference(reference);
        }

        @ApiOperation("delete by situationModerateur reference")
        @DeleteMapping("/situationModerateur/reference/{reference}")
        public int deleteBySituationModerateurReference(@PathVariable String reference){
        return moderateurService.deleteBySituationModerateurReference(reference);
        }

        @ApiOperation("find by situationModerateur id")
        @GetMapping("/situationModerateur/id/{id}")
        public List<Moderateur> findBySituationModerateurId(@PathVariable Long id){
        return moderateurService.findBySituationModerateurId(id);
        }

        @ApiOperation("delete by situationModerateur id")
        @DeleteMapping("/situationModerateur/id/{id}")
        public int deleteBySituationModerateurId(@PathVariable Long id){
        return moderateurService.deleteBySituationModerateurId(id);
        }

        @ApiOperation("find by profil reference")
        @GetMapping("/profil/reference/{reference}")
        public List<Moderateur> findByProfilReference(@PathVariable String reference){
        return moderateurService.findByProfilReference(reference);
        }

        @ApiOperation("delete by profil reference")
        @DeleteMapping("/profil/reference/{reference}")
        public int deleteByProfilReference(@PathVariable String reference){
        return moderateurService.deleteByProfilReference(reference);
        }

        @ApiOperation("find by profil id")
        @GetMapping("/profil/id/{id}")
        public List<Moderateur> findByProfilId(@PathVariable Long id){
        return moderateurService.findByProfilId(id);
        }

        @ApiOperation("delete by profil id")
        @DeleteMapping("/profil/id/{id}")
        public int deleteByProfilId(@PathVariable Long id){
        return moderateurService.deleteByProfilId(id);
        }



            }

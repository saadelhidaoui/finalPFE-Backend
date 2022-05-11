package  com.ird.faa.ws.rest.provided.facade.moderateur;

import com.ird.faa.service.moderateur.facade.EtatProjetModerateurService;

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
import com.ird.faa.bean.EtatProjet;
import com.ird.faa.ws.rest.provided.converter.EtatProjetConverter;
import com.ird.faa.ws.rest.provided.vo.EtatProjetVo;

@Api("Manages etatProjet services")
@RestController
@RequestMapping("api/moderateur/etatProjet")
public class EtatProjetRestModerateur {

@Autowired
private EtatProjetModerateurService etatProjetService;

@Autowired
private EtatProjetConverter etatProjetConverter;


            @ApiOperation("Updates the specified  etatProjet")
            @PutMapping("/")
            public  EtatProjetVo update(@RequestBody  EtatProjetVo  etatProjetVo){
            EtatProjet etatProjet = etatProjetConverter.toItem(etatProjetVo);
            etatProjet = etatProjetService.update(etatProjet);
            return etatProjetConverter.toVo(etatProjet);
            }

    @ApiOperation("Finds a list of all etatProjets")
    @GetMapping("/")
    public List<EtatProjetVo> findAll(){
        return etatProjetConverter.toVo(etatProjetService.findAll());
    }

    @ApiOperation("Finds a etatProjet with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EtatProjetVo findByIdWithAssociatedList(@PathVariable Long id){
    return etatProjetConverter.toVo(etatProjetService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search etatProjet by a specific criteria")
    @PostMapping("/search")
    public List<EtatProjetVo> findByCriteria(@RequestBody EtatProjetVo etatProjetVo){
        return etatProjetConverter.toVo(etatProjetService.findByCriteria(etatProjetVo));
        }

            @ApiOperation("Finds a etatProjet by id")
            @GetMapping("/id/{id}")
            public EtatProjetVo findById(@PathVariable Long id){
            return etatProjetConverter.toVo(etatProjetService.findById(id));
            }

            @ApiOperation("Saves the specified  etatProjet")
            @PostMapping("/")
            public EtatProjetVo save(@RequestBody EtatProjetVo etatProjetVo){
            EtatProjet etatProjet = etatProjetConverter.toItem(etatProjetVo);
            etatProjet = etatProjetService.save(etatProjet);
            return etatProjetConverter.toVo(etatProjet);
            }

            @ApiOperation("Delete the specified etatProjet")
            @DeleteMapping("/")
            public int delete(@RequestBody EtatProjetVo etatProjetVo){
            EtatProjet etatProjet = etatProjetConverter.toItem(etatProjetVo);
            return etatProjetService.delete(etatProjet);
            }

            @ApiOperation("Deletes a etatProjet by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return etatProjetService.deleteById(id);
            }


            @PutMapping("/archiver/")
            public EtatProjetVo archiver(@RequestBody EtatProjetVo etatProjetVo){
                EtatProjet etatProjet = etatProjetService.archiver(etatProjetConverter.toItem(etatProjetVo));
                return etatProjetConverter.toVo(etatProjet);
                }

            @PutMapping("/desarchiver/")
            public EtatProjetVo desarchiver(@RequestBody EtatProjetVo etatProjetVo){
                EtatProjet etatProjet = etatProjetService.desarchiver(etatProjetConverter.toItem(etatProjetVo));
                return etatProjetConverter.toVo(etatProjet);}
            }

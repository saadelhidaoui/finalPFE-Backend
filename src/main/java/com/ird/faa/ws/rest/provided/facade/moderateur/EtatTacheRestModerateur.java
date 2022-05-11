package  com.ird.faa.ws.rest.provided.facade.moderateur;

import com.ird.faa.service.moderateur.facade.EtatTacheModerateurService;

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
import com.ird.faa.bean.EtatTache;
import com.ird.faa.ws.rest.provided.converter.EtatTacheConverter;
import com.ird.faa.ws.rest.provided.vo.EtatTacheVo;

@Api("Manages etatTache services")
@RestController
@RequestMapping("api/moderateur/etatTache")
public class EtatTacheRestModerateur {

@Autowired
private EtatTacheModerateurService etatTacheService;

@Autowired
private EtatTacheConverter etatTacheConverter;


            @ApiOperation("Updates the specified  etatTache")
            @PutMapping("/")
            public  EtatTacheVo update(@RequestBody  EtatTacheVo  etatTacheVo){
            EtatTache etatTache = etatTacheConverter.toItem(etatTacheVo);
            etatTache = etatTacheService.update(etatTache);
            return etatTacheConverter.toVo(etatTache);
            }

    @ApiOperation("Finds a list of all etatTaches")
    @GetMapping("/")
    public List<EtatTacheVo> findAll(){
        return etatTacheConverter.toVo(etatTacheService.findAll());
    }

    @ApiOperation("Finds a etatTache with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EtatTacheVo findByIdWithAssociatedList(@PathVariable Long id){
    return etatTacheConverter.toVo(etatTacheService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search etatTache by a specific criteria")
    @PostMapping("/search")
    public List<EtatTacheVo> findByCriteria(@RequestBody EtatTacheVo etatTacheVo){
        return etatTacheConverter.toVo(etatTacheService.findByCriteria(etatTacheVo));
        }

            @ApiOperation("Finds a etatTache by id")
            @GetMapping("/id/{id}")
            public EtatTacheVo findById(@PathVariable Long id){
            return etatTacheConverter.toVo(etatTacheService.findById(id));
            }

            @ApiOperation("Saves the specified  etatTache")
            @PostMapping("/")
            public EtatTacheVo save(@RequestBody EtatTacheVo etatTacheVo){
            EtatTache etatTache = etatTacheConverter.toItem(etatTacheVo);
            etatTache = etatTacheService.save(etatTache);
            return etatTacheConverter.toVo(etatTache);
            }

            @ApiOperation("Delete the specified etatTache")
            @DeleteMapping("/")
            public int delete(@RequestBody EtatTacheVo etatTacheVo){
            EtatTache etatTache = etatTacheConverter.toItem(etatTacheVo);
            return etatTacheService.delete(etatTache);
            }

            @ApiOperation("Deletes a etatTache by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return etatTacheService.deleteById(id);
            }


            }

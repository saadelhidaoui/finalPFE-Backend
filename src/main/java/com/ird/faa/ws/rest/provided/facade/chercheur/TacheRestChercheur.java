package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.TacheChercheurService;

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
import com.ird.faa.bean.Tache;
import com.ird.faa.ws.rest.provided.converter.TacheConverter;
import com.ird.faa.ws.rest.provided.vo.TacheVo;

@Api("Manages tache services")
@RestController
@RequestMapping("api/chercheur/tache")
public class TacheRestChercheur {

@Autowired
private TacheChercheurService tacheService;

@Autowired
private TacheConverter tacheConverter;


            @ApiOperation("Updates the specified  tache")
            @PutMapping("/")
            public  TacheVo update(@RequestBody  TacheVo  tacheVo){
            Tache tache = tacheConverter.toItem(tacheVo);
            tache = tacheService.update(tache);
            return tacheConverter.toVo(tache);
            }

    @ApiOperation("Finds a list of all taches")
    @GetMapping("/")
    public List<TacheVo> findAll(){
        return tacheConverter.toVo(tacheService.findAll());
    }

    @ApiOperation("Finds a tache with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public TacheVo findByIdWithAssociatedList(@PathVariable Long id){
    return tacheConverter.toVo(tacheService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search tache by a specific criteria")
    @PostMapping("/search")
    public List<TacheVo> findByCriteria(@RequestBody TacheVo tacheVo){
        return tacheConverter.toVo(tacheService.findByCriteria(tacheVo));
        }

            @ApiOperation("Finds a tache by id")
            @GetMapping("/id/{id}")
            public TacheVo findById(@PathVariable Long id){
            return tacheConverter.toVo(tacheService.findById(id));
            }

            @ApiOperation("Saves the specified  tache")
            @PostMapping("/")
            public TacheVo save(@RequestBody TacheVo tacheVo){
            Tache tache = tacheConverter.toItem(tacheVo);
            tache = tacheService.save(tache);
            return tacheConverter.toVo(tache);
            }

            @ApiOperation("Delete the specified tache")
            @DeleteMapping("/")
            public int delete(@RequestBody TacheVo tacheVo){
            Tache tache = tacheConverter.toItem(tacheVo);
            return tacheService.delete(tache);
            }

            @ApiOperation("Deletes a tache by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return tacheService.deleteById(id);
            }
        @ApiOperation("find by etatTache reference")
        @GetMapping("/etatTache/reference/{reference}")
        public List<Tache> findByEtatTacheReference(@PathVariable String reference){
        return tacheService.findByEtatTacheReference(reference);
        }

        @ApiOperation("delete by etatTache reference")
        @DeleteMapping("/etatTache/reference/{reference}")
        public int deleteByEtatTacheReference(@PathVariable String reference){
        return tacheService.deleteByEtatTacheReference(reference);
        }

        @ApiOperation("find by etatTache id")
        @GetMapping("/etatTache/id/{id}")
        public List<Tache> findByEtatTacheId(@PathVariable Long id){
        return tacheService.findByEtatTacheId(id);
        }

        @ApiOperation("delete by etatTache id")
        @DeleteMapping("/etatTache/id/{id}")
        public int deleteByEtatTacheId(@PathVariable Long id){
        return tacheService.deleteByEtatTacheId(id);
        }

        @ApiOperation("find by moderateur numeroMatricule")
        @GetMapping("/moderateur/numeroMatricule/{numeroMatricule}")
        public List<Tache> findByModerateurNumeroMatricule(@PathVariable String numeroMatricule){
        return tacheService.findByModerateurNumeroMatricule(numeroMatricule);
        }

        @ApiOperation("delete by moderateur numeroMatricule")
        @DeleteMapping("/moderateur/numeroMatricule/{numeroMatricule}")
        public int deleteByModerateurNumeroMatricule(@PathVariable String numeroMatricule){
        return tacheService.deleteByModerateurNumeroMatricule(numeroMatricule);
        }

        @ApiOperation("find by moderateur id")
        @GetMapping("/moderateur/id/{id}")
        public List<Tache> findByModerateurId(@PathVariable Long id){
        return tacheService.findByModerateurId(id);
        }

        @ApiOperation("delete by moderateur id")
        @DeleteMapping("/moderateur/id/{id}")
        public int deleteByModerateurId(@PathVariable Long id){
        return tacheService.deleteByModerateurId(id);
        }



            }

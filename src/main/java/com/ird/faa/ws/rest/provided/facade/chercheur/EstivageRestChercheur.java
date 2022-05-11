package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.EstivageChercheurService;

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
import com.ird.faa.bean.Estivage;
import com.ird.faa.ws.rest.provided.converter.EstivageConverter;
import com.ird.faa.ws.rest.provided.vo.EstivageVo;

@Api("Manages estivage services")
@RestController
@RequestMapping("api/chercheur/estivage")
public class EstivageRestChercheur {

@Autowired
private EstivageChercheurService estivageService;

@Autowired
private EstivageConverter estivageConverter;


            @ApiOperation("Updates the specified  estivage")
            @PutMapping("/")
            public  EstivageVo update(@RequestBody  EstivageVo  estivageVo){
            Estivage estivage = estivageConverter.toItem(estivageVo);
            estivage = estivageService.update(estivage);
            return estivageConverter.toVo(estivage);
            }

    @ApiOperation("Finds a list of all estivages")
    @GetMapping("/")
    public List<EstivageVo> findAll(){
        return estivageConverter.toVo(estivageService.findAll());
    }

    @ApiOperation("Finds a estivage with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EstivageVo findByIdWithAssociatedList(@PathVariable Long id){
    return estivageConverter.toVo(estivageService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search estivage by a specific criteria")
    @PostMapping("/search")
    public List<EstivageVo> findByCriteria(@RequestBody EstivageVo estivageVo){
        return estivageConverter.toVo(estivageService.findByCriteria(estivageVo));
        }

            @ApiOperation("Finds a estivage by id")
            @GetMapping("/id/{id}")
            public EstivageVo findById(@PathVariable Long id){
            return estivageConverter.toVo(estivageService.findById(id));
            }

            @ApiOperation("Saves the specified  estivage")
            @PostMapping("/")
            public EstivageVo save(@RequestBody EstivageVo estivageVo){
            Estivage estivage = estivageConverter.toItem(estivageVo);
            estivage = estivageService.save(estivage);
            return estivageConverter.toVo(estivage);
            }

            @ApiOperation("Delete the specified estivage")
            @DeleteMapping("/")
            public int delete(@RequestBody EstivageVo estivageVo){
            Estivage estivage = estivageConverter.toItem(estivageVo);
            return estivageService.delete(estivage);
            }

            @ApiOperation("Deletes a estivage by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return estivageService.deleteById(id);
            }
        @ApiOperation("find by centreEstivage id")
        @GetMapping("/centreEstivage/id/{id}")
        public List<Estivage> findByCentreEstivageId(@PathVariable Long id){
        return estivageService.findByCentreEstivageId(id);
        }

        @ApiOperation("delete by centreEstivage id")
        @DeleteMapping("/centreEstivage/id/{id}")
        public int deleteByCentreEstivageId(@PathVariable Long id){
        return estivageService.deleteByCentreEstivageId(id);
        }

        @ApiOperation("find by niveauImportance reference")
        @GetMapping("/niveauImportance/reference/{reference}")
        public List<Estivage> findByNiveauImportanceReference(@PathVariable String reference){
        return estivageService.findByNiveauImportanceReference(reference);
        }

        @ApiOperation("delete by niveauImportance reference")
        @DeleteMapping("/niveauImportance/reference/{reference}")
        public int deleteByNiveauImportanceReference(@PathVariable String reference){
        return estivageService.deleteByNiveauImportanceReference(reference);
        }

        @ApiOperation("find by niveauImportance id")
        @GetMapping("/niveauImportance/id/{id}")
        public List<Estivage> findByNiveauImportanceId(@PathVariable Long id){
        return estivageService.findByNiveauImportanceId(id);
        }

        @ApiOperation("delete by niveauImportance id")
        @DeleteMapping("/niveauImportance/id/{id}")
        public int deleteByNiveauImportanceId(@PathVariable Long id){
        return estivageService.deleteByNiveauImportanceId(id);
        }



            }

package  com.ird.faa.ws.rest.provided.facade.adherent;

import com.ird.faa.service.adherent.facade.EstivageCentreEstivageAdherentService;

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
import com.ird.faa.bean.EstivageCentreEstivage;
import com.ird.faa.ws.rest.provided.converter.EstivageCentreEstivageConverter;
import com.ird.faa.ws.rest.provided.vo.EstivageCentreEstivageVo;

@Api("Manages estivageCentreEstivage services")
@RestController
@RequestMapping("api/adherent/estivageCentreEstivage")
public class EstivageCentreEstivageRestAdherent {

@Autowired
private EstivageCentreEstivageAdherentService estivageCentreEstivageService;

@Autowired
private EstivageCentreEstivageConverter estivageCentreEstivageConverter;


            @ApiOperation("Updates the specified  estivageCentreEstivage")
            @PutMapping("/")
            public  EstivageCentreEstivageVo update(@RequestBody  EstivageCentreEstivageVo  estivageCentreEstivageVo){
            EstivageCentreEstivage estivageCentreEstivage = estivageCentreEstivageConverter.toItem(estivageCentreEstivageVo);
            estivageCentreEstivage = estivageCentreEstivageService.update(estivageCentreEstivage);
            return estivageCentreEstivageConverter.toVo(estivageCentreEstivage);
            }

    @ApiOperation("Finds a list of all estivageCentreEstivages")
    @GetMapping("/")
    public List<EstivageCentreEstivageVo> findAll(){
        return estivageCentreEstivageConverter.toVo(estivageCentreEstivageService.findAll());
    }

    @ApiOperation("Finds a estivageCentreEstivage with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EstivageCentreEstivageVo findByIdWithAssociatedList(@PathVariable Long id){
    return estivageCentreEstivageConverter.toVo(estivageCentreEstivageService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search estivageCentreEstivage by a specific criteria")
    @PostMapping("/search")
    public List<EstivageCentreEstivageVo> findByCriteria(@RequestBody EstivageCentreEstivageVo estivageCentreEstivageVo){
        return estivageCentreEstivageConverter.toVo(estivageCentreEstivageService.findByCriteria(estivageCentreEstivageVo));
        }

            @ApiOperation("Finds a estivageCentreEstivage by id")
            @GetMapping("/id/{id}")
            public EstivageCentreEstivageVo findById(@PathVariable Long id){
            return estivageCentreEstivageConverter.toVo(estivageCentreEstivageService.findById(id));
            }

            @ApiOperation("Saves the specified  estivageCentreEstivage")
            @PostMapping("/")
            public EstivageCentreEstivageVo save(@RequestBody EstivageCentreEstivageVo estivageCentreEstivageVo){
            EstivageCentreEstivage estivageCentreEstivage = estivageCentreEstivageConverter.toItem(estivageCentreEstivageVo);
            estivageCentreEstivage = estivageCentreEstivageService.save(estivageCentreEstivage);
            return estivageCentreEstivageConverter.toVo(estivageCentreEstivage);
            }

            @ApiOperation("Delete the specified estivageCentreEstivage")
            @DeleteMapping("/")
            public int delete(@RequestBody EstivageCentreEstivageVo estivageCentreEstivageVo){
            EstivageCentreEstivage estivageCentreEstivage = estivageCentreEstivageConverter.toItem(estivageCentreEstivageVo);
            return estivageCentreEstivageService.delete(estivageCentreEstivage);
            }

            @ApiOperation("Deletes a estivageCentreEstivage by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return estivageCentreEstivageService.deleteById(id);
            }
        @ApiOperation("find by centreEstivage id")
        @GetMapping("/centreEstivage/id/{id}")
        public List<EstivageCentreEstivage> findByCentreEstivageId(@PathVariable Long id){
        return estivageCentreEstivageService.findByCentreEstivageId(id);
        }

        @ApiOperation("delete by centreEstivage id")
        @DeleteMapping("/centreEstivage/id/{id}")
        public int deleteByCentreEstivageId(@PathVariable Long id){
        return estivageCentreEstivageService.deleteByCentreEstivageId(id);
        }

        @ApiOperation("find by estivage reference")
        @GetMapping("/estivage/reference/{reference}")
        public List<EstivageCentreEstivage> findByEstivageReference(@PathVariable String reference){
        return estivageCentreEstivageService.findByEstivageReference(reference);
        }

        @ApiOperation("delete by estivage reference")
        @DeleteMapping("/estivage/reference/{reference}")
        public int deleteByEstivageReference(@PathVariable String reference){
        return estivageCentreEstivageService.deleteByEstivageReference(reference);
        }

        @ApiOperation("find by estivage id")
        @GetMapping("/estivage/id/{id}")
        public List<EstivageCentreEstivage> findByEstivageId(@PathVariable Long id){
        return estivageCentreEstivageService.findByEstivageId(id);
        }

        @ApiOperation("delete by estivage id")
        @DeleteMapping("/estivage/id/{id}")
        public int deleteByEstivageId(@PathVariable Long id){
        return estivageCentreEstivageService.deleteByEstivageId(id);
        }



            }

package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.ConventionChercheurService;

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
import com.ird.faa.bean.Convention;
import com.ird.faa.ws.rest.provided.converter.ConventionConverter;
import com.ird.faa.ws.rest.provided.vo.ConventionVo;

@Api("Manages convention services")
@RestController
@RequestMapping("api/chercheur/convention")
public class ConventionRestChercheur {

@Autowired
private ConventionChercheurService conventionService;

@Autowired
private ConventionConverter conventionConverter;


            @ApiOperation("Updates the specified  convention")
            @PutMapping("/")
            public  ConventionVo update(@RequestBody  ConventionVo  conventionVo){
            Convention convention = conventionConverter.toItem(conventionVo);
            convention = conventionService.update(convention);
            return conventionConverter.toVo(convention);
            }

    @ApiOperation("Finds a list of all conventions")
    @GetMapping("/")
    public List<ConventionVo> findAll(){
        return conventionConverter.toVo(conventionService.findAll());
    }

    @ApiOperation("Finds a convention with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public ConventionVo findByIdWithAssociatedList(@PathVariable Long id){
    return conventionConverter.toVo(conventionService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search convention by a specific criteria")
    @PostMapping("/search")
    public List<ConventionVo> findByCriteria(@RequestBody ConventionVo conventionVo){
        return conventionConverter.toVo(conventionService.findByCriteria(conventionVo));
        }

            @ApiOperation("Finds a convention by id")
            @GetMapping("/id/{id}")
            public ConventionVo findById(@PathVariable Long id){
            return conventionConverter.toVo(conventionService.findById(id));
            }

            @ApiOperation("Saves the specified  convention")
            @PostMapping("/")
            public ConventionVo save(@RequestBody ConventionVo conventionVo){
            Convention convention = conventionConverter.toItem(conventionVo);
            convention = conventionService.save(convention);
            return conventionConverter.toVo(convention);
            }

            @ApiOperation("Delete the specified convention")
            @DeleteMapping("/")
            public int delete(@RequestBody ConventionVo conventionVo){
            Convention convention = conventionConverter.toItem(conventionVo);
            return conventionService.delete(convention);
            }

            @ApiOperation("Deletes a convention by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return conventionService.deleteById(id);
            }
        @ApiOperation("find by organisme id")
        @GetMapping("/organisme/id/{id}")
        public List<Convention> findByOrganismeId(@PathVariable Long id){
        return conventionService.findByOrganismeId(id);
        }

        @ApiOperation("delete by organisme id")
        @DeleteMapping("/organisme/id/{id}")
        public int deleteByOrganismeId(@PathVariable Long id){
        return conventionService.deleteByOrganismeId(id);
        }



            }

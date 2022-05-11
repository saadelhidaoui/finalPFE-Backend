package  com.ird.faa.ws.rest.provided.facade.adherent;

import com.ird.faa.service.adherent.facade.ConjointAdherentService;

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
import com.ird.faa.bean.Conjoint;
import com.ird.faa.ws.rest.provided.converter.ConjointConverter;
import com.ird.faa.ws.rest.provided.vo.ConjointVo;

@Api("Manages conjoint services")
@RestController
@RequestMapping("api/adherent/conjoint")
public class ConjointRestAdherent {

@Autowired
private ConjointAdherentService conjointService;

@Autowired
private ConjointConverter conjointConverter;


            @ApiOperation("Updates the specified  conjoint")
            @PutMapping("/")
            public  ConjointVo update(@RequestBody  ConjointVo  conjointVo){
            Conjoint conjoint = conjointConverter.toItem(conjointVo);
            conjoint = conjointService.update(conjoint);
            return conjointConverter.toVo(conjoint);
            }

    @ApiOperation("Finds a list of all conjoints")
    @GetMapping("/")
    public List<ConjointVo> findAll(){
        return conjointConverter.toVo(conjointService.findAll());
    }

    @ApiOperation("Finds a conjoint with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public ConjointVo findByIdWithAssociatedList(@PathVariable Long id){
    return conjointConverter.toVo(conjointService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search conjoint by a specific criteria")
    @PostMapping("/search")
    public List<ConjointVo> findByCriteria(@RequestBody ConjointVo conjointVo){
        return conjointConverter.toVo(conjointService.findByCriteria(conjointVo));
        }

            @ApiOperation("Finds a conjoint by id")
            @GetMapping("/id/{id}")
            public ConjointVo findById(@PathVariable Long id){
            return conjointConverter.toVo(conjointService.findById(id));
            }

            @ApiOperation("Saves the specified  conjoint")
            @PostMapping("/")
            public ConjointVo save(@RequestBody ConjointVo conjointVo){
            Conjoint conjoint = conjointConverter.toItem(conjointVo);
            conjoint = conjointService.save(conjoint);
            return conjointConverter.toVo(conjoint);
            }

            @ApiOperation("Delete the specified conjoint")
            @DeleteMapping("/")
            public int delete(@RequestBody ConjointVo conjointVo){
            Conjoint conjoint = conjointConverter.toItem(conjointVo);
            return conjointService.delete(conjoint);
            }

            @ApiOperation("Deletes a conjoint by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return conjointService.deleteById(id);
            }
        @ApiOperation("find by qualite reference")
        @GetMapping("/qualite/reference/{reference}")
        public List<Conjoint> findByQualiteReference(@PathVariable String reference){
        return conjointService.findByQualiteReference(reference);
        }

        @ApiOperation("delete by qualite reference")
        @DeleteMapping("/qualite/reference/{reference}")
        public int deleteByQualiteReference(@PathVariable String reference){
        return conjointService.deleteByQualiteReference(reference);
        }

        @ApiOperation("find by qualite id")
        @GetMapping("/qualite/id/{id}")
        public List<Conjoint> findByQualiteId(@PathVariable Long id){
        return conjointService.findByQualiteId(id);
        }

        @ApiOperation("delete by qualite id")
        @DeleteMapping("/qualite/id/{id}")
        public int deleteByQualiteId(@PathVariable Long id){
        return conjointService.deleteByQualiteId(id);
        }

        @ApiOperation("find by adherent numeroMatricule")
        @GetMapping("/adherent/numeroMatricule/{numeroMatricule}")
        public List<Conjoint> findByAdherentNumeroMatricule(@PathVariable String numeroMatricule){
        return conjointService.findByAdherentNumeroMatricule(numeroMatricule);
        }

        @ApiOperation("delete by adherent numeroMatricule")
        @DeleteMapping("/adherent/numeroMatricule/{numeroMatricule}")
        public int deleteByAdherentNumeroMatricule(@PathVariable String numeroMatricule){
        return conjointService.deleteByAdherentNumeroMatricule(numeroMatricule);
        }

        @ApiOperation("find by adherent id")
        @GetMapping("/adherent/id/{id}")
        public List<Conjoint> findByAdherentId(@PathVariable Long id){
        return conjointService.findByAdherentId(id);
        }

        @ApiOperation("delete by adherent id")
        @DeleteMapping("/adherent/id/{id}")
        public int deleteByAdherentId(@PathVariable Long id){
        return conjointService.deleteByAdherentId(id);
        }



            }

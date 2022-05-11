package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.NiveauImportanceChercheurService;

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
import com.ird.faa.bean.NiveauImportance;
import com.ird.faa.ws.rest.provided.converter.NiveauImportanceConverter;
import com.ird.faa.ws.rest.provided.vo.NiveauImportanceVo;

@Api("Manages niveauImportance services")
@RestController
@RequestMapping("api/chercheur/niveauImportance")
public class NiveauImportanceRestChercheur {

@Autowired
private NiveauImportanceChercheurService niveauImportanceService;

@Autowired
private NiveauImportanceConverter niveauImportanceConverter;


            @ApiOperation("Updates the specified  niveauImportance")
            @PutMapping("/")
            public  NiveauImportanceVo update(@RequestBody  NiveauImportanceVo  niveauImportanceVo){
            NiveauImportance niveauImportance = niveauImportanceConverter.toItem(niveauImportanceVo);
            niveauImportance = niveauImportanceService.update(niveauImportance);
            return niveauImportanceConverter.toVo(niveauImportance);
            }

    @ApiOperation("Finds a list of all niveauImportances")
    @GetMapping("/")
    public List<NiveauImportanceVo> findAll(){
        return niveauImportanceConverter.toVo(niveauImportanceService.findAll());
    }

    @ApiOperation("Finds a niveauImportance with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public NiveauImportanceVo findByIdWithAssociatedList(@PathVariable Long id){
    return niveauImportanceConverter.toVo(niveauImportanceService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search niveauImportance by a specific criteria")
    @PostMapping("/search")
    public List<NiveauImportanceVo> findByCriteria(@RequestBody NiveauImportanceVo niveauImportanceVo){
        return niveauImportanceConverter.toVo(niveauImportanceService.findByCriteria(niveauImportanceVo));
        }

            @ApiOperation("Finds a niveauImportance by id")
            @GetMapping("/id/{id}")
            public NiveauImportanceVo findById(@PathVariable Long id){
            return niveauImportanceConverter.toVo(niveauImportanceService.findById(id));
            }

            @ApiOperation("Saves the specified  niveauImportance")
            @PostMapping("/")
            public NiveauImportanceVo save(@RequestBody NiveauImportanceVo niveauImportanceVo){
            NiveauImportance niveauImportance = niveauImportanceConverter.toItem(niveauImportanceVo);
            niveauImportance = niveauImportanceService.save(niveauImportance);
            return niveauImportanceConverter.toVo(niveauImportance);
            }

            @ApiOperation("Delete the specified niveauImportance")
            @DeleteMapping("/")
            public int delete(@RequestBody NiveauImportanceVo niveauImportanceVo){
            NiveauImportance niveauImportance = niveauImportanceConverter.toItem(niveauImportanceVo);
            return niveauImportanceService.delete(niveauImportance);
            }

            @ApiOperation("Deletes a niveauImportance by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return niveauImportanceService.deleteById(id);
            }


            }

package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.ImpressionCarteChercheurService;

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
import com.ird.faa.bean.ImpressionCarte;
import com.ird.faa.ws.rest.provided.converter.ImpressionCarteConverter;
import com.ird.faa.ws.rest.provided.vo.ImpressionCarteVo;

@Api("Manages impressionCarte services")
@RestController
@RequestMapping("api/chercheur/impressionCarte")
public class ImpressionCarteRestChercheur {

@Autowired
private ImpressionCarteChercheurService impressionCarteService;

@Autowired
private ImpressionCarteConverter impressionCarteConverter;


            @ApiOperation("Updates the specified  impressionCarte")
            @PutMapping("/")
            public  ImpressionCarteVo update(@RequestBody  ImpressionCarteVo  impressionCarteVo){
            ImpressionCarte impressionCarte = impressionCarteConverter.toItem(impressionCarteVo);
            impressionCarte = impressionCarteService.update(impressionCarte);
            return impressionCarteConverter.toVo(impressionCarte);
            }

    @ApiOperation("Finds a list of all impressionCartes")
    @GetMapping("/")
    public List<ImpressionCarteVo> findAll(){
        return impressionCarteConverter.toVo(impressionCarteService.findAll());
    }

    @ApiOperation("Finds a impressionCarte with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public ImpressionCarteVo findByIdWithAssociatedList(@PathVariable Long id){
    return impressionCarteConverter.toVo(impressionCarteService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search impressionCarte by a specific criteria")
    @PostMapping("/search")
    public List<ImpressionCarteVo> findByCriteria(@RequestBody ImpressionCarteVo impressionCarteVo){
        return impressionCarteConverter.toVo(impressionCarteService.findByCriteria(impressionCarteVo));
        }

            @ApiOperation("Finds a impressionCarte by id")
            @GetMapping("/id/{id}")
            public ImpressionCarteVo findById(@PathVariable Long id){
            return impressionCarteConverter.toVo(impressionCarteService.findById(id));
            }

            @ApiOperation("Saves the specified  impressionCarte")
            @PostMapping("/")
            public ImpressionCarteVo save(@RequestBody ImpressionCarteVo impressionCarteVo){
            ImpressionCarte impressionCarte = impressionCarteConverter.toItem(impressionCarteVo);
            impressionCarte = impressionCarteService.save(impressionCarte);
            return impressionCarteConverter.toVo(impressionCarte);
            }

            @ApiOperation("Delete the specified impressionCarte")
            @DeleteMapping("/")
            public int delete(@RequestBody ImpressionCarteVo impressionCarteVo){
            ImpressionCarte impressionCarte = impressionCarteConverter.toItem(impressionCarteVo);
            return impressionCarteService.delete(impressionCarte);
            }

            @ApiOperation("Deletes a impressionCarte by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return impressionCarteService.deleteById(id);
            }


            }

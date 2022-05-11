package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.FonctionChercheurService;

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
import com.ird.faa.bean.Fonction;
import com.ird.faa.ws.rest.provided.converter.FonctionConverter;
import com.ird.faa.ws.rest.provided.vo.FonctionVo;

@Api("Manages fonction services")
@RestController
@RequestMapping("api/chercheur/fonction")
public class FonctionRestChercheur {

@Autowired
private FonctionChercheurService fonctionService;

@Autowired
private FonctionConverter fonctionConverter;


            @ApiOperation("Updates the specified  fonction")
            @PutMapping("/")
            public  FonctionVo update(@RequestBody  FonctionVo  fonctionVo){
            Fonction fonction = fonctionConverter.toItem(fonctionVo);
            fonction = fonctionService.update(fonction);
            return fonctionConverter.toVo(fonction);
            }

    @ApiOperation("Finds a list of all fonctions")
    @GetMapping("/")
    public List<FonctionVo> findAll(){
        return fonctionConverter.toVo(fonctionService.findAll());
    }

    @ApiOperation("Finds a fonction with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public FonctionVo findByIdWithAssociatedList(@PathVariable Long id){
    return fonctionConverter.toVo(fonctionService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search fonction by a specific criteria")
    @PostMapping("/search")
    public List<FonctionVo> findByCriteria(@RequestBody FonctionVo fonctionVo){
        return fonctionConverter.toVo(fonctionService.findByCriteria(fonctionVo));
        }

            @ApiOperation("Finds a fonction by id")
            @GetMapping("/id/{id}")
            public FonctionVo findById(@PathVariable Long id){
            return fonctionConverter.toVo(fonctionService.findById(id));
            }

            @ApiOperation("Saves the specified  fonction")
            @PostMapping("/")
            public FonctionVo save(@RequestBody FonctionVo fonctionVo){
            Fonction fonction = fonctionConverter.toItem(fonctionVo);
            fonction = fonctionService.save(fonction);
            return fonctionConverter.toVo(fonction);
            }

            @ApiOperation("Delete the specified fonction")
            @DeleteMapping("/")
            public int delete(@RequestBody FonctionVo fonctionVo){
            Fonction fonction = fonctionConverter.toItem(fonctionVo);
            return fonctionService.delete(fonction);
            }

            @ApiOperation("Deletes a fonction by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return fonctionService.deleteById(id);
            }


            }

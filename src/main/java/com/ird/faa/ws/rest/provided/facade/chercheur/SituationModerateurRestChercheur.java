package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.SituationModerateurChercheurService;

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
import com.ird.faa.bean.SituationModerateur;
import com.ird.faa.ws.rest.provided.converter.SituationModerateurConverter;
import com.ird.faa.ws.rest.provided.vo.SituationModerateurVo;

@Api("Manages situationModerateur services")
@RestController
@RequestMapping("api/chercheur/situationModerateur")
public class SituationModerateurRestChercheur {

@Autowired
private SituationModerateurChercheurService situationModerateurService;

@Autowired
private SituationModerateurConverter situationModerateurConverter;


            @ApiOperation("Updates the specified  situationModerateur")
            @PutMapping("/")
            public  SituationModerateurVo update(@RequestBody  SituationModerateurVo  situationModerateurVo){
            SituationModerateur situationModerateur = situationModerateurConverter.toItem(situationModerateurVo);
            situationModerateur = situationModerateurService.update(situationModerateur);
            return situationModerateurConverter.toVo(situationModerateur);
            }

    @ApiOperation("Finds a list of all situationModerateurs")
    @GetMapping("/")
    public List<SituationModerateurVo> findAll(){
        return situationModerateurConverter.toVo(situationModerateurService.findAll());
    }

    @ApiOperation("Finds a situationModerateur with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public SituationModerateurVo findByIdWithAssociatedList(@PathVariable Long id){
    return situationModerateurConverter.toVo(situationModerateurService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search situationModerateur by a specific criteria")
    @PostMapping("/search")
    public List<SituationModerateurVo> findByCriteria(@RequestBody SituationModerateurVo situationModerateurVo){
        return situationModerateurConverter.toVo(situationModerateurService.findByCriteria(situationModerateurVo));
        }

            @ApiOperation("Finds a situationModerateur by id")
            @GetMapping("/id/{id}")
            public SituationModerateurVo findById(@PathVariable Long id){
            return situationModerateurConverter.toVo(situationModerateurService.findById(id));
            }

            @ApiOperation("Saves the specified  situationModerateur")
            @PostMapping("/")
            public SituationModerateurVo save(@RequestBody SituationModerateurVo situationModerateurVo){
            SituationModerateur situationModerateur = situationModerateurConverter.toItem(situationModerateurVo);
            situationModerateur = situationModerateurService.save(situationModerateur);
            return situationModerateurConverter.toVo(situationModerateur);
            }

            @ApiOperation("Delete the specified situationModerateur")
            @DeleteMapping("/")
            public int delete(@RequestBody SituationModerateurVo situationModerateurVo){
            SituationModerateur situationModerateur = situationModerateurConverter.toItem(situationModerateurVo);
            return situationModerateurService.delete(situationModerateur);
            }

            @ApiOperation("Deletes a situationModerateur by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return situationModerateurService.deleteById(id);
            }


            }

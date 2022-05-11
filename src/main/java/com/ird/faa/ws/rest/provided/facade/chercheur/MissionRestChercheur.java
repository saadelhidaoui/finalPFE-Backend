package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.MissionChercheurService;

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
import com.ird.faa.bean.Mission;
import com.ird.faa.ws.rest.provided.converter.MissionConverter;
import com.ird.faa.ws.rest.provided.vo.MissionVo;

@Api("Manages mission services")
@RestController
@RequestMapping("api/chercheur/mission")
public class MissionRestChercheur {

@Autowired
private MissionChercheurService missionService;

@Autowired
private MissionConverter missionConverter;


            @ApiOperation("Updates the specified  mission")
            @PutMapping("/")
            public  MissionVo update(@RequestBody  MissionVo  missionVo){
            Mission mission = missionConverter.toItem(missionVo);
            mission = missionService.update(mission);
            return missionConverter.toVo(mission);
            }

    @ApiOperation("Finds a list of all missions")
    @GetMapping("/")
    public List<MissionVo> findAll(){
        return missionConverter.toVo(missionService.findAll());
    }

    @ApiOperation("Finds a mission with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public MissionVo findByIdWithAssociatedList(@PathVariable Long id){
    return missionConverter.toVo(missionService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search mission by a specific criteria")
    @PostMapping("/search")
    public List<MissionVo> findByCriteria(@RequestBody MissionVo missionVo){
        return missionConverter.toVo(missionService.findByCriteria(missionVo));
        }

            @ApiOperation("Finds a mission by id")
            @GetMapping("/id/{id}")
            public MissionVo findById(@PathVariable Long id){
            return missionConverter.toVo(missionService.findById(id));
            }

            @ApiOperation("Saves the specified  mission")
            @PostMapping("/")
            public MissionVo save(@RequestBody MissionVo missionVo){
            Mission mission = missionConverter.toItem(missionVo);
            mission = missionService.save(mission);
            return missionConverter.toVo(mission);
            }

            @ApiOperation("Delete the specified mission")
            @DeleteMapping("/")
            public int delete(@RequestBody MissionVo missionVo){
            Mission mission = missionConverter.toItem(missionVo);
            return missionService.delete(mission);
            }

            @ApiOperation("Deletes a mission by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return missionService.deleteById(id);
            }
        @ApiOperation("find by villeDestination id")
        @GetMapping("/villeDestination/id/{id}")
        public List<Mission> findByVilleId(@PathVariable Long id){
        return missionService.findByVilleId(id);
        }

        @ApiOperation("delete by villeDestination id")
        @DeleteMapping("/villeDestination/id/{id}")
        public int deleteByVilleId(@PathVariable Long id){
        return missionService.deleteByVilleId(id);
        }

        @ApiOperation("find by moderateur numeroMatricule")
        @GetMapping("/moderateur/numeroMatricule/{numeroMatricule}")
        public List<Mission> findByModerateurNumeroMatricule(@PathVariable String numeroMatricule){
        return missionService.findByModerateurNumeroMatricule(numeroMatricule);
        }

        @ApiOperation("delete by moderateur numeroMatricule")
        @DeleteMapping("/moderateur/numeroMatricule/{numeroMatricule}")
        public int deleteByModerateurNumeroMatricule(@PathVariable String numeroMatricule){
        return missionService.deleteByModerateurNumeroMatricule(numeroMatricule);
        }

        @ApiOperation("find by moderateur id")
        @GetMapping("/moderateur/id/{id}")
        public List<Mission> findByModerateurId(@PathVariable Long id){
        return missionService.findByModerateurId(id);
        }

        @ApiOperation("delete by moderateur id")
        @DeleteMapping("/moderateur/id/{id}")
        public int deleteByModerateurId(@PathVariable Long id){
        return missionService.deleteByModerateurId(id);
        }



            }

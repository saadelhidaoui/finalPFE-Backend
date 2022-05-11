package  com.ird.faa.ws.rest.provided.facade.moderateur;

import com.ird.faa.service.moderateur.facade.CentreEstivageModerateurService;

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
import com.ird.faa.bean.CentreEstivage;
import com.ird.faa.ws.rest.provided.converter.CentreEstivageConverter;
import com.ird.faa.ws.rest.provided.vo.CentreEstivageVo;

@Api("Manages centreEstivage services")
@RestController
@RequestMapping("api/moderateur/centreEstivage")
public class CentreEstivageRestModerateur {

@Autowired
private CentreEstivageModerateurService centreEstivageService;

@Autowired
private CentreEstivageConverter centreEstivageConverter;


            @ApiOperation("Updates the specified  centreEstivage")
            @PutMapping("/")
            public  CentreEstivageVo update(@RequestBody  CentreEstivageVo  centreEstivageVo){
            CentreEstivage centreEstivage = centreEstivageConverter.toItem(centreEstivageVo);
            centreEstivage = centreEstivageService.update(centreEstivage);
            return centreEstivageConverter.toVo(centreEstivage);
            }

    @ApiOperation("Finds a list of all centreEstivages")
    @GetMapping("/")
    public List<CentreEstivageVo> findAll(){
        return centreEstivageConverter.toVo(centreEstivageService.findAll());
    }

    @ApiOperation("Finds a centreEstivage with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public CentreEstivageVo findByIdWithAssociatedList(@PathVariable Long id){
    return centreEstivageConverter.toVo(centreEstivageService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search centreEstivage by a specific criteria")
    @PostMapping("/search")
    public List<CentreEstivageVo> findByCriteria(@RequestBody CentreEstivageVo centreEstivageVo){
        return centreEstivageConverter.toVo(centreEstivageService.findByCriteria(centreEstivageVo));
        }

            @ApiOperation("Finds a centreEstivage by id")
            @GetMapping("/id/{id}")
            public CentreEstivageVo findById(@PathVariable Long id){
            return centreEstivageConverter.toVo(centreEstivageService.findById(id));
            }

            @ApiOperation("Saves the specified  centreEstivage")
            @PostMapping("/")
            public CentreEstivageVo save(@RequestBody CentreEstivageVo centreEstivageVo){
            CentreEstivage centreEstivage = centreEstivageConverter.toItem(centreEstivageVo);
            centreEstivage = centreEstivageService.save(centreEstivage);
            return centreEstivageConverter.toVo(centreEstivage);
            }

            @ApiOperation("Delete the specified centreEstivage")
            @DeleteMapping("/")
            public int delete(@RequestBody CentreEstivageVo centreEstivageVo){
            CentreEstivage centreEstivage = centreEstivageConverter.toItem(centreEstivageVo);
            return centreEstivageService.delete(centreEstivage);
            }

            @ApiOperation("Deletes a centreEstivage by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return centreEstivageService.deleteById(id);
            }
        @ApiOperation("find by ville id")
        @GetMapping("/ville/id/{id}")
        public List<CentreEstivage> findByVilleId(@PathVariable Long id){
        return centreEstivageService.findByVilleId(id);
        }

        @ApiOperation("delete by ville id")
        @DeleteMapping("/ville/id/{id}")
        public int deleteByVilleId(@PathVariable Long id){
        return centreEstivageService.deleteByVilleId(id);
        }



            }

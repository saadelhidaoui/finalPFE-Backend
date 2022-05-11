package  com.ird.faa.ws.rest.provided.facade.moderateur;

import com.ird.faa.service.moderateur.facade.EchelonModerateurService;

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
import com.ird.faa.bean.Echelon;
import com.ird.faa.ws.rest.provided.converter.EchelonConverter;
import com.ird.faa.ws.rest.provided.vo.EchelonVo;

@Api("Manages echelon services")
@RestController
@RequestMapping("api/moderateur/echelon")
public class EchelonRestModerateur {

@Autowired
private EchelonModerateurService echelonService;

@Autowired
private EchelonConverter echelonConverter;


            @ApiOperation("Updates the specified  echelon")
            @PutMapping("/")
            public  EchelonVo update(@RequestBody  EchelonVo  echelonVo){
            Echelon echelon = echelonConverter.toItem(echelonVo);
            echelon = echelonService.update(echelon);
            return echelonConverter.toVo(echelon);
            }

    @ApiOperation("Finds a list of all echelons")
    @GetMapping("/")
    public List<EchelonVo> findAll(){
        return echelonConverter.toVo(echelonService.findAll());
    }

    @ApiOperation("Finds a echelon with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EchelonVo findByIdWithAssociatedList(@PathVariable Long id){
    return echelonConverter.toVo(echelonService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search echelon by a specific criteria")
    @PostMapping("/search")
    public List<EchelonVo> findByCriteria(@RequestBody EchelonVo echelonVo){
        return echelonConverter.toVo(echelonService.findByCriteria(echelonVo));
        }

            @ApiOperation("Finds a echelon by id")
            @GetMapping("/id/{id}")
            public EchelonVo findById(@PathVariable Long id){
            return echelonConverter.toVo(echelonService.findById(id));
            }

            @ApiOperation("Saves the specified  echelon")
            @PostMapping("/")
            public EchelonVo save(@RequestBody EchelonVo echelonVo){
            Echelon echelon = echelonConverter.toItem(echelonVo);
            echelon = echelonService.save(echelon);
            return echelonConverter.toVo(echelon);
            }

            @ApiOperation("Delete the specified echelon")
            @DeleteMapping("/")
            public int delete(@RequestBody EchelonVo echelonVo){
            Echelon echelon = echelonConverter.toItem(echelonVo);
            return echelonService.delete(echelon);
            }

            @ApiOperation("Deletes a echelon by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return echelonService.deleteById(id);
            }


            }

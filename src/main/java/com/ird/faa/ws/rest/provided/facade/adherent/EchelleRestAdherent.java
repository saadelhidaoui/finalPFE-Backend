package  com.ird.faa.ws.rest.provided.facade.adherent;

import com.ird.faa.service.adherent.facade.EchelleAdherentService;

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
import com.ird.faa.bean.Echelle;
import com.ird.faa.ws.rest.provided.converter.EchelleConverter;
import com.ird.faa.ws.rest.provided.vo.EchelleVo;

@Api("Manages echelle services")
@RestController
@RequestMapping("api/adherent/echelle")
public class EchelleRestAdherent {

@Autowired
private EchelleAdherentService echelleService;

@Autowired
private EchelleConverter echelleConverter;


            @ApiOperation("Updates the specified  echelle")
            @PutMapping("/")
            public  EchelleVo update(@RequestBody  EchelleVo  echelleVo){
            Echelle echelle = echelleConverter.toItem(echelleVo);
            echelle = echelleService.update(echelle);
            return echelleConverter.toVo(echelle);
            }

    @ApiOperation("Finds a list of all echelles")
    @GetMapping("/")
    public List<EchelleVo> findAll(){
        return echelleConverter.toVo(echelleService.findAll());
    }

    @ApiOperation("Finds a echelle with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EchelleVo findByIdWithAssociatedList(@PathVariable Long id){
    return echelleConverter.toVo(echelleService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search echelle by a specific criteria")
    @PostMapping("/search")
    public List<EchelleVo> findByCriteria(@RequestBody EchelleVo echelleVo){
        return echelleConverter.toVo(echelleService.findByCriteria(echelleVo));
        }

            @ApiOperation("Finds a echelle by id")
            @GetMapping("/id/{id}")
            public EchelleVo findById(@PathVariable Long id){
            return echelleConverter.toVo(echelleService.findById(id));
            }

            @ApiOperation("Saves the specified  echelle")
            @PostMapping("/")
            public EchelleVo save(@RequestBody EchelleVo echelleVo){
            Echelle echelle = echelleConverter.toItem(echelleVo);
            echelle = echelleService.save(echelle);
            return echelleConverter.toVo(echelle);
            }

            @ApiOperation("Delete the specified echelle")
            @DeleteMapping("/")
            public int delete(@RequestBody EchelleVo echelleVo){
            Echelle echelle = echelleConverter.toItem(echelleVo);
            return echelleService.delete(echelle);
            }

            @ApiOperation("Deletes a echelle by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return echelleService.deleteById(id);
            }
        @ApiOperation("find by echelon reference")
        @GetMapping("/echelon/reference/{reference}")
        public List<Echelle> findByEchelonReference(@PathVariable String reference){
        return echelleService.findByEchelonReference(reference);
        }

        @ApiOperation("delete by echelon reference")
        @DeleteMapping("/echelon/reference/{reference}")
        public int deleteByEchelonReference(@PathVariable String reference){
        return echelleService.deleteByEchelonReference(reference);
        }

        @ApiOperation("find by echelon id")
        @GetMapping("/echelon/id/{id}")
        public List<Echelle> findByEchelonId(@PathVariable Long id){
        return echelleService.findByEchelonId(id);
        }

        @ApiOperation("delete by echelon id")
        @DeleteMapping("/echelon/id/{id}")
        public int deleteByEchelonId(@PathVariable Long id){
        return echelleService.deleteByEchelonId(id);
        }



            }

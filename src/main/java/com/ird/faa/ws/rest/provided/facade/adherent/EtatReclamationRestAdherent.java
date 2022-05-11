package  com.ird.faa.ws.rest.provided.facade.adherent;

import com.ird.faa.service.adherent.facade.EtatReclamationAdherentService;

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
import com.ird.faa.bean.EtatReclamation;
import com.ird.faa.ws.rest.provided.converter.EtatReclamationConverter;
import com.ird.faa.ws.rest.provided.vo.EtatReclamationVo;

@Api("Manages etatReclamation services")
@RestController
@RequestMapping("api/adherent/etatReclamation")
public class EtatReclamationRestAdherent {

@Autowired
private EtatReclamationAdherentService etatReclamationService;

@Autowired
private EtatReclamationConverter etatReclamationConverter;


            @ApiOperation("Updates the specified  etatReclamation")
            @PutMapping("/")
            public  EtatReclamationVo update(@RequestBody  EtatReclamationVo  etatReclamationVo){
            EtatReclamation etatReclamation = etatReclamationConverter.toItem(etatReclamationVo);
            etatReclamation = etatReclamationService.update(etatReclamation);
            return etatReclamationConverter.toVo(etatReclamation);
            }

    @ApiOperation("Finds a list of all etatReclamations")
    @GetMapping("/")
    public List<EtatReclamationVo> findAll(){
        return etatReclamationConverter.toVo(etatReclamationService.findAll());
    }

    @ApiOperation("Finds a etatReclamation with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EtatReclamationVo findByIdWithAssociatedList(@PathVariable Long id){
    return etatReclamationConverter.toVo(etatReclamationService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search etatReclamation by a specific criteria")
    @PostMapping("/search")
    public List<EtatReclamationVo> findByCriteria(@RequestBody EtatReclamationVo etatReclamationVo){
        return etatReclamationConverter.toVo(etatReclamationService.findByCriteria(etatReclamationVo));
        }

            @ApiOperation("Finds a etatReclamation by id")
            @GetMapping("/id/{id}")
            public EtatReclamationVo findById(@PathVariable Long id){
            return etatReclamationConverter.toVo(etatReclamationService.findById(id));
            }

            @ApiOperation("Saves the specified  etatReclamation")
            @PostMapping("/")
            public EtatReclamationVo save(@RequestBody EtatReclamationVo etatReclamationVo){
            EtatReclamation etatReclamation = etatReclamationConverter.toItem(etatReclamationVo);
            etatReclamation = etatReclamationService.save(etatReclamation);
            return etatReclamationConverter.toVo(etatReclamation);
            }

            @ApiOperation("Delete the specified etatReclamation")
            @DeleteMapping("/")
            public int delete(@RequestBody EtatReclamationVo etatReclamationVo){
            EtatReclamation etatReclamation = etatReclamationConverter.toItem(etatReclamationVo);
            return etatReclamationService.delete(etatReclamation);
            }

            @ApiOperation("Deletes a etatReclamation by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return etatReclamationService.deleteById(id);
            }


            }

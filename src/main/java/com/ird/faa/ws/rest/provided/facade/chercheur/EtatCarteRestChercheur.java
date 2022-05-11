package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.EtatCarteChercheurService;

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
import com.ird.faa.bean.EtatCarte;
import com.ird.faa.ws.rest.provided.converter.EtatCarteConverter;
import com.ird.faa.ws.rest.provided.vo.EtatCarteVo;

@Api("Manages etatCarte services")
@RestController
@RequestMapping("api/chercheur/etatCarte")
public class EtatCarteRestChercheur {

@Autowired
private EtatCarteChercheurService etatCarteService;

@Autowired
private EtatCarteConverter etatCarteConverter;


            @ApiOperation("Updates the specified  etatCarte")
            @PutMapping("/")
            public  EtatCarteVo update(@RequestBody  EtatCarteVo  etatCarteVo){
            EtatCarte etatCarte = etatCarteConverter.toItem(etatCarteVo);
            etatCarte = etatCarteService.update(etatCarte);
            return etatCarteConverter.toVo(etatCarte);
            }

    @ApiOperation("Finds a list of all etatCartes")
    @GetMapping("/")
    public List<EtatCarteVo> findAll(){
        return etatCarteConverter.toVo(etatCarteService.findAll());
    }

    @ApiOperation("Finds a etatCarte with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EtatCarteVo findByIdWithAssociatedList(@PathVariable Long id){
    return etatCarteConverter.toVo(etatCarteService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search etatCarte by a specific criteria")
    @PostMapping("/search")
    public List<EtatCarteVo> findByCriteria(@RequestBody EtatCarteVo etatCarteVo){
        return etatCarteConverter.toVo(etatCarteService.findByCriteria(etatCarteVo));
        }

            @ApiOperation("Finds a etatCarte by id")
            @GetMapping("/id/{id}")
            public EtatCarteVo findById(@PathVariable Long id){
            return etatCarteConverter.toVo(etatCarteService.findById(id));
            }

            @ApiOperation("Saves the specified  etatCarte")
            @PostMapping("/")
            public EtatCarteVo save(@RequestBody EtatCarteVo etatCarteVo){
            EtatCarte etatCarte = etatCarteConverter.toItem(etatCarteVo);
            etatCarte = etatCarteService.save(etatCarte);
            return etatCarteConverter.toVo(etatCarte);
            }

            @ApiOperation("Delete the specified etatCarte")
            @DeleteMapping("/")
            public int delete(@RequestBody EtatCarteVo etatCarteVo){
            EtatCarte etatCarte = etatCarteConverter.toItem(etatCarteVo);
            return etatCarteService.delete(etatCarte);
            }

            @ApiOperation("Deletes a etatCarte by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return etatCarteService.deleteById(id);
            }


            }

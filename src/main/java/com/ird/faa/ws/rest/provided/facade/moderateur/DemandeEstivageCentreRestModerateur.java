package  com.ird.faa.ws.rest.provided.facade.moderateur;

import com.ird.faa.service.moderateur.facade.DemandeEstivageCentreModerateurService;

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
import com.ird.faa.bean.DemandeEstivageCentre;
import com.ird.faa.ws.rest.provided.converter.DemandeEstivageCentreConverter;
import com.ird.faa.ws.rest.provided.vo.DemandeEstivageCentreVo;

@Api("Manages demandeEstivageCentre services")
@RestController
@RequestMapping("api/moderateur/demandeEstivageCentre")
public class DemandeEstivageCentreRestModerateur {

@Autowired
private DemandeEstivageCentreModerateurService demandeEstivageCentreService;

@Autowired
private DemandeEstivageCentreConverter demandeEstivageCentreConverter;


            @ApiOperation("Updates the specified  demandeEstivageCentre")
            @PutMapping("/")
            public  DemandeEstivageCentreVo update(@RequestBody  DemandeEstivageCentreVo  demandeEstivageCentreVo){
            DemandeEstivageCentre demandeEstivageCentre = demandeEstivageCentreConverter.toItem(demandeEstivageCentreVo);
            demandeEstivageCentre = demandeEstivageCentreService.update(demandeEstivageCentre);
            return demandeEstivageCentreConverter.toVo(demandeEstivageCentre);
            }

    @ApiOperation("Finds a list of all demandeEstivageCentres")
    @GetMapping("/")
    public List<DemandeEstivageCentreVo> findAll(){
        return demandeEstivageCentreConverter.toVo(demandeEstivageCentreService.findAll());
    }

    @ApiOperation("Finds a demandeEstivageCentre with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public DemandeEstivageCentreVo findByIdWithAssociatedList(@PathVariable Long id){
    return demandeEstivageCentreConverter.toVo(demandeEstivageCentreService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search demandeEstivageCentre by a specific criteria")
    @PostMapping("/search")
    public List<DemandeEstivageCentreVo> findByCriteria(@RequestBody DemandeEstivageCentreVo demandeEstivageCentreVo){
        return demandeEstivageCentreConverter.toVo(demandeEstivageCentreService.findByCriteria(demandeEstivageCentreVo));
        }

            @ApiOperation("Finds a demandeEstivageCentre by id")
            @GetMapping("/id/{id}")
            public DemandeEstivageCentreVo findById(@PathVariable Long id){
            return demandeEstivageCentreConverter.toVo(demandeEstivageCentreService.findById(id));
            }

            @ApiOperation("Saves the specified  demandeEstivageCentre")
            @PostMapping("/")
            public DemandeEstivageCentreVo save(@RequestBody DemandeEstivageCentreVo demandeEstivageCentreVo){
            DemandeEstivageCentre demandeEstivageCentre = demandeEstivageCentreConverter.toItem(demandeEstivageCentreVo);
            demandeEstivageCentre = demandeEstivageCentreService.save(demandeEstivageCentre);
            return demandeEstivageCentreConverter.toVo(demandeEstivageCentre);
            }

            @ApiOperation("Delete the specified demandeEstivageCentre")
            @DeleteMapping("/")
            public int delete(@RequestBody DemandeEstivageCentreVo demandeEstivageCentreVo){
            DemandeEstivageCentre demandeEstivageCentre = demandeEstivageCentreConverter.toItem(demandeEstivageCentreVo);
            return demandeEstivageCentreService.delete(demandeEstivageCentre);
            }

            @ApiOperation("Deletes a demandeEstivageCentre by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return demandeEstivageCentreService.deleteById(id);
            }
        @ApiOperation("find by demandeEstivage reference")
        @GetMapping("/demandeEstivage/reference/{reference}")
        public List<DemandeEstivageCentre> findByDemandeEstivageReference(@PathVariable String reference){
        return demandeEstivageCentreService.findByDemandeEstivageReference(reference);
        }

        @ApiOperation("delete by demandeEstivage reference")
        @DeleteMapping("/demandeEstivage/reference/{reference}")
        public int deleteByDemandeEstivageReference(@PathVariable String reference){
        return demandeEstivageCentreService.deleteByDemandeEstivageReference(reference);
        }

        @ApiOperation("find by demandeEstivage id")
        @GetMapping("/demandeEstivage/id/{id}")
        public List<DemandeEstivageCentre> findByDemandeEstivageId(@PathVariable Long id){
        return demandeEstivageCentreService.findByDemandeEstivageId(id);
        }

        @ApiOperation("delete by demandeEstivage id")
        @DeleteMapping("/demandeEstivage/id/{id}")
        public int deleteByDemandeEstivageId(@PathVariable Long id){
        return demandeEstivageCentreService.deleteByDemandeEstivageId(id);
        }

        @ApiOperation("find by CentreEstivage id")
        @GetMapping("/centreEstivage/id/{id}")
        public List<DemandeEstivageCentre> findByCentreEstivageId(@PathVariable Long id){
        return demandeEstivageCentreService.findByCentreEstivageId(id);
        }

        @ApiOperation("delete by CentreEstivage id")
        @DeleteMapping("/centreEstivage/id/{id}")
        public int deleteByCentreEstivageId(@PathVariable Long id){
        return demandeEstivageCentreService.deleteByCentreEstivageId(id);
        }



            }

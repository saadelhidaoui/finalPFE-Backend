package  com.ird.faa.ws.rest.provided.facade.adherent;

import com.ird.faa.service.adherent.facade.RendezVousAdherentService;

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
import com.ird.faa.bean.RendezVous;
import com.ird.faa.ws.rest.provided.converter.RendezVousConverter;
import com.ird.faa.ws.rest.provided.vo.RendezVousVo;

@Api("Manages rendezVous services")
@RestController
@RequestMapping("api/adherent/rendezVous")
public class RendezVousRestAdherent {

@Autowired
private RendezVousAdherentService rendezVousService;

@Autowired
private RendezVousConverter rendezVousConverter;


            @ApiOperation("Updates the specified  rendezVous")
            @PutMapping("/")
            public  RendezVousVo update(@RequestBody  RendezVousVo  rendezVousVo){
            RendezVous rendezVous = rendezVousConverter.toItem(rendezVousVo);
            rendezVous = rendezVousService.update(rendezVous);
            return rendezVousConverter.toVo(rendezVous);
            }

    @ApiOperation("Finds a list of all rendezVouss")
    @GetMapping("/")
    public List<RendezVousVo> findAll(){
        return rendezVousConverter.toVo(rendezVousService.findAll());
    }

    @ApiOperation("Finds a rendezVous with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public RendezVousVo findByIdWithAssociatedList(@PathVariable Long id){
    return rendezVousConverter.toVo(rendezVousService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search rendezVous by a specific criteria")
    @PostMapping("/search")
    public List<RendezVousVo> findByCriteria(@RequestBody RendezVousVo rendezVousVo){
        return rendezVousConverter.toVo(rendezVousService.findByCriteria(rendezVousVo));
        }

            @ApiOperation("Finds a rendezVous by id")
            @GetMapping("/id/{id}")
            public RendezVousVo findById(@PathVariable Long id){
            return rendezVousConverter.toVo(rendezVousService.findById(id));
            }

            @ApiOperation("Saves the specified  rendezVous")
            @PostMapping("/")
            public RendezVousVo save(@RequestBody RendezVousVo rendezVousVo){
            RendezVous rendezVous = rendezVousConverter.toItem(rendezVousVo);
            rendezVous = rendezVousService.save(rendezVous);
            return rendezVousConverter.toVo(rendezVous);
            }

            @ApiOperation("Delete the specified rendezVous")
            @DeleteMapping("/")
            public int delete(@RequestBody RendezVousVo rendezVousVo){
            RendezVous rendezVous = rendezVousConverter.toItem(rendezVousVo);
            return rendezVousService.delete(rendezVous);
            }

            @ApiOperation("Deletes a rendezVous by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return rendezVousService.deleteById(id);
            }


            @PutMapping("/archiver/")
            public RendezVousVo archiver(@RequestBody RendezVousVo rendezVousVo){
                RendezVous rendezVous = rendezVousService.archiver(rendezVousConverter.toItem(rendezVousVo));
                return rendezVousConverter.toVo(rendezVous);
                }

            @PutMapping("/desarchiver/")
            public RendezVousVo desarchiver(@RequestBody RendezVousVo rendezVousVo){
                RendezVous rendezVous = rendezVousService.desarchiver(rendezVousConverter.toItem(rendezVousVo));
                return rendezVousConverter.toVo(rendezVous);}
            }

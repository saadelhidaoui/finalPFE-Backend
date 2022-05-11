package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.ProjetChercheurService;

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
import com.ird.faa.bean.Projet;
import com.ird.faa.ws.rest.provided.converter.ProjetConverter;
import com.ird.faa.ws.rest.provided.vo.ProjetVo;

@Api("Manages projet services")
@RestController
@RequestMapping("api/chercheur/projet")
public class ProjetRestChercheur {

@Autowired
private ProjetChercheurService projetService;

@Autowired
private ProjetConverter projetConverter;


            @ApiOperation("Updates the specified  projet")
            @PutMapping("/")
            public  ProjetVo update(@RequestBody  ProjetVo  projetVo){
            Projet projet = projetConverter.toItem(projetVo);
            projet = projetService.update(projet);
            return projetConverter.toVo(projet);
            }

    @ApiOperation("Finds a list of all projets")
    @GetMapping("/")
    public List<ProjetVo> findAll(){
        return projetConverter.toVo(projetService.findAll());
    }

    @ApiOperation("Finds a projet with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public ProjetVo findByIdWithAssociatedList(@PathVariable Long id){
    return projetConverter.toVo(projetService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search projet by a specific criteria")
    @PostMapping("/search")
    public List<ProjetVo> findByCriteria(@RequestBody ProjetVo projetVo){
        return projetConverter.toVo(projetService.findByCriteria(projetVo));
        }

            @ApiOperation("Finds a projet by id")
            @GetMapping("/id/{id}")
            public ProjetVo findById(@PathVariable Long id){
            return projetConverter.toVo(projetService.findById(id));
            }

            @ApiOperation("Saves the specified  projet")
            @PostMapping("/")
            public ProjetVo save(@RequestBody ProjetVo projetVo){
            Projet projet = projetConverter.toItem(projetVo);
            projet = projetService.save(projet);
            return projetConverter.toVo(projet);
            }

            @ApiOperation("Delete the specified projet")
            @DeleteMapping("/")
            public int delete(@RequestBody ProjetVo projetVo){
            Projet projet = projetConverter.toItem(projetVo);
            return projetService.delete(projet);
            }

            @ApiOperation("Deletes a projet by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return projetService.deleteById(id);
            }
        @ApiOperation("find by etatProjet code")
        @GetMapping("/etatProjet/code/{code}")
        public List<Projet> findByEtatProjetCode(@PathVariable String code){
        return projetService.findByEtatProjetCode(code);
        }

        @ApiOperation("delete by etatProjet code")
        @DeleteMapping("/etatProjet/code/{code}")
        public int deleteByEtatProjetCode(@PathVariable String code){
        return projetService.deleteByEtatProjetCode(code);
        }

        @ApiOperation("find by etatProjet id")
        @GetMapping("/etatProjet/id/{id}")
        public List<Projet> findByEtatProjetId(@PathVariable Long id){
        return projetService.findByEtatProjetId(id);
        }

        @ApiOperation("delete by etatProjet id")
        @DeleteMapping("/etatProjet/id/{id}")
        public int deleteByEtatProjetId(@PathVariable Long id){
        return projetService.deleteByEtatProjetId(id);
        }



            }

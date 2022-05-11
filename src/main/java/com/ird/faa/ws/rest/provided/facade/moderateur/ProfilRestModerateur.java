package  com.ird.faa.ws.rest.provided.facade.moderateur;

import com.ird.faa.service.moderateur.facade.ProfilModerateurService;

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
import com.ird.faa.bean.Profil;
import com.ird.faa.ws.rest.provided.converter.ProfilConverter;
import com.ird.faa.ws.rest.provided.vo.ProfilVo;

@Api("Manages profil services")
@RestController
@RequestMapping("api/moderateur/profil")
public class ProfilRestModerateur {

@Autowired
private ProfilModerateurService profilService;

@Autowired
private ProfilConverter profilConverter;


            @ApiOperation("Updates the specified  profil")
            @PutMapping("/")
            public  ProfilVo update(@RequestBody  ProfilVo  profilVo){
            Profil profil = profilConverter.toItem(profilVo);
            profil = profilService.update(profil);
            return profilConverter.toVo(profil);
            }

    @ApiOperation("Finds a list of all profils")
    @GetMapping("/")
    public List<ProfilVo> findAll(){
        return profilConverter.toVo(profilService.findAll());
    }

    @ApiOperation("Finds a profil with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public ProfilVo findByIdWithAssociatedList(@PathVariable Long id){
    return profilConverter.toVo(profilService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search profil by a specific criteria")
    @PostMapping("/search")
    public List<ProfilVo> findByCriteria(@RequestBody ProfilVo profilVo){
        return profilConverter.toVo(profilService.findByCriteria(profilVo));
        }

            @ApiOperation("Finds a profil by id")
            @GetMapping("/id/{id}")
            public ProfilVo findById(@PathVariable Long id){
            return profilConverter.toVo(profilService.findById(id));
            }

            @ApiOperation("Saves the specified  profil")
            @PostMapping("/")
            public ProfilVo save(@RequestBody ProfilVo profilVo){
            Profil profil = profilConverter.toItem(profilVo);
            profil = profilService.save(profil);
            return profilConverter.toVo(profil);
            }

            @ApiOperation("Delete the specified profil")
            @DeleteMapping("/")
            public int delete(@RequestBody ProfilVo profilVo){
            Profil profil = profilConverter.toItem(profilVo);
            return profilService.delete(profil);
            }

            @ApiOperation("Deletes a profil by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return profilService.deleteById(id);
            }
        @ApiOperation("find by grade reference")
        @GetMapping("/grade/reference/{reference}")
        public List<Profil> findByGradeReference(@PathVariable String reference){
        return profilService.findByGradeReference(reference);
        }

        @ApiOperation("delete by grade reference")
        @DeleteMapping("/grade/reference/{reference}")
        public int deleteByGradeReference(@PathVariable String reference){
        return profilService.deleteByGradeReference(reference);
        }

        @ApiOperation("find by grade id")
        @GetMapping("/grade/id/{id}")
        public List<Profil> findByGradeId(@PathVariable Long id){
        return profilService.findByGradeId(id);
        }

        @ApiOperation("delete by grade id")
        @DeleteMapping("/grade/id/{id}")
        public int deleteByGradeId(@PathVariable Long id){
        return profilService.deleteByGradeId(id);
        }

        @ApiOperation("find by echelle reference")
        @GetMapping("/echelle/reference/{reference}")
        public List<Profil> findByEchelleReference(@PathVariable String reference){
        return profilService.findByEchelleReference(reference);
        }

        @ApiOperation("delete by echelle reference")
        @DeleteMapping("/echelle/reference/{reference}")
        public int deleteByEchelleReference(@PathVariable String reference){
        return profilService.deleteByEchelleReference(reference);
        }

        @ApiOperation("find by echelle id")
        @GetMapping("/echelle/id/{id}")
        public List<Profil> findByEchelleId(@PathVariable Long id){
        return profilService.findByEchelleId(id);
        }

        @ApiOperation("delete by echelle id")
        @DeleteMapping("/echelle/id/{id}")
        public int deleteByEchelleId(@PathVariable Long id){
        return profilService.deleteByEchelleId(id);
        }



            }

package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.EtatDemandeEstivageAdminService;

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
import com.ird.faa.bean.EtatDemandeEstivage;
import com.ird.faa.ws.rest.provided.converter.EtatDemandeEstivageConverter;
import com.ird.faa.ws.rest.provided.vo.EtatDemandeEstivageVo;

@Api("Manages etatDemandeEstivage services")
@RestController
@RequestMapping("api/admin/etatDemandeEstivage")
public class EtatDemandeEstivageRestAdmin {

@Autowired
private EtatDemandeEstivageAdminService etatDemandeEstivageService;

@Autowired
private EtatDemandeEstivageConverter etatDemandeEstivageConverter;


            @ApiOperation("Updates the specified  etatDemandeEstivage")
            @PutMapping("/")
            public  EtatDemandeEstivageVo update(@RequestBody  EtatDemandeEstivageVo  etatDemandeEstivageVo){
            EtatDemandeEstivage etatDemandeEstivage = etatDemandeEstivageConverter.toItem(etatDemandeEstivageVo);
            etatDemandeEstivage = etatDemandeEstivageService.update(etatDemandeEstivage);
            return etatDemandeEstivageConverter.toVo(etatDemandeEstivage);
            }

    @ApiOperation("Finds a list of all etatDemandeEstivages")
    @GetMapping("/")
    public List<EtatDemandeEstivageVo> findAll(){
        return etatDemandeEstivageConverter.toVo(etatDemandeEstivageService.findAll());
    }

    @ApiOperation("Finds a etatDemandeEstivage with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EtatDemandeEstivageVo findByIdWithAssociatedList(@PathVariable Long id){
    return etatDemandeEstivageConverter.toVo(etatDemandeEstivageService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search etatDemandeEstivage by a specific criteria")
    @PostMapping("/search")
    public List<EtatDemandeEstivageVo> findByCriteria(@RequestBody EtatDemandeEstivageVo etatDemandeEstivageVo){
        return etatDemandeEstivageConverter.toVo(etatDemandeEstivageService.findByCriteria(etatDemandeEstivageVo));
        }

            @ApiOperation("Finds a etatDemandeEstivage by id")
            @GetMapping("/id/{id}")
            public EtatDemandeEstivageVo findById(@PathVariable Long id){
            return etatDemandeEstivageConverter.toVo(etatDemandeEstivageService.findById(id));
            }

            @ApiOperation("Saves the specified  etatDemandeEstivage")
            @PostMapping("/")
            public EtatDemandeEstivageVo save(@RequestBody EtatDemandeEstivageVo etatDemandeEstivageVo){
            EtatDemandeEstivage etatDemandeEstivage = etatDemandeEstivageConverter.toItem(etatDemandeEstivageVo);
            etatDemandeEstivage = etatDemandeEstivageService.save(etatDemandeEstivage);
            return etatDemandeEstivageConverter.toVo(etatDemandeEstivage);
            }

            @ApiOperation("Delete the specified etatDemandeEstivage")
            @DeleteMapping("/")
            public int delete(@RequestBody EtatDemandeEstivageVo etatDemandeEstivageVo){
            EtatDemandeEstivage etatDemandeEstivage = etatDemandeEstivageConverter.toItem(etatDemandeEstivageVo);
            return etatDemandeEstivageService.delete(etatDemandeEstivage);
            }

            @ApiOperation("Deletes a etatDemandeEstivage by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return etatDemandeEstivageService.deleteById(id);
            }


            }

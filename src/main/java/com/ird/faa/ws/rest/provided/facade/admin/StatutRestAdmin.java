package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.StatutAdminService;

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
import com.ird.faa.bean.Statut;
import com.ird.faa.ws.rest.provided.converter.StatutConverter;
import com.ird.faa.ws.rest.provided.vo.StatutVo;

@Api("Manages statut services")
@RestController
@RequestMapping("api/admin/statut")
public class StatutRestAdmin {

@Autowired
private StatutAdminService statutService;

@Autowired
private StatutConverter statutConverter;


            @ApiOperation("Updates the specified  statut")
            @PutMapping("/")
            public  StatutVo update(@RequestBody  StatutVo  statutVo){
            Statut statut = statutConverter.toItem(statutVo);
            statut = statutService.update(statut);
            return statutConverter.toVo(statut);
            }

    @ApiOperation("Finds a list of all statuts")
    @GetMapping("/")
    public List<StatutVo> findAll(){
        return statutConverter.toVo(statutService.findAll());
    }

    @ApiOperation("Finds a statut with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public StatutVo findByIdWithAssociatedList(@PathVariable Long id){
    return statutConverter.toVo(statutService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search statut by a specific criteria")
    @PostMapping("/search")
    public List<StatutVo> findByCriteria(@RequestBody StatutVo statutVo){
        return statutConverter.toVo(statutService.findByCriteria(statutVo));
        }

            @ApiOperation("Finds a statut by id")
            @GetMapping("/id/{id}")
            public StatutVo findById(@PathVariable Long id){
            return statutConverter.toVo(statutService.findById(id));
            }

            @ApiOperation("Saves the specified  statut")
            @PostMapping("/")
            public StatutVo save(@RequestBody StatutVo statutVo){
            Statut statut = statutConverter.toItem(statutVo);
            statut = statutService.save(statut);
            return statutConverter.toVo(statut);
            }

            @ApiOperation("Delete the specified statut")
            @DeleteMapping("/")
            public int delete(@RequestBody StatutVo statutVo){
            Statut statut = statutConverter.toItem(statutVo);
            return statutService.delete(statut);
            }

            @ApiOperation("Deletes a statut by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return statutService.deleteById(id);
            }


            }

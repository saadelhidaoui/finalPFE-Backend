package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.QualiteAdminService;

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
import com.ird.faa.bean.Qualite;
import com.ird.faa.ws.rest.provided.converter.QualiteConverter;
import com.ird.faa.ws.rest.provided.vo.QualiteVo;

@Api("Manages qualite services")
@RestController
@RequestMapping("api/admin/qualite")
public class QualiteRestAdmin {

@Autowired
private QualiteAdminService qualiteService;

@Autowired
private QualiteConverter qualiteConverter;


            @ApiOperation("Updates the specified  qualite")
            @PutMapping("/")
            public  QualiteVo update(@RequestBody  QualiteVo  qualiteVo){
            Qualite qualite = qualiteConverter.toItem(qualiteVo);
            qualite = qualiteService.update(qualite);
            return qualiteConverter.toVo(qualite);
            }

    @ApiOperation("Finds a list of all qualites")
    @GetMapping("/")
    public List<QualiteVo> findAll(){
        return qualiteConverter.toVo(qualiteService.findAll());
    }

    @ApiOperation("Finds a qualite with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public QualiteVo findByIdWithAssociatedList(@PathVariable Long id){
    return qualiteConverter.toVo(qualiteService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search qualite by a specific criteria")
    @PostMapping("/search")
    public List<QualiteVo> findByCriteria(@RequestBody QualiteVo qualiteVo){
        return qualiteConverter.toVo(qualiteService.findByCriteria(qualiteVo));
        }

            @ApiOperation("Finds a qualite by id")
            @GetMapping("/id/{id}")
            public QualiteVo findById(@PathVariable Long id){
            return qualiteConverter.toVo(qualiteService.findById(id));
            }

            @ApiOperation("Saves the specified  qualite")
            @PostMapping("/")
            public QualiteVo save(@RequestBody QualiteVo qualiteVo){
            Qualite qualite = qualiteConverter.toItem(qualiteVo);
            qualite = qualiteService.save(qualite);
            return qualiteConverter.toVo(qualite);
            }

            @ApiOperation("Delete the specified qualite")
            @DeleteMapping("/")
            public int delete(@RequestBody QualiteVo qualiteVo){
            Qualite qualite = qualiteConverter.toItem(qualiteVo);
            return qualiteService.delete(qualite);
            }

            @ApiOperation("Deletes a qualite by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return qualiteService.deleteById(id);
            }


            }

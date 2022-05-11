package  com.ird.faa.ws.rest.provided.facade.moderateur;

import com.ird.faa.service.moderateur.facade.RegionModerateurService;

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
import com.ird.faa.bean.Region;
import com.ird.faa.ws.rest.provided.converter.RegionConverter;
import com.ird.faa.ws.rest.provided.vo.RegionVo;

@Api("Manages region services")
@RestController
@RequestMapping("api/moderateur/region")
public class RegionRestModerateur {

@Autowired
private RegionModerateurService regionService;

@Autowired
private RegionConverter regionConverter;


            @ApiOperation("Updates the specified  region")
            @PutMapping("/")
            public  RegionVo update(@RequestBody  RegionVo  regionVo){
            Region region = regionConverter.toItem(regionVo);
            region = regionService.update(region);
            return regionConverter.toVo(region);
            }

    @ApiOperation("Finds a list of all regions")
    @GetMapping("/")
    public List<RegionVo> findAll(){
        return regionConverter.toVo(regionService.findAll());
    }

    @ApiOperation("Finds a region with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public RegionVo findByIdWithAssociatedList(@PathVariable Long id){
    return regionConverter.toVo(regionService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search region by a specific criteria")
    @PostMapping("/search")
    public List<RegionVo> findByCriteria(@RequestBody RegionVo regionVo){
        return regionConverter.toVo(regionService.findByCriteria(regionVo));
        }

            @ApiOperation("Finds a region by id")
            @GetMapping("/id/{id}")
            public RegionVo findById(@PathVariable Long id){
            return regionConverter.toVo(regionService.findById(id));
            }

            @ApiOperation("Saves the specified  region")
            @PostMapping("/")
            public RegionVo save(@RequestBody RegionVo regionVo){
            Region region = regionConverter.toItem(regionVo);
            region = regionService.save(region);
            return regionConverter.toVo(region);
            }

            @ApiOperation("Delete the specified region")
            @DeleteMapping("/")
            public int delete(@RequestBody RegionVo regionVo){
            Region region = regionConverter.toItem(regionVo);
            return regionService.delete(region);
            }

            @ApiOperation("Deletes a region by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return regionService.deleteById(id);
            }


            }

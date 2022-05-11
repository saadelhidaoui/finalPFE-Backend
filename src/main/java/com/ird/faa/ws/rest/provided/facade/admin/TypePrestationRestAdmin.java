package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.TypePrestationAdminService;

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
import com.ird.faa.bean.TypePrestation;
import com.ird.faa.ws.rest.provided.converter.TypePrestationConverter;
import com.ird.faa.ws.rest.provided.vo.TypePrestationVo;

@Api("Manages typePrestation services")
@RestController
@RequestMapping("api/admin/typePrestation")
public class TypePrestationRestAdmin {

@Autowired
private TypePrestationAdminService typePrestationService;

@Autowired
private TypePrestationConverter typePrestationConverter;


            @ApiOperation("Updates the specified  typePrestation")
            @PutMapping("/")
            public  TypePrestationVo update(@RequestBody  TypePrestationVo  typePrestationVo){
            TypePrestation typePrestation = typePrestationConverter.toItem(typePrestationVo);
            typePrestation = typePrestationService.update(typePrestation);
            return typePrestationConverter.toVo(typePrestation);
            }

    @ApiOperation("Finds a list of all typePrestations")
    @GetMapping("/")
    public List<TypePrestationVo> findAll(){
        return typePrestationConverter.toVo(typePrestationService.findAll());
    }

    @ApiOperation("Finds a typePrestation with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public TypePrestationVo findByIdWithAssociatedList(@PathVariable Long id){
    return typePrestationConverter.toVo(typePrestationService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search typePrestation by a specific criteria")
    @PostMapping("/search")
    public List<TypePrestationVo> findByCriteria(@RequestBody TypePrestationVo typePrestationVo){
        return typePrestationConverter.toVo(typePrestationService.findByCriteria(typePrestationVo));
        }

            @ApiOperation("Finds a typePrestation by id")
            @GetMapping("/id/{id}")
            public TypePrestationVo findById(@PathVariable Long id){
            return typePrestationConverter.toVo(typePrestationService.findById(id));
            }

            @ApiOperation("Saves the specified  typePrestation")
            @PostMapping("/")
            public TypePrestationVo save(@RequestBody TypePrestationVo typePrestationVo){
            TypePrestation typePrestation = typePrestationConverter.toItem(typePrestationVo);
            typePrestation = typePrestationService.save(typePrestation);
            return typePrestationConverter.toVo(typePrestation);
            }

            @ApiOperation("Delete the specified typePrestation")
            @DeleteMapping("/")
            public int delete(@RequestBody TypePrestationVo typePrestationVo){
            TypePrestation typePrestation = typePrestationConverter.toItem(typePrestationVo);
            return typePrestationService.delete(typePrestation);
            }

            @ApiOperation("Deletes a typePrestation by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return typePrestationService.deleteById(id);
            }


            }

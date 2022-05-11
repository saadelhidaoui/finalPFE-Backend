package  com.ird.faa.ws.rest.provided.facade.adherent;

import com.ird.faa.service.adherent.facade.PieceJointePrestationAdherentService;

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
import com.ird.faa.bean.PieceJointePrestation;
import com.ird.faa.ws.rest.provided.converter.PieceJointePrestationConverter;
import com.ird.faa.ws.rest.provided.vo.PieceJointePrestationVo;

@Api("Manages pieceJointePrestation services")
@RestController
@RequestMapping("api/adherent/pieceJointePrestation")
public class PieceJointePrestationRestAdherent {

@Autowired
private PieceJointePrestationAdherentService pieceJointePrestationService;

@Autowired
private PieceJointePrestationConverter pieceJointePrestationConverter;


            @ApiOperation("Updates the specified  pieceJointePrestation")
            @PutMapping("/")
            public  PieceJointePrestationVo update(@RequestBody  PieceJointePrestationVo  pieceJointePrestationVo){
            PieceJointePrestation pieceJointePrestation = pieceJointePrestationConverter.toItem(pieceJointePrestationVo);
            pieceJointePrestation = pieceJointePrestationService.update(pieceJointePrestation);
            return pieceJointePrestationConverter.toVo(pieceJointePrestation);
            }

    @ApiOperation("Finds a list of all pieceJointePrestations")
    @GetMapping("/")
    public List<PieceJointePrestationVo> findAll(){
        return pieceJointePrestationConverter.toVo(pieceJointePrestationService.findAll());
    }

    @ApiOperation("Finds a pieceJointePrestation with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public PieceJointePrestationVo findByIdWithAssociatedList(@PathVariable Long id){
    return pieceJointePrestationConverter.toVo(pieceJointePrestationService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search pieceJointePrestation by a specific criteria")
    @PostMapping("/search")
    public List<PieceJointePrestationVo> findByCriteria(@RequestBody PieceJointePrestationVo pieceJointePrestationVo){
        return pieceJointePrestationConverter.toVo(pieceJointePrestationService.findByCriteria(pieceJointePrestationVo));
        }

            @ApiOperation("Finds a pieceJointePrestation by id")
            @GetMapping("/id/{id}")
            public PieceJointePrestationVo findById(@PathVariable Long id){
            return pieceJointePrestationConverter.toVo(pieceJointePrestationService.findById(id));
            }

            @ApiOperation("Saves the specified  pieceJointePrestation")
            @PostMapping("/")
            public PieceJointePrestationVo save(@RequestBody PieceJointePrestationVo pieceJointePrestationVo){
            PieceJointePrestation pieceJointePrestation = pieceJointePrestationConverter.toItem(pieceJointePrestationVo);
            pieceJointePrestation = pieceJointePrestationService.save(pieceJointePrestation);
            return pieceJointePrestationConverter.toVo(pieceJointePrestation);
            }

            @ApiOperation("Delete the specified pieceJointePrestation")
            @DeleteMapping("/")
            public int delete(@RequestBody PieceJointePrestationVo pieceJointePrestationVo){
            PieceJointePrestation pieceJointePrestation = pieceJointePrestationConverter.toItem(pieceJointePrestationVo);
            return pieceJointePrestationService.delete(pieceJointePrestation);
            }

            @ApiOperation("Deletes a pieceJointePrestation by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return pieceJointePrestationService.deleteById(id);
            }
        @ApiOperation("find by prestation reference")
        @GetMapping("/prestation/reference/{reference}")
        public List<PieceJointePrestation> findByPrestationReference(@PathVariable String reference){
        return pieceJointePrestationService.findByPrestationReference(reference);
        }

        @ApiOperation("delete by prestation reference")
        @DeleteMapping("/prestation/reference/{reference}")
        public int deleteByPrestationReference(@PathVariable String reference){
        return pieceJointePrestationService.deleteByPrestationReference(reference);
        }

        @ApiOperation("find by prestation id")
        @GetMapping("/prestation/id/{id}")
        public List<PieceJointePrestation> findByPrestationId(@PathVariable Long id){
        return pieceJointePrestationService.findByPrestationId(id);
        }

        @ApiOperation("delete by prestation id")
        @DeleteMapping("/prestation/id/{id}")
        public int deleteByPrestationId(@PathVariable Long id){
        return pieceJointePrestationService.deleteByPrestationId(id);
        }



            @PutMapping("/archiver/")
            public PieceJointePrestationVo archiver(@RequestBody PieceJointePrestationVo pieceJointePrestationVo){
                PieceJointePrestation pieceJointePrestation = pieceJointePrestationService.archiver(pieceJointePrestationConverter.toItem(pieceJointePrestationVo));
                return pieceJointePrestationConverter.toVo(pieceJointePrestation);
                }

            @PutMapping("/desarchiver/")
            public PieceJointePrestationVo desarchiver(@RequestBody PieceJointePrestationVo pieceJointePrestationVo){
                PieceJointePrestation pieceJointePrestation = pieceJointePrestationService.desarchiver(pieceJointePrestationConverter.toItem(pieceJointePrestationVo));
                return pieceJointePrestationConverter.toVo(pieceJointePrestation);}
            }

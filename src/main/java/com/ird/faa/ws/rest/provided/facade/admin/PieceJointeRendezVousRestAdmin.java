package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.PieceJointeRendezVousAdminService;

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
import com.ird.faa.bean.PieceJointeRendezVous;
import com.ird.faa.ws.rest.provided.converter.PieceJointeRendezVousConverter;
import com.ird.faa.ws.rest.provided.vo.PieceJointeRendezVousVo;

@Api("Manages pieceJointeRendezVous services")
@RestController
@RequestMapping("api/admin/pieceJointeRendezVous")
public class PieceJointeRendezVousRestAdmin {

@Autowired
private PieceJointeRendezVousAdminService pieceJointeRendezVousService;

@Autowired
private PieceJointeRendezVousConverter pieceJointeRendezVousConverter;


            @ApiOperation("Updates the specified  pieceJointeRendezVous")
            @PutMapping("/")
            public  PieceJointeRendezVousVo update(@RequestBody  PieceJointeRendezVousVo  pieceJointeRendezVousVo){
            PieceJointeRendezVous pieceJointeRendezVous = pieceJointeRendezVousConverter.toItem(pieceJointeRendezVousVo);
            pieceJointeRendezVous = pieceJointeRendezVousService.update(pieceJointeRendezVous);
            return pieceJointeRendezVousConverter.toVo(pieceJointeRendezVous);
            }

    @ApiOperation("Finds a list of all pieceJointeRendezVouss")
    @GetMapping("/")
    public List<PieceJointeRendezVousVo> findAll(){
        return pieceJointeRendezVousConverter.toVo(pieceJointeRendezVousService.findAll());
    }

    @ApiOperation("Finds a pieceJointeRendezVous with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public PieceJointeRendezVousVo findByIdWithAssociatedList(@PathVariable Long id){
    return pieceJointeRendezVousConverter.toVo(pieceJointeRendezVousService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search pieceJointeRendezVous by a specific criteria")
    @PostMapping("/search")
    public List<PieceJointeRendezVousVo> findByCriteria(@RequestBody PieceJointeRendezVousVo pieceJointeRendezVousVo){
        return pieceJointeRendezVousConverter.toVo(pieceJointeRendezVousService.findByCriteria(pieceJointeRendezVousVo));
        }

            @ApiOperation("Finds a pieceJointeRendezVous by id")
            @GetMapping("/id/{id}")
            public PieceJointeRendezVousVo findById(@PathVariable Long id){
            return pieceJointeRendezVousConverter.toVo(pieceJointeRendezVousService.findById(id));
            }

            @ApiOperation("Saves the specified  pieceJointeRendezVous")
            @PostMapping("/")
            public PieceJointeRendezVousVo save(@RequestBody PieceJointeRendezVousVo pieceJointeRendezVousVo){
            PieceJointeRendezVous pieceJointeRendezVous = pieceJointeRendezVousConverter.toItem(pieceJointeRendezVousVo);
            pieceJointeRendezVous = pieceJointeRendezVousService.save(pieceJointeRendezVous);
            return pieceJointeRendezVousConverter.toVo(pieceJointeRendezVous);
            }

            @ApiOperation("Delete the specified pieceJointeRendezVous")
            @DeleteMapping("/")
            public int delete(@RequestBody PieceJointeRendezVousVo pieceJointeRendezVousVo){
            PieceJointeRendezVous pieceJointeRendezVous = pieceJointeRendezVousConverter.toItem(pieceJointeRendezVousVo);
            return pieceJointeRendezVousService.delete(pieceJointeRendezVous);
            }

            @ApiOperation("Deletes a pieceJointeRendezVous by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return pieceJointeRendezVousService.deleteById(id);
            }
        @ApiOperation("find by rendezVous reference")
        @GetMapping("/rendezVous/reference/{reference}")
        public List<PieceJointeRendezVous> findByRendezVousReference(@PathVariable String reference){
        return pieceJointeRendezVousService.findByRendezVousReference(reference);
        }

        @ApiOperation("delete by rendezVous reference")
        @DeleteMapping("/rendezVous/reference/{reference}")
        public int deleteByRendezVousReference(@PathVariable String reference){
        return pieceJointeRendezVousService.deleteByRendezVousReference(reference);
        }

        @ApiOperation("find by rendezVous id")
        @GetMapping("/rendezVous/id/{id}")
        public List<PieceJointeRendezVous> findByRendezVousId(@PathVariable Long id){
        return pieceJointeRendezVousService.findByRendezVousId(id);
        }

        @ApiOperation("delete by rendezVous id")
        @DeleteMapping("/rendezVous/id/{id}")
        public int deleteByRendezVousId(@PathVariable Long id){
        return pieceJointeRendezVousService.deleteByRendezVousId(id);
        }



            @PutMapping("/archiver/")
            public PieceJointeRendezVousVo archiver(@RequestBody PieceJointeRendezVousVo pieceJointeRendezVousVo){
                PieceJointeRendezVous pieceJointeRendezVous = pieceJointeRendezVousService.archiver(pieceJointeRendezVousConverter.toItem(pieceJointeRendezVousVo));
                return pieceJointeRendezVousConverter.toVo(pieceJointeRendezVous);
                }

            @PutMapping("/desarchiver/")
            public PieceJointeRendezVousVo desarchiver(@RequestBody PieceJointeRendezVousVo pieceJointeRendezVousVo){
                PieceJointeRendezVous pieceJointeRendezVous = pieceJointeRendezVousService.desarchiver(pieceJointeRendezVousConverter.toItem(pieceJointeRendezVousVo));
                return pieceJointeRendezVousConverter.toVo(pieceJointeRendezVous);}
            }

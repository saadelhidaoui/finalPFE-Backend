package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.PieceJointeReclamationAdminService;

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
import com.ird.faa.bean.PieceJointeReclamation;
import com.ird.faa.ws.rest.provided.converter.PieceJointeReclamationConverter;
import com.ird.faa.ws.rest.provided.vo.PieceJointeReclamationVo;

@Api("Manages pieceJointeReclamation services")
@RestController
@RequestMapping("api/admin/pieceJointeReclamation")
public class PieceJointeReclamationRestAdmin {

@Autowired
private PieceJointeReclamationAdminService pieceJointeReclamationService;

@Autowired
private PieceJointeReclamationConverter pieceJointeReclamationConverter;


            @ApiOperation("Updates the specified  pieceJointeReclamation")
            @PutMapping("/")
            public  PieceJointeReclamationVo update(@RequestBody  PieceJointeReclamationVo  pieceJointeReclamationVo){
            PieceJointeReclamation pieceJointeReclamation = pieceJointeReclamationConverter.toItem(pieceJointeReclamationVo);
            pieceJointeReclamation = pieceJointeReclamationService.update(pieceJointeReclamation);
            return pieceJointeReclamationConverter.toVo(pieceJointeReclamation);
            }

    @ApiOperation("Finds a list of all pieceJointeReclamations")
    @GetMapping("/")
    public List<PieceJointeReclamationVo> findAll(){
        return pieceJointeReclamationConverter.toVo(pieceJointeReclamationService.findAll());
    }

    @ApiOperation("Finds a pieceJointeReclamation with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public PieceJointeReclamationVo findByIdWithAssociatedList(@PathVariable Long id){
    return pieceJointeReclamationConverter.toVo(pieceJointeReclamationService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search pieceJointeReclamation by a specific criteria")
    @PostMapping("/search")
    public List<PieceJointeReclamationVo> findByCriteria(@RequestBody PieceJointeReclamationVo pieceJointeReclamationVo){
        return pieceJointeReclamationConverter.toVo(pieceJointeReclamationService.findByCriteria(pieceJointeReclamationVo));
        }

            @ApiOperation("Finds a pieceJointeReclamation by id")
            @GetMapping("/id/{id}")
            public PieceJointeReclamationVo findById(@PathVariable Long id){
            return pieceJointeReclamationConverter.toVo(pieceJointeReclamationService.findById(id));
            }

            @ApiOperation("Saves the specified  pieceJointeReclamation")
            @PostMapping("/")
            public PieceJointeReclamationVo save(@RequestBody PieceJointeReclamationVo pieceJointeReclamationVo){
            PieceJointeReclamation pieceJointeReclamation = pieceJointeReclamationConverter.toItem(pieceJointeReclamationVo);
            pieceJointeReclamation = pieceJointeReclamationService.save(pieceJointeReclamation);
            return pieceJointeReclamationConverter.toVo(pieceJointeReclamation);
            }

            @ApiOperation("Delete the specified pieceJointeReclamation")
            @DeleteMapping("/")
            public int delete(@RequestBody PieceJointeReclamationVo pieceJointeReclamationVo){
            PieceJointeReclamation pieceJointeReclamation = pieceJointeReclamationConverter.toItem(pieceJointeReclamationVo);
            return pieceJointeReclamationService.delete(pieceJointeReclamation);
            }

            @ApiOperation("Deletes a pieceJointeReclamation by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return pieceJointeReclamationService.deleteById(id);
            }
        @ApiOperation("find by reclamation reference")
        @GetMapping("/reclamation/reference/{reference}")
        public List<PieceJointeReclamation> findByReclamationReference(@PathVariable String reference){
        return pieceJointeReclamationService.findByReclamationReference(reference);
        }

        @ApiOperation("delete by reclamation reference")
        @DeleteMapping("/reclamation/reference/{reference}")
        public int deleteByReclamationReference(@PathVariable String reference){
        return pieceJointeReclamationService.deleteByReclamationReference(reference);
        }

        @ApiOperation("find by reclamation id")
        @GetMapping("/reclamation/id/{id}")
        public List<PieceJointeReclamation> findByReclamationId(@PathVariable Long id){
        return pieceJointeReclamationService.findByReclamationId(id);
        }

        @ApiOperation("delete by reclamation id")
        @DeleteMapping("/reclamation/id/{id}")
        public int deleteByReclamationId(@PathVariable Long id){
        return pieceJointeReclamationService.deleteByReclamationId(id);
        }



            @PutMapping("/archiver/")
            public PieceJointeReclamationVo archiver(@RequestBody PieceJointeReclamationVo pieceJointeReclamationVo){
                PieceJointeReclamation pieceJointeReclamation = pieceJointeReclamationService.archiver(pieceJointeReclamationConverter.toItem(pieceJointeReclamationVo));
                return pieceJointeReclamationConverter.toVo(pieceJointeReclamation);
                }

            @PutMapping("/desarchiver/")
            public PieceJointeReclamationVo desarchiver(@RequestBody PieceJointeReclamationVo pieceJointeReclamationVo){
                PieceJointeReclamation pieceJointeReclamation = pieceJointeReclamationService.desarchiver(pieceJointeReclamationConverter.toItem(pieceJointeReclamationVo));
                return pieceJointeReclamationConverter.toVo(pieceJointeReclamation);}
            }

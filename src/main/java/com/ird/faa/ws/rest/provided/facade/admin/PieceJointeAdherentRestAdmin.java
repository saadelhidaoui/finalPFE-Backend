package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.PieceJointeAdherentAdminService;

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
import com.ird.faa.bean.PieceJointeAdherent;
import com.ird.faa.ws.rest.provided.converter.PieceJointeAdherentConverter;
import com.ird.faa.ws.rest.provided.vo.PieceJointeAdherentVo;

@Api("Manages pieceJointeAdherent services")
@RestController
@RequestMapping("api/admin/pieceJointeAdherent")
public class PieceJointeAdherentRestAdmin {

@Autowired
private PieceJointeAdherentAdminService pieceJointeAdherentService;

@Autowired
private PieceJointeAdherentConverter pieceJointeAdherentConverter;


            @ApiOperation("Updates the specified  pieceJointeAdherent")
            @PutMapping("/")
            public  PieceJointeAdherentVo update(@RequestBody  PieceJointeAdherentVo  pieceJointeAdherentVo){
            PieceJointeAdherent pieceJointeAdherent = pieceJointeAdherentConverter.toItem(pieceJointeAdherentVo);
            pieceJointeAdherent = pieceJointeAdherentService.update(pieceJointeAdherent);
            return pieceJointeAdherentConverter.toVo(pieceJointeAdherent);
            }

    @ApiOperation("Finds a list of all pieceJointeAdherents")
    @GetMapping("/")
    public List<PieceJointeAdherentVo> findAll(){
        return pieceJointeAdherentConverter.toVo(pieceJointeAdherentService.findAll());
    }

    @ApiOperation("Finds a pieceJointeAdherent with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public PieceJointeAdherentVo findByIdWithAssociatedList(@PathVariable Long id){
    return pieceJointeAdherentConverter.toVo(pieceJointeAdherentService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search pieceJointeAdherent by a specific criteria")
    @PostMapping("/search")
    public List<PieceJointeAdherentVo> findByCriteria(@RequestBody PieceJointeAdherentVo pieceJointeAdherentVo){
        return pieceJointeAdherentConverter.toVo(pieceJointeAdherentService.findByCriteria(pieceJointeAdherentVo));
        }

            @ApiOperation("Finds a pieceJointeAdherent by id")
            @GetMapping("/id/{id}")
            public PieceJointeAdherentVo findById(@PathVariable Long id){
            return pieceJointeAdherentConverter.toVo(pieceJointeAdherentService.findById(id));
            }

            @ApiOperation("Saves the specified  pieceJointeAdherent")
            @PostMapping("/")
            public PieceJointeAdherentVo save(@RequestBody PieceJointeAdherentVo pieceJointeAdherentVo){
            PieceJointeAdherent pieceJointeAdherent = pieceJointeAdherentConverter.toItem(pieceJointeAdherentVo);
            pieceJointeAdherent = pieceJointeAdherentService.save(pieceJointeAdherent);
            return pieceJointeAdherentConverter.toVo(pieceJointeAdherent);
            }

            @ApiOperation("Delete the specified pieceJointeAdherent")
            @DeleteMapping("/")
            public int delete(@RequestBody PieceJointeAdherentVo pieceJointeAdherentVo){
            PieceJointeAdherent pieceJointeAdherent = pieceJointeAdherentConverter.toItem(pieceJointeAdherentVo);
            return pieceJointeAdherentService.delete(pieceJointeAdherent);
            }

            @ApiOperation("Deletes a pieceJointeAdherent by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return pieceJointeAdherentService.deleteById(id);
            }
        @ApiOperation("find by adherent numeroMatricule")
        @GetMapping("/adherent/numeroMatricule/{numeroMatricule}")
        public List<PieceJointeAdherent> findByAdherentNumeroMatricule(@PathVariable String numeroMatricule){
        return pieceJointeAdherentService.findByAdherentNumeroMatricule(numeroMatricule);
        }

        @ApiOperation("delete by adherent numeroMatricule")
        @DeleteMapping("/adherent/numeroMatricule/{numeroMatricule}")
        public int deleteByAdherentNumeroMatricule(@PathVariable String numeroMatricule){
        return pieceJointeAdherentService.deleteByAdherentNumeroMatricule(numeroMatricule);
        }

        @ApiOperation("find by adherent id")
        @GetMapping("/adherent/id/{id}")
        public List<PieceJointeAdherent> findByAdherentId(@PathVariable Long id){
        return pieceJointeAdherentService.findByAdherentId(id);
        }

        @ApiOperation("delete by adherent id")
        @DeleteMapping("/adherent/id/{id}")
        public int deleteByAdherentId(@PathVariable Long id){
        return pieceJointeAdherentService.deleteByAdherentId(id);
        }



            @PutMapping("/archiver/")
            public PieceJointeAdherentVo archiver(@RequestBody PieceJointeAdherentVo pieceJointeAdherentVo){
                PieceJointeAdherent pieceJointeAdherent = pieceJointeAdherentService.archiver(pieceJointeAdherentConverter.toItem(pieceJointeAdherentVo));
                return pieceJointeAdherentConverter.toVo(pieceJointeAdherent);
                }

            @PutMapping("/desarchiver/")
            public PieceJointeAdherentVo desarchiver(@RequestBody PieceJointeAdherentVo pieceJointeAdherentVo){
                PieceJointeAdherent pieceJointeAdherent = pieceJointeAdherentService.desarchiver(pieceJointeAdherentConverter.toItem(pieceJointeAdherentVo));
                return pieceJointeAdherentConverter.toVo(pieceJointeAdherent);}
            }

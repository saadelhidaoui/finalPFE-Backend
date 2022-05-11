package  com.ird.faa.ws.rest.provided.facade.adherent;

import com.ird.faa.service.adherent.facade.PieceJointeProjetAdherentService;

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
import com.ird.faa.bean.PieceJointeProjet;
import com.ird.faa.ws.rest.provided.converter.PieceJointeProjetConverter;
import com.ird.faa.ws.rest.provided.vo.PieceJointeProjetVo;

@Api("Manages pieceJointeProjet services")
@RestController
@RequestMapping("api/adherent/pieceJointeProjet")
public class PieceJointeProjetRestAdherent {

@Autowired
private PieceJointeProjetAdherentService pieceJointeProjetService;

@Autowired
private PieceJointeProjetConverter pieceJointeProjetConverter;


            @ApiOperation("Updates the specified  pieceJointeProjet")
            @PutMapping("/")
            public  PieceJointeProjetVo update(@RequestBody  PieceJointeProjetVo  pieceJointeProjetVo){
            PieceJointeProjet pieceJointeProjet = pieceJointeProjetConverter.toItem(pieceJointeProjetVo);
            pieceJointeProjet = pieceJointeProjetService.update(pieceJointeProjet);
            return pieceJointeProjetConverter.toVo(pieceJointeProjet);
            }

    @ApiOperation("Finds a list of all pieceJointeProjets")
    @GetMapping("/")
    public List<PieceJointeProjetVo> findAll(){
        return pieceJointeProjetConverter.toVo(pieceJointeProjetService.findAll());
    }

    @ApiOperation("Finds a pieceJointeProjet with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public PieceJointeProjetVo findByIdWithAssociatedList(@PathVariable Long id){
    return pieceJointeProjetConverter.toVo(pieceJointeProjetService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search pieceJointeProjet by a specific criteria")
    @PostMapping("/search")
    public List<PieceJointeProjetVo> findByCriteria(@RequestBody PieceJointeProjetVo pieceJointeProjetVo){
        return pieceJointeProjetConverter.toVo(pieceJointeProjetService.findByCriteria(pieceJointeProjetVo));
        }

            @ApiOperation("Finds a pieceJointeProjet by id")
            @GetMapping("/id/{id}")
            public PieceJointeProjetVo findById(@PathVariable Long id){
            return pieceJointeProjetConverter.toVo(pieceJointeProjetService.findById(id));
            }

            @ApiOperation("Saves the specified  pieceJointeProjet")
            @PostMapping("/")
            public PieceJointeProjetVo save(@RequestBody PieceJointeProjetVo pieceJointeProjetVo){
            PieceJointeProjet pieceJointeProjet = pieceJointeProjetConverter.toItem(pieceJointeProjetVo);
            pieceJointeProjet = pieceJointeProjetService.save(pieceJointeProjet);
            return pieceJointeProjetConverter.toVo(pieceJointeProjet);
            }

            @ApiOperation("Delete the specified pieceJointeProjet")
            @DeleteMapping("/")
            public int delete(@RequestBody PieceJointeProjetVo pieceJointeProjetVo){
            PieceJointeProjet pieceJointeProjet = pieceJointeProjetConverter.toItem(pieceJointeProjetVo);
            return pieceJointeProjetService.delete(pieceJointeProjet);
            }

            @ApiOperation("Deletes a pieceJointeProjet by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return pieceJointeProjetService.deleteById(id);
            }
        @ApiOperation("find by projet reference")
        @GetMapping("/projet/reference/{reference}")
        public List<PieceJointeProjet> findByProjetReference(@PathVariable String reference){
        return pieceJointeProjetService.findByProjetReference(reference);
        }

        @ApiOperation("delete by projet reference")
        @DeleteMapping("/projet/reference/{reference}")
        public int deleteByProjetReference(@PathVariable String reference){
        return pieceJointeProjetService.deleteByProjetReference(reference);
        }

        @ApiOperation("find by projet id")
        @GetMapping("/projet/id/{id}")
        public List<PieceJointeProjet> findByProjetId(@PathVariable Long id){
        return pieceJointeProjetService.findByProjetId(id);
        }

        @ApiOperation("delete by projet id")
        @DeleteMapping("/projet/id/{id}")
        public int deleteByProjetId(@PathVariable Long id){
        return pieceJointeProjetService.deleteByProjetId(id);
        }



            @PutMapping("/archiver/")
            public PieceJointeProjetVo archiver(@RequestBody PieceJointeProjetVo pieceJointeProjetVo){
                PieceJointeProjet pieceJointeProjet = pieceJointeProjetService.archiver(pieceJointeProjetConverter.toItem(pieceJointeProjetVo));
                return pieceJointeProjetConverter.toVo(pieceJointeProjet);
                }

            @PutMapping("/desarchiver/")
            public PieceJointeProjetVo desarchiver(@RequestBody PieceJointeProjetVo pieceJointeProjetVo){
                PieceJointeProjet pieceJointeProjet = pieceJointeProjetService.desarchiver(pieceJointeProjetConverter.toItem(pieceJointeProjetVo));
                return pieceJointeProjetConverter.toVo(pieceJointeProjet);}
            }

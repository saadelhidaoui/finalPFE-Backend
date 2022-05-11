package  com.ird.faa.ws.rest.provided.facade.moderateur;

import com.ird.faa.service.moderateur.facade.PieceJointeEstivageModerateurService;

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
import com.ird.faa.bean.PieceJointeEstivage;
import com.ird.faa.ws.rest.provided.converter.PieceJointeEstivageConverter;
import com.ird.faa.ws.rest.provided.vo.PieceJointeEstivageVo;

@Api("Manages pieceJointeEstivage services")
@RestController
@RequestMapping("api/moderateur/pieceJointeEstivage")
public class PieceJointeEstivageRestModerateur {

@Autowired
private PieceJointeEstivageModerateurService pieceJointeEstivageService;

@Autowired
private PieceJointeEstivageConverter pieceJointeEstivageConverter;


            @ApiOperation("Updates the specified  pieceJointeEstivage")
            @PutMapping("/")
            public  PieceJointeEstivageVo update(@RequestBody  PieceJointeEstivageVo  pieceJointeEstivageVo){
            PieceJointeEstivage pieceJointeEstivage = pieceJointeEstivageConverter.toItem(pieceJointeEstivageVo);
            pieceJointeEstivage = pieceJointeEstivageService.update(pieceJointeEstivage);
            return pieceJointeEstivageConverter.toVo(pieceJointeEstivage);
            }

    @ApiOperation("Finds a list of all pieceJointeEstivages")
    @GetMapping("/")
    public List<PieceJointeEstivageVo> findAll(){
        return pieceJointeEstivageConverter.toVo(pieceJointeEstivageService.findAll());
    }

    @ApiOperation("Finds a pieceJointeEstivage with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public PieceJointeEstivageVo findByIdWithAssociatedList(@PathVariable Long id){
    return pieceJointeEstivageConverter.toVo(pieceJointeEstivageService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search pieceJointeEstivage by a specific criteria")
    @PostMapping("/search")
    public List<PieceJointeEstivageVo> findByCriteria(@RequestBody PieceJointeEstivageVo pieceJointeEstivageVo){
        return pieceJointeEstivageConverter.toVo(pieceJointeEstivageService.findByCriteria(pieceJointeEstivageVo));
        }

            @ApiOperation("Finds a pieceJointeEstivage by id")
            @GetMapping("/id/{id}")
            public PieceJointeEstivageVo findById(@PathVariable Long id){
            return pieceJointeEstivageConverter.toVo(pieceJointeEstivageService.findById(id));
            }

            @ApiOperation("Saves the specified  pieceJointeEstivage")
            @PostMapping("/")
            public PieceJointeEstivageVo save(@RequestBody PieceJointeEstivageVo pieceJointeEstivageVo){
            PieceJointeEstivage pieceJointeEstivage = pieceJointeEstivageConverter.toItem(pieceJointeEstivageVo);
            pieceJointeEstivage = pieceJointeEstivageService.save(pieceJointeEstivage);
            return pieceJointeEstivageConverter.toVo(pieceJointeEstivage);
            }

            @ApiOperation("Delete the specified pieceJointeEstivage")
            @DeleteMapping("/")
            public int delete(@RequestBody PieceJointeEstivageVo pieceJointeEstivageVo){
            PieceJointeEstivage pieceJointeEstivage = pieceJointeEstivageConverter.toItem(pieceJointeEstivageVo);
            return pieceJointeEstivageService.delete(pieceJointeEstivage);
            }

            @ApiOperation("Deletes a pieceJointeEstivage by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return pieceJointeEstivageService.deleteById(id);
            }
        @ApiOperation("find by estivage reference")
        @GetMapping("/estivage/reference/{reference}")
        public List<PieceJointeEstivage> findByEstivageReference(@PathVariable String reference){
        return pieceJointeEstivageService.findByEstivageReference(reference);
        }

        @ApiOperation("delete by estivage reference")
        @DeleteMapping("/estivage/reference/{reference}")
        public int deleteByEstivageReference(@PathVariable String reference){
        return pieceJointeEstivageService.deleteByEstivageReference(reference);
        }

        @ApiOperation("find by estivage id")
        @GetMapping("/estivage/id/{id}")
        public List<PieceJointeEstivage> findByEstivageId(@PathVariable Long id){
        return pieceJointeEstivageService.findByEstivageId(id);
        }

        @ApiOperation("delete by estivage id")
        @DeleteMapping("/estivage/id/{id}")
        public int deleteByEstivageId(@PathVariable Long id){
        return pieceJointeEstivageService.deleteByEstivageId(id);
        }



            @PutMapping("/archiver/")
            public PieceJointeEstivageVo archiver(@RequestBody PieceJointeEstivageVo pieceJointeEstivageVo){
                PieceJointeEstivage pieceJointeEstivage = pieceJointeEstivageService.archiver(pieceJointeEstivageConverter.toItem(pieceJointeEstivageVo));
                return pieceJointeEstivageConverter.toVo(pieceJointeEstivage);
                }

            @PutMapping("/desarchiver/")
            public PieceJointeEstivageVo desarchiver(@RequestBody PieceJointeEstivageVo pieceJointeEstivageVo){
                PieceJointeEstivage pieceJointeEstivage = pieceJointeEstivageService.desarchiver(pieceJointeEstivageConverter.toItem(pieceJointeEstivageVo));
                return pieceJointeEstivageConverter.toVo(pieceJointeEstivage);}
            }

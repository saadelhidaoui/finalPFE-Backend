package  com.ird.faa.ws.rest.provided.facade.moderateur;

import com.ird.faa.service.moderateur.facade.PieceJointeMissionModerateurService;

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
import com.ird.faa.bean.PieceJointeMission;
import com.ird.faa.ws.rest.provided.converter.PieceJointeMissionConverter;
import com.ird.faa.ws.rest.provided.vo.PieceJointeMissionVo;

@Api("Manages pieceJointeMission services")
@RestController
@RequestMapping("api/moderateur/pieceJointeMission")
public class PieceJointeMissionRestModerateur {

@Autowired
private PieceJointeMissionModerateurService pieceJointeMissionService;

@Autowired
private PieceJointeMissionConverter pieceJointeMissionConverter;


            @ApiOperation("Updates the specified  pieceJointeMission")
            @PutMapping("/")
            public  PieceJointeMissionVo update(@RequestBody  PieceJointeMissionVo  pieceJointeMissionVo){
            PieceJointeMission pieceJointeMission = pieceJointeMissionConverter.toItem(pieceJointeMissionVo);
            pieceJointeMission = pieceJointeMissionService.update(pieceJointeMission);
            return pieceJointeMissionConverter.toVo(pieceJointeMission);
            }

    @ApiOperation("Finds a list of all pieceJointeMissions")
    @GetMapping("/")
    public List<PieceJointeMissionVo> findAll(){
        return pieceJointeMissionConverter.toVo(pieceJointeMissionService.findAll());
    }

    @ApiOperation("Finds a pieceJointeMission with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public PieceJointeMissionVo findByIdWithAssociatedList(@PathVariable Long id){
    return pieceJointeMissionConverter.toVo(pieceJointeMissionService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search pieceJointeMission by a specific criteria")
    @PostMapping("/search")
    public List<PieceJointeMissionVo> findByCriteria(@RequestBody PieceJointeMissionVo pieceJointeMissionVo){
        return pieceJointeMissionConverter.toVo(pieceJointeMissionService.findByCriteria(pieceJointeMissionVo));
        }

            @ApiOperation("Finds a pieceJointeMission by id")
            @GetMapping("/id/{id}")
            public PieceJointeMissionVo findById(@PathVariable Long id){
            return pieceJointeMissionConverter.toVo(pieceJointeMissionService.findById(id));
            }

            @ApiOperation("Saves the specified  pieceJointeMission")
            @PostMapping("/")
            public PieceJointeMissionVo save(@RequestBody PieceJointeMissionVo pieceJointeMissionVo){
            PieceJointeMission pieceJointeMission = pieceJointeMissionConverter.toItem(pieceJointeMissionVo);
            pieceJointeMission = pieceJointeMissionService.save(pieceJointeMission);
            return pieceJointeMissionConverter.toVo(pieceJointeMission);
            }

            @ApiOperation("Delete the specified pieceJointeMission")
            @DeleteMapping("/")
            public int delete(@RequestBody PieceJointeMissionVo pieceJointeMissionVo){
            PieceJointeMission pieceJointeMission = pieceJointeMissionConverter.toItem(pieceJointeMissionVo);
            return pieceJointeMissionService.delete(pieceJointeMission);
            }

            @ApiOperation("Deletes a pieceJointeMission by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return pieceJointeMissionService.deleteById(id);
            }
        @ApiOperation("find by mission reference")
        @GetMapping("/mission/reference/{reference}")
        public List<PieceJointeMission> findByMissionReference(@PathVariable String reference){
        return pieceJointeMissionService.findByMissionReference(reference);
        }

        @ApiOperation("delete by mission reference")
        @DeleteMapping("/mission/reference/{reference}")
        public int deleteByMissionReference(@PathVariable String reference){
        return pieceJointeMissionService.deleteByMissionReference(reference);
        }

        @ApiOperation("find by mission id")
        @GetMapping("/mission/id/{id}")
        public List<PieceJointeMission> findByMissionId(@PathVariable Long id){
        return pieceJointeMissionService.findByMissionId(id);
        }

        @ApiOperation("delete by mission id")
        @DeleteMapping("/mission/id/{id}")
        public int deleteByMissionId(@PathVariable Long id){
        return pieceJointeMissionService.deleteByMissionId(id);
        }



            @PutMapping("/archiver/")
            public PieceJointeMissionVo archiver(@RequestBody PieceJointeMissionVo pieceJointeMissionVo){
                PieceJointeMission pieceJointeMission = pieceJointeMissionService.archiver(pieceJointeMissionConverter.toItem(pieceJointeMissionVo));
                return pieceJointeMissionConverter.toVo(pieceJointeMission);
                }

            @PutMapping("/desarchiver/")
            public PieceJointeMissionVo desarchiver(@RequestBody PieceJointeMissionVo pieceJointeMissionVo){
                PieceJointeMission pieceJointeMission = pieceJointeMissionService.desarchiver(pieceJointeMissionConverter.toItem(pieceJointeMissionVo));
                return pieceJointeMissionConverter.toVo(pieceJointeMission);}
            }

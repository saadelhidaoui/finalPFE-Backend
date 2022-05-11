package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.PieceJointeProduitChercheurService;

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
import com.ird.faa.bean.PieceJointeProduit;
import com.ird.faa.ws.rest.provided.converter.PieceJointeProduitConverter;
import com.ird.faa.ws.rest.provided.vo.PieceJointeProduitVo;

@Api("Manages pieceJointeProduit services")
@RestController
@RequestMapping("api/chercheur/pieceJointeProduit")
public class PieceJointeProduitRestChercheur {

@Autowired
private PieceJointeProduitChercheurService pieceJointeProduitService;

@Autowired
private PieceJointeProduitConverter pieceJointeProduitConverter;


            @ApiOperation("Updates the specified  pieceJointeProduit")
            @PutMapping("/")
            public  PieceJointeProduitVo update(@RequestBody  PieceJointeProduitVo  pieceJointeProduitVo){
            PieceJointeProduit pieceJointeProduit = pieceJointeProduitConverter.toItem(pieceJointeProduitVo);
            pieceJointeProduit = pieceJointeProduitService.update(pieceJointeProduit);
            return pieceJointeProduitConverter.toVo(pieceJointeProduit);
            }

    @ApiOperation("Finds a list of all pieceJointeProduits")
    @GetMapping("/")
    public List<PieceJointeProduitVo> findAll(){
        return pieceJointeProduitConverter.toVo(pieceJointeProduitService.findAll());
    }

    @ApiOperation("Finds a pieceJointeProduit with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public PieceJointeProduitVo findByIdWithAssociatedList(@PathVariable Long id){
    return pieceJointeProduitConverter.toVo(pieceJointeProduitService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search pieceJointeProduit by a specific criteria")
    @PostMapping("/search")
    public List<PieceJointeProduitVo> findByCriteria(@RequestBody PieceJointeProduitVo pieceJointeProduitVo){
        return pieceJointeProduitConverter.toVo(pieceJointeProduitService.findByCriteria(pieceJointeProduitVo));
        }

            @ApiOperation("Finds a pieceJointeProduit by id")
            @GetMapping("/id/{id}")
            public PieceJointeProduitVo findById(@PathVariable Long id){
            return pieceJointeProduitConverter.toVo(pieceJointeProduitService.findById(id));
            }

            @ApiOperation("Saves the specified  pieceJointeProduit")
            @PostMapping("/")
            public PieceJointeProduitVo save(@RequestBody PieceJointeProduitVo pieceJointeProduitVo){
            PieceJointeProduit pieceJointeProduit = pieceJointeProduitConverter.toItem(pieceJointeProduitVo);
            pieceJointeProduit = pieceJointeProduitService.save(pieceJointeProduit);
            return pieceJointeProduitConverter.toVo(pieceJointeProduit);
            }

            @ApiOperation("Delete the specified pieceJointeProduit")
            @DeleteMapping("/")
            public int delete(@RequestBody PieceJointeProduitVo pieceJointeProduitVo){
            PieceJointeProduit pieceJointeProduit = pieceJointeProduitConverter.toItem(pieceJointeProduitVo);
            return pieceJointeProduitService.delete(pieceJointeProduit);
            }

            @ApiOperation("Deletes a pieceJointeProduit by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return pieceJointeProduitService.deleteById(id);
            }
        @ApiOperation("find by produit reference")
        @GetMapping("/produit/reference/{reference}")
        public List<PieceJointeProduit> findByProduitReference(@PathVariable String reference){
        return pieceJointeProduitService.findByProduitReference(reference);
        }

        @ApiOperation("delete by produit reference")
        @DeleteMapping("/produit/reference/{reference}")
        public int deleteByProduitReference(@PathVariable String reference){
        return pieceJointeProduitService.deleteByProduitReference(reference);
        }

        @ApiOperation("find by produit id")
        @GetMapping("/produit/id/{id}")
        public List<PieceJointeProduit> findByProduitId(@PathVariable Long id){
        return pieceJointeProduitService.findByProduitId(id);
        }

        @ApiOperation("delete by produit id")
        @DeleteMapping("/produit/id/{id}")
        public int deleteByProduitId(@PathVariable Long id){
        return pieceJointeProduitService.deleteByProduitId(id);
        }



            }

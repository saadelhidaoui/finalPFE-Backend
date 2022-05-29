package com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.bean.PieceJointeProjet;
import com.ird.faa.service.admin.facade.PieceJointeProjetAdminService;
import com.ird.faa.ws.rest.provided.converter.PieceJointeProjetConverter;
import com.ird.faa.ws.rest.provided.vo.PieceJointeProjetVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Api("Manages pieceJointeProjet services")
@RestController
@RequestMapping("api/admin/pieceJointeProjet")
public class PieceJointeProjetRestAdmin {

    @Autowired
    private PieceJointeProjetAdminService pieceJointeProjetService;

    @Autowired
    private PieceJointeProjetConverter pieceJointeProjetConverter;


    @ApiOperation("Updates the specified  pieceJointeProjet")
    @PutMapping("/")
    public PieceJointeProjetVo update(@RequestBody PieceJointeProjetVo pieceJointeProjetVo) {
        PieceJointeProjet pieceJointeProjet = pieceJointeProjetConverter.toItem(pieceJointeProjetVo);
        pieceJointeProjet = pieceJointeProjetService.update(pieceJointeProjet);
        return pieceJointeProjetConverter.toVo(pieceJointeProjet);
    }

    @ApiOperation("Finds a list of all pieceJointeProjets")
    @GetMapping("/")
    public List<PieceJointeProjetVo> findAll() {
        return pieceJointeProjetConverter.toVo(pieceJointeProjetService.findAll());
    }

    @ApiOperation("Finds a pieceJointeProjet with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public PieceJointeProjetVo findByIdWithAssociatedList(@PathVariable Long id) {
        return pieceJointeProjetConverter.toVo(pieceJointeProjetService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search pieceJointeProjet by a specific criteria")
    @PostMapping("/search")
    public List<PieceJointeProjetVo> findByCriteria(@RequestBody PieceJointeProjetVo pieceJointeProjetVo) {
        return pieceJointeProjetConverter.toVo(pieceJointeProjetService.findByCriteria(pieceJointeProjetVo));
    }

    @ApiOperation("Finds a pieceJointeProjet by id")
    @GetMapping("/id/{id}")
    public PieceJointeProjetVo findById(@PathVariable Long id) {
        return pieceJointeProjetConverter.toVo(pieceJointeProjetService.findById(id));
    }

    @ApiOperation("Saves the specified  pieceJointeProjet")
    @PostMapping("/")
    public PieceJointeProjetVo save(@RequestBody PieceJointeProjetVo pieceJointeProjetVo) {
        PieceJointeProjet pieceJointeProjet = pieceJointeProjetConverter.toItem(pieceJointeProjetVo);
        pieceJointeProjet = pieceJointeProjetService.save(pieceJointeProjet);
        return pieceJointeProjetConverter.toVo(pieceJointeProjet);
    }

    @ApiOperation("Delete the specified pieceJointeProjet")
    @DeleteMapping("/")
    public int delete(@RequestBody PieceJointeProjetVo pieceJointeProjetVo) {
        PieceJointeProjet pieceJointeProjet = pieceJointeProjetConverter.toItem(pieceJointeProjetVo);
        return pieceJointeProjetService.delete(pieceJointeProjet);
    }

    @ApiOperation("Deletes a pieceJointeProjet by id")
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return pieceJointeProjetService.deleteById(id);
    }

    @ApiOperation("find by projet reference")
    @GetMapping("/projet/reference/{reference}")
    public List<PieceJointeProjet> findByProjetReference(@PathVariable String reference) {
        return pieceJointeProjetService.findByProjetReference(reference);
    }

    @ApiOperation("delete by projet reference")
    @DeleteMapping("/projet/reference/{reference}")
    public int deleteByProjetReference(@PathVariable String reference) {
        return pieceJointeProjetService.deleteByProjetReference(reference);
    }

    @ApiOperation("find by projet id")
    @GetMapping("/projet/id/{id}")
    public List<PieceJointeProjet> findByProjetId(@PathVariable Long id) {
        return pieceJointeProjetService.findByProjetId(id);
    }

    @ApiOperation("delete by projet id")
    @DeleteMapping("/projet/id/{id}")
    public int deleteByProjetId(@PathVariable Long id) {
        return pieceJointeProjetService.deleteByProjetId(id);
    }


    @PutMapping("/archiver/")
    public PieceJointeProjetVo archiver(@RequestBody PieceJointeProjetVo pieceJointeProjetVo) {
        PieceJointeProjet pieceJointeProjet = pieceJointeProjetService.archiver(pieceJointeProjetConverter.toItem(pieceJointeProjetVo));
        return pieceJointeProjetConverter.toVo(pieceJointeProjet);
    }

    @PutMapping("/desarchiver/")
    public PieceJointeProjetVo desarchiver(@RequestBody PieceJointeProjetVo pieceJointeProjetVo) {
        PieceJointeProjet pieceJointeProjet = pieceJointeProjetService.desarchiver(pieceJointeProjetConverter.toItem(pieceJointeProjetVo));
        return pieceJointeProjetConverter.toVo(pieceJointeProjet);
    }

    @PutMapping("/upload/projet/{reference}")
    public void uploadFile(@RequestParam("file") MultipartFile file, @PathVariable String reference) throws IOException {
        pieceJointeProjetService.uploadFile(file,reference);

    }
    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
        PieceJointeProjet pieceJointeProjet = pieceJointeProjetService.getFile(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + pieceJointeProjet.getLibelle() + "\"")
                .body(pieceJointeProjet.getData());
    }
}

package com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.bean.PieceJointeConvention;
import com.ird.faa.bean.PieceJointeProjet;
import com.ird.faa.service.admin.facade.PieceJointeConventionAdminService;
import com.ird.faa.ws.rest.provided.converter.PieceJointeConventionConverter;
import com.ird.faa.ws.rest.provided.vo.PieceJointeConventionVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Api("Manages pieceJointeConvention services")
@RestController
@RequestMapping("api/admin/pieceJointeConvention")
public class PieceJointeConventionRestAdmin {

    @Autowired
    private PieceJointeConventionAdminService pieceJointeConventionService;

    @Autowired
    private PieceJointeConventionConverter pieceJointeConventionConverter;


    @ApiOperation("Updates the specified  pieceJointeConvention")
    @PutMapping("/")
    public PieceJointeConventionVo update(@RequestBody PieceJointeConventionVo pieceJointeConventionVo) {
        PieceJointeConvention pieceJointeConvention = pieceJointeConventionConverter.toItem(pieceJointeConventionVo);
        pieceJointeConvention = pieceJointeConventionService.update(pieceJointeConvention);
        return pieceJointeConventionConverter.toVo(pieceJointeConvention);
    }

    @ApiOperation("Finds a list of all pieceJointeConventions")
    @GetMapping("/")
    public List<PieceJointeConventionVo> findAll() {
        return pieceJointeConventionConverter.toVo(pieceJointeConventionService.findAll());
    }

    @ApiOperation("Finds a pieceJointeConvention with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public PieceJointeConventionVo findByIdWithAssociatedList(@PathVariable Long id) {
        return pieceJointeConventionConverter.toVo(pieceJointeConventionService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search pieceJointeConvention by a specific criteria")
    @PostMapping("/search")
    public List<PieceJointeConventionVo> findByCriteria(@RequestBody PieceJointeConventionVo pieceJointeConventionVo) {
        return pieceJointeConventionConverter.toVo(pieceJointeConventionService.findByCriteria(pieceJointeConventionVo));
    }

    @ApiOperation("Finds a pieceJointeConvention by id")
    @GetMapping("/id/{id}")
    public PieceJointeConventionVo findById(@PathVariable Long id) {
        return pieceJointeConventionConverter.toVo(pieceJointeConventionService.findById(id));
    }

    @ApiOperation("Saves the specified  pieceJointeConvention")
    @PostMapping("/")
    public PieceJointeConventionVo save(@RequestBody PieceJointeConventionVo pieceJointeConventionVo) {
        PieceJointeConvention pieceJointeConvention = pieceJointeConventionConverter.toItem(pieceJointeConventionVo);
        pieceJointeConvention = pieceJointeConventionService.save(pieceJointeConvention);
        return pieceJointeConventionConverter.toVo(pieceJointeConvention);
    }

    @ApiOperation("Delete the specified pieceJointeConvention")
    @DeleteMapping("/")
    public int delete(@RequestBody PieceJointeConventionVo pieceJointeConventionVo) {
        PieceJointeConvention pieceJointeConvention = pieceJointeConventionConverter.toItem(pieceJointeConventionVo);
        return pieceJointeConventionService.delete(pieceJointeConvention);
    }

    @ApiOperation("Deletes a pieceJointeConvention by id")
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return pieceJointeConventionService.deleteById(id);
    }

    @ApiOperation("find by convention reference")
    @GetMapping("/convention/reference/{reference}")
    public List<PieceJointeConvention> findByConventionReference(@PathVariable String reference) {
        return pieceJointeConventionService.findByConventionReference(reference);
    }

    @ApiOperation("delete by convention reference")
    @DeleteMapping("/convention/reference/{reference}")
    public int deleteByConventionReference(@PathVariable String reference) {
        return pieceJointeConventionService.deleteByConventionReference(reference);
    }

    @ApiOperation("find by convention id")
    @GetMapping("/convention/id/{id}")
    public List<PieceJointeConvention> findByConventionId(@PathVariable Long id) {
        return pieceJointeConventionService.findByConventionId(id);
    }

    @ApiOperation("delete by convention id")
    @DeleteMapping("/convention/id/{id}")
    public int deleteByConventionId(@PathVariable Long id) {
        return pieceJointeConventionService.deleteByConventionId(id);
    }


    @PutMapping("/archiver/")
    public PieceJointeConventionVo archiver(@RequestBody PieceJointeConventionVo pieceJointeConventionVo) {
        PieceJointeConvention pieceJointeConvention = pieceJointeConventionService.archiver(pieceJointeConventionConverter.toItem(pieceJointeConventionVo));
        return pieceJointeConventionConverter.toVo(pieceJointeConvention);
    }

    @PutMapping("/desarchiver/")
    public PieceJointeConventionVo desarchiver(@RequestBody PieceJointeConventionVo pieceJointeConventionVo) {
        PieceJointeConvention pieceJointeConvention = pieceJointeConventionService.desarchiver(pieceJointeConventionConverter.toItem(pieceJointeConventionVo));
        return pieceJointeConventionConverter.toVo(pieceJointeConvention);
    }

    @PutMapping("/upload/convention/{reference}")
    public void uploadFile(@RequestParam("file") MultipartFile file, @PathVariable String reference) throws IOException {
        pieceJointeConventionService.uploadFile(file,reference);
    }
    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
        PieceJointeConvention pieceJointeConvention = pieceJointeConventionService.getFile(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + pieceJointeConvention.getLibelle() + "\"")
                .body(pieceJointeConvention.getData());
    }
}

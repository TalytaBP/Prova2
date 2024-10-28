package br.com.fiap.Prova2.controller;


import br.com.fiap.Prova2.dto.BrinquedoRecordDto;
import br.com.fiap.Prova2.model.BrinquedoModel;
import br.com.fiap.Prova2.repositorios.BrinquedoRepositorio;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
public class BrinquedoController {

    @Autowired
    BrinquedoRepositorio brinquedoRepositorio;

    @PostMapping("/brinquedos")
    public ResponseEntity<BrinquedoModel> saveBrinquedo(@RequestBody @Valid BrinquedoRecordDto brinquedoRecordDto) {
        var brinquedoModel = new BrinquedoModel();
        BeanUtils.copyProperties(brinquedoRecordDto, brinquedoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(brinquedoRepositorio.save(brinquedoModel));
    }
    @GetMapping("/brinquedos")
    public ResponseEntity<List<BrinquedoModel>> getAllBrinquedos(){
        List<BrinquedoModel> brinquedosList = brinquedoRepositorio.findAll();
        if (!brinquedosList.isEmpty()) {
            for (BrinquedoModel brinquedos : brinquedosList) {
                UUID id = brinquedos.getId();
                brinquedos.add(linkTo(methodOn(BrinquedoController.class).getOneBrinquedo(id)).withSelfRel());
            }
        }

        return ResponseEntity.status(HttpStatus.OK).body(brinquedosList);
    }

    @GetMapping("/brinquedos/{id}")
    public ResponseEntity<Object> getOneBrinquedo(@PathVariable(value = "id") UUID id) {
        Optional<BrinquedoModel> brinquedoO = brinquedoRepositorio.findById(id);
        if (brinquedoO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Brinquedo não encontrado.");
        }

        brinquedoO.get().add(linkTo(methodOn(BrinquedoController.class).getAllBrinquedos()).withRel("Lista de Brinquedos"));


        return ResponseEntity.status(HttpStatus.OK).body(brinquedoO.get());
    }
    @PutMapping("/brinquedos/{id}")
    public ResponseEntity<Object> updateBrinquedo(@PathVariable(value="id") UUID id, @RequestBody @Valid BrinquedoRecordDto brinquedoRecordDto) {

        Optional<BrinquedoModel> brinquedo0 = brinquedoRepositorio.findById(id);
        if (brinquedo0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Brinquedo não encontrado");
        }
        var brinquedoModel = brinquedo0.get();
        BeanUtils.copyProperties(brinquedoRecordDto, brinquedoModel);
        return ResponseEntity.status(HttpStatus.OK).body(brinquedoRepositorio.save(brinquedoModel));
    }
    @DeleteMapping("/brinquedos/{id}")
    public ResponseEntity<Object> deleteBrinquedo(@PathVariable(value = "id") UUID id) {
        Optional<BrinquedoModel> brinquedo0 = brinquedoRepositorio.findById(id);
        if (brinquedo0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Brinquedo não encontrado");
        }
        brinquedoRepositorio.delete(brinquedo0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Brinquedo deletado com sucesso.");
    }

}

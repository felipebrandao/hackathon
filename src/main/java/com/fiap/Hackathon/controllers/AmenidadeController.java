package com.fiap.Hackathon.controllers;

import com.fiap.Hackathon.dtos.AmenidadeDTO;
import com.fiap.Hackathon.services.AmenidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/amenidades")
public class AmenidadeController {

    private final AmenidadeService amenidadeService;

    @Autowired
    public AmenidadeController(AmenidadeService amenidadeService) {
        this.amenidadeService = amenidadeService;
    }

    @PostMapping
    public ResponseEntity<AmenidadeDTO> cadastrarAmenidade(@RequestBody AmenidadeDTO amenidadeDTO) {
        AmenidadeDTO novaAmenidade = amenidadeService.cadastrarAmenidade(amenidadeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaAmenidade);
    }

    @GetMapping
    public ResponseEntity<List<AmenidadeDTO>> listarAmenidades() {
        List<AmenidadeDTO> amenidades = amenidadeService.listarAmenidades();
        return ResponseEntity.ok(amenidades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AmenidadeDTO> buscarAmenidadePorId(@PathVariable Long id) {
        AmenidadeDTO amenidade = amenidadeService.buscarAmenidadePorId(id);
        return ResponseEntity.ok(amenidade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAmenidade(@PathVariable Long id) {
        amenidadeService.deletarAmenidade(id);
        return ResponseEntity.noContent().build();
    }
}
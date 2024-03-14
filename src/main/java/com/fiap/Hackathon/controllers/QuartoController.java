package com.fiap.Hackathon.controllers;

import com.fiap.Hackathon.dtos.QuartoDTO;
import com.fiap.Hackathon.services.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quartos")
public class QuartoController {

    private final QuartoService quartoService;

    @Autowired
    public QuartoController(QuartoService quartoService) {
        this.quartoService = quartoService;
    }

    @PostMapping
    public ResponseEntity<QuartoDTO> criarQuarto(@RequestBody QuartoDTO quartoDTO) {
        QuartoDTO novoQuarto = quartoService.criarQuarto(quartoDTO);
        return new ResponseEntity<>(novoQuarto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuartoDTO> buscarQuartoPorId(@PathVariable String id) {
        QuartoDTO quartoDTO = quartoService.buscarQuartoPorId(id);
        return ResponseEntity.ok(quartoDTO);
    }
}

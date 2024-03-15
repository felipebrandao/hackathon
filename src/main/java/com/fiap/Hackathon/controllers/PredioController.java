package com.fiap.Hackathon.controllers;

import com.fiap.Hackathon.dtos.PredioDTO;
import com.fiap.Hackathon.services.PredioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/predios")
public class PredioController {

    private final PredioService predioService;

    @Autowired
    public PredioController(PredioService predioService) {
        this.predioService = predioService;
    }

    @PostMapping
    public ResponseEntity<PredioDTO> cadastrarPredio(@RequestBody PredioDTO predioDTO) {
        PredioDTO novoPredio = predioService.cadastrarPredio(predioDTO);
        return new ResponseEntity<>(novoPredio, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PredioDTO>> listarPredios() {
        List<PredioDTO> predios = predioService.listarPredios();
        return new ResponseEntity<>(predios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PredioDTO> buscarPredioPorId(@PathVariable Long id) {
        PredioDTO predio = predioService.buscarPredioPorId(id);
        return new ResponseEntity<>(predio, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPredio(@PathVariable Long id) {
        predioService.deletarPredio(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

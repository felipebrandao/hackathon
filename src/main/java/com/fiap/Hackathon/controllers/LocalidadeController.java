package com.fiap.Hackathon.controllers;

import com.fiap.Hackathon.dtos.LocalidadeDTO;
import com.fiap.Hackathon.services.LocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/localidades")
public class LocalidadeController {

    private final LocalidadeService localidadeService;

    @Autowired
    public LocalidadeController(LocalidadeService localidadeService) {
        this.localidadeService = localidadeService;
    }

    @PostMapping
    public ResponseEntity<LocalidadeDTO> cadastrarLocalidade(@RequestBody LocalidadeDTO localidadeDTO) {
        LocalidadeDTO novaLocalidade = localidadeService.cadastrarLocalidade(localidadeDTO);
        return new ResponseEntity<>(novaLocalidade, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LocalidadeDTO>> listarLocalidades() {
        List<LocalidadeDTO> localidades = localidadeService.listarLocalidades();
        return new ResponseEntity<>(localidades, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocalidadeDTO> buscarLocalidadePorId(@PathVariable Long id) {
        LocalidadeDTO localidade = localidadeService.buscarLocalidadePorId(id);
        return new ResponseEntity<>(localidade, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLocalidade(@PathVariable Long id) {
        localidadeService.deletarLocalidade(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

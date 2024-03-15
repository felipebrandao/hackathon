package com.fiap.Hackathon.services.impl;

import com.fiap.Hackathon.dtos.PredioDTO;
import com.fiap.Hackathon.entities.Predio;
import com.fiap.Hackathon.mappers.PredioMapper;
import com.fiap.Hackathon.repositories.PredioRepository;
import com.fiap.Hackathon.services.PredioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PredioServiceImpl implements PredioService {

    private final PredioRepository predioRepository;
    private final PredioMapper predioMapper;

    @Autowired
    public PredioServiceImpl(PredioRepository predioRepository, PredioMapper predioMapper) {
        this.predioRepository = predioRepository;
        this.predioMapper = predioMapper;
    }

    @Override
    public PredioDTO cadastrarPredio(PredioDTO predioDTO) {
        Predio predio = predioRepository.save(predioMapper.toEntity(predioDTO));
        return predioMapper.toDTO(predio);
    }

    @Override
    public List<PredioDTO> listarPredios() {
        List<Predio> predios = predioRepository.findAll();
        return predios.stream()
                .map(predio -> predioMapper.toDTO(predio))
                .collect(Collectors.toList());
    }

    @Override
    public PredioDTO buscarPredioPorId(Long id) {
        Predio predio = predioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Predio não encontrado"));
        return predioMapper.toDTO(predio);
    }

    @Override
    public void deletarPredio(Long id) {
        predioRepository.deleteById(id);
    }
}

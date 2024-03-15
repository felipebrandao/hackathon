package com.fiap.Hackathon.services.impl;

import com.fiap.Hackathon.dtos.QuartoDTO;
import com.fiap.Hackathon.entities.Quarto;
import com.fiap.Hackathon.mappers.QuartoMapper;
import com.fiap.Hackathon.repositories.QuartoRepository;
import com.fiap.Hackathon.services.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuartoServiceImpl implements QuartoService {

    private final QuartoRepository quartoRepository;
    private final QuartoMapper quartoMapper;

    @Autowired
    public QuartoServiceImpl(QuartoRepository quartoRepository, QuartoMapper quartoMapper) {
        this.quartoRepository = quartoRepository;
        this.quartoMapper = quartoMapper;
    }

    @Override
    public QuartoDTO criarQuarto(QuartoDTO quartoDTO) {
        Quarto quarto = quartoRepository.save(quartoMapper.toEntity(quartoDTO));
        return quartoMapper.toDTO(quarto);
    }

    @Override
    public List<QuartoDTO> listarQuartos() {
        List<Quarto> quartos = quartoRepository.findAll();
        return quartos.stream()
                .map(quartoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public QuartoDTO buscarQuartoPorId(Long id) {
        Quarto quarto = quartoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quarto não encontrado"));
        return quartoMapper.toDTO(quarto);
    }

    @Override
    public void deletarQuarto(Long id) {
        quartoRepository.deleteById(id);
    }

}

package com.fiap.Hackathon.services.impl;

import com.fiap.Hackathon.dtos.QuartoReservadoDTO;
import com.fiap.Hackathon.entities.QuartoReservado;
import com.fiap.Hackathon.mappers.QuartoReservadoMapper;
import com.fiap.Hackathon.repositories.QuartoReservadoRepository;
import com.fiap.Hackathon.services.QuartoReservadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuartoReservadoServiceImpl implements QuartoReservadoService {

    private final QuartoReservadoRepository quartoReservadoRepository;
    private final QuartoReservadoMapper quartoReservadoMapper;

    @Autowired
    public QuartoReservadoServiceImpl(QuartoReservadoRepository quartoReservadoRepository, QuartoReservadoMapper quartoReservadoMapper) {
        this.quartoReservadoRepository = quartoReservadoRepository;
        this.quartoReservadoMapper = quartoReservadoMapper;
    }

    @Override
    public QuartoReservadoDTO cadastrarQuartoReservado(QuartoReservadoDTO quartoReservadoDTO) {
        QuartoReservado quartoReservado = quartoReservadoRepository.save(quartoReservadoMapper.toEntity(quartoReservadoDTO));
        return quartoReservadoMapper.toDTO(quartoReservado);
    }

    @Override
    public List<QuartoReservadoDTO> listarQuartosReservados() {
        List<QuartoReservado> quartosReservados = quartoReservadoRepository.findAll();
        return quartosReservados.stream()
                .map(quartoReservado -> quartoReservadoMapper.toDTO(quartoReservado))
                .collect(Collectors.toList());
    }

    @Override
    public QuartoReservadoDTO buscarQuartoReservadoPorId(Long id) {
        QuartoReservado quartoReservado = quartoReservadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quarto reservado não encontrado"));
        return quartoReservadoMapper.toDTO(quartoReservado);
    }

    @Override
    public void deletarQuartoReservado(Long id) {
        quartoReservadoRepository.deleteById(id);
    }
}

package com.fiap.Hackathon.services.impl;

import com.fiap.Hackathon.dtos.CamaDTO;
import com.fiap.Hackathon.entities.Cama;
import com.fiap.Hackathon.mappers.CamaMapper;
import com.fiap.Hackathon.repositories.CamaRepository;
import com.fiap.Hackathon.services.CamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CamaServiceImpl implements CamaService {

    private final CamaRepository camaRepository;
    private final CamaMapper camaMapper;

    @Autowired
    public CamaServiceImpl(CamaRepository camaRepository, CamaMapper camaMapper) {
        this.camaRepository = camaRepository;
        this.camaMapper = camaMapper;
    }

    @Override
    public CamaDTO cadastrarCama(CamaDTO camaDTO) {
        Cama camaSalva = camaRepository.save(camaMapper.toEntity(camaDTO));
        return camaMapper.toDTO(camaSalva);
    }

    @Override
    public List<CamaDTO> listarCamas() {
        List<Cama> camas = camaRepository.findAll();
        return camas.stream()
                .map(camaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CamaDTO buscarCamaPorId(Long id) {
        Cama cama = camaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cama não encontrada"));
        return camaMapper.toDTO(cama);
    }

    @Override
    public void deletarCama(Long id) {
        camaRepository.deleteById(id);
    }
}

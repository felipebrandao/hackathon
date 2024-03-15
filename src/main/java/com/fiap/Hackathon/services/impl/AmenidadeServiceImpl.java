package com.fiap.Hackathon.services.impl;

import com.fiap.Hackathon.dtos.AmenidadeDTO;
import com.fiap.Hackathon.entities.Amenidade;
import com.fiap.Hackathon.mappers.AmenidadeMapper;
import com.fiap.Hackathon.repositories.AmenidadeRepository;
import com.fiap.Hackathon.services.AmenidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AmenidadeServiceImpl implements AmenidadeService {

    private final AmenidadeRepository amenidadeRepository;
    private final AmenidadeMapper amenidadeMapper;

    @Autowired
    public AmenidadeServiceImpl(AmenidadeRepository amenidadeRepository, AmenidadeMapper amenidadeMapper) {
        this.amenidadeRepository = amenidadeRepository;
        this.amenidadeMapper = amenidadeMapper;
    }

    @Override
    public AmenidadeDTO cadastrarAmenidade(AmenidadeDTO amenidadeDTO) {
        Amenidade amenidade = amenidadeRepository.save(amenidadeMapper.toEntity(amenidadeDTO));
        return amenidadeMapper.toDTO(amenidade);
    }

    @Override
    public List<AmenidadeDTO> listarAmenidades() {
        List<Amenidade> amenidades = amenidadeRepository.findAll();
        return amenidades.stream()
                .map(amenidade -> amenidadeMapper.toDTO(amenidade))
                .collect(Collectors.toList());
    }

    @Override
    public AmenidadeDTO buscarAmenidadePorId(Long id) {
        Amenidade amenidade = amenidadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Amenidade não encontrada"));
        return amenidadeMapper.toDTO(amenidade);
    }

    @Override
    public void deletarAmenidade(Long id) {
        amenidadeRepository.deleteById(id);
    }
}
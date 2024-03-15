package com.fiap.Hackathon.services.impl;

import com.fiap.Hackathon.dtos.LocalidadeDTO;
import com.fiap.Hackathon.entities.Localidade;
import com.fiap.Hackathon.mappers.LocalidadeMapper;
import com.fiap.Hackathon.repositories.LocalidadeRepository;
import com.fiap.Hackathon.services.LocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocalidadeServiceImpl implements LocalidadeService {

    private final LocalidadeRepository localidadeRepository;
    private final LocalidadeMapper localidadeMapper;

    @Autowired
    public LocalidadeServiceImpl(LocalidadeRepository localidadeRepository, LocalidadeMapper localidadeMapper) {
        this.localidadeRepository = localidadeRepository;
        this.localidadeMapper = localidadeMapper;
    }

    @Override
    public LocalidadeDTO cadastrarLocalidade(LocalidadeDTO localidadeDTO) {
        Localidade localidade = localidadeRepository.save(localidadeMapper.toEntity(localidadeDTO));
        return localidadeMapper.toDTO(localidade);
    }

    @Override
    public List<LocalidadeDTO> listarLocalidades() {
        List<Localidade> localidades = localidadeRepository.findAll();
        return localidades.stream()
                .map(localidadeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LocalidadeDTO buscarLocalidadePorId(Long id) {
        Localidade localidade = localidadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Localidade não encontrada"));
        return localidadeMapper.toDTO(localidade);
    }

    @Override
    public void deletarLocalidade(Long id) {
        localidadeRepository.deleteById(id);
    }
}

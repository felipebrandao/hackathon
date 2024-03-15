package com.fiap.Hackathon.services.impl;

import com.fiap.Hackathon.dtos.MoveisDTO;
import com.fiap.Hackathon.entities.Moveis;
import com.fiap.Hackathon.mappers.MoveisMapper;
import com.fiap.Hackathon.repositories.MoveisRepository;
import com.fiap.Hackathon.services.MoveisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MoveisServiceImpl implements MoveisService {

    private final MoveisRepository moveisRepository;
    private final MoveisMapper moveisMapper;

    @Autowired
    public MoveisServiceImpl(MoveisRepository moveisRepository, MoveisMapper moveisMapper) {
        this.moveisRepository = moveisRepository;
        this.moveisMapper = moveisMapper;
    }

    @Override
    public MoveisDTO cadastrarMoveis(MoveisDTO moveisDTO) {
        Moveis moveis = moveisRepository.save(moveisMapper.toEntity(moveisDTO));
        return moveisMapper.toDTO(moveis);
    }

    @Override
    public List<MoveisDTO> listarMoveis() {
        List<Moveis> moveis = moveisRepository.findAll();
        return moveis.stream()
                .map(moveisMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MoveisDTO buscarMoveisPorId(Long id) {
        Moveis moveis = moveisRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Moveis não encontrados"));
        return moveisMapper.toDTO(moveis);
    }

    @Override
    public void deletarMoveis(Long id) {
        moveisRepository.deleteById(id);
    }
}
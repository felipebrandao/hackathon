package com.fiap.Hackathon.services.impl;

import com.fiap.Hackathon.dtos.CamaDTO;
import com.fiap.Hackathon.dtos.MoveisDTO;
import com.fiap.Hackathon.dtos.QuartoDTO;
import com.fiap.Hackathon.entities.Cama;
import com.fiap.Hackathon.entities.Moveis;
import com.fiap.Hackathon.entities.Quarto;
import com.fiap.Hackathon.enums.TipoQuartoEnum;
import com.fiap.Hackathon.mappers.CamaMapper;
import com.fiap.Hackathon.mappers.QuartoMapper;
import com.fiap.Hackathon.repositories.QuartoRepository;
import com.fiap.Hackathon.services.CamaService;
import com.fiap.Hackathon.services.MoveisService;
import com.fiap.Hackathon.services.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuartoServiceImpl implements QuartoService {

    private final QuartoRepository quartoRepository;

    private final MoveisService moveisService;

    private final CamaService camaService;

    private final QuartoMapper quartoMapper;

    @Autowired
    public QuartoServiceImpl(QuartoRepository quartoRepository, MoveisService moveisService, CamaService camaService, QuartoMapper quartoMapper) {
        this.quartoRepository = quartoRepository;
        this.moveisService = moveisService;
        this.camaService = camaService;
        this.quartoMapper = quartoMapper;
    }

    @Transactional
    @Override
    public QuartoDTO criarQuarto(QuartoDTO quartoDTO) {

        Quarto quarto = quartoRepository.save(quartoMapper.toEntity(quartoDTO));

        Long id = quarto.getId();

        List<CamaDTO> camasSalvas = quartoDTO.getCamas().stream()
                .map(camaDTO -> {
                    camaDTO.setIdQuarto(id);
                    return camaService.cadastrarCama(camaDTO);
                })
                .collect(Collectors.toList());

        List<MoveisDTO> moveisSalvos = quartoDTO.getMoveis().stream()
                .map(moveisDTO -> {
                    moveisDTO.setIdQuarto(id);
                    return moveisService.cadastrarMoveis(moveisDTO);
                })
                .collect(Collectors.toList());

        QuartoDTO quartoSalvo = quartoMapper.toDTO(quarto);

        quartoSalvo.setCamas(camasSalvas);
        quartoSalvo.setMoveis(moveisSalvos);

        return quartoSalvo;
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

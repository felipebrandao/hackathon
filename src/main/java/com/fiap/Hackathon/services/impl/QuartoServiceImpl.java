package com.fiap.Hackathon.services.impl;

import com.fiap.Hackathon.dtos.QuartoDTO;
import com.fiap.Hackathon.entities.Quarto;
import com.fiap.Hackathon.repositories.QuartoRepository;
import com.fiap.Hackathon.services.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuartoServiceImpl implements QuartoService {
    private final QuartoRepository quartoRepository;

    @Autowired
    public QuartoServiceImpl(QuartoRepository quartoRepository) {
        this.quartoRepository = quartoRepository;
    }

    @Override
    public QuartoDTO criarQuarto(QuartoDTO quartoDTO) {
        Quarto quarto = new Quarto();
        BeanUtils.copyProperties(quartoDTO, quarto);
        Quarto quartoSalvo = quartoRepository.save(quarto);
        QuartoDTO quartoSalvoDTO = new QuartoDTO();
        BeanUtils.copyProperties(quartoSalvo, quartoSalvoDTO);
        return quartoSalvoDTO;
    }

    @Override
    public QuartoDTO atualizarQuarto(String id, QuartoDTO quartoDTO) {
        Quarto quarto = quartoRepository.getOne(id);
        BeanUtils.copyProperties(quartoDTO, quarto);
        Quarto quartoAtualizado = quartoRepository.save(quarto);
        QuartoDTO quartoAtualizadoDTO = new QuartoDTO();
        BeanUtils.copyProperties(quartoAtualizado, quartoAtualizadoDTO);
        return quartoAtualizadoDTO;
    }

    @Override
    public void deletarQuarto(String id) {
        quartoRepository.deleteById(id);
    }

    @Override
    public QuartoDTO buscarQuartoPorId(String id) {
        Quarto quarto = quartoRepository.getOne(id);
        QuartoDTO quartoDTO = new QuartoDTO();
        BeanUtils.copyProperties(quarto, quartoDTO);
        return quartoDTO;
    }

}

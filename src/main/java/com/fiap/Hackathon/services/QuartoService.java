package com.fiap.Hackathon.services;

import com.fiap.Hackathon.dtos.QuartoDTO;

import java.util.List;

public interface QuartoService {

    QuartoDTO criarQuarto(QuartoDTO quartoDTO);

    List<QuartoDTO> listarQuartos();

    QuartoDTO buscarQuartoPorId(Long id);

    void deletarQuarto(Long id);
}

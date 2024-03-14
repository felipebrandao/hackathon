package com.fiap.Hackathon.services;

import com.fiap.Hackathon.dtos.QuartoDTO;

public interface QuartoService {

    QuartoDTO criarQuarto(QuartoDTO quartoDTO);
    QuartoDTO atualizarQuarto(String id, QuartoDTO quartoDTO);
    void deletarQuarto(String id);
    QuartoDTO buscarQuartoPorId(String id);
}

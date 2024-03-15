package com.fiap.Hackathon.services;

import com.fiap.Hackathon.dtos.PredioDTO;

import java.util.List;

public interface PredioService {

    PredioDTO cadastrarPredio(PredioDTO predioDTO);

    List<PredioDTO> listarPredios();

    PredioDTO buscarPredioPorId(Long id);

    void deletarPredio(Long id);

}

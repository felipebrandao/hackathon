package com.fiap.Hackathon.services;

import com.fiap.Hackathon.dtos.QuartoReservadoDTO;

import java.util.List;

public interface QuartoReservadoService {

    QuartoReservadoDTO cadastrarQuartoReservado(QuartoReservadoDTO quartoReservadoDTO);

    List<QuartoReservadoDTO> listarQuartosReservados();

    QuartoReservadoDTO buscarQuartoReservadoPorId(Long id);

    void deletarQuartoReservado(Long id);
}

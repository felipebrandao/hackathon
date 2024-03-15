package com.fiap.Hackathon.services;

import com.fiap.Hackathon.dtos.MoveisDTO;

import java.util.List;

public interface MoveisService {
    MoveisDTO cadastrarMoveis(MoveisDTO moveisDTO);

    List<MoveisDTO> listarMoveis();

    MoveisDTO buscarMoveisPorId(Long id);

    void deletarMoveis(Long id);
}

package com.fiap.Hackathon.services;

import com.fiap.Hackathon.dtos.CamaDTO;
import com.fiap.Hackathon.entities.Cama;

import java.util.List;

public interface CamaService {

    CamaDTO cadastrarCama(CamaDTO camaDTO);

    List<CamaDTO> listarCamas();

    CamaDTO buscarCamaPorId(Long id);

    void deletarCama(Long id);
}

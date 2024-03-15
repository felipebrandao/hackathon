package com.fiap.Hackathon.services;

import com.fiap.Hackathon.dtos.AmenidadeDTO;
import java.util.List;

public interface AmenidadeService {
    AmenidadeDTO cadastrarAmenidade(AmenidadeDTO amenidadeDTO);
    List<AmenidadeDTO> listarAmenidades();
    AmenidadeDTO buscarAmenidadePorId(Long id);
    void deletarAmenidade(Long id);
}
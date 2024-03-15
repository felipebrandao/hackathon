package com.fiap.Hackathon.services;

import com.fiap.Hackathon.dtos.LocalidadeDTO;

import java.util.List;

public interface LocalidadeService {

    LocalidadeDTO cadastrarLocalidade(LocalidadeDTO localidadeDTO);

    List<LocalidadeDTO> listarLocalidades();

    LocalidadeDTO buscarLocalidadePorId(Long id);

    void deletarLocalidade(Long id);
}

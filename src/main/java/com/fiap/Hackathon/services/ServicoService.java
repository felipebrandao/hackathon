package com.fiap.Hackathon.services;

import com.fiap.Hackathon.dtos.ServicoDTO;

public interface ServicoService {

    ServicoDTO criarServico(ServicoDTO servicoDTO);
    ServicoDTO atualizarServico(String id, ServicoDTO servicoDTO);
    void deletarServico(String id);
    ServicoDTO buscarServicoPorId(String id);
}

package com.fiap.Hackathon.services;

import com.fiap.Hackathon.dtos.EnderecoDTO;

import java.util.List;

public interface EnderecoService {

    EnderecoDTO cadastrarEndereco(EnderecoDTO enderecoDTO);
    List<EnderecoDTO> listarEnderecos();
    EnderecoDTO buscarEnderecoPorId(Long id);
    void deletarEndereco(Long id);

}

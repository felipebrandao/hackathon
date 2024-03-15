package com.fiap.Hackathon.services;

import com.fiap.Hackathon.dtos.ClienteDTO;

public interface ClienteService {

    ClienteDTO criarCliente(ClienteDTO clienteDTO);
    ClienteDTO atualizarCliente(Long id, ClienteDTO clienteDTO);
    void deletarCliente(Long id);
    ClienteDTO buscarClientePorId(Long id);

}

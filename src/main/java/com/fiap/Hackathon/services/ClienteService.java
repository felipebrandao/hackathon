package com.fiap.Hackathon.services;

import com.fiap.Hackathon.dtos.ClienteDTO;

public interface ClienteService {

    ClienteDTO criarCliente(ClienteDTO clienteDTO);
    ClienteDTO atualizarCliente(String id, ClienteDTO clienteDTO);
    void deletarCliente(String id);
    ClienteDTO buscarClientePorId(String id);

}

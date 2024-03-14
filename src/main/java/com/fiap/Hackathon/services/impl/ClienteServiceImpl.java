package com.fiap.Hackathon.services.impl;

import com.fiap.Hackathon.dtos.ClienteDTO;
import com.fiap.Hackathon.entities.Cliente;
import com.fiap.Hackathon.repositories.ClienteRepository;
import com.fiap.Hackathon.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteDTO criarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteDTO, cliente);
        Cliente clienteSalvo = clienteRepository.save(cliente);
        ClienteDTO clienteSalvoDTO = new ClienteDTO();
        BeanUtils.copyProperties(clienteSalvo, clienteSalvoDTO);
        return clienteSalvoDTO;
    }

    @Override
    public ClienteDTO atualizarCliente(String id, ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.getOne(id);
        BeanUtils.copyProperties(clienteDTO, cliente);
        Cliente clienteAtualizado = clienteRepository.save(cliente);
        ClienteDTO clienteAtualizadoDTO = new ClienteDTO();
        BeanUtils.copyProperties(clienteAtualizado, clienteAtualizadoDTO);
        return clienteAtualizadoDTO;
    }

    @Override
    public void deletarCliente(String id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public ClienteDTO buscarClientePorId(String id) {
        Cliente cliente = clienteRepository.getOne(id);
        ClienteDTO clienteDTO = new ClienteDTO();
        BeanUtils.copyProperties(cliente, clienteDTO);
        return clienteDTO;
    }
}

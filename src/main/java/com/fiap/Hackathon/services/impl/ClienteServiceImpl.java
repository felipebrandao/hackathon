package com.fiap.Hackathon.services.impl;

import com.fiap.Hackathon.dtos.ClienteDTO;
import com.fiap.Hackathon.entities.Cliente;
import com.fiap.Hackathon.excepctions.ClienteNaoEncontradoException;
import com.fiap.Hackathon.mappers.ClienteMapper;
import com.fiap.Hackathon.repositories.ClienteRepository;
import com.fiap.Hackathon.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    private final ClienteMapper clienteMapper;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public ClienteDTO criarCliente(ClienteDTO clienteDTO) {
        Cliente clienteSalvo = clienteRepository.save(clienteMapper.toEntity(clienteDTO));
        return clienteMapper.toDTO(clienteSalvo);
    }

    @Override
    public ClienteDTO atualizarCliente(Long id, ClienteDTO clienteDTO) {
        Cliente clienteEncontrado = clienteRepository.findByIdAndCPF(id, clienteDTO.getCpf());

        if (clienteEncontrado == null)
            throw new ClienteNaoEncontradoException("Pessoa com este id: " + id + " e CPF: " + clienteDTO.getCpf() + " não encontrada.");

        Cliente clienteAtualizado = toEntityUpdate(clienteDTO, clienteEncontrado);
        clienteAtualizado = clienteRepository.save(clienteAtualizado);

        return clienteMapper.toDTO(clienteAtualizado);
    }

    private Cliente toEntityUpdate(ClienteDTO clienteDTO, Cliente clienteEncontrado) {
        if (clienteDTO.getNomeCompleto() != null) clienteEncontrado.setNomeCompleto(clienteDTO.getNomeCompleto());
        if (clienteDTO.getDataNascimento() != null) clienteEncontrado.setDataNascimento(clienteDTO.getDataNascimento());
        return clienteEncontrado;
    }

    @Override
    public void deletarCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNaoEncontradoException("Cliente com ID " + id + " não encontrada."));
        clienteRepository.delete(cliente);
    }

    @Override
    public ClienteDTO buscarClientePorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNaoEncontradoException("Cliente com ID " + id + " não encontrada."));
        return clienteMapper.toDTO(cliente);
    }
}

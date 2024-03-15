package com.fiap.Hackathon.services.impl;

import com.fiap.Hackathon.dtos.EnderecoDTO;
import com.fiap.Hackathon.entities.Endereco;
import com.fiap.Hackathon.mappers.EnderecoMapper;
import com.fiap.Hackathon.repositories.EnderecoRepository;
import com.fiap.Hackathon.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final EnderecoMapper enderecoMapper;

    @Autowired
    public EnderecoServiceImpl(EnderecoRepository enderecoRepository, EnderecoMapper enderecoMapper) {
        this.enderecoRepository = enderecoRepository;
        this.enderecoMapper = enderecoMapper;
    }

    @Override
    public EnderecoDTO cadastrarEndereco(EnderecoDTO enderecoDTO) {
        Endereco endereco = enderecoRepository.save(enderecoMapper.toEntity(enderecoDTO));
        return enderecoMapper.toDTO(endereco);
    }

    @Override
    public List<EnderecoDTO> listarEnderecos() {
        List<Endereco> enderecos = enderecoRepository.findAll();
        return enderecos.stream()
                .map(endereco -> enderecoMapper.toDTO(endereco))
                .collect(Collectors.toList());
    }

    @Override
    public EnderecoDTO buscarEnderecoPorId(Long id) {
        Endereco endereco = enderecoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereco não encontrado"));
        return enderecoMapper.toDTO(endereco);
    }

    @Override
    public void deletarEndereco(Long id) {
        enderecoRepository.deleteById(id);
    }
}

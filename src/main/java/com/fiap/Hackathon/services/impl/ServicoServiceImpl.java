package com.fiap.Hackathon.services.impl;

import com.fiap.Hackathon.dtos.ServicoDTO;
import com.fiap.Hackathon.entities.Servico;
import com.fiap.Hackathon.repositories.ServicoRepository;
import com.fiap.Hackathon.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoServiceImpl implements ServicoService {

    private final ServicoRepository servicoRepository;

    @Autowired
    public ServicoServiceImpl(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    @Override
    public ServicoDTO criarServico(ServicoDTO servicoDTO) {
        Servico servico = new Servico();
        BeanUtils.copyProperties(servicoDTO, servico);
        Servico servicoSalvo = servicoRepository.save(servico);
        ServicoDTO servicoSalvoDTO = new ServicoDTO();
        BeanUtils.copyProperties(servicoSalvo, servicoSalvoDTO);
        return servicoSalvoDTO;
    }

    @Override
    public ServicoDTO atualizarServico(String id, ServicoDTO servicoDTO) {
        Servico servico = servicoRepository.getOne(id);
        BeanUtils.copyProperties(servicoDTO, servico);
        Servico servicoAtualizado = servicoRepository.save(servico);
        ServicoDTO servicoAtualizadoDTO = new ServicoDTO();
        BeanUtils.copyProperties(servicoAtualizado, servicoAtualizadoDTO);
        return servicoAtualizadoDTO;
    }

    @Override
    public void deletarServico(String id) {
        servicoRepository.deleteById(id);
    }

    @Override
    public ServicoDTO buscarServicoPorId(String id) {
        Servico servico = servicoRepository.getOne(id);
        ServicoDTO servicoDTO = new ServicoDTO();
        BeanUtils.copyProperties(servico, servicoDTO);
        return servicoDTO;
    }
}

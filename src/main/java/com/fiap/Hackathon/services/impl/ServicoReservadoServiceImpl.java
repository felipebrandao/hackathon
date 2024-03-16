package com.fiap.Hackathon.services.impl;

import com.fiap.Hackathon.dtos.ServicoReservadoDTO;
import com.fiap.Hackathon.entities.ServicoReservado;
import com.fiap.Hackathon.mappers.ServicoReservadoMapper;
import com.fiap.Hackathon.repositories.ServicoReservadoRepository;
import com.fiap.Hackathon.services.ServicoReservadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicoReservadoServiceImpl implements ServicoReservadoService {

    private final ServicoReservadoRepository servicoReservadoRepository;
    private final ServicoReservadoMapper servicoReservadoMapper;

    @Autowired
    public ServicoReservadoServiceImpl(ServicoReservadoRepository servicoReservadoRepository, ServicoReservadoMapper servicoReservadoMapper) {
        this.servicoReservadoRepository = servicoReservadoRepository;
        this.servicoReservadoMapper = servicoReservadoMapper;
    }

    @Override
    public ServicoReservadoDTO cadastrarServicoReservado(ServicoReservadoDTO servicoReservadoDTO) {
        ServicoReservado servicoReservado = servicoReservadoRepository.save(servicoReservadoMapper.toEntity(servicoReservadoDTO));
        return servicoReservadoMapper.toDTO(servicoReservado);
    }

    @Override
    public List<ServicoReservadoDTO> listarServicosReservados() {
        List<ServicoReservado> servicosReservados = servicoReservadoRepository.findAll();
        return servicosReservados.stream()
                .map(servicoReservado -> servicoReservadoMapper.toDTO(servicoReservado))
                .collect(Collectors.toList());
    }

    @Override
    public ServicoReservadoDTO buscarServicoReservadoPorId(Long id) {
        ServicoReservado servicoReservado = servicoReservadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço reservado não encontrado"));
        return servicoReservadoMapper.toDTO(servicoReservado);
    }

    @Override
    public void deletarServicoReservado(Long id) {
        servicoReservadoRepository.deleteById(id);
    }
}

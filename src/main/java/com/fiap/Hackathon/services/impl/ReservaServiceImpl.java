package com.fiap.Hackathon.services.impl;

import com.fiap.Hackathon.dtos.ItemOpcionalReservadoDTO;
import com.fiap.Hackathon.dtos.QuartoReservadoDTO;
import com.fiap.Hackathon.dtos.ReservaDTO;
import com.fiap.Hackathon.dtos.ServicoReservadoDTO;
import com.fiap.Hackathon.entities.Reserva;
import com.fiap.Hackathon.mappers.ReservaMapper;
import com.fiap.Hackathon.repositories.ReservaRepository;
import com.fiap.Hackathon.services.ItemOpcionalReservadoService;
import com.fiap.Hackathon.services.QuartoReservadoService;
import com.fiap.Hackathon.services.ReservaService;
import com.fiap.Hackathon.services.ServicoReservadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;

    private final ReservaMapper reservaMapper;

    private final QuartoReservadoService quartoReservadoService;

    private final ServicoReservadoService servicoReservadoService;

    private final ItemOpcionalReservadoService itemOpcionalReservadoService;

    @Autowired
    public ReservaServiceImpl(ReservaRepository reservaRepository, ReservaMapper reservaMapper, QuartoReservadoService quartoReservadoService, ServicoReservadoService servicoReservadoService, ItemOpcionalReservadoService itemOpcionalReservadoService) {
        this.reservaRepository = reservaRepository;
        this.reservaMapper = reservaMapper;
        this.quartoReservadoService = quartoReservadoService;
        this.servicoReservadoService = servicoReservadoService;
        this.itemOpcionalReservadoService = itemOpcionalReservadoService;
    }

    @Transactional
    @Override
    public ReservaDTO criarReserva(ReservaDTO reservaDTO) {

        Reserva reservaSalva = reservaRepository.save(reservaMapper.toEntity(reservaDTO));

        Long id = reservaSalva.getId();

        List<QuartoReservadoDTO> quartoReservadoSalvos = reservaDTO.getQuartos().stream()
                .map(quartoReservadoDTO -> {
                    quartoReservadoDTO.setIdReserva(id);
                    return quartoReservadoService.cadastrarQuartoReservado(quartoReservadoDTO);
                })
                .collect(Collectors.toList());

        List<ServicoReservadoDTO> servicoReservadoSalvos = reservaDTO.getServicos().stream()
                .map(servicoReservadoDTO -> {
                    servicoReservadoDTO.setIdReserva(id);
                    return servicoReservadoService.cadastrarServicoReservado(servicoReservadoDTO);
                })
                .collect(Collectors.toList());

        List<ItemOpcionalReservadoDTO> itemOpcionalReservadoSalvos = reservaDTO.getItensOpcionais().stream()
                .map(itemOpcionalReservadoDTO -> {
                    itemOpcionalReservadoDTO.setIdReserva(id);
                    return itemOpcionalReservadoService.cadastrarItemOpcionalReservado(itemOpcionalReservadoDTO);
                })
                .collect(Collectors.toList());

        ReservaDTO reservaSalvaDTO = reservaMapper.toDTO(reservaSalva);
        reservaSalvaDTO.setQuartos(quartoReservadoSalvos);
        reservaSalvaDTO.setServicos(servicoReservadoSalvos);
        reservaSalvaDTO.setItensOpcionais(itemOpcionalReservadoSalvos);

        return reservaSalvaDTO;
    }

    @Override
    public ReservaDTO atualizarReserva(String id, ReservaDTO reservaDTO) {
        Reserva reserva = reservaRepository.getOne(id);
        //BeanUtils.copyProperties(reservaDTO, reserva);
        Reserva reservaAtualizada = reservaRepository.save(reserva);
        ReservaDTO reservaAtualizadaDTO = new ReservaDTO();
        //BeanUtils.copyProperties(reservaAtualizada, reservaAtualizadaDTO);
        return reservaAtualizadaDTO;
    }

    @Override
    public void cancelarReserva(String id) {
        reservaRepository.deleteById(id);
    }

    @Override
    public ReservaDTO buscarReservaPorId(String id) {
        Reserva reserva = reservaRepository.getOne(id);
        ReservaDTO reservaDTO = new ReservaDTO();
        //BeanUtils.copyProperties(reserva, reservaDTO);
        return reservaDTO;
    }
}

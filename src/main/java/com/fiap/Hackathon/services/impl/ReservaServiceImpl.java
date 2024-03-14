package com.fiap.Hackathon.services.impl;

import com.fiap.Hackathon.dtos.ReservaDTO;
import com.fiap.Hackathon.entities.Reserva;
import com.fiap.Hackathon.repositories.ReservaRepository;
import com.fiap.Hackathon.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;

    @Autowired
    public ReservaServiceImpl(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Override
    public ReservaDTO criarReserva(ReservaDTO reservaDTO) {
        Reserva reserva = new Reserva();
        BeanUtils.copyProperties(reservaDTO, reserva);
        Reserva reservaSalva = reservaRepository.save(reserva);
        ReservaDTO reservaSalvaDTO = new ReservaDTO();
        BeanUtils.copyProperties(reservaSalva, reservaSalvaDTO);
        return reservaSalvaDTO;
    }

    @Override
    public ReservaDTO atualizarReserva(String id, ReservaDTO reservaDTO) {
        Reserva reserva = reservaRepository.getOne(id);
        BeanUtils.copyProperties(reservaDTO, reserva);
        Reserva reservaAtualizada = reservaRepository.save(reserva);
        ReservaDTO reservaAtualizadaDTO = new ReservaDTO();
        BeanUtils.copyProperties(reservaAtualizada, reservaAtualizadaDTO);
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
        BeanUtils.copyProperties(reserva, reservaDTO);
        return reservaDTO;
    }
}

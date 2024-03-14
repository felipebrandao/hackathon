package com.fiap.Hackathon.services;

import com.fiap.Hackathon.dtos.ReservaDTO;

public interface ReservaService {
    ReservaDTO criarReserva(ReservaDTO reservaDTO);
    ReservaDTO atualizarReserva(String id, ReservaDTO reservaDTO);
    void cancelarReserva(String id);
    ReservaDTO buscarReservaPorId(String id);
}

package com.fiap.Hackathon.services;

import com.fiap.Hackathon.dtos.ServicoReservadoDTO;

import java.util.List;

public interface ServicoReservadoService {

    ServicoReservadoDTO cadastrarServicoReservado(ServicoReservadoDTO servicoReservadoDTO);

    List<ServicoReservadoDTO> listarServicosReservados();

    ServicoReservadoDTO buscarServicoReservadoPorId(Long id);

    void deletarServicoReservado(Long id);

}

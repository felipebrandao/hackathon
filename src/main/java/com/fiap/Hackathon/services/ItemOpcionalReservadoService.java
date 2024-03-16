package com.fiap.Hackathon.services;

import com.fiap.Hackathon.dtos.ItemOpcionalReservadoDTO;

import java.util.List;

public interface ItemOpcionalReservadoService {

    ItemOpcionalReservadoDTO cadastrarItemOpcionalReservado(ItemOpcionalReservadoDTO itemOpcionalReservadoDTO);

    List<ItemOpcionalReservadoDTO> listarItensOpcionaisReservados();

    ItemOpcionalReservadoDTO buscarItemOpcionalReservadoPorId(Long id);

    void deletarItemOpcionalReservado(Long id);
}

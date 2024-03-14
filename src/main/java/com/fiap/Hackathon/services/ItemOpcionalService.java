package com.fiap.Hackathon.services;

import com.fiap.Hackathon.dtos.ItemOpcionalDTO;

public interface ItemOpcionalService {

    ItemOpcionalDTO criarItemOpcional(ItemOpcionalDTO itemOpcionalDTO);
    ItemOpcionalDTO atualizarItemOpcional(String id, ItemOpcionalDTO itemOpcionalDTO);
    void deletarItemOpcional(String id);
    ItemOpcionalDTO buscarItemOpcionalPorId(String id);
}

package com.fiap.Hackathon.services.impl;

import com.fiap.Hackathon.dtos.ItemOpcionalReservadoDTO;
import com.fiap.Hackathon.entities.ItemOpcionalReservado;
import com.fiap.Hackathon.mappers.ItemOpcionalReservadoMapper;
import com.fiap.Hackathon.repositories.ItemOpcionalReservadoRepository;
import com.fiap.Hackathon.services.ItemOpcionalReservadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ItemOpcionalReservadoServiceImpl implements ItemOpcionalReservadoService {

    private final ItemOpcionalReservadoRepository itemOpcionalReservadoRepository;
    private final ItemOpcionalReservadoMapper itemOpcionalReservadoMapper;

    @Autowired
    public ItemOpcionalReservadoServiceImpl(ItemOpcionalReservadoRepository itemOpcionalReservadoRepository, ItemOpcionalReservadoMapper itemOpcionalReservadoMapper) {
        this.itemOpcionalReservadoRepository = itemOpcionalReservadoRepository;
        this.itemOpcionalReservadoMapper = itemOpcionalReservadoMapper;
    }

    @Override
    public ItemOpcionalReservadoDTO cadastrarItemOpcionalReservado(ItemOpcionalReservadoDTO itemOpcionalReservadoDTO) {
        ItemOpcionalReservado itemOpcionalReservado = itemOpcionalReservadoRepository.save(itemOpcionalReservadoMapper.toEntity(itemOpcionalReservadoDTO));
        return itemOpcionalReservadoMapper.toDTO(itemOpcionalReservado);
    }

    @Override
    public List<ItemOpcionalReservadoDTO> listarItensOpcionaisReservados() {
        List<ItemOpcionalReservado> itensOpcionaisReservados = itemOpcionalReservadoRepository.findAll();
        return itensOpcionaisReservados.stream()
                .map(itemOpcionalReservado -> itemOpcionalReservadoMapper.toDTO(itemOpcionalReservado))
                .collect(Collectors.toList());
    }

    @Override
    public ItemOpcionalReservadoDTO buscarItemOpcionalReservadoPorId(Long id) {
        ItemOpcionalReservado itemOpcionalReservado = itemOpcionalReservadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item opcional reservado não encontrado"));
        return itemOpcionalReservadoMapper.toDTO(itemOpcionalReservado);
    }

    @Override
    public void deletarItemOpcionalReservado(Long id) {
        itemOpcionalReservadoRepository.deleteById(id);
    }
}
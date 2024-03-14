package com.fiap.Hackathon.services.impl;

import com.fiap.Hackathon.dtos.ItemOpcionalDTO;
import com.fiap.Hackathon.entities.ItemOpcional;
import com.fiap.Hackathon.repositories.ItemOpcionalRepository;
import com.fiap.Hackathon.services.ItemOpcionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemOpcionalServiceImpl implements ItemOpcionalService {

    private final ItemOpcionalRepository itemOpcionalRepository;

    @Autowired
    public ItemOpcionalServiceImpl(ItemOpcionalRepository itemOpcionalRepository) {
        this.itemOpcionalRepository = itemOpcionalRepository;
    }

    @Override
    public ItemOpcionalDTO criarItemOpcional(ItemOpcionalDTO itemOpcionalDTO) {
        ItemOpcional itemOpcional = new ItemOpcional();
        BeanUtils.copyProperties(itemOpcionalDTO, itemOpcional);
        ItemOpcional itemOpcionalSalvo = itemOpcionalRepository.save(itemOpcional);
        ItemOpcionalDTO itemOpcionalSalvoDTO = new ItemOpcionalDTO();
        BeanUtils.copyProperties(itemOpcionalSalvo, itemOpcionalSalvoDTO);
        return itemOpcionalSalvoDTO;
    }

    @Override
    public ItemOpcionalDTO atualizarItemOpcional(String id, ItemOpcionalDTO itemOpcionalDTO) {
        ItemOpcional itemOpcional = itemOpcionalRepository.getOne(id);
        BeanUtils.copyProperties(itemOpcionalDTO, itemOpcional);
        ItemOpcional itemOpcionalAtualizado = itemOpcionalRepository.save(itemOpcional);
        ItemOpcionalDTO itemOpcionalAtualizadoDTO = new ItemOpcionalDTO();
        BeanUtils.copyProperties(itemOpcionalAtualizado, itemOpcionalAtualizadoDTO);
        return itemOpcionalAtualizadoDTO;
    }

    @Override
    public void deletarItemOpcional(String id) {
        itemOpcionalRepository.deleteById(id);
    }

    @Override
    public ItemOpcionalDTO buscarItemOpcionalPorId(String id) {
        ItemOpcional itemOpcional = itemOpcionalRepository.getOne(id);
        ItemOpcionalDTO itemOpcionalDTO = new ItemOpcionalDTO();
        BeanUtils.copyProperties(itemOpcional, itemOpcionalDTO);
        return itemOpcionalDTO;
    }
}

package com.fiap.Hackathon.mappers;

import com.fiap.Hackathon.dtos.ItemOpcionalReservadoDTO;
import com.fiap.Hackathon.entities.ItemOpcionalReservado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemOpcionalReservadoMapper {
    ItemOpcionalReservadoDTO toDTO(ItemOpcionalReservado itemOpcionalReservado);
    ItemOpcionalReservado toEntity(ItemOpcionalReservadoDTO itemOpcionalReservadoDTO);
}

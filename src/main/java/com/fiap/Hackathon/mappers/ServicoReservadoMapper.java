package com.fiap.Hackathon.mappers;

import com.fiap.Hackathon.dtos.ServicoReservadoDTO;
import com.fiap.Hackathon.entities.ServicoReservado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServicoReservadoMapper {

    ServicoReservadoDTO toDTO(ServicoReservado servicoReservado);
    ServicoReservado toEntity(ServicoReservadoDTO servicoReservadoDTO);
}

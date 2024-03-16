package com.fiap.Hackathon.mappers;

import com.fiap.Hackathon.dtos.ReservaDTO;
import com.fiap.Hackathon.entities.Reserva;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservaMapper {

    ReservaDTO toDTO(Reserva reserva);
    Reserva toEntity(ReservaDTO reservaDTO);
}

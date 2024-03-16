package com.fiap.Hackathon.mappers;

import com.fiap.Hackathon.dtos.QuartoReservadoDTO;
import com.fiap.Hackathon.entities.QuartoReservado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuartoReservadoMapper {

    QuartoReservadoDTO toDTO(QuartoReservado quartoReservado);
    QuartoReservado toEntity(QuartoReservadoDTO quartoReservadoDTO);
}

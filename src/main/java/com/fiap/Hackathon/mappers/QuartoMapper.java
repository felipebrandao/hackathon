package com.fiap.Hackathon.mappers;

import com.fiap.Hackathon.dtos.QuartoDTO;
import com.fiap.Hackathon.entities.Quarto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface QuartoMapper {

    QuartoDTO toDTO(Quarto quarto);
    Quarto toEntity(QuartoDTO quartoDTO);
}

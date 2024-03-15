package com.fiap.Hackathon.mappers;

import com.fiap.Hackathon.dtos.PredioDTO;
import com.fiap.Hackathon.entities.Predio;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PredioMapper {

    PredioDTO toDTO(Predio predio);
    Predio toEntity(PredioDTO predioDTO);
}

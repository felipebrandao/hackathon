package com.fiap.Hackathon.mappers;

import com.fiap.Hackathon.dtos.CamaDTO;
import com.fiap.Hackathon.entities.Cama;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CamaMapper {


    CamaDTO toDTO(Cama cama);


    Cama toEntity(CamaDTO camaDTO);
}

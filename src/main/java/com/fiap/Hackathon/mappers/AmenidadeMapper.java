package com.fiap.Hackathon.mappers;

import com.fiap.Hackathon.dtos.AmenidadeDTO;
import com.fiap.Hackathon.entities.Amenidade;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AmenidadeMapper {

    AmenidadeDTO toDTO(Amenidade amenidade);

    Amenidade toEntity(AmenidadeDTO amenidadeDTO);

}

package com.fiap.Hackathon.mappers;

import com.fiap.Hackathon.dtos.LocalidadeDTO;
import com.fiap.Hackathon.entities.Localidade;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocalidadeMapper {

    LocalidadeDTO toDTO(Localidade localidade);
    Localidade toEntity(LocalidadeDTO localidadeDTO);
}

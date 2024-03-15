package com.fiap.Hackathon.mappers;

import com.fiap.Hackathon.dtos.EnderecoDTO;
import com.fiap.Hackathon.entities.Endereco;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {

    Endereco toEntity(EnderecoDTO enderecoDTO);
    EnderecoDTO toDTO(Endereco endereco);

}
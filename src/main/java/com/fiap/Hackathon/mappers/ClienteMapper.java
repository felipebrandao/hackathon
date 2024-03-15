package com.fiap.Hackathon.mappers;

import com.fiap.Hackathon.dtos.ClienteDTO;
import com.fiap.Hackathon.entities.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente toEntity(ClienteDTO clienteDTO);
    ClienteDTO toDTO(Cliente cliente);
}

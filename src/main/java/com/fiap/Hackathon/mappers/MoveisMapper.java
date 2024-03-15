package com.fiap.Hackathon.mappers;

import com.fiap.Hackathon.dtos.MoveisDTO;
import com.fiap.Hackathon.entities.Moveis;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MoveisMapper {
    MoveisDTO toDTO(Moveis moveis);
    Moveis toEntity(MoveisDTO moveisDTO);
}

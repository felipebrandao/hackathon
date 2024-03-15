package com.fiap.Hackathon.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemOpcionalReservadoDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @JsonProperty
    private Long idItemOpcional;

    @JsonProperty
    private Long quantidade;
}

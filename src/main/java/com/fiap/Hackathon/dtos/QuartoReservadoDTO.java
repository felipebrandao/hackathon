package com.fiap.Hackathon.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuartoReservadoDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @JsonProperty
    private Long idQuarto;

    @JsonProperty
    private Long quantidade;
}

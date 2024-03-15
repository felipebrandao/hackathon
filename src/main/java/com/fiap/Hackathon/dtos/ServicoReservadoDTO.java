package com.fiap.Hackathon.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ServicoReservadoDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @JsonProperty
    private Long idServico;

    @JsonProperty
    private Long quantidade;
}

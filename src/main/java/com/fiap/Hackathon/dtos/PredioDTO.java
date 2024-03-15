package com.fiap.Hackathon.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PredioDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long idPredio;

    @JsonProperty
    private String nome;

    @JsonProperty
    private Long idLocalidade;
}

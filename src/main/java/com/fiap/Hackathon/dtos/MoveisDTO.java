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
public class MoveisDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long idMoveis;

    private String descricao;

    private Integer quantidade;

}

package com.fiap.Hackathon.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.Hackathon.enums.TipoBanheiroEnum;
import com.fiap.Hackathon.enums.TipoQuartoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuartoDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @JsonProperty
    private Long idPredio;

    @JsonProperty
    private TipoQuartoEnum tipoQuarto;

    @JsonProperty
    private int totalPessoas;

    @JsonProperty
    private List<CamaDTO> camas;

    @JsonProperty
    private List<MoveisDTO> moveis;

    @JsonProperty
    private TipoBanheiroEnum tipoBanheiro;

    @JsonProperty
    private BigDecimal valorDiaria;

    @JsonProperty
    private int quantidadeQuartos;

}

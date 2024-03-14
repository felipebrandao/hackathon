package com.fiap.Hackathon.dtos;

import com.fiap.Hackathon.enums.TipoBanheiroEnum;
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
@Builder
public class QuartoDTO {

    private UUID id;
    private String idPrédio;
    private String idLocalidade;
    private String tipo;
    private int totalPessoas;
    private int totalCamas;
    private List<String> outrosMoveis;
    private TipoBanheiroEnum tipoBanheiro;
    private BigDecimal valorDiaria;
    private int quantidadeQuartos;
}

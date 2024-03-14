package com.fiap.Hackathon.entities;

import com.fiap.Hackathon.enums.TipoQuartoEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Quarto {

    @Id
    private String id;
    private String idPredio;
    private String idLocalidade;
    private TipoQuartoEnum tipo;
    private int totalPessoas;
    private List<String> camas;
    private List<String> moveis;
    private String tipoBanheiro;
    private BigDecimal valorDiaria;
    private int quantidadeQuartos;
}

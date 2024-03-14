package com.fiap.Hackathon.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemOpcionalDTO {
    private String id;
    private String nome;
    private double valor;
}

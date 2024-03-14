package com.fiap.Hackathon.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservaDTO {
    private String id;
    private String idCliente;
    private List<String> idQuartos;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private List<String> idServicos;
    private List<String> idItensOpcionais;
}

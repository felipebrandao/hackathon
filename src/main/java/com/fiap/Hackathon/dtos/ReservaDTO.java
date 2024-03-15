package com.fiap.Hackathon.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @JsonProperty
    private Long idCliente;

    @JsonProperty
    private List<QuartoReservadoDTO> quartos;

    @JsonProperty
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataEntrada;

    @JsonProperty
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataSaida;

    @JsonProperty
    private List<ServicoReservadoDTO> servicos;

    @JsonProperty
    private List<ItemOpcionalReservadoDTO> itensOpcionais;
}

package com.fiap.Hackathon.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "reserva")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Reserva {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_cliente")
    private Long idCliente;

    @Column(name = "data_entrada")
    private LocalDate dataEntrada;

    @Column(name = "data_saida")
    private LocalDate dataSaida;

    @Column(name = "quantidade_pessoas")
    private int quantidadePessoas;

    @OneToMany(mappedBy = "reservaQuarto", fetch = FetchType.LAZY)
    private List<QuartoReservado> quartosReserva;

    @OneToMany(mappedBy = "reservaServico", fetch = FetchType.LAZY)
    private List<ServicoReservado> servicosReserva;

    @OneToMany(mappedBy = "reservaItemOpcional", fetch = FetchType.LAZY)
    private List<ItemOpcionalReservado> itemOpcionaisReserva;

}

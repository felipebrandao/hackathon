package com.fiap.Hackathon.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "servico_reservado")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ServicoReservado {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_reserva")
    private Long idReserva;

    @Column(name = "id_servico")
    private Long idServico;

    @Column(name = "quantidade")
    private Long quantidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reserva", referencedColumnName = "id", insertable = false, updatable = false)
    private Reserva reservaServico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_servico", referencedColumnName = "id", insertable = false, updatable = false)
    private Servico servicoReservado;
}
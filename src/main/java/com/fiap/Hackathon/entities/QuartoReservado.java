package com.fiap.Hackathon.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "quarto_reservado")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class QuartoReservado {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_reserva")
    private Long idReserva;

    @Column(name = "id_quarto")
    private Long idQuarto;

    @Column(name = "quantidade")
    private Long quantidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reserva", referencedColumnName = "id", insertable = false, updatable = false)
    private Reserva reservaQuarto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_quarto", referencedColumnName = "id", insertable = false, updatable = false)
    private Quarto quartoReservado;
}

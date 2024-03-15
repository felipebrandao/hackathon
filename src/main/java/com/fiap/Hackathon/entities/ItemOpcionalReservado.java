package com.fiap.Hackathon.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "item_opcional_reservado")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ItemOpcionalReservado {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_reserva")
    private Long idReserva;

    @Column(name = "id_item_opcional")
    private Long idItemOpcional;

    @Column(name = "quantidade")
    private Long quantidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reserva", referencedColumnName = "id", insertable = false, updatable = false)
    private Reserva reservaItemOpcional;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_servico", referencedColumnName = "id", insertable = false, updatable = false)
    private ItemOpcional itemOpcionalReservado;
}


package com.fiap.Hackathon.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "item_opcional")
@NoArgsConstructor
@Data
public class ItemOpcional {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "valor")
    private BigDecimal valor;

    @OneToMany(mappedBy = "itemOpcionalReservado", fetch = FetchType.LAZY)
    private List<ItemOpcionalReservado> itemOpcionaisReservado;

}

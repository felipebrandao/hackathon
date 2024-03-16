package com.fiap.Hackathon.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "amenidade")
@NoArgsConstructor
@Data
public class Amenidade {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAmenidade;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "id_predio")
    private Long idPredio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_predio", referencedColumnName = "id", insertable = false, updatable = false)
    private Predio predio;

}

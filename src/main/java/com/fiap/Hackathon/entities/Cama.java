package com.fiap.Hackathon.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "cama")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Cama {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_quarto")
    private Long idQuarto;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "quantidade")
    private Integer quantidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_quarto", referencedColumnName = "id", insertable = false, updatable = false)
    private Quarto camaQuarto;

}

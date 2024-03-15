package com.fiap.Hackathon.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "servico")
@NoArgsConstructor
@Data
public class Servico {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "valorPorPessoa")
    private BigDecimal valorPorPessoa;

    @OneToMany(mappedBy = "servicoReservado", fetch = FetchType.LAZY)
    private List<ServicoReservado> servicosReservado;

}

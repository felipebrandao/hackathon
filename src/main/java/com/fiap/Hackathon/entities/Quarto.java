package com.fiap.Hackathon.entities;

import com.fiap.Hackathon.enums.TipoBanheiroEnum;
import com.fiap.Hackathon.enums.TipoQuartoEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "quarto")
@NoArgsConstructor
@Data
public class Quarto {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_predio")
    private Long idPredio;

    @Column(name = "tipo_quarto")
    private TipoQuartoEnum tipoQuarto;

    @Column(name = "totalPessoas")
    private int totalPessoas;

    @Column(name = "tipo_banheiro")
    private TipoBanheiroEnum tipoBanheiro;

    @Column(name = "valor_diaria")
    private BigDecimal valorDiaria;

    private int quantidadeQuartos;

    @OneToMany(mappedBy = "camaQuarto", fetch = FetchType.LAZY)
    private List<Cama> camas;

    @OneToMany(mappedBy = "moveisQuarto", fetch = FetchType.LAZY)
    private List<Moveis> moveis;

    @OneToMany(mappedBy = "quartoReservado", fetch = FetchType.LAZY)
    private List<QuartoReservado> quartosReservado;

}

package com.fiap.Hackathon.entities;

import com.fiap.Hackathon.enums.TipoBanheiroEnum;
import com.fiap.Hackathon.enums.TipoQuartoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

import static jakarta.persistence.EnumType.STRING;

@Entity
@Table(name = "quarto")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Quarto {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_predio")
    private Long idPredio;

    @Column(name = "tipo_quarto")
    @Enumerated(STRING)
    private TipoQuartoEnum tipoQuarto;

    @Column(name = "totalPessoas")
    private int totalPessoas;

    @Column(name = "tipo_banheiro")
    @Enumerated(STRING)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_predio", referencedColumnName = "id", insertable = false, updatable = false)
    private Predio predioQuarto;

//    public Quarto(Long idPredio, TipoQuartoEnum tipoQuarto, int totalPessoas, TipoBanheiroEnum tipoBanheiro, BigDecimal valorDiaria, int quantidadeQuartos, List<Cama> camas, List<Moveis> moveis) {
//        this.idPredio = idPredio;
//        this.tipoQuarto = tipoQuarto;
//        this.totalPessoas = totalPessoas;
//        this.tipoBanheiro = tipoBanheiro;
//        this.valorDiaria = valorDiaria;
//        this.quantidadeQuartos = quantidadeQuartos;
//        this.camas = camas;
//        this.moveis = moveis;
//    }
}

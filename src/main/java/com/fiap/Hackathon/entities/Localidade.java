package com.fiap.Hackathon.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "localidade")
@NoArgsConstructor
@Data
public class Localidade {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "id_endereco")
    private Long idEndereco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_endereco", referencedColumnName = "id", insertable = false, updatable = false)
    private Endereco endereco;

    @OneToMany(mappedBy = "localidade", fetch = FetchType.LAZY)
    private List<Predio> predios;
}

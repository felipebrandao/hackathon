package com.fiap.Hackathon.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "predio")
@NoArgsConstructor
@Data
public class Predio {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "id_localidade")
    private Long idLocalidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_localidade", referencedColumnName = "id", insertable = false, updatable = false)
    private Localidade localidade;

    @OneToMany(mappedBy = "predio", fetch = FetchType.LAZY)
    private List<Amenidade> amenidades;

}

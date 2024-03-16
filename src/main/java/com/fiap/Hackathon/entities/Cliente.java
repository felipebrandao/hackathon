package com.fiap.Hackathon.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "cliente")
@NoArgsConstructor
@Data
public class Cliente {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pais_origem")
    private String paisOrigem;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "passaporte")
    private String passaporte;

    @Column(name = "nome_completo")
    private String nomeCompleto;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "endereco_pais_origem")
    private String enderecoPaisOrigem;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "clienteReserva", fetch = FetchType.LAZY)
    private List<Reserva> ReservaCliente;

    public Cliente(String paisOrigem, String cpf, String passaporte, String nomeCompleto, LocalDate dataNascimento, String enderecoPaisOrigem, String telefone, String email) {
        this.paisOrigem = paisOrigem;
        this.cpf = cpf;
        this.passaporte = passaporte;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.enderecoPaisOrigem = enderecoPaisOrigem;
        this.telefone = telefone;
        this.email = email;
    }
}

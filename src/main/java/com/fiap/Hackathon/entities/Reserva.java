package com.fiap.Hackathon.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Reserva {
    @Id
    private String id;
    private String idCliente;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private int quantidadePessoas;
    private String[] idsQuartos;
    private String[] idsOpcionais;
    // getters e setters
}

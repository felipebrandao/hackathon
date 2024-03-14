package com.fiap.Hackathon.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Servico {
    @Id
    private String id;
    private String nome;
    private double valorPorPessoa;
}

package com.fiap.Hackathon.repositories;

import com.fiap.Hackathon.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
}

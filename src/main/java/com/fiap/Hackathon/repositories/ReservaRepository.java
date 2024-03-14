package com.fiap.Hackathon.repositories;

import com.fiap.Hackathon.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, String> {
}

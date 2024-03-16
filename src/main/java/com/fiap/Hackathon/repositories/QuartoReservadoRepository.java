package com.fiap.Hackathon.repositories;

import com.fiap.Hackathon.entities.QuartoReservado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuartoReservadoRepository extends JpaRepository<QuartoReservado, Long> {
}

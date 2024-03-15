package com.fiap.Hackathon.repositories;

import com.fiap.Hackathon.entities.Predio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PredioRepository extends JpaRepository<Predio, Long> {
}

package com.fiap.Hackathon.repositories;

import com.fiap.Hackathon.entities.ServicoReservado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoReservadoRepository extends JpaRepository<ServicoReservado, Long> {

}

package com.fiap.Hackathon.repositories;

import com.fiap.Hackathon.entities.ItemOpcionalReservado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemOpcionalReservadoRepository extends JpaRepository<ItemOpcionalReservado, Long> {
}

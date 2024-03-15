package com.fiap.Hackathon.repositories;

import com.fiap.Hackathon.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByCpf(String cpf);

    @Query("SELECT c FROM Cliente c WHERE c.id = :id AND c.cpf = :cpf")
    Cliente findByIdAndCPF(@Param("id") Long id, @Param("cpf") String cpf);
}

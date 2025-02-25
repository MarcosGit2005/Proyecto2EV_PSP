package com.example.proyecto2ev_psp.repository;

import com.example.proyecto2ev_psp.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    Cliente getById(Long id);
}

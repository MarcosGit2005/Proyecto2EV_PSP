package com.example.proyecto2ev_psp.repository;

import com.example.proyecto2ev_psp.model.Cliente;
import com.example.proyecto2ev_psp.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long> {
    Pedido getById(Long id);
    List<Pedido> getAllByCliente(Cliente cliente);
}

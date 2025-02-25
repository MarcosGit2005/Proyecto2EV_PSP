package com.example.proyecto2ev_psp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity(name = "pedido")
public class Pedido extends TimeStampedPersistableObject{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación N:1 con Cliente
    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente", nullable = false)
    private Cliente cliente;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal total;
}
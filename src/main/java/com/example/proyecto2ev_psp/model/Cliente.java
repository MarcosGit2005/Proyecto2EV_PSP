package com.example.proyecto2ev_psp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name="cliente")
public class Cliente extends TimeStampedPersistableObject{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

}
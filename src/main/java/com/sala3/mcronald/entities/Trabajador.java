package com.sala3.mcronald.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "trabajador")
@Table(name = "TRABAJADOR")
public class Trabajador {

    @Column(name = "nombre", nullable = false)
    private double nombre;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}

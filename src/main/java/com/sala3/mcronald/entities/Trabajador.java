package com.sala3.mcronald.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "trabajador")
@Table(name = "TRABAJADOR")
public class Trabajador {

    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTrabajador;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Pedido> pedidos;

    public Trabajador(String nombre){
        this.nombre = nombre;
    }
}

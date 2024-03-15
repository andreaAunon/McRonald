package com.sala3.mcronald.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity(name = "almacen")
@Table(name = "ALMACEN")
public class Almacen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    private Set<Producto> productos;

    public Almacen() {
    }

    public Almacen(String name, Set<Producto> productos) {
        this.name = name;
        this.productos = productos;
    }
}

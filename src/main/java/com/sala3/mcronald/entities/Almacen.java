package com.sala3.mcronald.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
    @JoinTable(
            name = "almacen_producto",
            joinColumns = @JoinColumn(name = "almacen_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    private List<Producto> productos;

    public Almacen() {
    }

    public Almacen(String name, List<Producto> productos) {
        this.name = name;
        this.productos = productos;
    }
}

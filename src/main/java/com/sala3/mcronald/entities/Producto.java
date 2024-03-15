package com.sala3.mcronald.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "producto")
@Table(name = "PRODUCTO")
public class Producto {

    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "descripcion", nullable = true)
    private String descripcion;
    @Column(name = "precio", nullable = false)
    private double precio;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(mappedBy = "productos")
    private List<Almacen> almacenes;

    public Producto() {
    }

    public Producto(String nombre, String descripcion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

}
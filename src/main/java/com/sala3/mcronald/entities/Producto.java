package com.sala3.mcronald.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    public Producto() {
    }

    public Producto(String nombre, String descripcion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

}

//Ejercicio Spring MVC
//--------------------
//
//Diseño y desarrollo de la webapp del McRonald's
//El diseño será libre, como mínimo tiene que contar con 5 vistas (Index + 4 flujos), 4 controladores,
//        4 servicios y 4 entities
//- Flujo Almacén: Consulta, adición y eliminación de productos en almacén como mínimo
//- Flujo Pedido: Consulta, alta, modificación y cancelación de pedidos (Con las comprobaciones y acciones oportunas
//        sobre el almacén)
//- Flujo Carta: Consulta, alta, modificación y cancelación de productos disponibles (Menús, productos sueltos...)
//- Flujo Plantilla: Administración de la plantilla de trabajadores, con altas, bajas y asignación a pedidos.
//
//        Valorable:
//        - Diseño del frontal
//- Uso correcto de los logs
//- Uso de aspectos para logs y control de excepciones
//- Uso correcto de los verbos en los controladores
//- Clean code
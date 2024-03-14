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
@Entity(name = "pedido")
@Table(name = "PEDIDO")
public class Pedido {


    @Column(name = "importe", nullable = false)
    private double importe;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<Producto> productos;
    //@OneToMany
    //private Trabajador productos;

}

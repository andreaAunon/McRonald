package com.sala3.mcronald.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


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
    private Long idPedido;

    @ManyToMany
    private List<Producto> productos;
    @ManyToOne
    @JoinColumn(name="idTrabajador")
    @Cascade(CascadeType.SAVE_UPDATE)
    private Trabajador trabajador;

    public Pedido(double importe, Trabajador trabajador){
        this.importe = importe;
        this.trabajador = trabajador;
    }

}

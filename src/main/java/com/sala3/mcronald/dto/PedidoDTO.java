package com.sala3.mcronald.dto;

import com.sala3.mcronald.entities.Pedido;
import com.sala3.mcronald.entities.Producto;
import com.sala3.mcronald.entities.Trabajador;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PedidoDTO {

    private double importe;
    private Long id;
    private Trabajador trabajador;
    private List<Producto> productos;

    public PedidoDTO(){

    }

    public PedidoDTO(double importe, Trabajador trabajador){
        this.importe = importe;
        this.trabajador = trabajador;
    }

}

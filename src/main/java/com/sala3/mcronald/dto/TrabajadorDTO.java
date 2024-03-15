package com.sala3.mcronald.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrabajadorDTO {

    private String nombre;
    private Long idTrabajador;

    public TrabajadorDTO(String nombre){
        this.nombre = nombre;
    }
}

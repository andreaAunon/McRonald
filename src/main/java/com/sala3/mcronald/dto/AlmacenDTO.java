package com.sala3.mcronald.dto;

import com.sala3.mcronald.entities.Producto;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class AlmacenDTO {

    private Long id;
    private String nombre;

    public AlmacenDTO() {
    }

    public AlmacenDTO(Long id, String name) {
        this.nombre = name;
    }
}

package com.sala3.mcronald.service;

import com.sala3.mcronald.entities.Almacen;
import com.sala3.mcronald.entities.Producto;
import jakarta.persistence.*;

public interface IAlmacenService {
    Long crearAlmacen(String nombre);
    Almacen cogerAlmacen(Long idAlmacen);
    void añadirProducto(Producto producto, Almacen almacen);
    int eliminarProducto(Long idProducto, Almacen almacen);
}

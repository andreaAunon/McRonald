package com.sala3.mcronald.service;

import com.sala3.mcronald.dto.AlmacenDTO;
import com.sala3.mcronald.dto.ProductoDTO;
import com.sala3.mcronald.entities.Almacen;
import com.sala3.mcronald.entities.Producto;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

public interface IAlmacenService {
    Long crearAlmacen(String nombre);
    Almacen cogerAlmacen(Long idAlmacen);
    List<AlmacenDTO> listarAlmacenes();
    void añadirProducto(Producto producto, Almacen almacen);
    List<ProductoDTO> getListaProductos(Almacen almacen);
    int eliminarProducto(Long idProducto, Almacen almacen);
}

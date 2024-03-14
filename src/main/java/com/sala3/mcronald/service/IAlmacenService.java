package com.sala3.mcronald.service;

import jakarta.persistence.*;

public interface IAlmacenService {
    Long createAlmacen(String nombre);
    void addProducto(String nombre, String descripcion, Double precio, int idAlmacen);
    void deleteProducto();
}

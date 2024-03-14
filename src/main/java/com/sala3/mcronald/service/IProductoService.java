package com.sala3.mcronald.service;

import com.sala3.mcronald.entities.Producto;

import java.util.List;

public interface IProductoService {

    public Producto consultarProductoPorId(Long id);
    public void eliminarProductoPorId(Long id);
    public void actualizarProducto(Producto producto);
    public void guardarProducto(Producto producto);
    public List<Producto> consultarTodosLosProductos();
}

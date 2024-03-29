package com.sala3.mcronald.service;

import com.sala3.mcronald.entities.Almacen;
import com.sala3.mcronald.entities.Producto;

import java.util.List;
import java.util.Set;

public interface IProductoService {

    public Producto consultarProductoPorId(Long id);
    public void eliminarProductoPorId(Long id);
    public void actualizarProducto(Producto producto);
    public Producto guardarProducto(Producto producto, Almacen almacen);
    public Producto getProducto(Set<Producto> productos, int idProducto);
    public List<Producto> consultarTodosLosProductos();
}

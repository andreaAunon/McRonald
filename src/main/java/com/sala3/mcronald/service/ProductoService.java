package com.sala3.mcronald.service;

import com.sala3.mcronald.entities.Producto;
import com.sala3.mcronald.repository.ProductoRepository;

import java.util.List;

public class ProductoService implements IProductoService {

    private final ProductoRepository productRepository;

    public ProductoService(ProductoRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public Producto consultarProductoPorId(Long id) {
        return null;
    }

    @Override
    public void eliminarProductoPorId(Long id) {

    }

    @Override
    public void actualizarProducto(Producto producto) {

    }

    @Override
    public void guardarProducto(Producto producto) {

    }

    @Override
    public List<Producto> consultarTodosLosProductos() {
        return null;
    }
}

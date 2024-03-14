package com.sala3.mcronald.service;

import com.sala3.mcronald.entities.Almacen;
import com.sala3.mcronald.entities.Producto;
import com.sala3.mcronald.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
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
    public Producto guardarProducto(Producto producto, Almacen almacen) {
        List<Almacen> almacenes = new ArrayList<>();
        if(producto.getAlmacenes() != null){
            almacenes = producto.getAlmacenes();
        }
        almacenes.add(almacen);
        producto.setAlmacenes(almacenes);
        productRepository.save(producto);
        return producto;
    }

    @Override
    public Producto getProducto(List<Producto> productos, int idProducto) {
        Producto productoBuscado;
        for(Producto producto : productos){
            if(producto.getId() == idProducto){
                productoBuscado = producto;
                return productoBuscado;
            }
        }
        return null;
    }

    @Override
    public List<Producto> consultarTodosLosProductos() {
        return null;
    }
}

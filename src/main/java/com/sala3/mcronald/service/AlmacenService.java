package com.sala3.mcronald.service;

import com.sala3.mcronald.entities.Almacen;
import com.sala3.mcronald.entities.Producto;
import com.sala3.mcronald.repository.AlmacenRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AlmacenService implements IAlmacenService{
    @Autowired
    private AlmacenRepository almacenRepository;

    @Override
    public Long crearAlmacen(String nombre) {
        List<Producto> productos = new ArrayList<>();
        Almacen almacen = new Almacen(nombre, productos);

        almacenRepository.save(almacen);
        Long id = almacen.getId();
        return null;
    }

    @Override
    public Almacen cogerAlmacen(Long idAlmacen) {
        Almacen almacen = almacenRepository.findById(idAlmacen).orElse(null);
        return almacen;
    }

    @Override
    public void añadirProducto(Producto producto, Almacen almacen) {
        List<Producto> productos = new ArrayList<>();
        if(producto.getAlmacenes() != null){
            productos = almacen.getProductos();
        }
        productos.add(producto);
        almacen.setProductos(productos);
        almacenRepository.save(almacen);
    }

    public Long crearAlmacenSin() {
        List<Producto> productos = new ArrayList<>();
        Almacen almacen = new Almacen("AlmacenPrueba", productos);

        almacenRepository.save(almacen);
        return almacen.getId();
    }



    @Override
    public int eliminarProducto(Long idProducto, Almacen almacen) {
        Producto productoBuscado;
        List<Producto> productos = almacen.getProductos();

        for(Producto producto : productos){
            if(producto.getId() == idProducto){
                productos.remove(producto);
                return 1;
            }
        }
        return 0;
    }
}

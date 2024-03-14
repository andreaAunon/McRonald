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
    public Long createAlmacen(String nombre) {
        List<Producto> productos = new ArrayList<>();
        Almacen almacen = new Almacen(nombre, productos);

        almacenRepository.save(almacen);
        Long id = almacen.getId();
        return null;
    }

    @Override
    public void addProducto(String nombre, String descripcion, Double precio, int idAlmacen) {
        
    }

    public Long createAlmacenSin() {
        List<Producto> productos = new ArrayList<>();
        Almacen almacen = new Almacen("AlmacenPrueba", productos);

        almacenRepository.save(almacen);
        return almacen.getId();
    }



    @Override
    public void deleteProducto() {

    }
}

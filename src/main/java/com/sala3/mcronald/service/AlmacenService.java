package com.sala3.mcronald.service;

import com.sala3.mcronald.dto.AlmacenDTO;
import com.sala3.mcronald.dto.ProductoDTO;
import com.sala3.mcronald.entities.Almacen;
import com.sala3.mcronald.entities.Producto;
import com.sala3.mcronald.repository.AlmacenRepository;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.Array2DHashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class AlmacenService implements IAlmacenService{
    @Autowired
    private AlmacenRepository almacenRepository;

    @Override
    public Long crearAlmacen(String nombre) {
        Set<Producto> productos = null;
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
    public List<AlmacenDTO> listarAlmacenes() {
        List<AlmacenDTO> almacenesdto = new ArrayList();
        for(Almacen almacen : almacenRepository.findAll()){
            AlmacenDTO almacenDTO = new AlmacenDTO();
            almacenDTO.setName(almacen.getName());
            almacenDTO.setId(almacen.getId());
            almacenesdto.add(almacenDTO);
        };
        return almacenesdto;
    }

    @Override
    public void añadirProducto(Producto producto, Almacen almacen) {
        Set<Producto> productos = null;
        if(producto.getAlmacenes() != null){
            productos = almacen.getProductos();
        }
        productos.add(producto);
        almacen.setProductos(productos);
        almacenRepository.save(almacen);
    }

    @Override
    public List<ProductoDTO> getListaProductos(Almacen almacen) {
        List<ProductoDTO> productosDTO = new ArrayList<>();
        for (Producto producto : almacen.getProductos()) {
            ProductoDTO productoDTO = new ProductoDTO();
            productoDTO.setId(producto.getIdProducto());
            productoDTO.setNombre(producto.getNombre());
            productoDTO.setDescripcion(producto.getDescripcion());
            productoDTO.setPrecio(producto.getPrecio());
            productosDTO.add(productoDTO);
        }
        return productosDTO;
    }

    public Long crearAlmacenSin() {
        Set<Producto> productos = null;
        Almacen almacen = new Almacen("AlmacenPrueba", productos);

        almacenRepository.save(almacen);
        return almacen.getId();
    }



    @Override
    public int eliminarProducto(Long idProducto, Almacen almacen) {
        Set<Producto> productos = almacen.getProductos();

        for(Producto producto : productos){
            if(producto.getIdProducto() == idProducto){
                productos.remove(producto);
                almacen.setProductos(productos);
                almacenRepository.save(almacen);
                return 1;
            }
        }
        return 0;
    }
}

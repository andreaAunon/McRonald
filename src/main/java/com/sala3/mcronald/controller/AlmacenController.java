package com.sala3.mcronald.controller;

import com.sala3.mcronald.entities.Almacen;
import com.sala3.mcronald.entities.Producto;
import com.sala3.mcronald.service.AlmacenService;
import com.sala3.mcronald.service.ProductoService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/almacen")
public class AlmacenController {
    @Autowired
    private AlmacenService almacenService;
    @Autowired
    private ProductoService productoService;
    @PostConstruct
    @PostMapping("/createSinParams")
    public Long crearAlmacenSinParams(){
        return almacenService.crearAlmacenSin();
    }
    @PostMapping("/")
    public Long crearAlmacen(@RequestParam String nombre){
        return almacenService.crearAlmacen(nombre);
    }

    @PostMapping("/producto")
    public int añadirProducto(@RequestParam String nombre,@RequestParam String descripcion, @RequestParam Double precio,
                              @RequestParam Long idAlmacen){
        Producto producto = new Producto(nombre, descripcion, precio);
        Almacen almacen = almacenService.cogerAlmacen(idAlmacen);
        productoService.guardarProducto(producto, almacen);
        almacenService.añadirProducto(producto, almacen);
        return 1;
    }

    @GetMapping("/productos")
    public List<Producto> getProductos(@RequestParam Long idAlmacen){
        Almacen almacen = almacenService.cogerAlmacen(idAlmacen);
        return almacen.getProductos();
    }
    @GetMapping("/productos/{idProducto}")
    public Producto getProducto(@PathVariable int idProducto, @RequestParam Long idAlmacen){
        Almacen almacen = almacenService.cogerAlmacen(idAlmacen);
        return productoService.getProducto(almacen.getProductos(), idProducto);
    }

    @DeleteMapping("/productos/{idProducto}")
    public int eliminarProducto(@PathVariable Long idProducto, @RequestParam Long idAlmacen){
        Almacen almacen = almacenService.cogerAlmacen(idAlmacen);
        return almacenService.eliminarProducto(idProducto, almacen);
    }

}

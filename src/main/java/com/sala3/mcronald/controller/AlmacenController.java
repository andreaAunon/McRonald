package com.sala3.mcronald.controller;

import com.sala3.mcronald.dto.AlmacenDTO;
import com.sala3.mcronald.dto.ProductoDTO;
import com.sala3.mcronald.entities.Almacen;
import com.sala3.mcronald.entities.Producto;
import com.sala3.mcronald.service.AlmacenService;
import com.sala3.mcronald.service.ProductoService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
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
    @GetMapping("")
    public String listarAlmacenes(Model model){
        model.addAttribute("almacenes", almacenService.listarAlmacenes()); // Pasar la lista de almacenes a la plantilla
        return "almacen";
    }
    @PostMapping("/producto")
    public ResponseEntity<String> añadirProducto(@RequestParam String nombre, @RequestParam String descripcion, @RequestParam Double precio,
                                                 @RequestParam Long idAlmacen){
        Producto producto = new Producto(nombre, descripcion, precio);
        Almacen almacen = almacenService.cogerAlmacen(idAlmacen);
        productoService.guardarProducto(producto, almacen);
        almacenService.añadirProducto(producto, almacen);
        return ResponseEntity.ok().body("<script>window.location='/almacen/productos?idAlmacen=" + idAlmacen + "'</script>");
    }

    @GetMapping("/productos")
    public String getProductos(@RequestParam Long idAlmacen, Model model){
        Almacen almacen = almacenService.cogerAlmacen(idAlmacen);
        model.addAttribute("productos", almacenService.getListaProductos(almacen));
        model.addAttribute("idAlmacen", idAlmacen);
        return "almacen/productos";
    }
    @GetMapping("/productos/{idProducto}")
    public Producto getProducto(@PathVariable int idProducto, @RequestParam Long idAlmacen){
        Almacen almacen = almacenService.cogerAlmacen(idAlmacen);
        return productoService.getProducto(almacen.getProductos(), idProducto);
    }

    @DeleteMapping("/productos/{idProducto}")
    public ResponseEntity<String> eliminarProducto(@PathVariable Long idProducto, @RequestParam Long idAlmacen, Model model){
        Almacen almacen = almacenService.cogerAlmacen(idAlmacen);
        model.addAttribute("productos", almacenService.getListaProductos(almacen));
        model.addAttribute("idAlmacen", idAlmacen);
        almacenService.eliminarProducto(idProducto, almacen);
        return ResponseEntity.ok().body("<script>window.location='/almacen/productos?idAlmacen=" + idAlmacen + "'</script>");

    }

}

package com.sala3.mcronald.controller;

import com.sala3.mcronald.service.AlmacenService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/almacen")
public class AlmacenController {
    @Autowired
    private AlmacenService almacenService;
    @PostConstruct
    @PostMapping("/createSinParams")
    public Long createAlmacenSinParams(){
        return almacenService.createAlmacenSin();
    }
    @PostMapping("/")
    public Long createAlmacen(String nombre){
        return almacenService.createAlmacen(nombre);
    }
}

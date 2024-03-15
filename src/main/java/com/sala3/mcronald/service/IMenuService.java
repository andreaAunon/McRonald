package com.sala3.mcronald.service;

import com.sala3.mcronald.dto.newMenuRequest;
import com.sala3.mcronald.entities.Menu;
import com.sala3.mcronald.entities.Producto;

import java.util.List;

public interface IMenuService {

    public Menu consultarMenuPorId(Long id);
    public List<Menu> consultarTodosLosMenus();
    public void eliminarMenuPorId(Long id);
    public void actualizarMenu(Menu menu);

    void guardarMenu(newMenuRequest menu);

    public List<Producto> consultarProductos(Long id);
}

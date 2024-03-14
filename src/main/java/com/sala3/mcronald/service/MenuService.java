package com.sala3.mcronald.service;

import com.sala3.mcronald.entities.Menu;
import com.sala3.mcronald.entities.Producto;
import com.sala3.mcronald.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService implements IMenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }


    @Override
    public Menu consultarMenuPorId(Long id) {
        return null;
    }

    @Override
    public List<Menu> consultarTodosLosMenus() {
        return null;
    }

    @Override
    public void eliminarMenuPorId(Long id) {

    }

    @Override
    public void actualizarMenu(Menu menu) {

    }

    @Override
    public void guardarMenu(Menu menu) {

    }

    @Override
    public List<Producto> consultarProductos(Long id) {
        return null;
    }
}

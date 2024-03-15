package com.sala3.mcronald.service;

import com.sala3.mcronald.dto.newMenuRequest;
import com.sala3.mcronald.entities.Menu;
import com.sala3.mcronald.entities.Producto;
import com.sala3.mcronald.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService implements IMenuService {

    private final MenuRepository menuRepository;
    private final ProductoService productoService;

    public MenuService(MenuRepository menuRepository, ProductoService productoService) {
        this.menuRepository = menuRepository;
        this.productoService = productoService;
    }


    @Override
    public Menu consultarMenuPorId(Long id) {
        return menuRepository.findById(id).get();
    }

    @Override
    public List<Menu> consultarTodosLosMenus() {
        return menuRepository.findAll();
    }

    @Override
    public void eliminarMenuPorId(Long id) {
        menuRepository.deleteById(id);
    }

    @Override
    public void actualizarMenu(Menu menu) {
        Menu menuToUpdate = menuRepository.findById(menu.getId()).get();
        menu = menuToUpdate;
        menuRepository.save(menu);

    }

    @Override
    public void guardarMenu(newMenuRequest menu) {
        Menu newMenu = new Menu(menu.getNombre(), menu.getPrecio(), menu.getDescripcion() );
        menuRepository.save(newMenu);
    }

    @Override
    public List<Producto> consultarProductos(Long id) {
        //return productoService.consultarProductosPorMenu(id);
        return null;
    }
}

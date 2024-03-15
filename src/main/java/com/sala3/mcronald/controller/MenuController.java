package com.sala3.mcronald.controller;

import com.sala3.mcronald.dto.newMenuRequest;
import com.sala3.mcronald.entities.Menu;
import com.sala3.mcronald.service.MenuService;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RestController
public class MenuController {

    private final MenuService menuService;
    MenuController(MenuService menuService) {
        this.menuService = menuService;
    }
    @GetMapping("/menu/{id}")
    public Map<String, Menu> getMenu(@PathVariable("id") Long id, Model model) {
        System.out.println("GET /menu/{id}");
        Menu menu = menuService.consultarMenuPorId(id);
        Map<String, Menu> response = new HashMap<>();
        response.put("data",menu);
        return response;
    }
    @GetMapping("/menus")
    public Map<String, List<Menu>> getMenus() {
        System.out.println("GET /menus");
        List<Menu> menus = menuService.consultarTodosLosMenus();
        Map<String, List<Menu>> response = new HashMap<>();
        response.put("data",menus);
        return response;
    }

    @DeleteMapping("/menu/{id}")
    public Map<String, Boolean> deleteMenu(@PathVariable("id") Long id) {
        System.out.println("DELETE /menu/{id}");
        menuService.eliminarMenuPorId(id);
        return Map.of("success", true);
    }

    @PostMapping("/menu")
    public Map<String, Boolean> saveMenu(@RequestBody newMenuRequest menu) {
        System.out.println("POST /menu");
        menuService.guardarMenu(menu);
        return Map.of("success", true);
    }
    @PutMapping("/menu")
    public Map<String, Boolean> updateMenu(@RequestBody Menu menu) {
        System.out.println("PUT /menu");
        menuService.actualizarMenu(menu);
        return Map.of("success", true);
    }
    


}

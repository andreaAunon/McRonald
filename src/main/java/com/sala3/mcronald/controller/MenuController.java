package com.sala3.mcronald.controller;

import com.sala3.mcronald.entities.Menu;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
public class MenuController {
    @GetMapping("/menu")
    public String getMenu(Model model) {
        System.out.println("GET /menu");
        Menu menu = new Menu();
        model.addAttribute("menu", menu);
        return "menu_form";
    }
    @PostMapping("/menu")
    public String saveMenu(@ModelAttribute("user") Menu menu) {
        System.out.println(menu);
        return "menu_form";
    }
}

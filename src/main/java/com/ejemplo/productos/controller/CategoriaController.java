package com.ejemplo.productos.controller;

import com.ejemplo.productos.model.Categoria;
import com.ejemplo.productos.service.CategoriaServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaServiceImpl service;

    public CategoriaController(CategoriaServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("categorias", service.listar());
        model.addAttribute("categoria", new Categoria());
        return "categorias";
    }

    @PostMapping
    public String guardar(@ModelAttribute Categoria categoria) {
        service.guardar(categoria);
        return "redirect:/categorias";
    }
}
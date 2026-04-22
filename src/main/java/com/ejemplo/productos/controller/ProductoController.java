package com.ejemplo.productos.controller;

import com.ejemplo.productos.model.Producto;
import com.ejemplo.productos.service.ProductoServiceImpl;
import com.ejemplo.productos.service.CategoriaServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoServiceImpl productoService;
    private final CategoriaServiceImpl categoriaService;

    public ProductoController(ProductoServiceImpl productoService, CategoriaServiceImpl categoriaService) {
        this.productoService = productoService;
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("productos", productoService.listar());
        model.addAttribute("categorias", categoriaService.listar());
        model.addAttribute("producto", new Producto());
        return "productos";
    }

    @PostMapping
    public String guardar(@ModelAttribute Producto producto) {
        productoService.guardar(producto);
        return "redirect:/productos";
    }
}
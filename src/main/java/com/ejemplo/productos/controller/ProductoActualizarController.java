package com.ejemplo.productos.controller;

import com.ejemplo.productos.model.Producto;
import com.ejemplo.productos.service.CategoriaServiceImpl;
import com.ejemplo.productos.service.ProductoServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("productos_actualizar")
public class ProductoActualizarController {
    private final ProductoServiceImpl productoService;
    private final CategoriaServiceImpl categoriaService;

    public ProductoActualizarController(ProductoServiceImpl productoService, CategoriaServiceImpl categoriaService){
        this.productoService = productoService;
        this.categoriaService = categoriaService;
    }

    @GetMapping("/rellenar/{id}")
    public String rellenar(@PathVariable Long id, Model model){
        Producto producto = productoService.obtenerPorId(id).get();
        model.addAttribute("producto", producto);
        model.addAttribute("categorias", categoriaService.listar());
        return "productos_actualizar";
    }

    @PostMapping
    public String guardar(Producto producto){
        productoService.guardar(producto);
        return "redirect:/productos";
    }
}

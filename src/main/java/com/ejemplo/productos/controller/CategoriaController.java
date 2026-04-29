package com.ejemplo.productos.controller;

import com.ejemplo.productos.model.Categoria;
import com.ejemplo.productos.service.CategoriaServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador encargado de gestionar las operaciones relacionadas con las categorías.
 *
 * Maneja las peticiones HTTP para listar y guardar categorías dentro de la aplicación.
 *
 * @author Héctor Crespo
 * @version 1.0
 */
@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    /**
     * Servicio que contiene la lógica de negocio para las categorías.
     */
    private final CategoriaServiceImpl service;

    /**
     * Constructor que inyecta el servicio de categorías.
     *
     * @param service servicio de categorías
     */
    public CategoriaController(CategoriaServiceImpl service)     {
        this.service = service;
    }

    /**
     * Maneja las peticiones GET para listar todas las categorías.
     *
     * Añade la lista de categorías al modelo para que sea accesible en la vista.
     *
     * @param model objeto que transporta datos a la vista
     * @return nombre de la vista que muestra las categorías
     */
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("categorias", service.listar());
        // model.addAttribute("categoria", new Categoria());
        return "categorias";
    }

    /**
     * Maneja las peticiones POST para guardar una nueva categoría.
     *
     * Recibe una categoría desde el formulario, la guarda mediante el servicio
     * y redirige a la lista de categorías.
     *
     * @param categoria objeto categoría a guardar
     * @return redirección a la lista de categorías
     */
    @PostMapping
    public String guardar(@ModelAttribute Categoria categoria) {
        service.guardar(categoria);
        return "redirect:/categorias";
    }
}
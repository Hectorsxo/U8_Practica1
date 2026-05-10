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

/**
 * Controlador encargado de gestionar la actualización de productos existentes.
 * Proporciona las rutas necesarias para cargar los datos de un producto en el formulario
 * y procesar los cambios realizados.
 *
 * @author Héctor Crespo
 * @version 1.0
 */
@Controller
@RequestMapping("productos_actualizar")
public class ProductoActualizarController {

    private final ProductoServiceImpl productoService;
    private final CategoriaServiceImpl categoriaService;

    /**
     * Constructor para la inyección de dependencias de los servicios necesarios.
     *
     * @param productoService Servicio para la gestión de operaciones de productos.
     * @param categoriaService Servicio para la gestión de operaciones de categorías.
     */
    public ProductoActualizarController(ProductoServiceImpl productoService, CategoriaServiceImpl categoriaService){
        this.productoService = productoService;
        this.categoriaService = categoriaService;
    }

    /**
     * Recupera los datos de un producto específico y los carga en el modelo para editar.
     * Además, carga la lista de categorías disponibles para el selector del formulario.
     *
     * @param id Identificador único del producto que se desea editar.
     * @param model Objeto Model de Spring para pasar datos a la vista.
     * @return El nombre de la vista (template) para el formulario de actualización.
     */
    @GetMapping("/rellenar/{id}")
    public String rellenar(@PathVariable Long id, Model model){
        Producto producto = productoService.obtenerPorId(id).get();
        model.addAttribute("producto", producto);
        model.addAttribute("categorias", categoriaService.listar());
        return "productos_actualizar";
    }

    /**
     * Procesa la solicitud de guardado del producto con los datos actualizados.
     * Tras guardar los cambios, redirige al listado general de productos.
     *
     * @param producto Objeto Producto vinculado con los datos enviados desde el formulario.
     * @return Una cadena de redirección a la ruta principal de productos.
     */
    @PostMapping
    public String guardar(Producto producto){
        productoService.guardar(producto);
        return "redirect:/productos";
    }
}
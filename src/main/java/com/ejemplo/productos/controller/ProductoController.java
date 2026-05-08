package com.ejemplo.productos.controller;

import com.ejemplo.productos.model.Producto;
import com.ejemplo.productos.service.ProductoServiceImpl;
import com.ejemplo.productos.service.CategoriaServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador encargado de gestionar las operaciones relacionadas con los productos.
 *
 * Permite listar los productos y registrar nuevos productos en el sistema.
 *
 * @author Héctor Crespo
 * @version 1.0
 */
@Controller
@RequestMapping("/productos")
public class ProductoController {

    /**
     * Servicio que contiene la lógica de negocio para los productos.
     */
    private final ProductoServiceImpl productoService;

    /**
     * Servicio que contiene la lógica de negocio para las categorías.
     */
    private final CategoriaServiceImpl categoriaService;

    /**
     * Constructor que inyecta los servicios de productos y categorías.
     *
     * @param productoService servicio de productos
     * @param categoriaService servicio de categorías
     */
    public ProductoController(ProductoServiceImpl productoService, CategoriaServiceImpl categoriaService) {
        this.productoService = productoService;
        this.categoriaService = categoriaService;
    }

    /**
     * Maneja las peticiones GET para listar los productos.
     *
     * Añade al modelo la lista de productos, la lista de categorías
     * y un objeto producto vacío para el formulario.
     *
     * @param model objeto que transporta datos a la vista
     * @return nombre de la vista que muestra los productos
     */
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("productos", productoService.listar());
        model.addAttribute("categorias", categoriaService.listar());
        model.addAttribute("producto", new Producto());
        return "productos";
    }

    /**
     * Maneja las peticiones POST para guardar un producto.
     *
     * Recibe un producto desde el formulario, lo guarda mediante el servicio
     * y redirige a la lista de productos.
     *
     * @param producto objeto producto a guardar
     * @return redirección a la lista de productos
     */
    @PostMapping
    public String guardar(@ModelAttribute Producto producto) {
        productoService.guardar(producto);
        return "redirect:/productos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id){
        productoService.eliminar(id);
        return "redirect:/productos";
    }

    @GetMapping("/ejecutar/{parametro}/{filtro1}/{filtro2}")
    public String ejecutar(@PathVariable("parametro") String parametro, @PathVariable("filtro1") String filtro1, @PathVariable("filtro2") String filtro2, Model model) {
        //Debemos de rellenar productos y categorías para que no de error la página
        model.addAttribute("productos", productoService.listar());
        model.addAttribute("categorias", categoriaService.listar());
        //Almcenaremos en la variable "resultado" el resultado de la consulta y lo mostraremos en el HTML
        if(parametro.equals("buscarProductosPrecioMenorQue")){
            model.addAttribute("resultado", productoService.obtenerProductosPrecioMenor(Double.parseDouble(filtro1)));
        }else if(parametro.equals("buscarProductosPrecioMayorQue")){
            //  model.addAttribute("resultado", productoService.buscarProductosPrecioMayorQue(Double.parseDouble(filtro1)));
        }else if(parametro.equals("buscarProducto")){

        }

        //TODO añade el resto de métodos siguiendo la estructura del if-else-if
        return "productos";
    }

}
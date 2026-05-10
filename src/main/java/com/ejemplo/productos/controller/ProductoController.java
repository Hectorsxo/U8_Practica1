package com.ejemplo.productos.controller;

import com.ejemplo.productos.model.Producto;
import com.ejemplo.productos.service.CategoriaServiceImpl;
import com.ejemplo.productos.service.ProductoServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador encargado de gestionar las operaciones relacionadas con los productos.
 *
 * Permite listar los productos, registrar nuevos productos
 * y ejecutar consultas derivadas JPA.
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
    public ProductoController(ProductoServiceImpl productoService,
                              CategoriaServiceImpl categoriaService) {
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

    /**
     * Elimina un producto por su ID.
     *
     * @param id identificador del producto
     * @return redirección a la lista de productos
     */
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {

        productoService.eliminar(id);

        return "redirect:/productos";
    }

    /**
     * Ejecuta diferentes consultas derivadas JPA.
     *
     * @param parametro tipo de consulta
     * @param filtro1 primer filtro
     * @param filtro2 segundo filtro
     * @param model modelo para enviar datos a la vista
     * @return vista productos
     */
    @GetMapping("/ejecutar/{parametro}/{filtro1}/{filtro2}")
    public String ejecutar(@PathVariable("parametro") String parametro,
                           @PathVariable("filtro1") String filtro1,
                           @PathVariable("filtro2") String filtro2,
                           Model model) {

        // Datos necesarios para la vista
        model.addAttribute("productos", productoService.listar());
        model.addAttribute("categorias", categoriaService.listar());

        // BLOQUE 1
        if (parametro.equals("buscarProductosPrecioMenorQue")) {

            model.addAttribute("resultado",
                    productoService.obtenerProductosPrecioMenor(
                            Double.parseDouble(filtro1)));

        } else if (parametro.equals("buscarProductosPrecioMayorQue")) {

            model.addAttribute("resultado",
                    productoService.obtenerProductosPrecioMayor(
                            Double.parseDouble(filtro1)));

        } else if (parametro.equals("buscarProducto")) {

            model.addAttribute("resultado",
                    productoService.buscarProducto(filtro1));

            // BLOQUE 2
        } else if (parametro.equals("buscarProductosContengan")) {

            model.addAttribute("resultado",
                    productoService.buscarProductosContengan(filtro1));

        } else if (parametro.equals("buscarProductosEmpiecenPor")) {

            model.addAttribute("resultado",
                    productoService.buscarProductosEmpiecenPor(filtro1));

        } else if (parametro.equals("buscarProductosTerminenPor")) {

            model.addAttribute("resultado",
                    productoService.buscarProductosTerminenPor(filtro1));

            // BLOQUE 3
        } else if (parametro.equals("buscarProductosCategoria")) {

            model.addAttribute("resultado",
                    productoService.buscarProductosCategoria(filtro1));

        } else if (parametro.equals("buscarProductosCategoriaPrecioMenor")) {

            model.addAttribute("resultado",
                    productoService.buscarProductosCategoriaPrecioMenor(
                            filtro1,
                            Double.parseDouble(filtro2)));

        } else if (parametro.equals("buscarProductosCategoriaNombre")) {

            model.addAttribute("resultado",
                    productoService.buscarProductosCategoriaNombre(
                            filtro1,
                            filtro2));

            // BLOQUE 4
        } else if (parametro.equals("buscarProductosNombreOPrecio")) {

            model.addAttribute("resultado",
                    productoService.buscarProductosNombreOPrecio(
                            filtro1,
                            Double.parseDouble(filtro2)));

            // BLOQUE 5
        } else if (parametro.equals("ordenarPrecioAsc")) {

            model.addAttribute("resultado",
                    productoService.ordenarPrecioAsc());

            // BLOQUE 6
        } else if (parametro.equals("buscarProductosEntrePrecios")) {

            model.addAttribute("resultado",
                    productoService.buscarProductosEntrePrecios(
                            Double.parseDouble(filtro1),
                            Double.parseDouble(filtro2)));

        } else if (parametro.equals("buscarCategoriaPrecioMayor")) {

            model.addAttribute("resultado",
                    productoService.buscarCategoriaPrecioMayor(
                            filtro1,
                            Double.parseDouble(filtro2)));
        }

        return "productos";
    }
}
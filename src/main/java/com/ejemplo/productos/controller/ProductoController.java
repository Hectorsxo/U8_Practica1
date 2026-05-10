package com.ejemplo.productos.controller;

import com.ejemplo.productos.model.Producto;
import com.ejemplo.productos.service.CategoriaServiceImpl;
import com.ejemplo.productos.service.ProductoServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador principal para la gestión del catálogo de productos.
 *
 * Esta clase centraliza las operaciones de visualización, creación y eliminación
 * de productos, además de proporcionar una interfaz para ejecutar consultas
 * avanzadas (filtros) mediante métodos derivados de Spring Data JPA.
 *
 * @author Héctor Crespo
 * @version 1.0
 */
@Controller
@RequestMapping("/productos")
public class ProductoController {

    /**
     * Servicio especializado en la lógica de negocio y persistencia de productos.
     */
    private final ProductoServiceImpl productoService;

    /**
     * Servicio especializado en la gestión de las categorías de productos.
     */
    private final CategoriaServiceImpl categoriaService;

    /**
     * Constructor que inicializa los servicios necesarios mediante inyección de dependencias.
     *
     * @param productoService Implementación del servicio de productos.
     * @param categoriaService Implementación del servicio de categorías.
     */
    public ProductoController(ProductoServiceImpl productoService,
                              CategoriaServiceImpl categoriaService) {
        this.productoService = productoService;
        this.categoriaService = categoriaService;
    }

    /**
     * Gestiona las peticiones GET para visualizar el inventario completo.
     *
     * Prepara el modelo con la lista total de productos, las categorías disponibles
     * y un objeto vacío para el formulario de inserción.
     *
     * @param model Objeto de Spring UI para el envío de datos a la vista.
     * @return Nombre de la plantilla Thymeleaf para la página de productos.
     */
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("productos", productoService.listar());
        model.addAttribute("categorias", categoriaService.listar());
        model.addAttribute("producto", new Producto());
        return "productos";
    }

    /**
     * Procesa el envío del formulario para registrar o actualizar un producto.
     *
     * @param producto El objeto producto vinculado desde la vista mediante ModelAttribute.
     * @return Redirección a la ruta base de productos para refrescar la lista.
     */
    @PostMapping
    public String guardar(@ModelAttribute Producto producto) {
        productoService.guardar(producto);
        return "redirect:/productos";
    }

    /**
     * Elimina de forma permanente un producto del sistema basándose en su identificador.
     *
     * @param id El identificador único (Primary Key) del producto a borrar.
     * @return Redirección a la ruta base de productos.
     */
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        productoService.eliminar(id);
        return "redirect:/productos";
    }

    /**
     * Punto de entrada dinámico para la ejecución de consultas filtradas (Derived Queries).
     *
     * Este método evalúa el parámetro de acción y aplica filtros basados en nombres,
     * rangos de precios, coincidencias parciales o categorías.
     *
     * @param parametro Cadena que define el tipo de búsqueda o filtrado a realizar.
     * @param filtro1 Primer criterio de búsqueda (ej. nombre, precio mínimo o categoría).
     * @param filtro2 Segundo criterio de búsqueda opcional (ej. precio máximo o nombre secundario).
     * @param model Objeto Model para inyectar los resultados de la consulta en la vista.
     * @return Nombre de la plantilla de productos con la lista de resultados actualizada.
     */
    @GetMapping("/ejecutar/{parametro}/{filtro1}/{filtro2}")
    public String ejecutar(@PathVariable("parametro") String parametro,
                           @PathVariable("filtro1") String filtro1,
                           @PathVariable("filtro2") String filtro2,
                           Model model) {

        // Carga inicial de datos contextuales para mantener la integridad de la vista
        model.addAttribute("productos", productoService.listar());
        model.addAttribute("categorias", categoriaService.listar());

        // Selección de consulta basada en el parámetro dinámico
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

        } else if (parametro.equals("buscarProductosContengan")) {
            model.addAttribute("resultado",
                    productoService.buscarProductosContengan(filtro1));

        } else if (parametro.equals("buscarProductosEmpiecenPor")) {
            model.addAttribute("resultado",
                    productoService.buscarProductosEmpiecenPor(filtro1));

        } else if (parametro.equals("buscarProductosTerminenPor")) {
            model.addAttribute("resultado",
                    productoService.buscarProductosTerminenPor(filtro1));

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

        } else if (parametro.equals("buscarProductosNombreOPrecio")) {
            model.addAttribute("resultado",
                    productoService.buscarProductosNombreOPrecio(
                            filtro1,
                            Double.parseDouble(filtro2)));

        } else if (parametro.equals("ordenarPrecioAsc")) {
            model.addAttribute("resultado",
                    productoService.ordenarPrecioAsc());

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
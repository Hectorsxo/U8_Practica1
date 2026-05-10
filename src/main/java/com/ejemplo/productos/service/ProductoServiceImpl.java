package com.ejemplo.productos.service;

import com.ejemplo.productos.model.Categoria;
import com.ejemplo.productos.model.Producto;
import com.ejemplo.productos.repository.CategoriaRepository;
import com.ejemplo.productos.repository.ProductoRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio que gestiona la lógica de negocio relacionada con los productos.
 *
 * Se encarga de validar datos, aplicar reglas de negocio y coordinar
 * el acceso a los repositorios de productos y categorías.
 *
 * @author Héctor Crespo
 * @version 1.0
 */
@Service
public class ProductoServiceImpl {

    /**
     * Repositorio de categorías para validar la existencia de la categoría.
     */
    private final CategoriaRepository categoriaRepository;

    /**
     * Repositorio de productos para el acceso a datos.
     */
    private final ProductoRepository repository;

    /**
     * Constructor que inyecta los repositorios necesarios.
     *
     * @param categoriaRepository repositorio de categorías
     * @param repository repositorio de productos
     */
    public ProductoServiceImpl(CategoriaRepository categoriaRepository, ProductoRepository repository) {
        this.categoriaRepository = categoriaRepository;
        this.repository = repository;
    }

    /**
     * Obtiene la lista de todos los productos.
     *
     * @return lista de productos
     */
    public List<Producto> listar() {
        return repository.findAll();
    }

    /**
     * Guarda un producto en el sistema.
     *
     * Valida que el producto no sea nulo, que tenga nombre válido
     * y que tenga una categoría existente. Además, normaliza los datos
     * antes de guardarlos.
     *
     * @param producto producto a guardar
     * @throws IllegalArgumentException si el producto es nulo, el nombre es inválido
     *                                  o no tiene categoría asignada
     */
    public void guardar(Producto producto) {
        if (producto == null || producto.getNombre() == null) {
            throw new IllegalArgumentException("Nombre null");
        }

        if (producto.getNombre().isEmpty()) {
            throw new IllegalArgumentException("Nombre vacío");
        }

        if (producto.getCategoria() == null) {
            throw new IllegalArgumentException("Producto sin categoría");
        }

        Optional<Categoria> categoria = categoriaRepository.findById(producto.getCategoria().getId());

        producto.setNombre(producto.getNombre().toUpperCase());
        producto.setCategoria(categoria.get());
        repository.save(producto);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public Optional<Producto> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    // =====================================================
    // BLOQUE 1
    // =====================================================

    public @Nullable List<Producto> obtenerProductosPrecioMenor(double precio) {
        if(precio == 0.0){
            throw new IllegalArgumentException("El precio no puede ser cero");
        }else{
            return repository.findByPrecioLessThan(precio);
        }
    }

    public @Nullable List<Producto> obtenerProductosPrecioMayor(double precio) {
        if(precio == 0.0){
            throw new IllegalArgumentException("El precio no puede ser cero");
        }else{
            return repository.findByPrecioGreaterThan(precio);
        }
    }

    public @Nullable Producto buscarProducto(String nombre) {
        if(nombre == null || nombre.isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }else{
            return repository.findByNombre(nombre);
        }
    }

    // =====================================================
    // BLOQUE 2
    // =====================================================

    public @Nullable List<Producto> buscarProductosContengan(String texto) {
        if(texto == null || texto.isEmpty()){
            throw new IllegalArgumentException("El texto no puede estar vacío");
        }else{
            return repository.findByNombreContaining(texto);
        }
    }

    public @Nullable List<Producto> buscarProductosEmpiecenPor(String texto) {
        if(texto == null || texto.isEmpty()){
            throw new IllegalArgumentException("El texto no puede estar vacío");
        }else{
            return repository.findByNombreStartingWith(texto);
        }
    }

    public @Nullable List<Producto> buscarProductosTerminenPor(String texto) {
        if(texto == null || texto.isEmpty()){
            throw new IllegalArgumentException("El texto no puede estar vacío");
        }else{
            return repository.findByNombreEndingWith(texto);
        }
    }

    // =====================================================
    // BLOQUE 3
    // =====================================================

    public @Nullable List<Producto> buscarProductosCategoria(String categoria) {
        if(categoria == null || categoria.isEmpty()){
            throw new IllegalArgumentException("La categoría no puede estar vacía");
        }else{
            return repository.findByCategoriaNombre(categoria);
        }
    }

    public @Nullable List<Producto> buscarProductosCategoriaPrecioMenor(String categoria,
                                                                        double precio) {

        if(categoria == null || categoria.isEmpty()){
            throw new IllegalArgumentException("La categoría no puede estar vacía");
        }else if(precio == 0.0){
            throw new IllegalArgumentException("El precio no puede ser cero");
        }else{
            return repository.findByCategoriaNombreAndPrecioLessThan(categoria, precio);
        }
    }

    public @Nullable List<Producto> buscarProductosCategoriaNombre(String categoria,
                                                                   String nombre) {

        if(categoria == null || categoria.isEmpty()){
            throw new IllegalArgumentException("La categoría no puede estar vacía");
        }else if(nombre == null || nombre.isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }else{
            return repository.findByCategoriaNombreAndNombreContaining(categoria, nombre);
        }
    }

    // =====================================================
    // BLOQUE 4
    // =====================================================

    public @Nullable List<Producto> buscarProductosNombreOPrecio(String nombre,
                                                                 double precio) {

        if(nombre == null || nombre.isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }else if(precio == 0.0){
            throw new IllegalArgumentException("El precio no puede ser cero");
        }else{
            return repository.findByNombreContainingOrPrecioLessThan(nombre, precio);
        }
    }

    // =====================================================
    // BLOQUE 5
    // =====================================================

    public @Nullable List<Producto> ordenarPrecioAsc() {
        return repository.findByOrderByPrecioAsc();
    }

    // =====================================================
    // BLOQUE 6
    // =====================================================

    public @Nullable List<Producto> buscarProductosEntrePrecios(double min,
                                                                double max) {

        if(min == 0.0 || max == 0.0){
            throw new IllegalArgumentException("Los precios no pueden ser cero");
        }else{
            return repository.findByPrecioBetween(min, max);
        }
    }

    public @Nullable List<Producto> buscarCategoriaPrecioMayor(String categoria,
                                                               double precio) {

        if(categoria == null || categoria.isEmpty()){
            throw new IllegalArgumentException("La categoría no puede estar vacía");
        }else if(precio == 0.0){
            throw new IllegalArgumentException("El precio no puede ser cero");
        }else{
            return repository.findByCategoriaNombreAndPrecioGreaterThan(categoria, precio);
        }
    }

}
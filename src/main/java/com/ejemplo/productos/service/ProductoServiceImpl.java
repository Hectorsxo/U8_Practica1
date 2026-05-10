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
     * Obtiene la lista de todos los productos almacenados.
     *
     * @return lista de objetos Producto.
     */
    public List<Producto> listar() {
        return repository.findAll();
    }

    /**
     * Guarda un producto en el sistema tras validar sus campos obligatorios.
     *
     * El nombre se normaliza a mayúsculas y se vincula la categoría completa
     * recuperada desde el repositorio antes de la persistencia.
     *
     * @param producto objeto producto a guardar.
     * @throws IllegalArgumentException si el producto es nulo, el nombre está vacío
     *                                  o no tiene una categoría asociada.
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

    /**
     * Elimina un producto del sistema mediante su identificador único.
     *
     * @param id identificador del producto a eliminar.
     */
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    /**
     * Busca un producto por su identificador único.
     *
     * @param id identificador del producto.
     * @return un Optional que contiene el producto si se encuentra.
     */
    public Optional<Producto> obtenerPorId(Long id) {
        return repository.findById(id);
    }


    // BLOQUE 1:

    /**
     * Obtiene productos con un precio estrictamente inferior al valor dado.
     *
     * @param precio valor límite superior.
     * @return lista de productos encontrados.
     * @throws IllegalArgumentException si el precio es 0.0.
     */
    public @Nullable List<Producto> obtenerProductosPrecioMenor(double precio) {
        if(precio == 0.0){
            throw new IllegalArgumentException("El precio no puede ser cero");
        }else{
            return repository.findByPrecioLessThan(precio);
        }
    }

    /**
     * Obtiene productos con un precio estrictamente superior al valor dado.
     *
     * @param precio valor límite inferior.
     * @return lista de productos encontrados.
     * @throws IllegalArgumentException si el precio es 0.0.
     */
    public @Nullable List<Producto> obtenerProductosPrecioMayor(double precio) {
        if(precio == 0.0){
            throw new IllegalArgumentException("El precio no puede ser cero");
        }else{
            return repository.findByPrecioGreaterThan(precio);
        }
    }

    /**
     * Busca un producto por su nombre exacto.
     *
     * @param nombre nombre a buscar.
     * @return el producto si existe, o null.
     * @throws IllegalArgumentException si el nombre es nulo o vacío.
     */
    public @Nullable Producto buscarProducto(String nombre) {
        if(nombre == null || nombre.isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }else{
            return repository.findByNombre(nombre);
        }
    }


    // BLOQUE 2

    /**
     * Busca productos cuyo nombre contenga el texto indicado.
     *
     * @param texto cadena a buscar.
     * @return lista de productos que contienen el texto.
     * @throws IllegalArgumentException si el texto es nulo o vacío.
     */
    public @Nullable List<Producto> buscarProductosContengan(String texto) {
        if(texto == null || texto.isEmpty()){
            throw new IllegalArgumentException("El texto no puede estar vacío");
        }else{
            return repository.findByNombreContaining(texto);
        }
    }

    /**
     * Busca productos cuyo nombre comience por el texto indicado.
     *
     * @param texto prefijo a buscar.
     * @return lista de productos encontrados.
     * @throws IllegalArgumentException si el texto es nulo o vacío.
     */
    public @Nullable List<Producto> buscarProductosEmpiecenPor(String texto) {
        if(texto == null || texto.isEmpty()){
            throw new IllegalArgumentException("El texto no puede estar vacío");
        }else{
            return repository.findByNombreStartingWith(texto);
        }
    }

    /**
     * Busca productos cuyo nombre finalice con el texto indicado.
     *
     * @param texto sufijo a buscar.
     * @return lista de productos encontrados.
     * @throws IllegalArgumentException si el texto es nulo o vacío.
     */
    public @Nullable List<Producto> buscarProductosTerminenPor(String texto) {
        if(texto == null || texto.isEmpty()){
            throw new IllegalArgumentException("El texto no puede estar vacío");
        }else{
            return repository.findByNombreEndingWith(texto);
        }
    }


    // BLOQUE 3

    /**
     * Obtiene productos pertenecientes a una categoría específica.
     *
     * @param categoria nombre de la categoría.
     * @return lista de productos en esa categoría.
     * @throws IllegalArgumentException si el nombre de categoría es nulo o vacío.
     */
    public @Nullable List<Producto> buscarProductosCategoria(String categoria) {
        if(categoria == null || categoria.isEmpty()){
            throw new IllegalArgumentException("La categoría no puede estar vacía");
        }else{
            return repository.findByCategoriaNombre(categoria);
        }
    }

    /**
     * Obtiene productos de una categoría con precio inferior al indicado.
     *
     * @param categoria nombre de la categoría.
     * @param precio límite de precio.
     * @return lista de productos filtrados.
     * @throws IllegalArgumentException si los parámetros son inválidos.
     */
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

    /**
     * Obtiene productos de una categoría cuyo nombre contenga un texto específico.
     *
     * @param categoria nombre de la categoría.
     * @param nombre texto a buscar en el nombre del producto.
     * @return lista de productos filtrados.
     * @throws IllegalArgumentException si los parámetros son inválidos.
     */
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


    // BLOQUE 4

    /**
     * Busca productos que coincidan por nombre o que tengan un precio inferior al dado.
     *
     * @param nombre texto a buscar en el nombre.
     * @param precio límite de precio para la condición OR.
     * @return lista de productos que cumplen alguna de las condiciones.
     * @throws IllegalArgumentException si los parámetros son inválidos.
     */
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


    // BLOQUE 5

    /**
     * Obtiene todos los productos ordenados por precio ascendentemente.
     *
     * @return lista de productos ordenada.
     */
    public @Nullable List<Producto> ordenarPrecioAsc() {
        return repository.findByOrderByPrecioAsc();
    }


    // BLOQUE 6

    /**
     * Obtiene productos cuyo precio se encuentre en un rango determinado.
     *
     * @param min precio mínimo.
     * @param max precio máximo.
     * @return lista de productos dentro del rango.
     * @throws IllegalArgumentException si algún precio es 0.0.
     */
    public @Nullable List<Producto> buscarProductosEntrePrecios(double min,
                                                                double max) {

        if(min == 0.0 || max == 0.0){
            throw new IllegalArgumentException("Los precios no pueden ser cero");
        }else{
            return repository.findByPrecioBetween(min, max);
        }
    }

    /**
     * Obtiene productos de una categoría con precio superior al indicado.
     *
     * @param categoria nombre de la categoría.
     * @param precio límite de precio inferior.
     * @return lista de productos filtrados.
     * @throws IllegalArgumentException si los parámetros son inválidos.
     */
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
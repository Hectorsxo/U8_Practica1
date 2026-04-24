package com.ejemplo.productos.service;

import com.ejemplo.productos.model.Categoria;
import com.ejemplo.productos.model.Producto;
import com.ejemplo.productos.repository.CategoriaRepository;
import com.ejemplo.productos.repository.ProductoRepository;
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
}
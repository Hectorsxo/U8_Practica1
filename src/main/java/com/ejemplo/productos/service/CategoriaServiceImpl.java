package com.ejemplo.productos.service;

import com.ejemplo.productos.model.Categoria;
import com.ejemplo.productos.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación del servicio para la gestión de categorías.
 *
 * Esta clase actúa como capa intermedia entre el controlador y el repositorio,
 * encargándose de la lógica de negocio, como la normalización de datos y
 * validaciones antes de la persistencia.
 *
 * @author Héctor Crespo
 * @version 1.0
 */
@Service
public class CategoriaServiceImpl {

    /**
     * Referencia al repositorio de categorías para realizar operaciones de persistencia.
     */
    private final CategoriaRepository repository;

    /**
     * Constructor que inicializa el repositorio mediante inyección de dependencias.
     *
     * @param repository Repositorio de categorías a inyectar.
     */
    public CategoriaServiceImpl(CategoriaRepository repository) {
        this.repository = repository;
    }

    /**
     * Recupera todas las categorías almacenadas en la base de datos.
     *
     * @return Una lista que contiene todos los objetos Categoria registrados.
     */
    public List<Categoria> listar() {
        return repository.findAll();
    }

    /**
     * Registra una nueva categoría en el sistema tras aplicar lógica de negocio.
     *
     * El método valida que el objeto no sea nulo y que el nombre sea válido.
     * Como regla de negocio, el nombre de la categoría se transforma a
     * letras mayúsculas antes de ser persistido.
     *
     * @param categoria El objeto categoría que se desea guardar.
     * @throws IllegalArgumentException Si la categoría es nula, si el nombre es
     *         nulo o si la cadena del nombre está vacía.
     */
    public void guardar(Categoria categoria) {
        if (categoria == null || categoria.getNombre() == null) {
            throw new IllegalArgumentException("Nombre null");
        }

        if (categoria.getNombre().isEmpty()) {
            throw new IllegalArgumentException("Nombre vacío");
        }

        // Normalización de datos: convertir a mayúsculas
        categoria.setNombre(categoria.getNombre().toUpperCase());

        repository.save(categoria);
    }
}
package com.ejemplo.productos.repository;

import com.ejemplo.productos.model.Categoria;
import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad Categoria.
 *
 * Establece los métodos básicos para gestionar categorías en el sistema.
 *
 * @author Héctor Crespo
 * @version 1.0
 */
public interface CategoriaRepository {

    /**
     * Obtiene todas las categorías disponibles.
     *
     * @return lista de categorías
     */
    List<Categoria> findAll();

    /**
     * Guarda una categoría en el sistema.
     *
     * @param categoria categoría a guardar
     */
    void save(Categoria categoria);

    /**
     * Busca una categoría por su identificador.
     *
     * @param id identificador de la categoría
     * @return un Optional que contiene la categoría si se encuentra, o vacío si no existe
     */
    Optional<Categoria> findById(Long id);
}
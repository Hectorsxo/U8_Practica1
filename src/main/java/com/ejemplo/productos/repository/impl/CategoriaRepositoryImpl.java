package com.ejemplo.productos.repository.impl;

import com.ejemplo.productos.model.Categoria;
import com.ejemplo.productos.repository.CategoriaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementación del repositorio de categorías.
 *
 * Gestiona el almacenamiento de categorías en memoria utilizando una lista.
 * Proporciona operaciones básicas como guardar, listar y buscar por identificador.
 *
 * @author Héctor Crespo
 * @version 1.0
 */
@Repository
public class CategoriaRepositoryImpl implements CategoriaRepository {

    /**
     * Constructor por defecto.
     */
    public CategoriaRepositoryImpl() {
    }

    /**
     * Lista que almacena las categorías en memoria.
     */
    private List<Categoria> categorias = new ArrayList<>();

    /**
     * Contador utilizado para generar identificadores únicos.
     */
    private Long id = 0L;

    /**
     * Obtiene todas las categorías almacenadas.
     *
     * @return lista de categorías
     */
    @Override
    public List<Categoria> findAll() {
        return categorias;
    }

    /**
     * Guarda una nueva categoría en la lista.
     *
     * Asigna automáticamente un identificador único antes de almacenarla.
     *
     * @param categoria categoría a guardar
     */
    @Override
    public void save(Categoria categoria) {
        categoria.setId(id++);
        categorias.add(categoria);
    }

    /**
     * Busca una categoría por su identificador.
     *
     * Recorre la lista de categorías y devuelve la que coincida con el id proporcionado.
     *
     * @param id identificador de la categoría
     * @return un Optional que contiene la categoría si se encuentra, o vacío si no existe
     */
    @Override
    public Optional<Categoria> findById(Long id) {
        for (Categoria categoria : categorias) {
            if (categoria.getId().equals(id)) {
                return Optional.of(categoria);
            }
        }
        return Optional.empty();
    }
}
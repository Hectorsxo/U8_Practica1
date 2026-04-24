package com.ejemplo.productos.service;

import com.ejemplo.productos.model.Categoria;
import com.ejemplo.productos.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio que gestiona la lógica de negocio relacionada con las categorías.
 *
 * Se encarga de validar los datos y delegar las operaciones al repositorio.
 *
 * @author Héctor Crespo
 * @version 1.0
 */
@Service
public class CategoriaServiceImpl {

    /**
     * Repositorio de categorías para el acceso a datos.
     */
    private final CategoriaRepository repository;

    /**
     * Constructor que inyecta el repositorio de categorías.
     *
     * @param repository repositorio de categorías
     */
    public CategoriaServiceImpl(CategoriaRepository repository) {
        this.repository = repository;
    }

    /**
     * Obtiene la lista de todas las categorías.
     *
     * @return lista de categorías
     */
    public List<Categoria> listar() {
        return repository.findAll();
    }

    /**
     * Guarda una categoría en el sistema.
     *
     * Realiza validaciones sobre el nombre de la categoría antes de guardarla.
     * Convierte el nombre a mayúsculas antes de almacenarlo.
     *
     * @param categoria categoría a guardar
     * @throws IllegalArgumentException si la categoría es nula, el nombre es nulo o está vacío
     */
    public void guardar(Categoria categoria) {
        if (categoria == null || categoria.getNombre() == null) {
            throw new IllegalArgumentException("Nombre null");
        }

        if (categoria.getNombre().isEmpty()) {
            throw new IllegalArgumentException("Nombre vacío");
        }

        categoria.setNombre(categoria.getNombre().toUpperCase());

        repository.save(categoria);
    }
}
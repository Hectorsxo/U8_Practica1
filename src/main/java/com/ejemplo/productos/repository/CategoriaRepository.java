package com.ejemplo.productos.repository;

import com.ejemplo.productos.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

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
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
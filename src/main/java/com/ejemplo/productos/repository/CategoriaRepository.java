package com.ejemplo.productos.repository;

import com.ejemplo.productos.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz de acceso a datos para la entidad Categoria.
 *
 * Al extender JpaRepository, esta interfaz hereda todos los métodos estándar
 * de Spring Data JPA para realizar operaciones CRUD (Crear, Leer, Actualizar, Borrar)
 * y de paginación sobre la tabla de categorías en la base de datos.
 *
 * No requiere una implementación manual, ya que Spring Data JPA genera
 * automáticamente la lógica necesaria en tiempo de ejecución.
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
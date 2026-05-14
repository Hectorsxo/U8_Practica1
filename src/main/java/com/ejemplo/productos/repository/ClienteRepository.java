package com.ejemplo.productos.repository;

import com.ejemplo.productos.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la gestión de entidad Cliente.
 *
 * Proporciona operaciones CRUD y funcionalidades de acceso
 * a datos sobre la tabla de clientes utilizando Spring Data JPA.
 *
 * Hereda métodos estándar como:
 *
 * - Guardar clientes
 * - Buscar clientes por identificador
 * - Listar clientes
 * - Eliminar clientes
 *
 *
 * @author Héctor Crespo
 * @version 1.0
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
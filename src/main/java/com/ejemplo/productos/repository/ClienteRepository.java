package com.ejemplo.productos.repository;

import com.ejemplo.productos.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la gestión de entidades {@link Cliente}.
 *
 * Proporciona operaciones CRUD y funcionalidades de acceso
 * a datos sobre la tabla de clientes utilizando Spring Data JPA.
 *
 * Hereda métodos estándar como:
 * <ul>
 *     <li>guardar clientes</li>
 *     <li>buscar clientes por identificador</li>
 *     <li>listar clientes</li>
 *     <li>eliminar clientes</li>
 * </ul>
 *
 * @author Héctor Crespo
 * @version 1.0
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
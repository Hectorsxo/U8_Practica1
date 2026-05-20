package com.ejemplo.productos.repository;

import com.ejemplo.productos.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de acceso a datos para la entidad Cliente.
 *
 * Extiende JpaRepository para heredar operaciones CRUD básicas y proporcionar acceso
 * a la base de datos de clientes. Permite la realización de consultas y operaciones
 * sobre los registros almacenados de forma sencilla mediante Spring Data JPA.
 *
 * @author Héctor Crespo
 * @version 1.0
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
package com.ejemplo.productos.repository;

import com.ejemplo.productos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la gestión de entidad Pedido.
 *
 * Proporciona operaciones CRUD y funcionalidades de acceso
 * a datos sobre la tabla de pedidos utilizando Spring Data JPA.
 *
 * Hereda métodos estándar como:
 *
 * - Guardar pedidos
 * - Buscar pedidos por identificador
 * - Listar pedidos
 * - Eliminar pedidos
 *
 *
 * @author Héctor Crespo
 * @version 1.0
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
package com.ejemplo.productos.repository;

import com.ejemplo.productos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la gestión de entidades {@link Pedido}.
 *
 * Proporciona operaciones CRUD y funcionalidades de acceso
 * a datos sobre la tabla de pedidos utilizando Spring Data JPA.
 *
 * Hereda métodos estándar como:
 * <ul>
 *     <li>guardar pedidos</li>
 *     <li>buscar pedidos por identificador</li>
 *     <li>listar pedidos</li>
 *     <li>eliminar pedidos</li>
 * </ul>
 *
 * @author Héctor Crespo
 * @version 1.0
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
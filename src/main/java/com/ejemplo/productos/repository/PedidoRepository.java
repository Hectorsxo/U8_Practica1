package com.ejemplo.productos.repository;

import com.ejemplo.productos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de acceso a datos para la entidad Pedido.
 *
 * Extiende JpaRepository para heredar operaciones CRUD básicas y proporcionar acceso
 * a la base de datos de pedidos. Permite la gestión completa de los registros de pedidos
 * mediante Spring Data JPA, incluyendo su creación, consulta, actualización y eliminación.
 *
 * @author Héctor Crespo
 * @version 1.0
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
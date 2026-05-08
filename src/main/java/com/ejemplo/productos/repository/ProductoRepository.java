package com.ejemplo.productos.repository;

import com.ejemplo.productos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad Producto.
 *
 * Establece los métodos básicos para gestionar productos en el sistema.
 *
 * @author Héctor Crespo
 * @version 1.0
 */
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByPrecioLessThan(double precio);
    List<Producto> findByPrecioGreaterThan(double precio);

}
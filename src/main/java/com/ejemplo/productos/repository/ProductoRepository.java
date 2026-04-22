package com.ejemplo.productos.repository;

import com.ejemplo.productos.model.Producto;
import java.util.List;

public interface ProductoRepository {
    List<Producto> findAll();
    void save(Producto producto);
}

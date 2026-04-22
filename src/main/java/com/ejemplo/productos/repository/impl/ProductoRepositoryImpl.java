package com.ejemplo.productos.repository.impl;

import com.ejemplo.productos.model.Producto;
import com.ejemplo.productos.repository.ProductoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductoRepositoryImpl implements ProductoRepository {

    private List<Producto> productos = new ArrayList<>();

    @Override
    public List<Producto> findAll() {
        return productos;
    }

    @Override
    public void save(Producto producto) {
        productos.add(producto);
    }
}
package com.ejemplo.productos.service;

import com.ejemplo.productos.model.Producto;
import com.ejemplo.productos.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl {

    private final ProductoRepository repository;

    public ProductoServiceImpl(ProductoRepository repository) {
        this.repository = repository;
    }

    public List<Producto> listar() {
        return repository.findAll();
    }

    public void guardar(Producto producto) {
        if (producto == null || producto.getNombre() == null) {
            throw new IllegalArgumentException("Nombre null");
        }

        if (producto.getNombre().isEmpty()) {
            throw new IllegalArgumentException("Nombre vacío");
        }

        if (producto.getCategoria() == null) {
            throw new IllegalArgumentException("Producto sin categoría");
        }

        producto.setNombre(producto.getNombre().toUpperCase());

        repository.save(producto);
    }
}
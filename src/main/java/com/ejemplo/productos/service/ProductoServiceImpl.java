package com.ejemplo.productos.service;

import com.ejemplo.productos.model.Categoria;
import com.ejemplo.productos.model.Producto;
import com.ejemplo.productos.repository.CategoriaRepository;
import com.ejemplo.productos.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl {

    private final CategoriaRepository categoriaRepository;

    private final ProductoRepository repository;

    public ProductoServiceImpl(CategoriaRepository categoriaRepository, ProductoRepository repository) {
        this.categoriaRepository = categoriaRepository;
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

        Optional<Categoria> categoria = categoriaRepository.findById(producto.getCategoria().getId());

        producto.setNombre(producto.getNombre().toUpperCase());
        producto.setCategoria(categoria.get());
        repository.save(producto);
    }
}
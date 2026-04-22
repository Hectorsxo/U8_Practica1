package com.ejemplo.productos.service;

import com.ejemplo.productos.model.Categoria;
import com.ejemplo.productos.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl {

    private final CategoriaRepository repository;

    public CategoriaServiceImpl(CategoriaRepository repository) {
        this.repository = repository;
    }

    public List<Categoria> listar() {
        return repository.findAll();
    }

    public void guardar(Categoria categoria) {
        if (categoria == null || categoria.getNombre() == null) {
            throw new IllegalArgumentException("Nombre null");
        }

        if (categoria.getNombre().isEmpty()) {
            throw new IllegalArgumentException("Nombre vacío");
        }

        categoria.setNombre(categoria.getNombre().toUpperCase());

        repository.save(categoria);
    }
}
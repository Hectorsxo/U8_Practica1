package com.ejemplo.productos.repository;

import com.ejemplo.productos.model.Categoria;
import java.util.List;
import java.util.Optional;

public interface CategoriaRepository {
    List<Categoria> findAll();
    void save(Categoria categoria);
    Optional<Categoria> findById(Long id);
}
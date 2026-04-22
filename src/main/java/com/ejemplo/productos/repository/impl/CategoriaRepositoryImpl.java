package com.ejemplo.productos.repository.impl;

import com.ejemplo.productos.model.Categoria;
import com.ejemplo.productos.repository.CategoriaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoriaRepositoryImpl implements CategoriaRepository {

    private List<Categoria> categorias = new ArrayList<>();

    @Override
    public List<Categoria> findAll() {
        return categorias;
    }

    @Override
    public void save(Categoria categoria) {
        categorias.add(categoria);
    }
}
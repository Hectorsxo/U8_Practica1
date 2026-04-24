package com.ejemplo.productos.repository.impl;

import com.ejemplo.productos.model.Categoria;
import com.ejemplo.productos.repository.CategoriaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaRepositoryImpl implements CategoriaRepository {

    private List<Categoria> categorias = new ArrayList<>();
    private Long id = 0L;

    @Override
    public List<Categoria> findAll() {
        return categorias;
    }

    @Override
    public void save(Categoria categoria) {
        categoria.setId(id++);
        categorias.add(categoria);
    }

    @Override
    public Optional<Categoria> findById(Long id) {
        for (Categoria categoria: categorias){
            if(categoria.getId().equals(id)){
                return Optional.of(categoria);
            }
        }
        return Optional.empty();

    }
}
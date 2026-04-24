package com.ejemplo.productos.repository.impl;

import com.ejemplo.productos.model.Producto;
import com.ejemplo.productos.repository.ProductoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del repositorio de productos.
 *
 * Gestiona el almacenamiento de productos en memoria utilizando una lista.
 * Proporciona operaciones básicas como guardar y listar productos.
 *
 * @author Héctor Crespo
 * @version 1.0
 */
@Repository
public class ProductoRepositoryImpl implements ProductoRepository {

    /**
     * Constructor por defecto.
     */
    public ProductoRepositoryImpl() {
    }

    /**
     * Lista que almacena los productos en memoria.
     */
    private List<Producto> productos = new ArrayList<>();

    /**
     * Obtiene todos los productos almacenados.
     *
     * @return lista de productos
     */
    @Override
    public List<Producto> findAll() {
        return productos;
    }

    /**
     * Guarda un nuevo producto en la lista.
     *
     * @param producto producto a guardar
     */
    @Override
    public void save(Producto producto) {
        productos.add(producto);
    }
}
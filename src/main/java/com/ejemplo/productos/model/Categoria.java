package com.ejemplo.productos.model;

import jakarta.persistence.*;
import java.util.List;

/**
 * Clase que representa una categoría de productos.
 *
 * Contiene la información básica de una categoría, como su identificador
 * y su nombre.
 *
 * @author Héctor Crespo
 * @version 1.0
 */
@Entity
@Table(name = "categoria")
public class Categoria {

    /**
     * Identificador único de la categoría.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre de la categoría.
     */
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;

    /**
     * Constructor vacío necesario para la creación de objetos.
     */
    public Categoria() {}

    /**
     * Constructor con parámetros para inicializar la categoría.
     *
     * @param id identificador de la categoría
     * @param nombre nombre de la categoría
     */
    public Categoria(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Obtiene el identificador de la categoría.
     *
     * @return identificador de la categoría
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador de la categoría.
     *
     * @param id identificador de la categoría
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la categoría.
     *
     * @return nombre de la categoría
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la categoría.
     *
     * @param nombre nombre de la categoría
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la lista de productos de la categoría.
     *
     * @return lista de productos
     */
    public List<Producto> getProductos() {
        return productos;
    }

    /**
     * Establece la lista de productos de la categoría.
     *
     * @param productos lista de productos
     */
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
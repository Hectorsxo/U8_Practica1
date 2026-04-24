package com.ejemplo.productos.model;

/**
 * Clase que representa una categoría de productos.
 *
 * Contiene la información básica de una categoría, como su identificador
 * y su nombre.
 *
 * @author Héctor Crespo
 * @version 1.0
 */
public class Categoria {

    /**
     * Identificador único de la categoría.
     */
    private Long id;

    /**
     * Nombre de la categoría.
     */
    private String nombre;

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
}
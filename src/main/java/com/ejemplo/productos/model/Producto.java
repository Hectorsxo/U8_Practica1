package com.ejemplo.productos.model;

/**
 * Clase que representa un producto dentro del sistema.
 *
 * Contiene información básica como el identificador, nombre,
 * precio y la categoría a la que pertenece.
 *
 * @author Héctor Crespo
 * @version 1.0
 */
public class Producto {

    /**
     * Identificador único del producto.
     */
    private Long id;

    /**
     * Nombre del producto.
     */
    private String nombre;

    /**
     * Precio del producto.
     */
    private double precio;

    /**
     * Categoría a la que pertenece el producto.
     */
    private Categoria categoria;

    /**
     * Constructor vacío necesario para la creación de objetos.
     */
    public Producto() {}

    /**
     * Constructor con parámetros para inicializar el producto.
     *
     * @param id identificador del producto
     * @param nombre nombre del producto
     * @param precio precio del producto
     * @param categoria categoría del producto
     */
    public Producto(Long id, String nombre, double precio, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    /**
     * Obtiene el identificador del producto.
     *
     * @return identificador del producto
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador del producto.
     *
     * @param id identificador del producto
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombre nombre del producto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return precio del producto
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     *
     * @param precio precio del producto
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la categoría del producto.
     *
     * @return categoría del producto
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * Establece la categoría del producto.
     *
     * @param categoria categoría del producto
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
package com.ejemplo.productos.model;

import jakarta.persistence.*;

/**
 * Clase que representa un producto dentro del sistema.
 *
 * Contiene información básica como el identificador, nombre,
 * precio y la categoría a la que pertenece.
 *
 * @author Héctor Crespo
 * @version 1.0
 */
@Entity
@Table(name = "productos")
public class Producto {

    /**
     * Identificador único del producto.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del producto.
     */
    @Column(name = "nombre_producto", nullable = false, length = 200)
    private String nombre;

    /**
     * Precio del producto.
     */
    @Column(name = "precio_producto", nullable = true)
    private double precio;

    /**
     * Descripción del producto.
     */
    @Column(name = "descripcion_producto", nullable = false, length = 600)
    private String descripcion;

    /**
     * Categoría a la que pertenece el producto.
     */
    //CREAR RELACIÓN
    private Categoria categoria;

    @Transient //No detecta el campo como columna
    private int contador;

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
    public Producto(Long id, String nombre, double precio, String descripcion, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
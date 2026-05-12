package com.ejemplo.productos.model;

import jakarta.persistence.*;

import java.util.Set;

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
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToMany(mappedBy = "productos")
    private Set<Pedido> pedidos;

    /**
     * Campo auxiliar para conteos, no persistido en la base de datos.
     */
    @Transient
    private int contador;

    /**
     * Constructor vacío.
     */
    public Producto() {}


    /**
     * Constructor con parámetros para inicializar el producto.
     *
     * @param id identificador del producto
     * @param nombre nombre del producto
     * @param precio precio del producto
     * @param descripcion descripcion del producto
     * @param categoria categoría del producto
     * @param pedidos pedidos
     */

    public Producto(Long id, String nombre, double precio, String descripcion, Categoria categoria, Set<Pedido> pedidos) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.pedidos = pedidos;
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

    /**
     * Obtiene la descripción detallada del producto.
     *
     * @return descripción del producto
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción detallada del producto.
     *
     * @param descripcion descripción del producto
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
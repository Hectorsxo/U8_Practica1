package com.ejemplo.productos.model;

import jakarta.persistence.*;
import java.util.Set;

/**
 * Clase que representa un producto dentro del sistema.
 *
 * Contiene información básica como el identificador, nombre,
 * precio y la categoría a la que pertenece.
 *
 * Además, mantiene la relación con los pedidos asociados
 * al producto.
 *
 * @author Héctor Crespo
 * @version 1.0
 */
@Entity
@Table(name = "producto")
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
    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;

    /**
     * Precio del producto.
     */
    @Column(name = "precio", nullable = false)
    private Double precio;

    /**
     * Descripción del producto (solo en memoria, no persistida en BD).
     */
    @Transient
    private String descripcion;

    /**
     * Categoría a la que pertenece el producto.
     *
     * Relación muchos a uno: muchos productos pertenecen a una categoría.
     */
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    /**
     * Conjunto de pedidos asociados al producto.
     *
     * Relación muchos a muchos con Pedido.
     */
    @ManyToMany(mappedBy = "productos")
    private Set<Pedido> pedidos;

    /**
     * Constructor vacío necesario para JPA.
     */
    public Producto() {
    }

    /**
     * Constructor con parámetros para inicializar el producto.
     *
     * @param id identificador del producto
     * @param nombre nombre del producto
     * @param precio precio del producto
     * @param descripcion descripción del producto
     * @param categoria categoría del producto
     * @param pedidos pedidos asociados al producto
     */
    public Producto(Long id, String nombre, Double precio,
                    String descripcion, Categoria categoria,
                    Set<Pedido> pedidos) {
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
     * @return id del producto
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
    public Double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     *
     * @param precio precio del producto
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la descripción del producto.
     *
     * @return descripción del producto
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del producto.
     *
     * @param descripcion descripción del producto
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la categoría del producto.
     *
     * @return categoría asociada
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
     * Obtiene los pedidos asociados al producto.
     *
     * @return conjunto de pedidos
     */
    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    /**
     * Establece los pedidos asociados al producto.
     *
     * @param pedidos conjunto de pedidos
     */
    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
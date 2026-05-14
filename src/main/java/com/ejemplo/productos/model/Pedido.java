package com.ejemplo.productos.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Clase que representa un pedido.
 *
 * Contiene la información básica de un pedido, como su identificador,
 * descripción, total y fecha de realización.
 *
 * Además, mantiene la relación con el cliente que realizó el pedido
 * y los productos incluidos en él.
 *
 * @author Héctor Crespo
 * @version 1.0
 */
@Entity
@Table(name = "pedidos")
public class Pedido {

    /**
     * Identificador único del pedido.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Descripción del pedido.
     */
    @Column(name = "descripcion", nullable = false, length = 600)
    private String descripcion;

    /**
     * Importe total del pedido.
     */
    @Column(name = "total", nullable = false)
    private Double total;

    /**
     * Fecha de realización del pedido.
     */
    @Column(name = "fecha", nullable = false)
    private Date fecha;

    /**
     * Cliente que realizó el pedido.
     */
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    /**
     * Conjunto de productos incluidos en el pedido.
     */
    @ManyToMany
    @JoinTable(
            name = "pedido_producto",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    private Set<Producto> productos;

    /**
     * Constructor vacío necesario para JPA.
     */
    public Pedido() {
    }

    /**
     * Constructor con parámetros para inicializar el pedido.
     *
     * @param id identificador del pedido
     * @param descripcion descripción del pedido
     * @param total importe total del pedido
     * @param fecha fecha del pedido
     * @param cliente cliente asociado al pedido
     */
    public Pedido(Long id, String descripcion, Double total, Date fecha, Cliente cliente) {
        this.id = id;
        this.descripcion = descripcion;
        this.total = total;
        this.fecha = fecha;
        this.cliente = cliente;
    }

    /**
     * Obtiene el identificador del pedido.
     *
     * @return identificador del pedido
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador del pedido.
     *
     * @param id identificador del pedido
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la descripción del pedido.
     *
     * @return descripción del pedido
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del pedido.
     *
     * @param descripcion descripción del pedido
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el importe total del pedido.
     *
     * @return importe total
     */
    public Double getTotal() {
        return total;
    }

    /**
     * Establece el importe total del pedido.
     *
     * @param total importe total
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * Obtiene la fecha del pedido.
     *
     * @return fecha del pedido
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha del pedido.
     *
     * @param fecha fecha del pedido
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el cliente asociado al pedido.
     *
     * @return cliente del pedido
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Establece el cliente asociado al pedido.
     *
     * @param cliente cliente del pedido
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtiene el conjunto de productos del pedido.
     *
     * @return conjunto de productos
     */
    public Set<Producto> getProductos() {
        return productos;
    }

    /**
     * Establece el conjunto de productos del pedido.
     *
     * @param productos conjunto de productos
     */
    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }
}
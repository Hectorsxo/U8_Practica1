package com.ejemplo.productos.model;

import jakarta.persistence.*;
import java.util.List;

/**
 * Clase que representa un cliente.
 *
 * Contiene la información básica de un cliente, como su identificador,
 * nombre y ciudad de residencia.
 *
 * Además, mantiene la relación con los pedidos realizados por el cliente.
 *
 * @author Héctor Crespo
 * @version 1.0
 */
@Entity
@Table(name = "clientes")
public class Cliente {

    /**
     * Identificador único del cliente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del cliente.
     */
    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;

    /**
     * Ciudad de residencia del cliente.
     */
    @Column(name = "ciudad", nullable = false, length = 200)
    private String ciudad;

    /**
     * Lista de pedidos realizados por el cliente.
     */
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

    /**
     * Constructor vacío necesario para JPA.
     */
    public Cliente() {
    }

    /**
     * Constructor con parámetros para inicializar el cliente.
     *
     * @param id identificador del cliente
     * @param nombre nombre del cliente
     * @param ciudad ciudad de residencia del cliente
     * @param pedidos lista de pedidos del cliente
     */
    public Cliente(Long id, String nombre, String ciudad, List<Pedido> pedidos) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pedidos = pedidos;
    }

    /**
     * Obtiene el identificador del cliente.
     *
     * @return identificador del cliente
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador del cliente.
     *
     * @param id identificador del cliente
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     *
     * @param nombre nombre del cliente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la ciudad del cliente.
     *
     * @return ciudad del cliente
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad del cliente.
     *
     * @param ciudad ciudad del cliente
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Obtiene la lista de pedidos del cliente.
     *
     * @return lista de pedidos
     */
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    /**
     * Establece la lista de pedidos del cliente.
     *
     * @param pedidos lista de pedidos
     */
    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
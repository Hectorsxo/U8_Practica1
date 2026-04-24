package com.ejemplo.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de arranque de la aplicación Spring Boot.
 *
 * Inicia el contexto de la aplicación y configura automáticamente
 * los componentes definidos en el proyecto.
 *
 * @author Héctor Crespo
 * @version 1.0
 */
@SpringBootApplication
public class ProductosCategoriasApplication {

    /**
     * Constructor por defecto.
     */
    public ProductosCategoriasApplication() {
    }

    /**
     * Método principal que inicia la ejecución de la aplicación.
     *
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        SpringApplication.run(ProductosCategoriasApplication.class, args);
    }
}
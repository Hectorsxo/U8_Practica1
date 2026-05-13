package com.ejemplo.productos.repository;

import com.ejemplo.productos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interfaz de acceso a datos para la entidad Producto.
 *
 * Extiende JpaRepository para heredar operaciones CRUD básicas y define métodos
 * de consulta derivados (Query Methods) para realizar búsquedas personalizadas
 * en la base de datos de productos.
 *
 * @author Héctor Crespo
 * @version 1.0
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    /**
     * Busca productos cuyo precio sea estrictamente menor al valor indicado.
     *
     * @param precio Valor de corte para la comparación.
     * @return Lista de productos que cumplen el criterio.
     */
    List<Producto> findByPrecioLessThan(double precio);

    /**
     * Busca productos cuyo precio sea estrictamente mayor al valor indicado.
     *
     * @param precio Valor de corte para la comparación.
     * @return Lista de productos que cumplen el criterio.
     */
    List<Producto> findByPrecioGreaterThan(double precio);

    /**
     * Recupera un único producto buscando por su nombre exacto.
     *
     * @param nombre Nombre completo del producto.
     * @return El producto encontrado o null si no existe coincidencia.
     */
    Producto findByNombre(String nombre);

    /**
     * Busca productos cuyo nombre contenga la cadena de texto especificada.
     * Equivale a una consulta SQL con LIKE %texto%.
     *
     * @param texto Cadena a buscar dentro del nombre.
     * @return Lista de productos que contienen el texto.
     */
    List<Producto> findByNombreContaining(String texto);

    /**
     * Busca productos cuyo nombre comience por el texto indicado.
     * Equivale a una consulta SQL con LIKE texto%.
     *
     * @param texto Prefijo del nombre.
     * @return Lista de productos encontrados.
     */
    List<Producto> findByNombreStartingWith(String texto);

    /**
     * Busca productos cuyo nombre finalice con el texto indicado.
     * Equivale a una consulta SQL con LIKE %texto.
     *
     * @param texto Sufijo del nombre.
     * @return Lista de productos encontrados.
     */
    List<Producto> findByNombreEndingWith(String texto);

    /**
     * Busca productos pertenecientes a una categoría específica mediante su nombre.
     * Realiza un join implícito entre las entidades Producto y Categoria.
     *
     * @param categoria Nombre de la categoría.
     * @return Lista de productos asociados a dicha categoría.
     */
    List<Producto> findByCategoriaNombre(String categoria);

    /**
     * Busca productos de una categoría cuyo precio sea inferior a un límite.
     *
     * @param categoria Nombre de la categoría.
     * @param precio Límite de precio superior.
     * @return Lista de productos filtrados por categoría y precio máximo.
     */
    List<Producto> findByCategoriaNombreAndPrecioLessThan(String categoria, Double precio);

    /**
     * Busca productos de una categoría específica que contengan un texto en su nombre.
     *
     * @param categoria Nombre de la categoría.
     * @param nombre Texto a buscar en el nombre del producto.
     * @return Lista de productos que cumplen ambos criterios.
     */
    List<Producto> findByCategoriaNombreAndNombreContaining(String categoria, String nombre);

    /**
     * Busca productos que cumplan al menos una de las dos condiciones:
     * contener el texto en el nombre o tener un precio menor al indicado.
     *
     * @param nombre Texto a buscar en el nombre.
     * @param precio Límite de precio.
     * @return Lista de productos que cumplen el criterio OR.
     */
    List<Producto> findByNombreContainingOrPrecioLessThan(String nombre, Double precio);

    /**
     * Obtiene todos los productos ordenados por precio de forma ascendente.
     *
     * @return Lista de productos ordenada de menor a mayor precio.
     */
    List<Producto> findByOrderByPrecioAsc();

    /**
     * Busca productos cuyo precio se encuentre dentro del rango inclusivo especificado.
     *
     * @param min Límite inferior del precio.
     * @param max Límite superior del precio.
     * @return Lista de productos dentro del rango de precios.
     */
    List<Producto> findByPrecioBetween(Double min, Double max);

    /**
     * Busca productos de una categoría cuyo precio sea superior a un valor dado.
     *
     * @param categoria Nombre de la categoría.
     * @param precio Límite de precio inferior.
     * @return Lista de productos filtrados por categoría y precio mínimo.
     */
    List<Producto> findByCategoriaNombreAndPrecioGreaterThan(String categoria, Double precio);

}
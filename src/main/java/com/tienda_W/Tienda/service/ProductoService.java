
package com.tienda_W.Tienda.service;

import com.tienda_W.Tienda.domain.Producto;
import java.util.List;

/**
 *
 * @author Adria
 */
public interface ProductoService {
    //Se obtiene un arraylist  con todas las productos de la tabla
    public List<Producto> getProductos(boolean activo);
    
    
    //Se obtiene una producto según el Id pasado por parámetro
    public Producto getProducto(Producto producto);
    
    //se actualiza una producto o se inserta una nueva
    public void save(Producto producto);
    
    //Se elimina una producto segun el id pasado
    public void delete(Producto producto);
}

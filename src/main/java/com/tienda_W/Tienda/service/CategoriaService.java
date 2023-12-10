
package com.tienda_W.Tienda.service;

import com.tienda_W.Tienda.domain.Categoria;
import java.util.List;

/**
 *
 * @author Adria
 */
public interface CategoriaService {
    //Se obtiene un arraylist  con todas las categorias de la tabla
    public List<Categoria> getCategorias(boolean activo);
    
    
    //Se obtiene una categoria según el Id pasado por parámetro
    public Categoria getCategoria(Categoria categoria);
    
    //se actualiza una categoria o se inserta una nueva
    public void save(Categoria categoria);
    
    //Se elimina una categoria segun el id pasado
    public void delete(Categoria categoria);
}

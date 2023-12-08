
package com.tienda_W.Tienda.service;

import com.tienda_W.Tienda.domain.Categoria;
import java.util.List;

/**
 *
 * @author Adria
 */
public interface CategoriaService {
    
    public List<Categoria> getCategorias(boolean activo);
    
}

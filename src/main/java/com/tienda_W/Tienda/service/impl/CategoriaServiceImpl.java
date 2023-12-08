
package com.tienda_W.Tienda.service.impl;

import com.tienda_W.Tienda.dao.CategoriaDao;
import com.tienda_W.Tienda.domain.Categoria;
import com.tienda_W.Tienda.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adria
 */
@Service
public class CategoriaServiceImpl 
        implements CategoriaService {

    
    @Autowired
    private CategoriaDao categoriaDao;
    
    @Override
    public List<Categoria> getCategorias(boolean activo) {
        var categorias = categoriaDao.findAll();
        return categorias;
    }
    
}

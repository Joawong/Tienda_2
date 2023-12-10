
package com.tienda_W.Tienda.service.impl;

import com.tienda_W.Tienda.dao.CategoriaDao;
import com.tienda_W.Tienda.domain.Categoria;
import com.tienda_W.Tienda.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class CategoriaServiceImpl 
        implements CategoriaService {

    
    @Autowired
    private CategoriaDao categoriaDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Categoria> getCategorias(boolean activo) {
        var categorias = categoriaDao.findAll();
        //si son solo activas (activo = true) debo filtrar las inactivas...
        if(activo){
            categorias.removeIf(e -> !e.isActivo());
        }
        return categorias;
    }
    
    //Se obtiene una categoria según el Id pasado por parámetro
    @Transactional(readOnly=true)
    @Override
    public Categoria getCategoria(Categoria categoria){
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }
    
    //se actualiza una categoria o se inserta una nueva
    @Override
    public void save(Categoria categoria){
        categoriaDao.save(categoria);
    }
    
    //Se elimina una categoria segun el id pasado
    @Override
    public void delete(Categoria categoria){
         categoriaDao.delete(categoria);
        
    }    
}


package com.tienda_W.Tienda.service.impl;

import com.tienda_W.Tienda.dao.ProductoDao;
import com.tienda_W.Tienda.domain.Producto;
import com.tienda_W.Tienda.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class ProductoServiceImpl 
        implements ProductoService {

    
    @Autowired
    private ProductoDao productoDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Producto> getProductos(boolean activo) {
        var productos = productoDao.findAll();
        //si son solo activas (activo = true) debo filtrar las inactivas...
        if(activo){
            productos.removeIf(e -> !e.isActivo());
        }
        return productos;
    }
    
    //Se obtiene una producto según el Id pasado por parámetro
    @Transactional(readOnly=true)
    @Override
    public Producto getProducto(Producto producto){
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }
    
    //se actualiza una producto o se inserta una nueva
    @Override
    public void save(Producto producto){
        productoDao.save(producto);
    }
    
    //Se elimina una producto segun el id pasado
    @Override
    public void delete(Producto producto){
         productoDao.delete(producto);
        
    }    
}

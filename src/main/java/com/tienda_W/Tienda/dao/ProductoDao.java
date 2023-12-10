
package com.tienda_W.Tienda.dao;

import com.tienda_W.Tienda.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductoDao 
        extends JpaRepository<Producto, Long>{
    
}

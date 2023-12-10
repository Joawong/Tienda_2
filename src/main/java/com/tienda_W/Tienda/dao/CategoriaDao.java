
package com.tienda_W.Tienda.dao;

import com.tienda_W.Tienda.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoriaDao 
        extends JpaRepository<Categoria, Long>{
    
}

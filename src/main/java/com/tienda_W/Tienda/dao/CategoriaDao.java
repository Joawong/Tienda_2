
package com.tienda_W.Tienda.dao;

import com.tienda_W.Tienda.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Adria
 */
//data access object // objeto de acceso a los datos
public interface CategoriaDao 
        extends JpaRepository<Categoria, Long>{
    
}

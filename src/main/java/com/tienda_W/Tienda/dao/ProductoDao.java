
package com.tienda_W.Tienda.dao;

import com.tienda_W.Tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ProductoDao 
        extends JpaRepository<Producto, Long>{
    
    
    //metodo para obtener un listado de producto filtrado por precio, ordenado por descripcion
    // findByPrecioBetweenOrderByDescripcion = findBy(<- verbo)Precio(<-atributo de la tabla producto)
    //Between(<-el lugar donde va a buscarlo)OrderBy(<-ordenador por)Descripcion(<-atributo)
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);
    
    @Query(value="Select a from Producto a where a.precio between :precioInf and :precioSup order by a.descripcion asc")
    public List<Producto> consultaJPQL(double precioInf, double precioSup);
    
    @Query(nativeQuery=true,value="Select * from Producto a where a.precio between :precioInf and :precioSup order by a.descripcion asc")
    public List<Producto> consultaSQL(double precioInf, double precioSup);
}

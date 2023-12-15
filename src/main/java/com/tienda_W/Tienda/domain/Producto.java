
package com.tienda_W.Tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Adria
 */
@Data
@Entity
@Table(name = "producto")

public class Producto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;
    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias;
    private String rutaImagen;
    private boolean activo;
    
    
    /*@ManyToOne: Indicates a many-to-one 
    relationship with another entity, in this case, a Categoria entity.*
    @JoinColumn(name="id_categoria"): 
    Specifies the name of the foreign key 
    column in the producto table that links to the primary key of the Categoria table.
    */
    @ManyToOne
    @JoinColumn(name="id_categoria")
    private Categoria categoria;
    /*
    private Categoria categoria;: 
    Represents the many-to-one relationship with the Categoria entity. 
    Each Producto belongs to a single Categoria.
    */
    
    
    
    
}

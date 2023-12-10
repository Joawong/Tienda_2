package com.tienda_W.Tienda.controller;

import com.tienda_W.Tienda.domain.Producto;
import com.tienda_W.Tienda.service.ProductoService;
import com.tienda_W.Tienda.service.FirebaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Adria
 */
@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var productos = productoService.getProductos(false);

        model.addAttribute("productos", productos);
        model.addAttribute("totalProductos", productos.size());

        return "/producto/listado";
    }

    //el parametro es el mismo nombre de la variable que está en el domain
    @GetMapping("/eliminar/{idProducto}")
    public String eliminar(Producto producto) {
        productoService.delete(producto);
        return "redirect:/producto/listado";
    }


    @GetMapping("/modificar/{idProducto}")
    public String modificar(Producto producto, Model model) {
        producto = productoService.getProducto(producto);
        model.addAttribute("producto", producto);
        return "/producto/modifica";
    }

    @Autowired
    private FirebaseStorageService firabaseStorageService;

    @PostMapping("/guardar")
    public String guardar(Producto producto, @RequestParam("imagenFile")
        MultipartFile imagenFile) {

        if (!imagenFile.isEmpty()) {
            productoService.save(producto);
            String ruta=firabaseStorageService.cargaImagen(imagenFile, 
                    "producto", producto.getIdProducto());
            producto.setRutaImagen(ruta);
            }
        
        productoService.save(producto);
        return "redirect:/producto/listado";
    }
}

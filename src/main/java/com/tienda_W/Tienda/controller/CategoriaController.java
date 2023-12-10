package com.tienda_W.Tienda.controller;

import com.tienda_W.Tienda.domain.Categoria;
import com.tienda_W.Tienda.service.CategoriaService;
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
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var categorias = categoriaService.getCategorias(false);

        model.addAttribute("categorias", categorias);
        model.addAttribute("totalCategorias", categorias.size());

        return "/categoria/listado";
    }

    //el parametro es el mismo nombre de la variable que está en el domain
    @GetMapping("/eliminar/{idCategoria}")
    public String eliminar(Categoria categoria) {
        categoriaService.delete(categoria);
        return "redirect:/categoria/listado";
    }


    @GetMapping("/modificar/{idCategoria}")
    public String modificar(Categoria categoria, Model model) {
        categoria = categoriaService.getCategoria(categoria);
        model.addAttribute("categoria", categoria);
        return "/categoria/modifica";
    }

    @Autowired
    private FirebaseStorageService firabaseStorageService;

    @PostMapping("/guardar")
    public String guardar(Categoria categoria, @RequestParam("imagenFile")
        MultipartFile imagenFile) {

        if (!imagenFile.isEmpty()) {
            categoriaService.save(categoria);
            String ruta=firabaseStorageService.cargaImagen(imagenFile, 
                    "categoria", categoria.getIdCategoria());
            categoria.setRutaImagen(ruta);
            }
        
        categoriaService.save(categoria);
        return "redirect:/categoria/listado";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.eggNews.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author franc
 */

@Controller
@RequestMapping("/noticia")//localhost:8080/noticia
public class NoticiaControlador {
    
    @GetMapping("/registrar") //localhost:8080/noti/registrar
    public String registrar(){
        return "noticia.html";
    }
    
    @PostMapping("/registro")
    public String registro(@RequestParam String titulo){
        System.out.println("Titulo"+titulo);
        
        return "noticia.html";
    }
}

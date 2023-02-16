/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.eggNews.servicios;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practica.eggNews.entidades.Noticia;
import practica.eggNews.excepciones.MiException;
import practica.eggNews.repositorios.NoticiaRepositorio;

/**
 *
 * @author franc
 */
@Service
public class NoticiaServicio {
    
    @Autowired
    private NoticiaRepositorio noticiaRepo;
    
    @Transactional
    public void crearNoticia(String titulo, String cuerpo) throws MiException{
        validar(titulo, cuerpo);
           
        Noticia noticia = new Noticia();
        
        noticia.setTitulo(titulo);
        noticia.setCuerpo(cuerpo);
        
        noticiaRepo.save(noticia);
    }
    
    public Noticia buscarNoticia(Integer id){
        Noticia noticia = new Noticia();
        
        noticia = noticiaRepo.findById(id).get();
            
        return noticia;
    }
    
    @Transactional
    public void modificarNoticia(Integer id, String Titulo, String Cuerpo) throws MiException{
        
         validar(Titulo, Cuerpo);
         
        Optional<Noticia> respuesta = noticiaRepo.findById(id);
        
        if(respuesta.isPresent()){
            Noticia noticia = respuesta.get();
            noticia.setCuerpo(Cuerpo);
            noticia.setTitulo(Titulo);
            noticiaRepo.save(noticia);
        }
        
        
        
    }
    
    private void validar(String titulo, String cuerpo) throws MiException{
        if(titulo.isEmpty() || titulo == null){
            throw new MiException("El titulo no puede ser nulo o estar vacio");
        }
        
        if(cuerpo.isEmpty() || cuerpo == null){
            throw new MiException("El cuerpo no puede ser nulo o estar vacio");
        }
    }
    
    private void validarNuevosDatos(String titulo,String nuevoCuerpo, String NuevoTitulo) throws MiException{
        if(titulo.isEmpty() || titulo == null){
            throw new MiException("El titulo no puede ser nulo o estar vacio");
        }
        
        if(nuevoCuerpo.isEmpty() || nuevoCuerpo == null){
            throw new MiException("El  nuevo cuerpo no puede ser nulo o estar vacio");
        }
        if(NuevoTitulo.isEmpty() || NuevoTitulo == null){
            throw new MiException("El nuevo titulo no puede ser nulo o estar vacio");
        }
    }
    
}

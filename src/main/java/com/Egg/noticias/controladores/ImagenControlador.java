
package com.Egg.noticias.controladores;

import com.Egg.noticias.entidades.Usuario;
import com.Egg.noticias.repositorios.UsuarioRepositorio;
import com.Egg.noticias.servicios.UsuarioServicio;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/imagen")
public class ImagenControlador {
    
    @Autowired
    private UsuarioServicio usuarioServicio;
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
    @GetMapping("/perfil/{id}")
    public ResponseEntity<byte[]> imagenUsuario(@PathVariable String id){
        
        Optional<Usuario> usuarioRespuesta=usuarioRepositorio.findById(id);
        
        byte[] imagen=usuarioRespuesta.get().getImagen().getContenido();
        
        HttpHeaders headers=new HttpHeaders();
        
        headers.setContentType(MediaType.IMAGE_PNG);
        
        return new ResponseEntity<>(imagen, headers, HttpStatus.OK);
        
     
        
        
    }
    
}

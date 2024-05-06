package es.ieslavereda.springboot_class2324.controller;

import es.ieslavereda.springboot_class2324.repository.Usuario;
import es.ieslavereda.springboot_class2324.service.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuarios/{id}")
    public Usuario getById(@PathVariable("id") int id){
        return usuarioService.getById(id);
    }

    @GetMapping("/usuarios/")
    public List<Usuario> getAll(){
        return usuarioService.getAll();
    }


}

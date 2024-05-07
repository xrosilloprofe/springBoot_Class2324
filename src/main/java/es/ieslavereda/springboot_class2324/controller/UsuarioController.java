package es.ieslavereda.springboot_class2324.controller;

import es.ieslavereda.springboot_class2324.repository.model.Usuario;
import es.ieslavereda.springboot_class2324.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

//    public UsuarioController(UsuarioService usuarioService){
//        this.usuarioService = usuarioService;
//    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id){
        Usuario usuario1 = usuarioService.getById(id);
        if(usuario1==null)
            return new ResponseEntity<>("El usuario no existe", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(usuario1,HttpStatus.OK);
    }

    @GetMapping("/usuarios/")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(usuarioService.getAll(),HttpStatus.OK);
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id){
        Usuario usuario1 = usuarioService.deleteUser(id);
        if(usuario1==null)
            return new ResponseEntity<>("El usuario no existe", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(usuario1,HttpStatus.OK);
    }

    @PutMapping("/usuarios/")
    public ResponseEntity<?> updateUser(@RequestBody Usuario usuario){
        Usuario usuario1 = usuarioService.updateUser(usuario);
        if(usuario1==null)
            return new ResponseEntity<>("El usuario no existe", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(usuario1,HttpStatus.OK);
    }

    @PostMapping("/usuarios/")
    public ResponseEntity<?> addUser(@RequestBody Usuario usuario){
        Usuario usuario1 = usuarioService.addUser(usuario);
        if(usuario1==null)
            return new ResponseEntity<>("El usuario ya existe", HttpStatus.FOUND);
        return new ResponseEntity<>(usuario1,HttpStatus.OK);
    }

}

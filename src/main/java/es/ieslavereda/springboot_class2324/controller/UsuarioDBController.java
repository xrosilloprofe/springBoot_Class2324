package es.ieslavereda.springboot_class2324.controller;

import es.ieslavereda.springboot_class2324.service.UsuarioDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/apidb")
public class UsuarioDBController {
    @Autowired
    private UsuarioDBService dbService;

    @GetMapping("/usuarios/")
    public ResponseEntity<?> getAll(){
        try {
            return new ResponseEntity<>(dbService.getAll(), HttpStatus.OK);
        } catch (SQLException e){
            return new ResponseEntity<>(e.getErrorCode(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

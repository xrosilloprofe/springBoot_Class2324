package es.ieslavereda.springboot_class2324;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloWorldController {

    @GetMapping("/hello/{nombre}")
    public String getHello(@PathVariable("nombre") String nombre){
        return "Hola desarrollador " + nombre;
    }

}

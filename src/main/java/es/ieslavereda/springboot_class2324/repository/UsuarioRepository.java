package es.ieslavereda.springboot_class2324.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository {
    private List<Usuario> usuarios;

    public UsuarioRepository(){
        usuarios = new ArrayList<>();
        usuarios.add(Usuario.builder().id(1).
                nombre("xavi").apellidos("rosillo").build());
        usuarios.add(new Usuario(2,"luna","navarro"));
        usuarios.add(Usuario.builder().id(3).
                nombre("pepa").apellidos("garcía").build());
        usuarios.add(Usuario.builder().id(4).
                nombre("blanca").apellidos("romero").build());
    }

    public Usuario getById(int id){
        Optional<Usuario> usuarioOptional = usuarios.stream().
                filter(usuario -> id== usuario.getId()).findFirst();

        if(usuarioOptional.isPresent())
            return usuarioOptional.get();

        return null;

    }

    public List<Usuario> getAll(){
        return usuarios;
    }

}

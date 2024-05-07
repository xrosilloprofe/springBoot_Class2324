package es.ieslavereda.springboot_class2324.repository;

import es.ieslavereda.springboot_class2324.repository.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository implements IUsuarioRepository{
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

    @Override
    public Usuario getById(int id){
        Optional<Usuario> usuarioOptional = usuarios.stream().
                filter(usuario -> id== usuario.getId()).findFirst();

        if(usuarioOptional.isPresent())
            return usuarioOptional.get();

        return null;

    }

    @Override
    public List<Usuario> getAll(){
        return usuarios;
    }

    @Override
    public Usuario deleteUser(int id) {
        Usuario usuario = getById(id);
        if(usuario!=null)
            usuarios.remove(usuario);
        return usuario;
    }

    @Override
    public Usuario updateUser(Usuario usuario) {
        Usuario usuario1 = getById(usuario.getId());

        if(usuario1!=null){
            usuario1.setNombre(usuario.getNombre());
            usuario1.setApellidos(usuario.getApellidos());
        }

        return usuario1;
    }

    @Override
    public Usuario addUser(Usuario usuario) {
        if(!usuarios.contains(usuario)) {
            usuarios.add(usuario);
            return usuario;
        }
        return null;
    }

}

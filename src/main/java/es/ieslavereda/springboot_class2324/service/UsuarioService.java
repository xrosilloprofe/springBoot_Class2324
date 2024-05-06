package es.ieslavereda.springboot_class2324.service;

import es.ieslavereda.springboot_class2324.repository.Usuario;
import es.ieslavereda.springboot_class2324.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario getById(int id){
        return usuarioRepository.getById(id);
    }

    public List<Usuario> getAll(){
        return usuarioRepository.getAll();
    }
}

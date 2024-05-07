package es.ieslavereda.springboot_class2324.repository;

import es.ieslavereda.springboot_class2324.repository.model.Usuario;

import java.util.List;

public interface IUsuarioRepository {
    Usuario getById(int id);
    List<Usuario> getAll();
    Usuario deleteUser(int id);
    Usuario updateUser(Usuario usuario);
    Usuario addUser(Usuario usuario);
}

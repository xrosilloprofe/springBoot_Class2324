package es.ieslavereda.springboot_class2324.repository;

import es.ieslavereda.springboot_class2324.repository.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface IUsuarioDBRepository {
    List<Usuario> getAll() throws SQLException;
    Usuario getbyID(int id) throws SQLException;
    Usuario deleteUser(int id) throws SQLException;
    Usuario addUser(Usuario usuario) throws SQLException;
    Usuario updateUser(Usuario usuario) throws SQLException;

}

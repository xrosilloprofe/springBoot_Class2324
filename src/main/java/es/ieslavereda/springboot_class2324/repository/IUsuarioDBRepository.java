package es.ieslavereda.springboot_class2324.repository;

import es.ieslavereda.springboot_class2324.repository.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface IUsuarioDBRepository {
    List<Usuario> getAll() throws SQLException;
    Usuario getbyID() throws SQLException;
    Usuario deleteUser() throws SQLException;
    Usuario addUser() throws SQLException;
    Usuario updateUser() throws SQLException;

}

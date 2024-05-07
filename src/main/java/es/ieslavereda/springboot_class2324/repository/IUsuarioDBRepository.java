package es.ieslavereda.springboot_class2324.repository;

import es.ieslavereda.springboot_class2324.repository.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface IUsuarioDBRepository {
    List<Usuario> getAll() throws SQLException;

}

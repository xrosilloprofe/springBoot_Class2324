package es.ieslavereda.springboot_class2324.service;

import es.ieslavereda.springboot_class2324.repository.UsuarioDBRepository;
import es.ieslavereda.springboot_class2324.repository.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UsuarioDBService {

    @Autowired
    private UsuarioDBRepository dbRepository;

    public List<Usuario> getAll() throws SQLException {
        return dbRepository.getAll();
    }
    public Usuario getbyID(int id) throws SQLException{
        return dbRepository.getbyID(id);
    }
    public Usuario deleteUser(int id) throws SQLException{
        return dbRepository.deleteUser(id);
    }
    public Usuario addUser(Usuario usuario) throws SQLException{
        return dbRepository.addUser(usuario);
    }
    public Usuario updateUser(Usuario usuario) throws SQLException{
        return dbRepository.updateUser(usuario);
    }

}

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

}

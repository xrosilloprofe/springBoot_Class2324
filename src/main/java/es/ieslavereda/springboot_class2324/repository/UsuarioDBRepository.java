package es.ieslavereda.springboot_class2324.repository;

import es.ieslavereda.springboot_class2324.repository.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioDBRepository implements IUsuarioDBRepository{

    @Autowired
    @Qualifier("mysqlDataSource")
    private DataSource  dataSource;


    @Override
    public List<Usuario> getAll() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM usuario";

        try(Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)){
            while(resultSet.next()){
                usuarios.add(Usuario.builder().id(resultSet.getInt(1)).
                        nombre(resultSet.getString(2)).
                        apellidos(resultSet.getString(3)).
                        build());
            }
        }

        return usuarios;
    }

    @Override
    public Usuario getbyID(int id) throws SQLException {
        Usuario usuario = null;
        String query = "select * from usuario where id = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1,id);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next())
               usuario = new Usuario(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3));
        }
        return usuario;
    }

    @Override
    public Usuario deleteUser(int id) throws SQLException {
        Usuario usuario = getbyID(id);
        String query = "delete from usuario where id = ?";

        if(usuario==null)
            return null;

        try(Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1,id);
            ps.executeUpdate();
        }
        return usuario;
    }

    @Override
    public Usuario addUser() throws SQLException {
        return null;
    }

    @Override
    public Usuario updateUser() throws SQLException {
        return null;
    }
}

package com.example.prueba.dao;

import com.example.prueba.dto.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DaoImpl implements Dao{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private Connection connection;

    private void obtenerConexion() throws SQLException {
        connection = jdbcTemplate.getDataSource().getConnection();
    }

    private void cerrarConexion() throws SQLException {
        connection.close();
        connection=null;
    }

    public List<Producto> obtenerProductos() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        obtenerConexion();
        Statement statement = connection.createStatement();
        String sql = "SELECT codigo, nombre" +
                " FROM producto";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            Producto producto = new Producto();
            producto.setCodigo(resultSet.getInt("codigo"));
            producto.setNombre(resultSet.getString("nombre"));
            productos.add(producto);
            }
        resultSet.close();
        statement.close();
        connection.close();

        return productos;
    }
}

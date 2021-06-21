package com.example.prueba.dao;

import com.example.prueba.dto.Producto;

import java.sql.SQLException;
import java.util.List;

public interface Dao {
    public List<Producto> obtenerProductos() throws SQLException;
}

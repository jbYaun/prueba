package com.example.prueba.servicio;

import com.example.prueba.dao.Dao;
import com.example.prueba.dto.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ServicioImpl implements Servicio{
    @Autowired
    private Dao dao;
    public List<Producto> obtenerProductos(){
            List<Producto> Lista = new ArrayList<>();
        try {
            Lista = dao.obtenerProductos();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Lista;
    }

}

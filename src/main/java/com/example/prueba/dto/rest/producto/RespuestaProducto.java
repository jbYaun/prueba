package com.example.prueba.dto.rest.producto;

import com.example.prueba.dto.Producto;
import lombok.Data;

import java.util.List;

@Data
public class RespuestaProducto {
    private List<Producto> lista;
}

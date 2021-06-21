package com.example.prueba.controlador;


import com.example.prueba.dto.rest.producto.RespuestaProducto;
import com.example.prueba.servicio.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador {

    @Autowired
    private Servicio servicio;
    @RequestMapping(value = "/obtener-productos",
            method = RequestMethod.POST,
            produces = "application/json;charset=utf-8",
            consumes = "application/json;charset=utf-8"
    )
    public @ResponseBody RespuestaProducto obtenerProductos(){
        RespuestaProducto respuestaProducto = new RespuestaProducto();
        respuestaProducto.setLista(servicio.obtenerProductos());
        return respuestaProducto;
    }
}

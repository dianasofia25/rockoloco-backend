package com.mintic.backRockoloco.controladores;

import com.mintic.backRockoloco.entidades.Cancion;
import com.mintic.backRockoloco.entidades.Decada;
import com.mintic.backRockoloco.servicios.CancionesServicios;
import com.mintic.backRockoloco.servicios.DecadasServicios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/decadas")
@CrossOrigin(origins = "*")
public class DecadasControlador {
    
    @Autowired
    private DecadasServicios decadasServicios;
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/todas", method = RequestMethod.GET)
    public List<Decada> obtenerDecadas(){
        return decadasServicios.consultar();
    }
    
}

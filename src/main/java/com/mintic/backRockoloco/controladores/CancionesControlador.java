package com.mintic.backRockoloco.controladores;

import com.mintic.backRockoloco.entidades.Cancion;
import com.mintic.backRockoloco.servicios.CancionesServicios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/canciones")
@CrossOrigin(origins = "*")
public class CancionesControlador {
    
    @Autowired
    private CancionesServicios cancionesServicios;
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/todas", method = RequestMethod.GET)
    public List<Cancion> obtenerCanciones(){
        return cancionesServicios.consultar();
    }
    
    //Crear
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity <Cancion> crearCanciones(@RequestBody Cancion objCancion){
        if (cancionesServicios.agregar(objCancion)) {
            return ResponseEntity.ok(objCancion);
        }else{
            return ResponseEntity.notFound().build();
        }  
    } 
    
    //Endpoint para eliminar***********************
    @ResponseStatus(code = HttpStatus.OK, reason = "Objeto eliminado correctamente")
    @RequestMapping(value = "/delete/{codigo}", method = RequestMethod.DELETE)
    public void borrarCanciones(@PathVariable Integer codigo){
        cancionesServicios.eliminar(codigo);
    }

    //Endpoint para buscar
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/buscar/{codigo}", method = RequestMethod.GET)
    public Cancion buscarUno(@PathVariable Integer codigo){
        return cancionesServicios.buscar(codigo);
    }
    
    //Endpoint para actualizar
    @ResponseStatus(code = HttpStatus.OK, reason = "Objeto actualizado correctamente")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Boolean actualizarCanciones(@RequestBody Cancion miObjeto){
        return cancionesServicios.actualizar(miObjeto);
    }
    
}

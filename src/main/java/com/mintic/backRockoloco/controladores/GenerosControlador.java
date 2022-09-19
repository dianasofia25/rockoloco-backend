package com.mintic.backRockoloco.controladores;

import com.mintic.backRockoloco.entidades.Genero;
import com.mintic.backRockoloco.servicios.GenerosServicios;
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
@RequestMapping("/generos")
@CrossOrigin(origins = "*")
public class GenerosControlador {
   
    @Autowired
    private GenerosServicios generosServicios;
    
    //Endpoint para listar
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public List<Genero> obtenerGeneros(){
        return generosServicios.consultar();
    }
    
    //Endpoint para crear
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity <Genero> crearGeneros(@RequestBody Genero objGen){
        if (generosServicios.agregar(objGen)) {
            return ResponseEntity.ok(objGen);
        }else{
            return ResponseEntity.notFound().build();
        }  
    }
    
    //Endpoint para eliminar***********************
    @ResponseStatus(code = HttpStatus.OK, reason = "Objeto eliminado correctamente")
    @RequestMapping(value = "/delete/{codigo}", method = RequestMethod.DELETE)
    public void borrarGeneros(@PathVariable Integer codigo){
        generosServicios.eliminar(codigo);
    }

    //Endpoint para buscar
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/buscar/{codigo}", method = RequestMethod.GET)
    public Genero buscarUno(@PathVariable Integer codigo){
        return generosServicios.buscar(codigo);
    }
    
    //Endpoint para actualizar
    @ResponseStatus(code = HttpStatus.OK, reason = "Objeto actualizado correctamente")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Boolean actualizarGeneros(@RequestBody Genero miObjeto){
        return generosServicios.actualizar(miObjeto);
    }
    
}

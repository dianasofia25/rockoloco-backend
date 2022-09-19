package com.mintic.backRockoloco.controladores;

import com.mintic.backRockoloco.entidades.Artista;
import com.mintic.backRockoloco.servicios.ArtistasServicios;
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

/// Cuarto se crean los controladores
@RestController
@RequestMapping("/artistas")
@CrossOrigin(origins = "*")
public class ArtistasControlador {
    
    @Autowired
    private ArtistasServicios artistasServicios;
    
    //listar
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public List<Artista> obtenerArtistas(){
        return artistasServicios.consultar();
    }
    
    
    //Crear
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity <Artista> crearArtistas(@RequestBody Artista objArtist){
        if (artistasServicios.agregar(objArtist)) {
            return ResponseEntity.ok(objArtist);
        }else{
            return ResponseEntity.notFound().build();
        }  
    } 
    
    //Endpoint para eliminar***********************
    @ResponseStatus(code = HttpStatus.OK, reason = "Objeto eliminado correctamente")
    @RequestMapping(value = "/delete/{codigo}", method = RequestMethod.DELETE)
    public void borrarArtistas(@PathVariable Integer codigo){
        artistasServicios.eliminar(codigo);
    }

    //Endpoint para buscar
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/buscar/{codigo}", method = RequestMethod.GET)
    public Artista buscarUno(@PathVariable Integer codigo){
        return artistasServicios.buscar(codigo);
    }
    
    //Endpoint para actualizar
    @ResponseStatus(code = HttpStatus.OK, reason = "Objeto actualizado correctamente")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Boolean actualizarArtistas(@RequestBody Artista miObjeto){
        return artistasServicios.actualizar(miObjeto);
    }
    
}

package com.mintic.backRockoloco.servicios;

import com.mintic.backRockoloco.entidades.Cancion;
import com.mintic.backRockoloco.interfaces.Operaciones;
import com.mintic.backRockoloco.repositorios.CancionesRepositorios;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service("cancionesServices")
public class CancionesServicios implements Operaciones<Cancion>{

    @Autowired
    private CancionesRepositorios cancionesRepo;
    
    @Override
    public List<Cancion> consultar() {
        return cancionesRepo.obtenerTodasC();
    }

    @Override
    public Boolean agregar(Cancion miObjeto) {
        Cancion temporal = cancionesRepo.save(miObjeto);
        return temporal!=null;
    }

    @Override
    public Boolean eliminar(Integer llavePrimaria) {
        cancionesRepo.deleteById(llavePrimaria);
        return !cancionesRepo.existsById(llavePrimaria);
    }

    @Override
    public Cancion buscar(Integer llavePrimaria) {
        return cancionesRepo.findById(llavePrimaria).get();
    }
    
    @Override
    public Boolean actualizar(Cancion miObjeto) {
        Optional<Cancion> objVerificar=cancionesRepo.findById(miObjeto.getCodCancion());
        if (!objVerificar.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Objeto no aceptado");
        } else {
            cancionesRepo.save(miObjeto);
            return true;
        }
        
    }

    @Override
    public Integer cantidadRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


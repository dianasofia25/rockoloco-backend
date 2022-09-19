package com.mintic.backRockoloco.servicios;

import com.mintic.backRockoloco.entidades.Artista;
import com.mintic.backRockoloco.interfaces.Operaciones;
import com.mintic.backRockoloco.repositorios.ArtistasRepositorios;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/// Tercero se crean los servicios 
@Service("artistasServices")
public class ArtistasServicios implements Operaciones<Artista>{

    @Autowired /// Induccion de dependencias, inyectar las consultas del repositorio aqui
    private ArtistasRepositorios artistasRepo;
        
    @Override
    public List<Artista> consultar() {
        return artistasRepo.obtenerTodosA();
    }

    @Override
    public Boolean agregar(Artista miObjeto) {
        Artista temporal = artistasRepo.save(miObjeto);
        return temporal!=null;
    }

    @Override
    public Boolean eliminar(Integer llavePrimaria) {
        artistasRepo.deleteById(llavePrimaria);
        return !artistasRepo.existsById(llavePrimaria);
    }

    @Override
    public Artista buscar(Integer llavePrimaria) {
        return artistasRepo.findById(llavePrimaria).get();
    }
    
    @Override
    public Boolean actualizar(Artista miObjeto) {
        Optional<Artista> objVerificar=artistasRepo.findById(miObjeto.getCodArtista());
        if (!objVerificar.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Objeto no aceptado");
        } else {
            artistasRepo.save(miObjeto);
            return true;
        }
        
    }

    @Override
    public Integer cantidadRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

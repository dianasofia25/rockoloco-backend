package com.mintic.backRockoloco.servicios;

import com.mintic.backRockoloco.entidades.Genero;
import com.mintic.backRockoloco.interfaces.Operaciones;
import com.mintic.backRockoloco.repositorios.GenerosRepositorios;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service("generosServices")
public class GenerosServicios implements Operaciones<Genero>{
    
    @Autowired
    private GenerosRepositorios generosRepo;
    
    @Override
    public List<Genero> consultar() {
        return generosRepo.obtenerTodosG();
    }

    @Override
    public Boolean agregar(Genero miObjeto) {
        Genero temporal = generosRepo.save(miObjeto);
        return temporal!=null;
    }
    
    @Override
    public Boolean eliminar(Integer llavePrimaria) {
        generosRepo.deleteById(llavePrimaria);
        return !generosRepo.existsById(llavePrimaria);
    }

    @Override
    public Genero buscar(Integer llavePrimaria) {
        return generosRepo.findById(llavePrimaria).get();
    }
    
    @Override
    public Boolean actualizar(Genero miObjeto) {
        Optional<Genero> objVerificar=generosRepo.findById(miObjeto.getCodGenero());
        if (!objVerificar.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Objeto no aceptado");
        } else {
            generosRepo.save(miObjeto);
            return true;
        }
    }
    
    @Override
    public Integer cantidadRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

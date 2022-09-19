package com.mintic.backRockoloco.repositorios;

import com.mintic.backRockoloco.entidades.Cancion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CancionesRepositorios extends JpaRepository<Cancion, Integer>{
    
    @Query("SELECT c FROM Cancion c")
    public List<Cancion> obtenerTodasC();
    
}

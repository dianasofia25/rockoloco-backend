package com.mintic.backRockoloco.repositorios;

import com.mintic.backRockoloco.entidades.Genero;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GenerosRepositorios extends JpaRepository<Genero, Integer>{
    
    @Query("SELECT g FROM Genero g")
    public List<Genero> obtenerTodosG();
}

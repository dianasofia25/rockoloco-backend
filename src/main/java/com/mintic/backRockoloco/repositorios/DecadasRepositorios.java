package com.mintic.backRockoloco.repositorios;

import com.mintic.backRockoloco.entidades.Decada;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DecadasRepositorios extends JpaRepository<Decada, Integer>{
    
    @Query("SELECT d FROM Decada d")
    public List<Decada> obtenerTodasD();
}

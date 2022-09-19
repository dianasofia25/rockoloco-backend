package com.mintic.backRockoloco.repositorios;

import com.mintic.backRockoloco.entidades.Artista;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// Segundo se crean los repositorios
// Este repositorio significa que aqui van las consultas de las entidades en la base de datos
@Repository
public interface ArtistasRepositorios extends JpaRepository<Artista, Integer> {

    @Query("SELECT a FROM Artista a")
    public List<Artista> obtenerTodosA();
}

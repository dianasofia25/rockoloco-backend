package com.mintic.backRockoloco.interfaces;

import java.util.List;

// Primero se crean las operaciones
public interface Operaciones<T> { // Operaciones que aplican a cualquier tabla, gracias a <T>

    public List<T> consultar();
    
    public Boolean agregar(T miObjeto);
    
    public Integer cantidadRegistro();
    
    public Boolean eliminar(Integer llavePrimaria);
    
    public Boolean actualizar(T miObjeto);
    
    public T buscar(Integer llavePrimaria);

}

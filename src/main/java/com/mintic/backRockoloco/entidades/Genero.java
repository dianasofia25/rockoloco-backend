package com.mintic.backRockoloco.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "generos")
public class Genero implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_genero")
    private Integer codGenero;
    
    @Column(name = "nombre_genero")
    private String nombreGenero;

    public Genero() {
    }

    public Genero(Integer codGenero) {
        this.codGenero = codGenero;
    }

    public Genero(Integer codGenero, String nombreGenero) {
        this.codGenero = codGenero;
        this.nombreGenero = nombreGenero;
    }

    public Integer getCodGenero() {
        return codGenero;
    }

    public void setCodGenero(Integer codGenero) {
        this.codGenero = codGenero;
    }

    public String getNombreGenero() {
        return nombreGenero;
    }

    public void setNombreGenero(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codGenero != null ? codGenero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Genero)) {
            return false;
        }
        Genero other = (Genero) object;
        if ((this.codGenero == null && other.codGenero != null) || (this.codGenero != null && !this.codGenero.equals(other.codGenero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.mintic.back01.entidades.Generos[ codGenero=" + codGenero + " ]";
    }
    
}


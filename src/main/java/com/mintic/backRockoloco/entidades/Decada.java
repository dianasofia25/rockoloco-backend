package com.mintic.backRockoloco.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "decadas")
public class Decada implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_decada")
    private Integer codDecada;
    
    @Column(name = "nombre_decada")
    private String nombreDecada;

    public Decada() {
    }

    public Decada(Integer codDecada) {
        this.codDecada = codDecada;
    }

    public Decada(Integer codDecada, String nombreDecada) {
        this.codDecada = codDecada;
        this.nombreDecada = nombreDecada;
    }

    public Integer getCodDecada() {
        return codDecada;
    }

    public void setCodDecada(Integer codDecada) {
        this.codDecada = codDecada;
    }

    public String getNombreDecada() {
        return nombreDecada;
    }

    public void setNombreDecada(String nombreDecada) {
        this.nombreDecada = nombreDecada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDecada != null ? codDecada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Decada)) {
            return false;
        }
        Decada other = (Decada) object;
        if ((this.codDecada == null && other.codDecada != null) || (this.codDecada != null && !this.codDecada.equals(other.codDecada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.mintic.back01.entidades.Decadas[ codDecada=" + codDecada + " ]";
    }
    
}
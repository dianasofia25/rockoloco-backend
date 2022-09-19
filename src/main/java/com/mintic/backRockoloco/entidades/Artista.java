package com.mintic.backRockoloco.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "artistas")
public class Artista implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_artista")
    private Integer codArtista;
    
    @Column(name = "nombre_artista")
    private String nombreArtista;
    
    @Column(name = "nacionalidad_artista")
    private String nacionalidadArtista;

    public Artista() {
    }

    public Artista(Integer codArtista) {
        this.codArtista = codArtista;
    }

    public Artista(Integer codArtista, String nombreArtista, String nacionalidadArtista) {
        this.codArtista = codArtista;
        this.nombreArtista = nombreArtista;
        this.nacionalidadArtista = nacionalidadArtista;
    }

    public Integer getCodArtista() {
        return codArtista;
    }

    public void setCodArtista(Integer codArtista) {
        this.codArtista = codArtista;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public String getNacionalidadArtista() {
        return nacionalidadArtista;
    }

    public void setNacionalidadArtista(String nacionalidadArtista) {
        this.nacionalidadArtista = nacionalidadArtista;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codArtista != null ? codArtista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artista)) {
            return false;
        }
        Artista other = (Artista) object;
        if ((this.codArtista == null && other.codArtista != null) || (this.codArtista != null && !this.codArtista.equals(other.codArtista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.mintic.back01.entidades.Artistas[ codArtista=" + codArtista + " ]";
    }
    
}

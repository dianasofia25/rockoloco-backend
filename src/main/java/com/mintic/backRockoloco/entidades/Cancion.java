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
@Table(name = "canciones")
public class Cancion implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_cancion")
    private Integer codCancion;
    
    @Column(name = "nombre_cancion")
    private String nombreCancion;
    
    @JoinColumn(name = "cod_artista", referencedColumnName = "cod_artista")
    @ManyToOne
    private Artista codArtista;
    
    @JoinColumn(name = "cod_decada", referencedColumnName = "cod_decada")
    @ManyToOne(optional = false)
    private Decada codDecada;
    
    @JoinColumn(name = "cod_genero", referencedColumnName = "cod_genero")
    @ManyToOne(optional = false)
    private Genero codGenero;

    public Cancion() {
    }

    public Cancion(Integer codCancion) {
        this.codCancion = codCancion;
    }

    public Cancion(Integer codCancion, String nombreCancion) {
        this.codCancion = codCancion;
        this.nombreCancion = nombreCancion;
    }

    public Integer getCodCancion() {
        return codCancion;
    }

    public void setCodCancion(Integer codCancion) {
        this.codCancion = codCancion;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public Artista getCodArtista() {
       return codArtista;
    }

    public void setCodArtista(Artista codArtista) {
       this.codArtista = codArtista;
    }

    public Decada getCodDecada() {
       return codDecada;
    }

    public void setCodDecada(Decada codDecada) {
       this.codDecada = codDecada;
    }

    public Genero getCodGenero() {
       return codGenero;
    }

    public void setCodGenero(Genero codGenero) {
       this.codGenero = codGenero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCancion != null ? codCancion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cancion)) {
            return false;
        }
        Cancion other = (Cancion) object;
        if ((this.codCancion == null && other.codCancion != null) || (this.codCancion != null && !this.codCancion.equals(other.codCancion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.mintic.back01.entidades.Canciones[ codCancion=" + codCancion + " ]";
    }
    
}
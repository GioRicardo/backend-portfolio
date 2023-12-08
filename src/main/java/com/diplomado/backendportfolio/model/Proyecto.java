package com.diplomado.backendportfolio.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private String linkgithub;
    private LocalDate fecha;
    private String lenguaje;

    @ManyToMany(mappedBy = "proyectos")
    private Set<Programador> programadores;

    public Proyecto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getLinkgithub() {
        return linkgithub;
    }

    public void setLinkgithub(String linkgithub) {
        this.linkgithub = linkgithub;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public Set<Programador> getProgramadores() {
        return programadores;
    }

    public void setProgramadores(Set<Programador> programadores) {
        this.programadores = programadores;
    }
}

package com.Intecap.Libros.models;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

/*
*
*   insertar autores
*   modificar autores
*   listar autores
*
* */

@Entity
@Table(name= "autores")
public class autoresModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAutor")
    private int idAutor;
    @Column(nullable = false, name = "nombre")
    private String nombre;

    public autoresModel() {
    }

    public autoresModel(int idAutor, String nombre) {
        this.idAutor = idAutor;
        this.nombre = nombre;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

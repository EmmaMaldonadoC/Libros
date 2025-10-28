package com.Intecap.Libros.models;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

/*
*   insertar libro
*   modificar libro
*   listar libro
*   listar libros por id editorial
*   listar libros por id autor
*
* */

@Entity
@Table(name= "libros")
public class librosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLibro;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private int edicion;
    @Column(nullable = false)
    private int existencia;

    @ManyToOne
    @JoinColumn(name="idEditorial")
    private editorialesModel idEditorial;
    @ManyToOne
    @JoinColumn(name = "idAutor")
    private autoresModel idAutor;

    public librosModel() {
    }

    public librosModel(int idLibro, String nombre, int edicion, int existencia) {
        this.idLibro = idLibro;
        this.nombre = nombre;
        this.edicion = edicion;
        this.existencia = existencia;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }
    public editorialesModel getIdEditorial() { return idEditorial; }
    public void setIdEditorial(editorialesModel idEditorial) { this.idEditorial = idEditorial; }

    public autoresModel getIdAutor() { return idAutor; }
    public void setIdAutor(autoresModel idAutor) { this.idAutor = idAutor; }
}

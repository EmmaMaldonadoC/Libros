package com.Intecap.Libros.models;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

/*
*   inserta detalle
*   listar detalles por idventa
*   eliminar detalle
*   modificar detalle
* */

@Entity
@Table(name= "detalleVenta")
public class detalleVentaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalleVenta;
    @Column(nullable = false)
    private int cantidad;
    @Column(nullable = false)
    private double subtotal;

    @ManyToOne
    @JoinColumn(name="idVenta")
    private ventasModel idVenta;
    @ManyToOne
    @JoinColumn(name="idLibro")
    private librosModel idLibro;


    public detalleVentaModel() {
    }

    public detalleVentaModel(int idDetalleVenta, int cantidad, double subtotal) {
        this.idDetalleVenta = idDetalleVenta;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public ventasModel getIdVenta() { return idVenta; }
    public void setIdVenta(ventasModel idVenta) { this.idVenta = idVenta; }

    public librosModel getIdLibro() { return idLibro; }
    public void setIdLibro(librosModel idLibro) { this.idLibro = idLibro; }
}

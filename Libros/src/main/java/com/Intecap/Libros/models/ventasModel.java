package com.Intecap.Libros.models;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;
/*
*   insertar venta
*   modificar venta
*   listar venta por fechas
*
* */
@Entity
@Table(name= "ventas")
public class ventasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVenta;
    @Column(nullable = false)
    private Date fecha;
    @Column(nullable = false)
    private double total;

    @ManyToOne
    @JoinColumn(name="IdCliente")
    private clientesModel idCliente;

    public ventasModel() {
    }

    public ventasModel(int idVenta, Date fecha, double total) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.total = total;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    public clientesModel getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(clientesModel idCliente) {
        this.idCliente = idCliente;
    }
}

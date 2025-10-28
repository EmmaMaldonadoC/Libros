package com.Intecap.Libros.repository;

import com.Intecap.Libros.models.detalleVentaModel;
import com.Intecap.Libros.models.ventasModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface detalleVentaRepository extends JpaRepository<detalleVentaModel, Integer> {
    List<detalleVentaModel> findByIdVenta(ventasModel venta);
}

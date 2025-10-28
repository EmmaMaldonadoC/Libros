package com.Intecap.Libros.controllers;

import com.Intecap.Libros.models.detalleVentaModel;
import com.Intecap.Libros.models.ventasModel;
import com.Intecap.Libros.repository.detalleVentaRepository;
import com.Intecap.Libros.repository.ventasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/detalleVenta")
@CrossOrigin(origins = "*")
public class detalleVentaController {

    @Autowired
    private detalleVentaRepository detalleRepo;

    @Autowired
    private ventasRepository ventasRepo;

    @PostMapping("/insertar")
    public detalleVentaModel insertarDetalle(@RequestBody detalleVentaModel detalle) {
        return detalleRepo.save(detalle);
    }

    @GetMapping("/listar/{idVenta}")
    public List<detalleVentaModel> listarPorIdVenta(@PathVariable int idVenta) {
        Optional<ventasModel> ventaOpt = ventasRepo.findById(idVenta);
        if (ventaOpt.isPresent()) {
            return detalleRepo.findByIdVenta(ventaOpt.get());
        }
        return List.of(); // si no existe la venta, retorna lista vacía
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarDetalle(@PathVariable int id) {
        if (detalleRepo.existsById(id)) {
            detalleRepo.deleteById(id);
            return "Detalle eliminado correctamente";
        }
        return "No se encontró el detalle con ID " + id;
    }

    @PutMapping("/modificar/{id}")
    public detalleVentaModel modificarDetalle(@PathVariable int id, @RequestBody detalleVentaModel detalleActualizado) {
        Optional<detalleVentaModel> detalleOpt = detalleRepo.findById(id);
        if (detalleOpt.isPresent()) {
            detalleVentaModel detalle = detalleOpt.get();
            detalle.setCantidad(detalleActualizado.getCantidad());
            detalle.setSubtotal(detalleActualizado.getSubtotal());
            detalle.setIdLibro(detalleActualizado.getIdLibro());
            detalle.setIdVenta(detalleActualizado.getIdVenta());
            return detalleRepo.save(detalle);
        }
        return null;
    }
}

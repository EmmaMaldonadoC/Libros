package com.Intecap.Libros.controllers;

import com.Intecap.Libros.models.ventasModel;
import com.Intecap.Libros.repository.ventasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/ventas")
@CrossOrigin(origins = "*")
public class ventaController {

    @Autowired
    private ventasRepository ventasRepo;

    @PostMapping("/insertar")
    public ventasModel insertarVenta(@RequestBody ventasModel venta) {
        return ventasRepo.save(venta);
    }

    @PutMapping("/modificar/{id}")
    public ventasModel modificarVenta(@PathVariable int id, @RequestBody ventasModel ventaActualizada) {
        ventasModel venta = ventasRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada con id: " + id));

        venta.setFecha(ventaActualizada.getFecha());
        venta.setTotal(ventaActualizada.getTotal());
        venta.setIdCliente(ventaActualizada.getIdCliente());

        return ventasRepo.save(venta);
    }

    @GetMapping("/listar/fechas")
    public List<ventasModel> listarPorFechas(@RequestParam("inicio") Date inicio, @RequestParam("fin") Date fin) {
        return ventasRepo.findByFechaBetween(inicio, fin);
    }

    @GetMapping("/listar")
    public List<ventasModel> listarTodas() {
        return ventasRepo.findAll();
    }
}
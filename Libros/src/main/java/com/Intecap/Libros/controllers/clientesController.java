package com.Intecap.Libros.controllers;

import com.Intecap.Libros.models.clientesModel;
import com.Intecap.Libros.repository.clientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class clientesController {

    @Autowired
    private clientesRepository clientesRepo;

    @PostMapping("/insertar")
    public clientesModel insertarCliente(@RequestBody clientesModel cliente) {
        return clientesRepo.save(cliente);
    }

    @PutMapping("/modificar/{id}")
    public clientesModel modificarCliente(@PathVariable int id, @RequestBody clientesModel clienteActualizado) {
        Optional<clientesModel> clienteOpt = clientesRepo.findById(id);
        if (clienteOpt.isPresent()) {
            clientesModel cliente = clienteOpt.get();
            cliente.setNombre(clienteActualizado.getNombre());
            cliente.setDireccion(clienteActualizado.getDireccion());
            cliente.setTelefono(clienteActualizado.getTelefono());
            cliente.setNit(clienteActualizado.getNit());
            return clientesRepo.save(cliente);
        }
        return null; // o lanzar una excepción personalizada
    }

    @GetMapping("/listar")
    public List<clientesModel> listarClientes() {
        return clientesRepo.findAll();
    }

    @GetMapping("/buscar/nombre/{nombre}")
    public List<clientesModel> buscarPorNombre(@PathVariable String nombre) {
        return clientesRepo.findByNombreContainingIgnoreCase(nombre);
    }

    @GetMapping("/buscar/nit/{nit}")
    public clientesModel buscarPorNit(@PathVariable String nit) {
        return clientesRepo.findByNit(nit);
    }
}
package com.Intecap.Libros.controllers;

import com.Intecap.Libros.models.autoresModel;
import com.Intecap.Libros.models.editorialesModel;
import com.Intecap.Libros.models.librosModel;
import com.Intecap.Libros.repository.autoresRepository;
import com.Intecap.Libros.repository.editorialesRepository;
import com.Intecap.Libros.repository.librosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
@CrossOrigin(origins = "*")
public class librosController {

    @Autowired
    private librosRepository librosRepo;

    @Autowired
    private editorialesRepository editorialesRepo;

    @Autowired
    private autoresRepository autoresRepo;

    @PostMapping("/insertar")
    public librosModel insertarLibro(@RequestBody librosModel libro) {
        return librosRepo.save(libro);
    }

    @PutMapping("/modificar/{id}")
    public librosModel modificarLibro(@PathVariable int id, @RequestBody librosModel libroActualizado) {
        Optional<librosModel> libroOpt = librosRepo.findById(id);
        if (libroOpt.isPresent()) {
            librosModel libro = libroOpt.get();
            libro.setNombre(libroActualizado.getNombre());
            libro.setEdicion(libroActualizado.getEdicion());
            libro.setExistencia(libroActualizado.getExistencia());
            libro.setIdAutor(libroActualizado.getIdAutor());
            libro.setIdEditorial(libroActualizado.getIdEditorial());
            return librosRepo.save(libro);
        }
        return null;
    }

    @GetMapping("/listar")
    public List<librosModel> listarLibros() {
        return librosRepo.findAll();
    }

    @GetMapping("/listar/editorial/{idEditorial}")
    public List<librosModel> listarPorEditorial(@PathVariable int idEditorial) {
        Optional<editorialesModel> editorialOpt = editorialesRepo.findById(idEditorial);
        if (editorialOpt.isPresent()) {
            return librosRepo.findByIdEditorial(editorialOpt.get());
        }
        return List.of();
    }

    @GetMapping("/listar/autor/{idAutor}")
    public List<librosModel> listarPorAutor(@PathVariable int idAutor) {
        Optional<autoresModel> autorOpt = autoresRepo.findById(idAutor);
        if (autorOpt.isPresent()) {
            return librosRepo.findByIdAutor(autorOpt.get());
        }
        return List.of();
    }
}
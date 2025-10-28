package com.Intecap.Libros.controllers;

import com.Intecap.Libros.models.editorialesModel;
import com.Intecap.Libros.repository.editorialesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/editoriales")
@CrossOrigin(origins = "*")
public class editorialesController {

    @Autowired
    private editorialesRepository editorialesRepo;

    @PostMapping("/insertar")
    public editorialesModel insertarEditorial(@RequestBody editorialesModel editorial) {
        return editorialesRepo.save(editorial);
    }

    @PutMapping("/modificar/{id}")
    public editorialesModel modificarEditorial(@PathVariable int id, @RequestBody editorialesModel editorialActualizada) {
        Optional<editorialesModel> editorialOpt = editorialesRepo.findById(id);
        if (editorialOpt.isPresent()) {
            editorialesModel editorial = editorialOpt.get();
            editorial.setNombre(editorialActualizada.getNombre());
            editorial.setTelefono(editorialActualizada.getTelefono());
            editorial.setDireccion(editorialActualizada.getDireccion());
            return editorialesRepo.save(editorial);
        }
        return null; // o puedes lanzar una excepción personalizada si prefieres
    }

    @GetMapping("/listar")
    public List<editorialesModel> listarEditoriales() {
        return editorialesRepo.findAll();
    }
}
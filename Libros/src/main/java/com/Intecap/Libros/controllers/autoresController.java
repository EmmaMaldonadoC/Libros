package com.Intecap.Libros.controllers;


import com.Intecap.Libros.models.autoresModel;
import com.Intecap.Libros.repository.autoresRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/autores")
@CrossOrigin //opcional por si consumimos la pai desde un fornt diferente
public class autoresController {
     private final autoresRepository autoresRepository;

    public autoresController(autoresRepository autoresRepository) {
        this.autoresRepository = autoresRepository;
    }

    //Listar autores
    @GetMapping
    public List<autoresModel> listar(){
        return  autoresRepository.findAll();
    }

    //obtener por id
    @GetMapping("/{id}")
    public autoresModel obtener (@PathVariable int id){
        return  autoresRepository.findById(id)
                .orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Autor no encontrado"));
    }

    //insertar
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public autoresModel crear(@RequestBody autoresModel autor){
        if(autor.getIdAutor()!=0){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "El idAutor no debe contener ningun valor");
        }

        String nombre = autor.getNombre();
        if (nombre ==null || nombre.trim().isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre no puede estar vacio");
        }

        String nombreMinusclas = nombre.toLowerCase();
        if (nombreMinusclas.contains("select") || nombreMinusclas.contains("insert") || nombreMinusclas.contains("update")
                || nombreMinusclas.contains("delete") || nombreMinusclas.contains("<script") || nombreMinusclas.contains(("--"))
                || nombreMinusclas.contains(";") || nombreMinusclas.contains("\"")){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre contiene caracteres no permitidos");
        }
        return autoresRepository.save(autor);
    }

    //modificar
    public autoresModel actualizar(@PathVariable Integer id, @RequestBody autoresModel autorRequest){
        autoresModel autor = autoresRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Autor no encontrado"));

        autor.setNombre(autorRequest.getNombre());
        return autoresRepository.save(autor);
    }
}

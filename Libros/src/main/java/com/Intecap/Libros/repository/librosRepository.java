package com.Intecap.Libros.repository;

import com.Intecap.Libros.models.autoresModel;
import com.Intecap.Libros.models.editorialesModel;
import com.Intecap.Libros.models.librosModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface librosRepository extends JpaRepository<librosModel, Integer> {
    List<librosModel> findByIdEditorial(editorialesModel editorial);
    List<librosModel> findByIdAutor(autoresModel autor);
}

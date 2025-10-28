package com.Intecap.Libros.repository;

import com.Intecap.Libros.models.clientesModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface clientesRepository extends JpaRepository<clientesModel, Integer> {
    List<clientesModel> findByNombreContainingIgnoreCase(String nombre);
    clientesModel findByNit(String nit);
}

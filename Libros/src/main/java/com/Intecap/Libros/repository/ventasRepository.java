package com.Intecap.Libros.repository;

import com.Intecap.Libros.models.ventasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ventasRepository extends JpaRepository<ventasModel, Integer> {
    @Query("SELECT v FROM ventasModel v WHERE v.fecha BETWEEN :inicio AND :fin")
    List<ventasModel> findByFechaBetween(@Param("inicio") Date inicio, @Param("fin") Date fin);
}

package com.creangel.pruebaTecnica.repository;

import com.creangel.pruebaTecnica.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Integer> {
    
    // Buscar por código
    Optional<Materia> findByCodigo(String codigo);
    
    // Buscar por nombre (ignorando mayúsculas/minúsculas)
    List<Materia> findByNombreContainingIgnoreCase(String nombre);
    
    // Buscar por código (ignorando mayúsculas/minúsculas)
    List<Materia> findByCodigoContainingIgnoreCase(String codigo);
    
    // Buscar por número de créditos
    List<Materia> findByCreditos(Integer creditos);
    
    // Buscar por rango de créditos
    List<Materia> findByCreditosBetween(Integer creditosMin, Integer creditosMax);
    
    // Buscar materias con créditos mayor o igual a
    List<Materia> findByCreditosGreaterThanEqual(Integer creditos);
    
    // Contar materias por número de créditos
    long countByCreditos(Integer creditos);
    
    // Verificar si existe por código
    boolean existsByCodigo(String codigo);
    
    // Buscar materias ordenadas por nombre
    List<Materia> findAllByOrderByNombreAsc();
    
    // Buscar materias ordenadas por créditos (descendente)
    List<Materia> findAllByOrderByCreditosDesc();
    
    // Buscar materias por nombre o código
    @Query("SELECT m FROM Materia m WHERE LOWER(m.nombre) LIKE LOWER(CONCAT('%', :termino, '%')) OR LOWER(m.codigo) LIKE LOWER(CONCAT('%', :termino, '%'))")
    List<Materia> findByNombreOrCodigoContaining(@Param("termino") String termino);
}

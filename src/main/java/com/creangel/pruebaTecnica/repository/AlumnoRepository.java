package com.creangel.pruebaTecnica.repository;

import com.creangel.pruebaTecnica.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
    
    // Buscar por email
    Optional<Alumno> findByEmail(String email);
    
    // Buscar por nombre y apellido
    List<Alumno> findByNombreAndApellido(String nombre, String apellido);
    
    // Buscar por nombre (ignorando mayúsculas/minúsculas)
    List<Alumno> findByNombreContainingIgnoreCase(String nombre);
    
    // Buscar por apellido (ignorando mayúsculas/minúsculas)
    List<Alumno> findByApellidoContainingIgnoreCase(String apellido);
    
    // Buscar por fecha de nacimiento
    List<Alumno> findByFechaNacimiento(LocalDate fechaNacimiento);
    
    // Buscar por rango de fechas de nacimiento
    List<Alumno> findByFechaNacimientoBetween(LocalDate fechaInicio, LocalDate fechaFin);
    
    // Buscar por edad (mayor o igual a)
    @Query("SELECT a FROM Alumno a WHERE YEAR(CURRENT_DATE) - YEAR(a.fechaNacimiento) >= :edad")
    List<Alumno> findByEdadMayorOIgual(@Param("edad") int edad);
    
    // Contar alumnos por fecha de nacimiento
    long countByFechaNacimiento(LocalDate fechaNacimiento);
    
    // Verificar si existe por email
    boolean existsByEmail(String email);
    
    // Buscar alumnos ordenados por apellido y nombre
    List<Alumno> findAllByOrderByApellidoAscNombreAsc();
}

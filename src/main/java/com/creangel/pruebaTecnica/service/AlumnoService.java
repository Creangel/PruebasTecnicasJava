package com.creangel.pruebaTecnica.service;

import com.creangel.pruebaTecnica.model.Alumno;
import com.creangel.pruebaTecnica.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AlumnoService {
    
    @Autowired
    private AlumnoRepository alumnoRepository;
    
    // CREATE - Crear un nuevo alumno
    public Alumno crearAlumno(Alumno alumno) {
        // Validar que el email no exista
        if (alumnoRepository.existsByEmail(alumno.getEmail())) {
            throw new RuntimeException("Ya existe un alumno con el email: " + alumno.getEmail());
        }
        
        // Validar que la fecha de nacimiento no sea futura
        if (alumno.getFechaNacimiento() != null && alumno.getFechaNacimiento().isAfter(LocalDate.now())) {
            throw new RuntimeException("La fecha de nacimiento no puede ser futura");
        }
        
        return alumnoRepository.save(alumno);
    }
    
    // READ - Obtener alumno por ID
    @Transactional(readOnly = true)
    public Optional<Alumno> obtenerAlumnoPorId(String id) {
        return alumnoRepository.findById(Integer.valueOf(id));
    }
    
    // READ - Obtener todos los alumnos
    @Transactional(readOnly = true)
    public List<Alumno> obtenerTodosLosAlumnos() {
        return alumnoRepository.findAllByOrderByApellidoAscNombreAsc();
    }
    
    // UPDATE - Actualizar alumno existente
    public Alumno actualizarAlumno(String id, Alumno alumnoActualizado) {
        Optional<Alumno> alumnoExistente = alumnoRepository.findById(Integer.valueOf(id));
        
        if (alumnoExistente.isPresent()) {
            Alumno alumno = alumnoExistente.get();
            
            // Validar que el email no exista en otro alumno
            if (!alumno.getEmail().equals(alumnoActualizado.getEmail()) && 
                alumnoRepository.existsByEmail(alumnoActualizado.getEmail())) {
                throw new RuntimeException("Ya existe otro alumno con el email: " + alumnoActualizado.getEmail());
            }
            
            // Actualizar campos
            alumno.setNombre(alumnoActualizado.getNombre());
            alumno.setApellido(alumnoActualizado.getApellido());
            alumno.setEmail(alumnoActualizado.getEmail());
            alumno.setFechaNacimiento(alumnoActualizado.getFechaNacimiento());
            
            return alumnoRepository.save(alumno);
        } else {
            throw new RuntimeException("No se encontró el alumno con ID: " + id);
        }
    }
    
    // DELETE - Eliminar alumno por ID
    public void eliminarAlumno(String id) {
        if (!alumnoRepository.existsById(Integer.valueOf(id))) {
            throw new RuntimeException("No se encontró el alumno con ID: " + id);
        }
        alumnoRepository.deleteById(Integer.valueOf(id));
    }
}

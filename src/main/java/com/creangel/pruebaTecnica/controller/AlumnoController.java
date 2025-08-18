package com.creangel.pruebaTecnica.controller;

import com.creangel.pruebaTecnica.dto.AlumnoDTO;
import com.creangel.pruebaTecnica.model.Alumno;
import com.creangel.pruebaTecnica.service.AlumnoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/alumnos")
@CrossOrigin(origins = "*")
@Tag(name = "Alumnos", description = "API para gestión de alumnos")
public class AlumnoController {
    
    @Autowired
    private AlumnoService alumnoService;
    
    @Operation(summary = "Crear un nuevo alumno", description = "Crea un nuevo alumno en el sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Alumno creado exitosamente",
                    content = @Content(schema = @Schema(implementation = AlumnoDTO.class))),
        @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    })
    @PostMapping
    public ResponseEntity<AlumnoDTO> crearAlumno(@RequestBody AlumnoDTO alumnoDTO) {
        try {
            Alumno alumno = convertirDTOaModelo(alumnoDTO);
            Alumno alumnoCreado = alumnoService.crearAlumno(alumno);
            AlumnoDTO respuesta = convertirModeloaDTO(alumnoCreado);
            return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @Operation(summary = "Obtener alumno por ID", description = "Recupera un alumno específico por su identificador")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Alumno encontrado",
                    content = @Content(schema = @Schema(implementation = AlumnoDTO.class))),
        @ApiResponse(responseCode = "404", description = "Alumno no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<AlumnoDTO> obtenerAlumnoPorId(@Parameter(description = "ID del alumno") @PathVariable String id) { 
        Optional<Alumno> alumno = alumnoService.obtenerAlumnoPorId(id);
        if (alumno.isPresent()) {
            AlumnoDTO respuesta = convertirModeloaDTO(alumno.get());
            return ResponseEntity.ok(respuesta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @Operation(summary = "Obtener todos los alumnos", description = "Recupera la lista completa de alumnos ordenados por apellido y nombre")
    @ApiResponse(responseCode = "200", description = "Lista de alumnos recuperada exitosamente",
                content = @Content(schema = @Schema(implementation = AlumnoDTO.class)))
    @GetMapping
    public ResponseEntity<List<AlumnoDTO>> obtenerTodosLosAlumnos() {
        List<Alumno> alumnos = alumnoService.obtenerTodosLosAlumnos();
        List<AlumnoDTO> respuesta = alumnos.stream()
                .map(this::convertirModeloaDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(respuesta);
    }
    
    // UPDATE - Actualizar alumno existente
    @PutMapping("/{id}")
    public ResponseEntity<AlumnoDTO> actualizarAlumno(@PathVariable String id, @RequestBody AlumnoDTO alumnoDTO) { 
        try {
            Alumno alumno = convertirDTOaModelo(alumnoDTO);
            Alumno alumnoActualizado = alumnoService.actualizarAlumno(id, alumno);
            AlumnoDTO respuesta = convertirModeloaDTO(alumnoActualizado);
            return ResponseEntity.ok(respuesta);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    // DELETE - Eliminar alumno por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAlumno(@PathVariable String id) {
        try {
            alumnoService.eliminarAlumno(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Métodos de conversión
    
    private Alumno convertirDTOaModelo(AlumnoDTO dto) {
        Alumno alumno = new Alumno();
        alumno.setId(dto.getId());
        alumno.setNombre(dto.getNombre());
        alumno.setApellido(dto.getApellido());
        alumno.setEmail(dto.getEmail());
        alumno.setFechaNacimiento(dto.getFechaNacimiento());
        return alumno;
    }
    
    private AlumnoDTO convertirModeloaDTO(Alumno alumno) {
        return new AlumnoDTO(
            alumno.getId(),
            alumno.getNombre(),
            alumno.getApellido(),
            alumno.getEmail(),
            alumno.getFechaNacimiento()
        );
    }
}

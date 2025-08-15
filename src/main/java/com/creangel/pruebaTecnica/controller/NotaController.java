package com.creangel.pruebaTecnica.controller;

import com.creangel.pruebaTecnica.dto.AlumnoDTO;
import com.creangel.pruebaTecnica.dto.NotaDTO;
import com.creangel.pruebaTecnica.model.Alumno;
import com.creangel.pruebaTecnica.model.Nota;
import com.creangel.pruebaTecnica.service.AlumnoService;
import com.creangel.pruebaTecnica.service.NotaService;

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
@Tag(name = "Notas", description = "API para gestión de alumnos")
public class NotaController {
    
    @Autowired
    private AlumnoService alumnoService;

    @Autowired
    private NotaService notaService;
   


    @Operation(summary = "Obtener nota por ID", description = "Recupera una nota específico por su identificador")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Nota encontrado",
                    content = @Content(schema = @Schema(implementation = NotaDTO.class))),
        @ApiResponse(responseCode = "404", description = "Alumno no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<AlumnoDTO> obtenerNotaPorId(@Parameter(description = "ID del nota") @PathVariable Integer id) { 
        Optional<Nota> nota = notaService.obtenerNotaPorId(id);

        if (nota.isPresent()) {
            NotaDTO respuesta = convertirModeloaDTO(nota.get());
            return ResponseEntity.ok(respuesta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    

        private NotaDTO convertirModeloaDTO(Nota nota) {
        return new NotaDTO(
            nota.getId(),
            nota.getValor(),
            nota.getAlumno(),
            nota.getMateria()
        );
    }


}

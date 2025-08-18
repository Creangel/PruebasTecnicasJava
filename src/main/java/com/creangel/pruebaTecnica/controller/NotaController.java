package com.creangel.pruebaTecnica.controller;
import com.creangel.pruebaTecnica.dto.NotaDTO;
import com.creangel.pruebaTecnica.model.Nota;
import com.creangel.pruebaTecnica.service.NotaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/notas")
@CrossOrigin(origins = "*")
@Tag(name = "Notas", description = "API para gestión de notas")
public class NotaController {

    @Autowired
    private NotaService notaService;
   
    @Operation(summary = "Obtener nota por ID", description = "Recupera una nota específico por su identificador")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Nota encontrado",
                    content = @Content(schema = @Schema(implementation = NotaDTO.class))),
        @ApiResponse(responseCode = "404", description = "Nota no encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<NotaDTO> obtenerNotaPorId(@Parameter(description = "ID del nota") @PathVariable Integer id) { 
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
            nota.getFechaRegistro(),
            nota.getAlumno(),
            nota.getMateria()
        );
    }


}

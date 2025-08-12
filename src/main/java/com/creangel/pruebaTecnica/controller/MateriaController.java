package com.creangel.pruebaTecnica.controller;

import com.creangel.pruebaTecnica.dto.MateriaDTO;
import com.creangel.pruebaTecnica.model.Materia;
import com.creangel.pruebaTecnica.service.MateriaService;
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
@RequestMapping("/api/materias")
@CrossOrigin(origins = "*")
@Tag(name = "Materias", description = "API para gestión de materias")
public class MateriaController {
    
    @Autowired
    private MateriaService materiaService;
    
    @Operation(summary = "Crear una nueva materia", description = "Crea una nueva materia en el sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Materia creada exitosamente",
                    content = @Content(schema = @Schema(implementation = MateriaDTO.class))),
        @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    })
    @PostMapping
    public ResponseEntity<MateriaDTO> crearMateria(@RequestBody MateriaDTO materiaDTO) {
        try {
            Materia materia = convertirDTOaModelo(materiaDTO);
            Materia materiaCreada = materiaService.crearMateria(materia);
            MateriaDTO respuesta = convertirModeloaDTO(materiaCreada);
            return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @Operation(summary = "Obtener materia por ID", description = "Recupera una materia específica por su identificador")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Materia encontrada",
                    content = @Content(schema = @Schema(implementation = MateriaDTO.class))),
        @ApiResponse(responseCode = "404", description = "Materia no encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<MateriaDTO> obtenerMateriaPorId(@Parameter(description = "ID de la materia") @PathVariable Integer id) {
        Optional<Materia> materia = materiaService.obtenerMateriaPorId(id);
        if (materia.isPresent()) {
            MateriaDTO respuesta = convertirModeloaDTO(materia.get());
            return ResponseEntity.ok(respuesta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @Operation(summary = "Obtener todas las materias", description = "Recupera la lista completa de materias ordenadas por nombre")
    @ApiResponse(responseCode = "200", description = "Lista de materias recuperada exitosamente",
                content = @Content(schema = @Schema(implementation = MateriaDTO.class)))
    @GetMapping
    public ResponseEntity<List<MateriaDTO>> obtenerTodasLasMaterias() {
        List<Materia> materias = materiaService.obtenerTodasLasMaterias();
        List<MateriaDTO> respuesta = materias.stream()
                .map(this::convertirModeloaDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(respuesta);
    }
    
    // READ - Obtener materia por código
    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<MateriaDTO> obtenerMateriaPorCodigo(@PathVariable String codigo) {
        Optional<Materia> materia = materiaService.obtenerMateriaPorCodigo(codigo);
        if (materia.isPresent()) {
            MateriaDTO respuesta = convertirModeloaDTO(materia.get());
            return ResponseEntity.ok(respuesta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // READ - Buscar materias por nombre
    @GetMapping("/buscar/nombre")
    public ResponseEntity<List<MateriaDTO>> buscarMateriasPorNombre(@RequestParam String nombre) {
        List<Materia> materias = materiaService.buscarMateriasPorNombre(nombre);
        List<MateriaDTO> respuesta = materias.stream()
                .map(this::convertirModeloaDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(respuesta);
    }
    
    // READ - Buscar materias por código
    @GetMapping("/buscar/codigo")
    public ResponseEntity<List<MateriaDTO>> buscarMateriasPorCodigo(@RequestParam String codigo) {
        List<Materia> materias = materiaService.buscarMateriasPorCodigo(codigo);
        List<MateriaDTO> respuesta = materias.stream()
                .map(this::convertirModeloaDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(respuesta);
    }
    
    // UPDATE - Actualizar materia existente
    @PutMapping("/{id}")
    public ResponseEntity<MateriaDTO> actualizarMateria(@PathVariable Integer id, @RequestBody MateriaDTO materiaDTO) {
        try {
            Materia materia = convertirDTOaModelo(materiaDTO);
            Materia materiaActualizada = materiaService.actualizarMateria(id, materia);
            MateriaDTO respuesta = convertirModeloaDTO(materiaActualizada);
            return ResponseEntity.ok(respuesta);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    // DELETE - Eliminar materia por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMateria(@PathVariable Integer id) {
        try {
            materiaService.eliminarMateria(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    // DELETE - Eliminar materia por código
    @DeleteMapping("/codigo/{codigo}")
    public ResponseEntity<Void> eliminarMateriaPorCodigo(@PathVariable String codigo) {
        try {
            materiaService.eliminarMateriaPorCodigo(codigo);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Métodos de utilidad
    
    // Contar total de materias
    @GetMapping("/contar")
    public ResponseEntity<Long> contarTotalMaterias() {
        long total = materiaService.contarTotalMaterias();
        return ResponseEntity.ok(total);
    }
    
    // Verificar si existe materia por ID
    @GetMapping("/{id}/existe")
    public ResponseEntity<Boolean> existeMateriaPorId(@PathVariable Integer id) {
        boolean existe = materiaService.existeMateriaPorId(id);
        return ResponseEntity.ok(existe);
    }
    
    // Verificar si existe materia por código
    @GetMapping("/codigo/{codigo}/existe")
    public ResponseEntity<Boolean> existeMateriaPorCodigo(@PathVariable String codigo) {
        boolean existe = materiaService.existeMateriaPorCodigo(codigo);
        return ResponseEntity.ok(existe);
    }
    
    // Contar materias por créditos
    @GetMapping("/contar/creditos/{creditos}")
    public ResponseEntity<Long> contarMateriasPorCreditos(@PathVariable Integer creditos) {
        long total = materiaService.contarMateriasPorCreditos(creditos);
        return ResponseEntity.ok(total);
    }
    
    // Métodos de conversión
    
    private Materia convertirDTOaModelo(MateriaDTO dto) {
        Materia materia = new Materia();
        materia.setId(dto.getId());
        materia.setNombre(dto.getNombre());
        materia.setCodigo(dto.getCodigo());
        materia.setCreditos(dto.getCreditos());
        return materia;
    }
    
    private MateriaDTO convertirModeloaDTO(Materia materia) {
        return new MateriaDTO(
            materia.getId(),
            materia.getNombre(),
            materia.getCodigo(),
            materia.getCreditos()
        );
    }
}

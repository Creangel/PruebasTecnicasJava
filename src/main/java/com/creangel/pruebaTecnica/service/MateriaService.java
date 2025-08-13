package com.creangel.pruebaTecnica.service;

import com.creangel.pruebaTecnica.model.Materia;
import com.creangel.pruebaTecnica.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MateriaService {
    
    @Autowired
    private MateriaRepository materiaRepository;
    
    // CREATE - Crear una nueva materia
    public Materia crearMateria(Materia materia) {
        // Validar que el código no exista
        if (materiaRepository.existsByCodigo(materia.getCodigo())) {
            throw new RuntimeException("Ya existe una materia con el código: " + materia.getCodigo());
        }
        
        // Validar que los créditos sean positivos
        if (materia.getCreditos() != null && materia.getCreditos() <= 0) {
            throw new RuntimeException("Los créditos deben ser un número positivo");
        }
        
        // Validar que el nombre no esté vacío
        if (materia.getNombre() == null || materia.getNombre().trim().isEmpty()) {
            throw new RuntimeException("El nombre de la materia no puede estar vacío");
        }
        
        return materiaRepository.save(materia);
    }
    
    // READ - Obtener materia por ID
    @Transactional(readOnly = true)
    public Optional<Materia> obtenerMateriaPorId(Integer id) {
        return materiaRepository.findById(id);
    }
    
    // READ - Obtener todas las materias
    @Transactional(readOnly = true)
    public List<Materia> obtenerTodasLasMaterias() {
        return materiaRepository.findAllByOrderByNombreAsc();
    }
    
    // UPDATE - Actualizar materia existente
    public Materia actualizarMateria(Integer id, Materia materiaActualizada) {
        Optional<Materia> materiaExistente = materiaRepository.findById(id);
        
        if (materiaExistente.isPresent()) {
            Materia materia = materiaExistente.get();
            
            // Validar que el código no exista en otra materia
            if (!materia.getCodigo().equals(materiaActualizada.getCodigo()) && 
                materiaRepository.existsByCodigo(materiaActualizada.getCodigo())) {
                throw new RuntimeException("Ya existe otra materia con el código: " + materiaActualizada.getCodigo());
            }
            
            // Validar créditos
            if (materiaActualizada.getCreditos() != null && materiaActualizada.getCreditos() <= 0) {
                throw new RuntimeException("Los créditos deben ser un número positivo");
            }
            
            // Validar nombre
            if (materiaActualizada.getNombre() == null || materiaActualizada.getNombre().trim().isEmpty()) {
                throw new RuntimeException("El nombre de la materia no puede estar vacío");
            }
            
            // Actualizar campos
            materia.setNombre(materiaActualizada.getNombre());
            materia.setCodigo(materiaActualizada.getCodigo());
            materia.setCreditos(materiaActualizada.getCreditos());
            
            return materiaRepository.save(materia);
        } else {
            throw new RuntimeException("No se encontró la materia con ID: " + id);
        }
    }

    // DELETE - Eliminar materia por ID
    public void eliminarMateria(Integer id) {
        if (!materiaRepository.existsById(id)) {
            throw new RuntimeException("No se encontró la materia con ID: " + id);
        }
        materiaRepository.deleteById(id);
    }
}

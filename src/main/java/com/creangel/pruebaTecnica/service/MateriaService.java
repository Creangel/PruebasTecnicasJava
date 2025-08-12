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
    
    // READ - Obtener materia por código
    @Transactional(readOnly = true)
    public Optional<Materia> obtenerMateriaPorCodigo(String codigo) {
        return materiaRepository.findByCodigo(codigo);
    }
    
    // READ - Buscar materias por nombre
    @Transactional(readOnly = true)
    public List<Materia> buscarMateriasPorNombre(String nombre) {
        return materiaRepository.findByNombreContainingIgnoreCase(nombre);
    }
    
    // READ - Buscar materias por código
    @Transactional(readOnly = true)
    public List<Materia> buscarMateriasPorCodigo(String codigo) {
        return materiaRepository.findByCodigoContainingIgnoreCase(codigo);
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
    
    // UPDATE - Actualizar solo campos específicos
    public Materia actualizarCamposMateria(Integer id, Materia camposActualizados) {
        Optional<Materia> materiaExistente = materiaRepository.findById(id);
        
        if (materiaExistente.isPresent()) {
            Materia materia = materiaExistente.get();
            
            // Actualizar solo los campos que no sean null
            if (camposActualizados.getNombre() != null && !camposActualizados.getNombre().trim().isEmpty()) {
                materia.setNombre(camposActualizados.getNombre());
            }
            if (camposActualizados.getCodigo() != null) {
                // Validar código único
                if (!materia.getCodigo().equals(camposActualizados.getCodigo()) && 
                    materiaRepository.existsByCodigo(camposActualizados.getCodigo())) {
                    throw new RuntimeException("Ya existe otra materia con el código: " + camposActualizados.getCodigo());
                }
                materia.setCodigo(camposActualizados.getCodigo());
            }
            if (camposActualizados.getCreditos() != null) {
                if (camposActualizados.getCreditos() <= 0) {
                    throw new RuntimeException("Los créditos deben ser un número positivo");
                }
                materia.setCreditos(camposActualizados.getCreditos());
            }
            
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
    
    // DELETE - Eliminar materia por código
    public void eliminarMateriaPorCodigo(String codigo) {
        Optional<Materia> materia = materiaRepository.findByCodigo(codigo);
        if (materia.isPresent()) {
            materiaRepository.delete(materia.get());
        } else {
            throw new RuntimeException("No se encontró la materia con código: " + codigo);
        }
    }
    
    // Métodos de utilidad
    
    // Contar total de materias
    @Transactional(readOnly = true)
    public long contarTotalMaterias() {
        return materiaRepository.count();
    }
    
    // Verificar si existe materia por ID
    @Transactional(readOnly = true)
    public boolean existeMateriaPorId(Integer id) {
        return materiaRepository.existsById(id);
    }
    
    // Verificar si existe materia por código
    @Transactional(readOnly = true)
    public boolean existeMateriaPorCodigo(String codigo) {
        return materiaRepository.existsByCodigo(codigo);
    }
    
    // Contar materias por créditos
    @Transactional(readOnly = true)
    public long contarMateriasPorCreditos(Integer creditos) {
        return materiaRepository.countByCreditos(creditos);
    }
}

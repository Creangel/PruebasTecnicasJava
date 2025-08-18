package com.creangel.pruebaTecnica.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.sql.Date;

import com.creangel.pruebaTecnica.model.Alumno;
import com.creangel.pruebaTecnica.model.Materia;


@Schema(description = "DTO para transferencia de datos de Alumno")
public class NotaDTO {
    
    @Schema(description = "Identificador único del nota", example = "1")
    private Integer id;
    

    @Schema(description = "Valor de la nota", example = "5.0", required = true)
    private BigDecimal valor;
    
    
    @Schema(description = "Fecha registro", required = true)
    private Date fechaRegistro;



    @ManyToOne
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;


    @ManyToOne
    @JoinColumn(name = "materia_id")
    private Materia materia;

    // Constructors
    public NotaDTO() {}
    


    public NotaDTO(Integer id, BigDecimal valor, Date fechaRegistro, Alumno alumno, Materia materia) {
        this.id = id;
        this.valor = valor;
        this.fechaRegistro = fechaRegistro;
        this.alumno = alumno;
        this.materia = materia;
    }
    
    // Getters and Setters
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public BigDecimal getValor() {
        return valor;
    }
    
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    
    public Date getFechaRegistro() {
        return fechaRegistro;
    }
    
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    public Alumno getAlumnoDTO() {
        return alumno;
    }
    
    public void setAlumnoDTO(Alumno alumnoDTO) {
        this.alumno = alumnoDTO;
    }
    
    public Materia getMateriaDTO() {
        return materia;
    }
    
    public void setMateriaDTO(Materia materiaDTO) {
        this.materia = materiaDTO;
    }
 
    
    @Override
    public String toString() {
        return "AlumnoDTO{" +
                "id=" + id +
                ", valor='" + valor + '\'' +
                ", fechaRegistro='" + fechaRegistro + '\'' +
                ", alumno='" + alumno.getNombre() + '\'' +
                ", materia=" + materia.getNombre() +
                '}';
    }
}

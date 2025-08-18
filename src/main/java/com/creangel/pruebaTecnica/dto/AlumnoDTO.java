package com.creangel.pruebaTecnica.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;

@Schema(description = "DTO para transferencia de datos de Alumno")
public class AlumnoDTO {
    
    @Schema(description = "Identificador único del alumno", example = "1")
    private Integer id;
    
    @Schema(description = "Nombre del alumno", example = "Juan", required = true)
    private String nombre;
    
    @Schema(description = "Apellido del alumno", example = "Pérez", required = true)
    private String apellido;
    
    @Schema(description = "Dirección de email del alumno", example = "juan.perez@email.com", required = true)
    private String email;
    
    @Schema(description = "Fecha de nacimiento del alumno", example = "2000-05-15", required = true)
    private LocalDate fechaNacimiento;
    
    // Constructors
    public AlumnoDTO() {}
    
    public AlumnoDTO(Integer id, String nombre, String apellido, String email, LocalDate fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    // Getters and Setters
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    @Override
    public String toString() {
        return "AlumnoDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}

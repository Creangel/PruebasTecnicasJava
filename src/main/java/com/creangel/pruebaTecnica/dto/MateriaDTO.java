package com.creangel.pruebaTecnica.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para transferencia de datos de Materia")
public class MateriaDTO {
    
    @Schema(description = "Identificador único de la materia", example = "1")
    private Integer id;
    
    @Schema(description = "Nombre de la materia", example = "Matemáticas", required = true)
    private String nombre;
    
    @Schema(description = "Código único de la materia", example = "MAT101", required = true)
    private String codigo;
    
    @Schema(description = "Número de créditos de la materia", example = "4", required = true)
    private Integer creditos;
    
    // Constructors
    public MateriaDTO() {}
    
    public MateriaDTO(Integer id, String nombre, String codigo, Integer creditos) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
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
    
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public Integer getCreditos() {
        return creditos;
    }
    
    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }
    
    @Override
    public String toString() {
        return "MateriaDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", creditos=" + creditos +
                '}';
    }
}

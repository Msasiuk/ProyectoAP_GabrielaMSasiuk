package com.portofio.GMsasiuk.Dto;

import javax.validation.constraints.NotBlank;

public class SkillDto {

    @NotBlank
    private String nombre;
    @NotBlank
    private int porcentaje;

    //Mét. constructores
    public SkillDto() {
    }

    public SkillDto(String nombre, int porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

    //Mét. getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

}

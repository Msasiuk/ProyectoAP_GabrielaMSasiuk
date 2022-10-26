package com.portofio.GMsasiuk.Dto;

import javax.validation.constraints.NotBlank;

public class ExperienciaDto {

    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;

    //Mét. constructores
    public ExperienciaDto() {
    }

    public ExperienciaDto(String nombreE, String descripcionE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
    }

    //Mét. getters y setters
    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

}

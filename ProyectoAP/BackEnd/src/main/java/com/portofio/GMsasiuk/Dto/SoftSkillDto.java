package com.portofio.GMsasiuk.Dto;

import javax.validation.constraints.NotBlank;

public class SoftSkillDto {

    //public SoftSkill(String nombreSf, int porcentajeSf)
    @NotBlank
    private String nombreSf;

    @NotBlank
    private int porcentajeSf;

    //Mét. constructores
    public SoftSkillDto() {
    }

    public SoftSkillDto(String nombreSf, int porcentajeSf) {
        this.nombreSf = nombreSf;
        this.porcentajeSf = porcentajeSf;
    }

    //Mét. getters y setters
    public String getNombreSf() {
        return nombreSf;
    }

    public void setNombreSf(String nombreSf) {
        this.nombreSf = nombreSf;
    }

    public int getPorcentajeSf() {
        return porcentajeSf;
    }

    public void setPorcentajeSf(int porcentajeSf) {
        this.porcentajeSf = porcentajeSf;
    }

}

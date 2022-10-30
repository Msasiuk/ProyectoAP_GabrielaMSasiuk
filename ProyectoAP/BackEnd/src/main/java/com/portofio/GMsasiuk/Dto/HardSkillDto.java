package com.portofio.GMsasiuk.Dto;

import javax.validation.constraints.NotBlank;

public class HardSkillDto {

    //public HardSkill(String nombreHd, int porcentajeHd)
    @NotBlank
    private String nombreHd;

    @NotBlank
    private int porcentajeHd;

    //Mét. constructores
    public HardSkillDto() {
    }

    public HardSkillDto(String nombreHd, int porcentajeHd) {
        this.nombreHd = nombreHd;
        this.porcentajeHd = porcentajeHd;
    }

    //Mét. getters y setters
    public String getNombreHd() {
        return nombreHd;
    }

    public void setNombreHd(String nombreHd) {
        this.nombreHd = nombreHd;
    }

    public int getPorcentajeHd() {
        return porcentajeHd;
    }

    public void setPorcentajeHd(int porcentajeHd) {
        this.porcentajeHd = porcentajeHd;
    }

}

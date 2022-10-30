package com.portofio.GMsasiuk.Dto;

import javax.validation.constraints.NotBlank;

public class ProyectoDto {

    //public Proyecto(String nombreP, String descripcionP, String imgP, String linkP, int fechaP)
    @NotBlank
    private String nombreP;

    @NotBlank
    private String descripcionP;

    private String imgP;

    @NotBlank
    private String linkP;

    @NotBlank
    private int fechaP;

    //Mét. constructor
    public ProyectoDto() {
    }

    public ProyectoDto(String nombreP, String descripcionP, String imgP, String linkP, int fechaP) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.imgP = imgP;
        this.linkP = linkP;
        this.fechaP = fechaP;
    }

    //Mét. getters y setters
    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getImgP() {
        return imgP;
    }

    public void setImgP(String imgP) {
        this.imgP = imgP;
    }

    public String getLinkP() {
        return linkP;
    }

    public void setLinkP(String linkP) {
        this.linkP = linkP;
    }

    public int getFechaP() {
        return fechaP;
    }

    public void setFechaP(int fechaP) {
        this.fechaP = fechaP;
    }

}

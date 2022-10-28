package com.portofio.GMsasiuk.Dto;

import javax.validation.constraints.NotBlank;


public class ProyectoDto {
    
    @NotBlank
    private String nombreP;

    @NotBlank
    private String descripcionP;
    
    @NotBlank
    private String linkP;
    
    @NotBlank
    private String imgP;
    
    @NotBlank
    private int fechaInicioP;
    
    @NotBlank
    private int fechaFinP;
    
    //Mét. constructor
    public ProyectoDto() {
    }

    public ProyectoDto(String nombreP, String descripcionP, String linkP, String imgP, int fechaInicioP, int fechaFinP) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.linkP = linkP;
        this.imgP = imgP;
        this.fechaInicioP = fechaInicioP;
        this.fechaFinP = fechaFinP;
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

    public String getLinkP() {
        return linkP;
    }

    public void setLinkP(String linkP) {
        this.linkP = linkP;
    }

    public String getImgP() {
        return imgP;
    }

    public void setImgP(String imgP) {
        this.imgP = imgP;
    }

    public int getFechaInicioP() {
        return fechaInicioP;
    }

    public void setFechaInicioP(int fechaInicioP) {
        this.fechaInicioP = fechaInicioP;
    }

    public int getFechaFinP() {
        return fechaFinP;
    }

    public void setFechaFinP(int fechaFinP) {
        this.fechaFinP = fechaFinP;
    }
   
}

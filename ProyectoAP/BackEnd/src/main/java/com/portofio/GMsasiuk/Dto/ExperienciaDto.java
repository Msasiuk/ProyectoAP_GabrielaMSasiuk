package com.portofio.GMsasiuk.Dto;

import javax.validation.constraints.NotBlank;

public class ExperienciaDto {

    //  public Experiencia(String empresaEx, String tituloEx, String descripcionEx, 
    //  String imgEmpresaEx, int fechaInicioEx, int fechaFinEx)
    @NotBlank
    private String empresaEx;

    @NotBlank
    private String tituloEx;

    @NotBlank
    private String imgEmpresaEx;

    @NotBlank
    private String descripcionEx;

    @NotBlank
    private int fechaInicioEx;

    @NotBlank
    private int fechaFinEx;

    //Mét. constructores
    public ExperienciaDto() {
    }

    public ExperienciaDto(String empresaEx, String tituloEx, String imgEmpresaEx, String descripcionEx, int fechaInicioEx, int fechaFinEx) {
        this.empresaEx = empresaEx;
        this.tituloEx = tituloEx;
        this.imgEmpresaEx = imgEmpresaEx;
        this.descripcionEx = descripcionEx;
        this.fechaInicioEx = fechaInicioEx;
        this.fechaFinEx = fechaFinEx;
    }

    //Mét. getters y setters
    public String getEmpresaEx() {
        return empresaEx;
    }

    public void setEmpresaEx(String empresaEx) {
        this.empresaEx = empresaEx;
    }

    public String getTituloEx() {
        return tituloEx;
    }

    public void setTituloEx(String tituloEx) {
        this.tituloEx = tituloEx;
    }

    public String getImgEmpresaEx() {
        return imgEmpresaEx;
    }

    public void setImgEmpresaEx(String imgEmpresaEx) {
        this.imgEmpresaEx = imgEmpresaEx;
    }

    public String getDescripcionEx() {
        return descripcionEx;
    }

    public void setDescripcionEx(String descripcionEx) {
        this.descripcionEx = descripcionEx;
    }

    public int getFechaInicioEx() {
        return fechaInicioEx;
    }

    public void setFechaInicioEx(int fechaInicioEx) {
        this.fechaInicioEx = fechaInicioEx;
    }

    public int getFechaFinEx() {
        return fechaFinEx;
    }

    public void setFechaFinEx(int fechaFinEx) {
        this.fechaFinEx = fechaFinEx;
    }

}

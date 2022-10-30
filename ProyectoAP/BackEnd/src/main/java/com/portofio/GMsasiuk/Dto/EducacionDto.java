package com.portofio.GMsasiuk.Dto;

import javax.validation.constraints.NotBlank;

public class EducacionDto {

    //  public Educacion(String institucionEd, String tituloEd, String imgInstitucionEd, int fechaInicioEd, int fechaFinEd)
    @NotBlank
    private String institucionEd;

    @NotBlank
    private String tituloEd;

    @NotBlank
    private String imgInstitucionEd;

    @NotBlank
    private int fechaInicioEd;

    @NotBlank
    private int fechaFinEd;

    //Mét. constructores
    public EducacionDto() {
    }

    public EducacionDto(String institucionEd, String tituloEd, String imgInstitucionEd, int fechaInicioEd, int fechaFinEd) {
        this.institucionEd = institucionEd;
        this.tituloEd = tituloEd;
        this.imgInstitucionEd = imgInstitucionEd;
        this.fechaInicioEd = fechaInicioEd;
        this.fechaFinEd = fechaFinEd;
    }

    //Mét. getters y setters
    public String getInstitucionEd() {
        return institucionEd;
    }

    public void setInstitucionEd(String institucionEd) {
        this.institucionEd = institucionEd;
    }

    public String getTituloEd() {
        return tituloEd;
    }

    public void setTituloEd(String tituloEd) {
        this.tituloEd = tituloEd;
    }

    public String getImgInstitucionEd() {
        return imgInstitucionEd;
    }

    public void setImgInstitucionEd(String imgInstitucionEd) {
        this.imgInstitucionEd = imgInstitucionEd;
    }

    public int getFechaInicioEd() {
        return fechaInicioEd;
    }

    public void setFechaInicioEd(int fechaInicioEd) {
        this.fechaInicioEd = fechaInicioEd;
    }

    public int getFechaFinEd() {
        return fechaFinEd;
    }

    public void setFechaFinEd(int fechaFinEd) {
        this.fechaFinEd = fechaFinEd;
    }

}

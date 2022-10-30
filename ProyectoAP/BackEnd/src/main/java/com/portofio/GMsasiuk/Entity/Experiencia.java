package com.portofio.GMsasiuk.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 5, message = "El nombre de la empresa no cumple con la longitud requerida")
    private String empresaEx;

    @NotNull
    @Size(min = 5, message = "El nombre del título no cumple con la longitud requerida")
    private String tituloEx;

    @NotNull
    @Size(min = 10, message = "La descripción no cumple con la longitud requerida")
    private String descripcionEx;

    private String imgEmpresaEx;

    @NotNull
    private int fechaInicioEx;

    private int fechaFinEx;

    //Mét. constructores
    public Experiencia() {
    }

    public Experiencia(String empresaEx, String tituloEx, String descripcionEx, String imgEmpresaEx, int fechaInicioEx, int fechaFinEx) {
        this.empresaEx = empresaEx;
        this.tituloEx = tituloEx;
        this.descripcionEx = descripcionEx;
        this.imgEmpresaEx = imgEmpresaEx;
        this.fechaInicioEx = fechaInicioEx;
        this.fechaFinEx = fechaFinEx;
    }

    //Mét. getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getDescripcionEx() {
        return descripcionEx;
    }

    public void setDescripcionEx(String descripcionEx) {
        this.descripcionEx = descripcionEx;
    }

    public String getImgEmpresaEx() {
        return imgEmpresaEx;
    }

    public void setImgEmpresaEx(String imgEmpresaEx) {
        this.imgEmpresaEx = imgEmpresaEx;
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

package com.portofio.GMsasiuk.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 5, message = "El nombre no cumple con la longitud requerida")
    private String nombreP;

    @NotNull
    @Size(min = 5, message = "La descripción no cumple con la longitud requerida")
    private String descripcionP;

    private String imgP;

    @NotNull
    @Size(min = 5, message = "El link no cumple con la longitud requerida")
    private String linkP;

    @NotNull
    private int fechaP;

    //Mét. constructores
    public Proyecto() {
    }

    public Proyecto(String nombreP, String descripcionP, String imgP, String linkP, int fechaP) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.imgP = imgP;
        this.linkP = linkP;
        this.fechaP = fechaP;
    }

    //Mét. getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

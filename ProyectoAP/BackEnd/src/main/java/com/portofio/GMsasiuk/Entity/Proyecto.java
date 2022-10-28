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
    @Size(min = 1, max = 50, message = "El nombre no cumple con la longitud requerida")
    private String nombreP;

    @NotNull
    @Size(min = 1, max = 50, message = "La descripción no cumple con la longitud requerida")
    private String descripcionP;
    
    private String linkP;
    
    private String imgP;
    
    @NotNull
    private int fechaInicioP;
    
    private int fechaFinP;
    
    //Mét. constructores
    public Proyecto() {
    }

    public Proyecto(String nombreP, String descripcionP, String linkP, String imgP, int fechaInicioP, int fechaFinP) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.linkP = linkP;
        this.imgP = imgP;
        this.fechaInicioP = fechaInicioP;
        this.fechaFinP = fechaFinP;
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

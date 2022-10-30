package com.portofio.GMsasiuk.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 5, message = "El nombre de la institución no cumple con la longitud requerida")
    private String institucionEd;

    @NotNull
    @Size(min = 5, message = "El nombre del título no cumple con la longitud requerida")
    private String tituloEd;

    private String imgInstitucionEd;

    @NotNull
    private int fechaInicioEd;

    private int fechaFinEd;

    //Mét. constructores
    public Educacion() {
    }

    public Educacion(String institucionEd, String tituloEd, String imgInstitucionEd, int fechaInicioEd, int fechaFinEd) {
        this.institucionEd = institucionEd;
        this.tituloEd = tituloEd;
        this.imgInstitucionEd = imgInstitucionEd;
        this.fechaInicioEd = fechaInicioEd;
        this.fechaFinEd = fechaFinEd;
    }

    //Mét. getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

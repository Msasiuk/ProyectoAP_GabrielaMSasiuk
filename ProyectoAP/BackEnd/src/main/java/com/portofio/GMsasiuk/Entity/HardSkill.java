package com.portofio.GMsasiuk.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class HardSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 1, max = 50, message = "El nombre no cumple con la longitud requerida")
    private String nombreHd;

    @NotNull
    private int porcentajeHd;

    //Mét. constructores
    public HardSkill() {
    }

    public HardSkill(String nombreHd, int porcentajeHd) {
        this.nombreHd = nombreHd;
        this.porcentajeHd = porcentajeHd;
    }

    //Mét. getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

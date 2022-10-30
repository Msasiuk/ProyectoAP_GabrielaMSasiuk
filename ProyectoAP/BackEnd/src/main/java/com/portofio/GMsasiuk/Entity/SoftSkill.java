package com.portofio.GMsasiuk.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class SoftSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 1, max = 50, message = "El nombre no cumple con la longitud requerida")
    private String nombreSf;

    @NotNull
    private int porcentajeSf;

    //Mét. constructores
    public SoftSkill() {
    }

    public SoftSkill(String nombreSf, int porcentajeSf) {
        this.nombreSf = nombreSf;
        this.porcentajeSf = porcentajeSf;
    }

    //Mét. getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreSf() {
        return nombreSf;
    }

    public void setNombreSf(String nombreSf) {
        this.nombreSf = nombreSf;
    }

    public int getPorcentajeSf() {
        return porcentajeSf;
    }

    public void setPorcentajeSf(int porcentajeSf) {
        this.porcentajeSf = porcentajeSf;
    }

}

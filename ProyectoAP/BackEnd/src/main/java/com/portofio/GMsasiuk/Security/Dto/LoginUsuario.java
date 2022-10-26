package com.portofio.GMsasiuk.Security.Dto;

import javax.validation.constraints.NotBlank;

//Clase que contiene el modelo de login de los usuario
public class LoginUsuario {

    @NotBlank
    private String nombreUsuario;
    @NotBlank
    private String password;

    //Mét. getters y setters
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

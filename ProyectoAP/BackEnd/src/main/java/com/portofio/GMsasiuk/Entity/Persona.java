package com.portofio.GMsasiuk.Entity;

import javax.persistence.*;

@Entity
public class Persona {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)    
    private int id;
    
    private String nombre;
    private String apellido;
    
    
}

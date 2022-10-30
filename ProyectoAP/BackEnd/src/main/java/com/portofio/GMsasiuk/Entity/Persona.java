package com.portofio.GMsasiuk.Entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private int id;

    @NotNull
    @Size(min = 5, max = 50, message = "El nombre no cumple con la longitud requerida")
    private String nombre;

    @NotNull
    @Size(min = 5, max = 50, message = "El apellido no cumple con la longitud requerida")
    private String apellido;

    @NotNull
    private String titulo;

    @NotNull
    @Size(min = 10, message = "La descripción no cumple con la longitud requerida")
    private String descripcion;

    private String img;

    //Atributos de vinculación
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
//    private List<Experiencia> experienciaList;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
//    private List<Educacion> educacionList;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
//    private List<SoftSkill> softSkillList;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
//    private List<HardSkill> hardSkillList;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
//    private List<Proyecto> proyectoList;

    //Mét. constructores
    public Persona() {
    }

    public Persona(String nombre, String apellido, String titulo, String descripcion, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.img = img;
    }

    //Mét. getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}

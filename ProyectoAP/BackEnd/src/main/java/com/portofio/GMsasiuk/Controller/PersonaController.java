package com.portofio.GMsasiuk.Controller;

import com.portofio.GMsasiuk.Dto.PersonaDto;
import com.portofio.GMsasiuk.Entity.Persona;
import com.portofio.GMsasiuk.Security.Controller.Mensaje;
import com.portofio.GMsasiuk.Service.PersonaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = {"https://frontpruebamsasiuk.web.app", "http://localhost:4200"})
public class PersonaController {

    //Clase que permite crear, buscar, editar, borrar los datos persona del portfolio
    @Autowired
    PersonaService personaService;

    //Mét. para crear persona
    @PostMapping("/create")
    public String createPersona(@RequestBody Persona persona) {
        personaService.save(persona);
        return "Persona creada correctamente";
    }

   //Mét. para traer persona según ID
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id) {
        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    //Mét. que actualiza persona según ID previas validaciones
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody PersonaDto personaDto) {
        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if (StringUtils.isBlank(personaDto.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre de la persona es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(personaDto.getTitulo())) {
            return new ResponseEntity(new Mensaje("El título de la persona es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(personaDto.getApellido())) {
            return new ResponseEntity(new Mensaje("El apellido de la persona es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(personaDto.getDescripcion())) {
            return new ResponseEntity(new Mensaje("La descripción de la persona es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(personaDto.getImg())) {
            return new ResponseEntity(new Mensaje("La imagen de la persona es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        //public Persona(String nombre, String apellido, String titulo, String descripcion, String img)
        Persona persona = personaService.getOne(id).get();

        persona.setNombre(personaDto.getNombre());
        persona.setApellido(personaDto.getApellido());
        persona.setTitulo(personaDto.getTitulo());
        persona.setDescripcion(personaDto.getDescripcion());
        persona.setImg(personaDto.getImg());

        personaService.save(persona);

        return new ResponseEntity(new Mensaje("Persona actualizada correctamente"), HttpStatus.OK);
    }

}

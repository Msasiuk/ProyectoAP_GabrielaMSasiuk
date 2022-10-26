package com.portofio.GMsasiuk.Controller;

import com.portofio.GMsasiuk.Dto.PersonaDto;
import com.portofio.GMsasiuk.Entity.Persona;
import com.portofio.GMsasiuk.Security.Controller.Mensaje;
import com.portofio.GMsasiuk.Service.PersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Clase que permite crear, buscar, editar, borrar los datos persona del portfolio
@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id) {
        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    //Mét. que actualiza la persona según ID previas validaciones
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody PersonaDto personaDto) {
        if (!personaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if (StringUtils.isBlank(personaDto.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre de la persona no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(personaDto.getApellido())) {
            return new ResponseEntity(new Mensaje("El apellido de la persona no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(personaDto.getDescripcion())) {
            return new ResponseEntity(new Mensaje("La descripción de la persona no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(personaDto.getImg())) {
            return new ResponseEntity(new Mensaje("La imagen de la persona no puede estar vacia"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = personaService.getOne(id).get();

        persona.setNombre(personaDto.getNombre());
        persona.setApellido(personaDto.getApellido());
        persona.setDescripcion(personaDto.getDescripcion());
        persona.setImg(personaDto.getImg());

        personaService.save(persona);

        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }

}

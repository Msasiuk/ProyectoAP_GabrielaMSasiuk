package com.portofio.GMsasiuk.Controller;

import com.portofio.GMsasiuk.Dto.ExperienciaDto;
import com.portofio.GMsasiuk.Entity.Experiencia;
import com.portofio.GMsasiuk.Security.Controller.Mensaje;
import com.portofio.GMsasiuk.Service.ExperienciaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/explab")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://frontpruebamsasiuk.web.app")
public class ExperienciaController {

    @Autowired
    ExperienciaService experienciaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = experienciaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id) {
        if (!experienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        Experiencia experiencia = experienciaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

    //Mét. para eliminar experiencias según ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!experienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID de la experiencia no existe"), HttpStatus.NOT_FOUND);
        }
        experienciaService.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada correctamente"), HttpStatus.OK);
    }

    //Mét. para crear experiencias previas validaciones
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ExperienciaDto experienciaDto) {
        if (StringUtils.isBlank(experienciaDto.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre de la experiencia es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (experienciaService.existsByNombreE(experienciaDto.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre de la experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(experienciaDto.getDescripcionE())) {
            return new ResponseEntity(new Mensaje("La descripción de la experiencia es obligatorio"), HttpStatus.BAD_REQUEST);
        }


        Experiencia experiencia = new Experiencia(experienciaDto.getNombreE(), experienciaDto.getDescripcionE());
        experienciaService.save(experiencia);

        return new ResponseEntity(new Mensaje("Experiencia agregada correctamente"), HttpStatus.OK);
    }
    
    //Mét. que actualiza la experiencia según ID previas validaciones
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ExperienciaDto experienciaDto) {
        if (!experienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID indicado de la experiencia no existe"), HttpStatus.BAD_REQUEST);
        }
        if (experienciaService.existsByNombreE(experienciaDto.getNombreE()) && experienciaService.getByNombreE(experienciaDto.getNombreE()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("El nombre de la experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(experienciaDto.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre de la experiencia no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }
             if (StringUtils.isBlank(experienciaDto.getDescripcionE())) {
            return new ResponseEntity(new Mensaje("La descripción de la experiencia no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }
        
        Experiencia experiencia = experienciaService.getOne(id).get();
        experiencia.setNombreE(experienciaDto.getNombreE());
        experiencia.setDescripcionE((experienciaDto.getDescripcionE()));

        experienciaService.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);

    }
}
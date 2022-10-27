package com.portofio.GMsasiuk.Controller;

import com.portofio.GMsasiuk.Dto.EducacionDto;
import com.portofio.GMsasiuk.Entity.Educacion;
import com.portofio.GMsasiuk.Security.Controller.Mensaje;
import com.portofio.GMsasiuk.Service.EducacionService;
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
@RequestMapping("/educacion")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://frontpruebamsasiuk.web.app")
public class EducacionController {

    @Autowired
    EducacionService educacionService;

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = educacionService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id) {
        if (!educacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = educacionService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    //Mét. para eliminar educación según ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!educacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID de la educación no existe"), HttpStatus.NOT_FOUND);
        }
        educacionService.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada correctamente"), HttpStatus.OK);
    }

    //Mét. para crear educaciones previas validaciones
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody EducacionDto educacionDto) {
        if (StringUtils.isBlank(educacionDto.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre de la educación es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (educacionService.existsByNombreE(educacionDto.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre de la educación ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(educacionDto.getDescripcionE())) {
            return new ResponseEntity(new Mensaje("La descripción de la educación es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = new Educacion(
                educacionDto.getNombreE(), educacionDto.getDescripcionE()
        );
        educacionService.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.OK);

    }

    //Mét. que actualiza la educación según ID previas validaciones
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody EducacionDto educacionDto) {
        if (!educacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if (educacionService.existsByNombreE(educacionDto.getNombreE()) && educacionService.getByNombreE(educacionDto.getNombreE()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(educacionDto.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre de la educación no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(educacionDto.getDescripcionE())) {
            return new ResponseEntity(new Mensaje("La descripción de la educación no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = educacionService.getOne(id).get();

        educacion.setNombreE(educacionDto.getNombreE());
        educacion.setDescripcionE(educacionDto.getDescripcionE());

        educacionService.save(educacion);

        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }
}

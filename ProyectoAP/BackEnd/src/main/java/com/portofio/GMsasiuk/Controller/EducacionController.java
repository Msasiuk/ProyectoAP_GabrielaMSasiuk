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
@CrossOrigin(origins = {"https://frontpruebamsasiuk.web.app", "http://localhost:4200"})
public class EducacionController {
    //Clase que permite crear, buscar, editar, borrar los datos de educación del portfolio
    
    @Autowired
    EducacionService educacionService;

    //Mét. para traer lista de ed.
    @GetMapping("/list")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = educacionService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    //Mét. para traer ed. según ID
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id) {
        if (!educacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = educacionService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    //Mét. para eliminar ed. según ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!educacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID de la educación no existe"), HttpStatus.NOT_FOUND);
        }
        educacionService.delete(id);
        return new ResponseEntity(new Mensaje("Educación eliminada correctamente"), HttpStatus.OK);
    }

    //Mét. para crear ed. previas validaciones
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody EducacionDto educacionDto) {
        if (StringUtils.isBlank(educacionDto.getInstitucionEd())) {
            return new ResponseEntity(new Mensaje("El nombre de la empresa es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(educacionDto.getTituloEd())) {
            return new ResponseEntity(new Mensaje("El título de la educacion es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(Integer.toString(educacionDto.getFechaInicioEd()))) {
            return new ResponseEntity(new Mensaje("La fecha de inicio de la educacion es obligatorio"), HttpStatus.BAD_REQUEST);
        }



        // public Educacion(String institucionEd, String tituloEd, String imgInstitucionEd, int fechaInicioEd, int fechaFinEd)
        Educacion educacion = new Educacion(
                educacionDto.getInstitucionEd(),
                educacionDto.getTituloEd(),
                educacionDto.getImgInstitucionEd(),            
                educacionDto.getFechaInicioEd(),
                educacionDto.getFechaFinEd()
        );
        educacionService.save(educacion);

        return new ResponseEntity(new Mensaje("Educacion agregada correctamente"), HttpStatus.OK);
    }

    //Mét. que actualiza ed. según ID previas validaciones
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody EducacionDto educacionDto) {
        if (!educacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if (StringUtils.isBlank(educacionDto.getInstitucionEd())) {
            return new ResponseEntity(new Mensaje("El nombre de la educación es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(educacionDto.getTituloEd())) {
            return new ResponseEntity(new Mensaje("El título de la educación es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(Integer.toString(educacionDto.getFechaInicioEd()))) {
            return new ResponseEntity(new Mensaje("La fecha de inicio de la educacion es obligatorio"), HttpStatus.BAD_REQUEST);
        }

       // public Educacion(String institucionEd, String tituloEd, String imgInstitucionEd, int fechaInicioEd, int fechaFinEd)
        Educacion educacion = educacionService.getOne(id).get();
    
        educacion.setInstitucionEd(educacionDto.getInstitucionEd());
        educacion.setTituloEd(educacionDto.getTituloEd());
        educacion.setImgInstitucionEd(educacionDto.getImgInstitucionEd());
        educacion.setFechaInicioEd(educacionDto.getFechaInicioEd());
        educacion.setFechaFinEd(educacionDto.getFechaFinEd());

        educacionService.save(educacion);

        return new ResponseEntity(new Mensaje("Educación actualizada correctamente"), HttpStatus.OK);
    }
}

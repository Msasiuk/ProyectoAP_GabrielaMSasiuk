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
@RequestMapping("/experiencia")
@CrossOrigin(origins = {"https://frontpruebamsasiuk.web.app", "http://localhost:4200"})
public class ExperienciaController {
    //Clase que permite crear, buscar, editar, borrar los datos de experiencia del portfolio
    
    @Autowired
    ExperienciaService experienciaService;

    //Mét. para traer lista de ex.
    @GetMapping("/list")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = experienciaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    //Mét. para traer ex. según ID
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id) {
        if (!experienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        Experiencia experiencia = experienciaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }

    //Mét. para eliminar ex. según ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!experienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID de la experiencia no existe"), HttpStatus.NOT_FOUND);
        }
        experienciaService.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada correctamente"), HttpStatus.OK);
    }

    //Mét. para crear ex. previas validaciones
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ExperienciaDto experienciaDto) {
        if (StringUtils.isBlank(experienciaDto.getEmpresaEx())) {
            return new ResponseEntity(new Mensaje("El nombre de la empresa es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (experienciaService.existsByEmpresa(experienciaDto.getEmpresaEx())) {
            return new ResponseEntity(new Mensaje("El nombre de la empresa ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(experienciaDto.getDescripcionEx())) {
            return new ResponseEntity(new Mensaje("La descripción de la experiencia es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(experienciaDto.getTituloEx())) {
            return new ResponseEntity(new Mensaje("El título de la experiencia es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(Integer.toString(experienciaDto.getFechaInicioEx()))) {
            return new ResponseEntity(new Mensaje("La fecha de inicio de la experiencia es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        //public Experiencia(String empresaEx, String tituloEx, String descripcionEx,
        //String imgEmpresaEx, int fechaInicioEx, int fechaFinEx)
        Experiencia experiencia = new Experiencia(
                experienciaDto.getEmpresaEx(),
                experienciaDto.getTituloEx(),
                experienciaDto.getDescripcionEx(),
                experienciaDto.getImgEmpresaEx(),            
                experienciaDto.getFechaInicioEx(),
                experienciaDto.getFechaFinEx()
        );
        experienciaService.save(experiencia);

        return new ResponseEntity(new Mensaje("Experiencia agregada correctamente"), HttpStatus.OK);
    }

    //Mét. que actualiza ed. según ID previas validaciones
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ExperienciaDto experienciaDto) {
        if (!experienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID indicado de la experiencia no existe"), HttpStatus.BAD_REQUEST);
        }
        if (experienciaService.existsByEmpresa(experienciaDto.getEmpresaEx())
                && experienciaService.getByNombre(experienciaDto.getEmpresaEx()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("El nombre de la empresa ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(experienciaDto.getEmpresaEx())) {
            return new ResponseEntity(new Mensaje("El nombre de la experiencia es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(experienciaDto.getTituloEx())) {
            return new ResponseEntity(new Mensaje("El título de la experiencia es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(experienciaDto.getDescripcionEx())) {
            return new ResponseEntity(new Mensaje("La descripción de la experiencia es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(Integer.toString(experienciaDto.getFechaInicioEx()))) {
            return new ResponseEntity(new Mensaje("La fecha de inicio de la experiencia es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        //public Experiencia(String empresaEx, String tituloEx, String descripcionEx,
        //String imgEmpresaEx, int fechaInicioEx, int fechaFinEx)
        Experiencia experiencia = experienciaService.getOne(id).get();

        experiencia.setEmpresaEx(experienciaDto.getEmpresaEx());
        experiencia.setTituloEx(experienciaDto.getTituloEx());
        experiencia.setDescripcionEx(experienciaDto.getDescripcionEx());
        experiencia.setImgEmpresaEx(experienciaDto.getImgEmpresaEx());
        experiencia.setFechaInicioEx(experienciaDto.getFechaInicioEx());
        experiencia.setFechaFinEx(experienciaDto.getFechaFinEx());

        experienciaService.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada correctamente"), HttpStatus.OK);

    }
}

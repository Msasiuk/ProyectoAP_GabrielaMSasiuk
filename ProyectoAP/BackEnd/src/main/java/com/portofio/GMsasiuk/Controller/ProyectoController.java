package com.portofio.GMsasiuk.Controller;

import com.portofio.GMsasiuk.Dto.ProyectoDto;
import com.portofio.GMsasiuk.Entity.Proyecto;
import com.portofio.GMsasiuk.Security.Controller.Mensaje;
import com.portofio.GMsasiuk.Service.ProyectoService;
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
@RequestMapping("/proyecto")
//@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "https://frontpruebamsasiuk.web.app")
@CrossOrigin(origins = {"https://frontpruebamsasiuk.web.app", "http://localhost:4200"})
public class ProyectoController {

    @Autowired
    ProyectoService proyectoService;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list() {
        List<Proyecto> list = proyectoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id) {
        if (!proyectoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }

        Proyecto proyecto = proyectoService.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }

    //Mét. para eliminar proyecto según ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!proyectoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID del proyecto no existe"), HttpStatus.NOT_FOUND);
        }
        proyectoService.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado correctamente"), HttpStatus.OK);
    }

    //Mét. para crear proyectoes previas validaciones
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProyectoDto proyectoDto) {
        if (StringUtils.isBlank(proyectoDto.getNombreP())) {
            return new ResponseEntity(new Mensaje("El nombre del proyecto es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (proyectoService.existsByNombreP(proyectoDto.getNombreP())) {
            return new ResponseEntity(new Mensaje("El nombre del proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(proyectoDto.getDescripcionP())) {
            return new ResponseEntity(new Mensaje("La descripción del proyecto es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(proyectoDto.getLinkP())) {
            return new ResponseEntity(new Mensaje("El link del proyecto es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        // Argumentos de constructor => String nombreP, String descripcionP, String linkP, String imgP, int fechaInicioP, int fechaFinP
        Proyecto proyecto = new Proyecto(
                proyectoDto.getNombreP(), proyectoDto.getDescripcionP(), 
                proyectoDto.getLinkP(), proyectoDto.getImgP(),
                proyectoDto.getFechaInicioP(), proyectoDto.getFechaFinP()
        
        ); 

        proyectoService.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto creado"), HttpStatus.OK);

    }

    //Mét. que actualiza la proyecto según ID previas validaciones
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ProyectoDto proyectoDto) {
        if (!proyectoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if (proyectoService.existsByNombreP(proyectoDto.getNombreP()) && proyectoService.getByNombreE(proyectoDto.getNombreP()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(proyectoDto.getNombreP())) {
            return new ResponseEntity(new Mensaje("El nombre de la proyecto no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(proyectoDto.getDescripcionP())) {
            return new ResponseEntity(new Mensaje("La descripción de la proyecto no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        Proyecto proyecto = proyectoService.getOne(id).get();

        // Argumentos de constructor => String nombreP, String descripcionP, String linkP, String imgP, int fechaInicioP, int fechaFinP
        proyecto.setNombreP(proyectoDto.getNombreP());
        proyecto.setDescripcionP(proyectoDto.getDescripcionP());
        proyecto.setLinkP(proyectoDto.getLinkP());
        proyecto.setImgP(proyectoDto.getImgP());
        proyecto.setFechaInicioP(proyectoDto.getFechaInicioP());
        proyecto.setFechaFinP(proyectoDto.getFechaFinP());
        
        proyectoService.save(proyecto);

        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
}

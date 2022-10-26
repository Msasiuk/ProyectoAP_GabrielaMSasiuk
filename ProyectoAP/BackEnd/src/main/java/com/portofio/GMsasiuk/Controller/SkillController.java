package com.portofio.GMsasiuk.Controller;

import com.portofio.GMsasiuk.Dto.SkillDto;
import com.portofio.GMsasiuk.Entity.Skill;
import com.portofio.GMsasiuk.Security.Controller.Mensaje;
import com.portofio.GMsasiuk.Service.SkillService;
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
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/skill")
public class SkillController {

    @Autowired
    SkillService skillService;

    @GetMapping("/lista")
    public ResponseEntity<List<Skill>> list() {
        List<Skill> list = skillService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") int id) {
        if (!skillService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        Skill hYs = skillService.getOne(id).get();
        return new ResponseEntity(hYs, HttpStatus.OK);
    }

    //Mét. para eliminar skill según ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!skillService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID de la Skill no existe"), HttpStatus.NOT_FOUND);
        }
        skillService.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminada correctamente"), HttpStatus.OK);
    }

    //Mét. para crear skill previas validaciones
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody SkillDto skillDto) {
        if (StringUtils.isBlank(skillDto.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre de la skill es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (skillService.existsByNombre(skillDto.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre de la skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        Skill hYs = new Skill(skillDto.getNombre(), skillDto.getPorcentaje());
        skillService.save(hYs);

        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }

    //Mét. que actualiza la skill según ID previas validaciones
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody SkillDto skillDto) {
        if (!skillService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        if (skillService.existsByNombre(skillDto.getNombre()) && skillService.getByNombre(skillDto.getNombre()).get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(skillDto.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Skill skill = skillService.getOne(id).get();
        skill.setNombre(skillDto.getNombre());
        skill.setPorcentaje(skillDto.getPorcentaje());

        skillService.save(skill);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);

    }
}
package com.portofio.GMsasiuk.Controller;

import com.portofio.GMsasiuk.Dto.HardSkillDto;
import com.portofio.GMsasiuk.Entity.HardSkill;
import com.portofio.GMsasiuk.Security.Controller.Mensaje;
import com.portofio.GMsasiuk.Service.HardSkillService;
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
@CrossOrigin(origins = {"https://frontpruebamsasiuk.web.app", "http://localhost:4200"})
@RequestMapping("/hardskill")
public class HardSkillController {
    //Clase que permite crear, buscar, editar, borrar los datos de skill del portfolio

    @Autowired
    HardSkillService hardSkillService;

    //Mét. para traer lista de skills
    @GetMapping("/list")
    public ResponseEntity<List<HardSkill>> list() {
        List<HardSkill> list = hardSkillService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    //Mét. para traer skill según ID
    @GetMapping("/detail/{id}")
    public ResponseEntity<HardSkill> getById(@PathVariable("id") int id) {
        if (!hardSkillService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }

        HardSkill hardSkill = hardSkillService.getOne(id).get();
        return new ResponseEntity(hardSkill, HttpStatus.OK);
    }

    //Mét. para eliminar skill según ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!hardSkillService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID del skill no existe"), HttpStatus.NOT_FOUND);
        }
        hardSkillService.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminada correctamente"), HttpStatus.OK);
    }

    //Mét. para crear skill previas validaciones
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody HardSkillDto hardSkillDto) {
        if (StringUtils.isBlank(hardSkillDto.getNombreHd())) {
            return new ResponseEntity(new Mensaje("El nombre de la skill es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(Integer.toString(hardSkillDto.getPorcentajeHd()))) {
            return new ResponseEntity(new Mensaje("El porcenteja de la skill es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        // public HardSkill(String nombreSf, int porcentajeSf)
        HardSkill hardSkill = new HardSkill(
                hardSkillDto.getNombreHd(),
                hardSkillDto.getPorcentajeHd()
        );
        hardSkillService.save(hardSkill);
        return new ResponseEntity(new Mensaje("Skill creada correctamente"), HttpStatus.OK);

    }

    //Mét. que actualiza skill según ID previas validaciones
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody HardSkillDto hardSkillDto) {
        if (!hardSkillService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if (StringUtils.isBlank(hardSkillDto.getNombreHd())) {
            return new ResponseEntity(new Mensaje("El nombre de la skill es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(Integer.toString(hardSkillDto.getPorcentajeHd()))) {
            return new ResponseEntity(new Mensaje("El porcenteja de la skill es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        // public HardSkill(String nombreSf, int porcentajeSf)
        HardSkill hardSkill = hardSkillService.getOne(id).get();
        hardSkill.setNombreHd(hardSkillDto.getNombreHd());
        hardSkill.setPorcentajeHd(hardSkillDto.getPorcentajeHd());

        hardSkillService.save(hardSkill);

        return new ResponseEntity(new Mensaje("Skill actualizada correctamente"), HttpStatus.OK);
    }
}

package com.portofio.GMsasiuk.Service;

import com.portofio.GMsasiuk.Entity.Skill;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portofio.GMsasiuk.Repository.SkillRepository;

@Transactional
@Service
public class SkillService {

    @Autowired
    SkillRepository skillRepository;
    //Mét. para traer listado de skills, obtener uno por ID/por nombre, guardar, borrar, validar si existe por ID/por nombre
    public List<Skill> list() {
        return skillRepository.findAll();
    }

    public Optional<Skill> getOne(int id) {
        return skillRepository.findById(id);
    }

    public Optional<Skill> getByNombre(String nombre) {
        return skillRepository.findByNombre(nombre);
    }

    public void save(Skill skill) {
        skillRepository.save(skill);
    }

    public void delete(int id) {
        skillRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return skillRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return skillRepository.existsByNombre(nombre);
    }
}

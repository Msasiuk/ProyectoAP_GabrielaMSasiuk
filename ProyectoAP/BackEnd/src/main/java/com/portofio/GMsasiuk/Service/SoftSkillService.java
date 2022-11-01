package com.portofio.GMsasiuk.Service;

import com.portofio.GMsasiuk.Entity.SoftSkill;
import java.util.List;
import java.util.Optional;
//import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portofio.GMsasiuk.Repository.ISoftSkillRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SoftSkillService {

    @Autowired
    ISoftSkillRepository iSoftSkillRepository;

    //Mét. para traer listado de skills, obtener uno por ID/por nombre, guardar, borrar, validar si existe por ID/por nombre
    public List<SoftSkill> list() {
        return iSoftSkillRepository.findAll();
    }

    public Optional<SoftSkill> getOne(int id) {
        return iSoftSkillRepository.findById(id);
    }

    public Optional<SoftSkill> getByNombre(String nombre) {
        return iSoftSkillRepository.findByNombreSf(nombre);
    }

    public void save(SoftSkill softSkill) {
        iSoftSkillRepository.save(softSkill);
    }

    public void delete(int id) {
        iSoftSkillRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return iSoftSkillRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return iSoftSkillRepository.existsByNombreSf(nombre);
    }
}

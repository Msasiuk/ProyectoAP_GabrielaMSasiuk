package com.portofio.GMsasiuk.Service;

import com.portofio.GMsasiuk.Entity.Experiencia;
import java.util.List;
import java.util.Optional;
//import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portofio.GMsasiuk.Repository.IExperienciaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExperienciaService {

    @Autowired
    IExperienciaRepository iExperienciaRepository;

    //Mét. para traer listado de experiencia, obtener uno por ID/por nombre, guardar, borrar, validar si existe por ID/por nombre
    public List<Experiencia> list() {
        return iExperienciaRepository.findAll();
    }

    public Optional<Experiencia> getOne(int id) {
        return iExperienciaRepository.findById(id);
    }

    public Optional<Experiencia> getByNombre(String empresa) {
        return iExperienciaRepository.findByEmpresaEx(empresa);
    }

    public void save(Experiencia experiencia) {
        iExperienciaRepository.save(experiencia);
    }

    public void delete(int id) {
        iExperienciaRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return iExperienciaRepository.existsById(id);
    }

    public boolean existsByEmpresa(String empresa) {
        return iExperienciaRepository.existsByEmpresaEx(empresa);
    }
}

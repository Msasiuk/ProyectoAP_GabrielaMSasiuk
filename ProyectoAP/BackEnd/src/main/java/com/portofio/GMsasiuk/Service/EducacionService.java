package com.portofio.GMsasiuk.Service;

import com.portofio.GMsasiuk.Entity.Educacion;
import java.util.List;
import java.util.Optional;
//import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portofio.GMsasiuk.Repository.IEducacionRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EducacionService {

    @Autowired
    IEducacionRepository iEducacionRepository;

    //Mét. para traer listado de educacion, obtener uno por ID/por nombre, guardar, borrar, validar si existe por ID/por nombre
    public List<Educacion> list() {
        return iEducacionRepository.findAll();
    }

    public Optional<Educacion> getOne(int id) {
        return iEducacionRepository.findById(id);
    }

    public Optional<Educacion> getByInstitucion(String institucion) {
        return iEducacionRepository.findByInstitucionEd(institucion);
    }

    public void save(Educacion educacion) {
        iEducacionRepository.save(educacion);
    }

    public void delete(int id) {
        iEducacionRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return iEducacionRepository.existsById(id);
    }
    
    public boolean existsByInstitucion(String institucion) {
        return iEducacionRepository.existsByInstitucionEd(institucion);
    }
}

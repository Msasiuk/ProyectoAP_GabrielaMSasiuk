package com.portofio.GMsasiuk.Service;

import com.portofio.GMsasiuk.Entity.Educacion;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portofio.GMsasiuk.Repository.IEducacionRepository;

@Service
@Transactional
public class EducacionService {

    @Autowired
    IEducacionRepository iEducacionRepository;

    //Mét. para traer listado de educación de bd, buscar ed. por Id/por nombre, guardar ed, borrar ed, validar por Id/por nombre
    public List<Educacion> list() {
        return iEducacionRepository.findAll();
    }

    public Optional<Educacion> getOne(int id) {
        return iEducacionRepository.findById(id);
    }

    public Optional<Educacion> getByNombreE(String nombreE) {
        return iEducacionRepository.findByNombreE(nombreE);
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

    public boolean existsByNombreE(String nombreE) {
        return iEducacionRepository.existsByNombreE(nombreE);
    }
}

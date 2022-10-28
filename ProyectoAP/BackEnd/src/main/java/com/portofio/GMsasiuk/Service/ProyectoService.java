package com.portofio.GMsasiuk.Service;

import com.portofio.GMsasiuk.Entity.Proyecto;
import com.portofio.GMsasiuk.Repository.IProyectoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectoService {
    
    @Autowired IProyectoRepository iProyectoRepository;
    
    //Mét. para traer listado de proyectos de bd, buscar por Id/por nombre, guardar ed, borrar ed, validar por Id/por nombre
    public List<Proyecto> list() {
        return iProyectoRepository.findAll();
    }

    public Optional<Proyecto> getOne(int id) {
        return iProyectoRepository.findById(id);
    }

    public Optional<Proyecto> getByNombreE(String nombreP) {
        return iProyectoRepository.findByNombreP(nombreP);
    }

    public void save(Proyecto proyecto) {
        iProyectoRepository.save(proyecto);
    }

    public void delete(int id) {
        iProyectoRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return iProyectoRepository.existsById(id);
    }

    public boolean existsByNombreP(String nombreP) {
        return iProyectoRepository.existsByNombreP(nombreP);
    }
}

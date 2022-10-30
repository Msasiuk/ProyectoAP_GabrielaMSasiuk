package com.portofio.GMsasiuk.Service;

import com.portofio.GMsasiuk.Entity.Proyecto;
import com.portofio.GMsasiuk.Repository.IProyectoRepository;
import java.util.List;
import java.util.Optional;
//import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProyectoService {
    
    @Autowired IProyectoRepository iProyectoRepository;
    
    //Mét. para traer listado de proyectos, obtener uno por ID/por nombre, guardar, borrar, validar si existe por ID/por nombre
    public List<Proyecto> list() {
        return iProyectoRepository.findAll();
    }

    public Optional<Proyecto> getOne(int id) {
        return iProyectoRepository.findById(id);
    }

    public Optional<Proyecto> getByNombre(String nombre) {
        return iProyectoRepository.findByNombreP(nombre);
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

    public boolean existsByNombre(String nombre) {
        return iProyectoRepository.existsByNombreP(nombre);
    }
}

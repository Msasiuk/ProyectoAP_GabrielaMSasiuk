package com.portofio.GMsasiuk.Service;

import com.portofio.GMsasiuk.Entity.Persona;
import com.portofio.GMsasiuk.Interface.IPersonaService;
import com.portofio.GMsasiuk.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService {
    @Autowired IPersonaRepository ipersonaRepository;
    
    @Override
    public List<Persona> traerListadoPersona() {
        List<Persona> listaPersonas = ipersonaRepository.findAll();
        return listaPersonas;
    }

    @Override
    public void guardarPersona(Persona persona) {
        ipersonaRepository.save(persona);
    }

    @Override
    public void borrarPersona(Long id) {
        ipersonaRepository.deleteById(id);
    }

    @Override
    public Persona traerPersona(Long id) {
        Persona persona = ipersonaRepository.findById(id).orElse(null);
        return persona;
    }
    
}

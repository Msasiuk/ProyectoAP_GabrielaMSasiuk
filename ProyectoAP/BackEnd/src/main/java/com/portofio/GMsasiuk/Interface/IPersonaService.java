package com.portofio.GMsasiuk.Interface;

import com.portofio.GMsasiuk.Entity.Persona;
import java.util.List;

public interface IPersonaService {
    // Metodo para traer listado de personas
    public List<Persona> traerListadoPersona();
    
    // Metodo para guardar una persona
    public void guardarPersona (Persona persona);
    
    // Metodo para eliminar una persona de la lista por id
    public void borrarPersona (Long id);
    
    // Metodo para buscar persona de una lista por id
    public Persona traerPersona (Long id);
}

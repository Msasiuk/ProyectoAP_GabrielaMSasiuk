package com.portofio.GMsasiuk.Controller;

import com.portofio.GMsasiuk.Entity.Persona;
import com.portofio.GMsasiuk.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    @GetMapping("/persona/traer/listado")
    public List<Persona> traerListadoPersona(){
        return ipersonaService.traerListadoPersona();
    }
    
    @PostMapping("/persona/crear")
    public String crearPersona (@RequestBody Persona persona){
        ipersonaService.guardarPersona(persona);
        return "La persona ingresada fue guardada exitosamente";
    }
    
    @DeleteMapping("/persona/borrar/{id}")
    public String borrarPersona (@PathVariable Long id){
        ipersonaService.borrarPersona(id);
        return "La persona de id: " + id + ", fue borrada exitosamente";
    }
    
    // URL:PUERTO/personas/editar/id?nombre=NuevoNombre&apellido=NuevoApellido&img=NuevoString
    @PutMapping("/persona/editar/datos/{id}")
    public Persona editarPersona (@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("img") String nuevaImg) {
        
        Persona persona = ipersonaService.traerPersona(id);
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevaImg);
        
        ipersonaService.guardarPersona(persona);
        return persona;
    }
    
    @GetMapping("/persona/traer/perfil")
    public Persona traerPersona(){
        return ipersonaService.traerPersona((long)1);
    }
        
} 
    


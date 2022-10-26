package com.portofio.GMsasiuk.Security.Service;

import com.portofio.GMsasiuk.Security.Entity.Rol;
import com.portofio.GMsasiuk.Security.Enums.RolNombre;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portofio.GMsasiuk.Security.Repository.IRolRepository;

//Notación transaccional permite persistencia en caso de error al grabar datos en bd.
@Service
@Transactional
public class RolService {
    @Autowired
    IRolRepository iRolRepository;
    
    //Mét. propios de la clase que validan la existencia del rol y guardan el rol
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return iRolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        iRolRepository.save(rol);
    }
}